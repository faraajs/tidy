cmake_minimum_required(VERSION 3.22.1)
project(tidyavif LANGUAGES C CXX)

include(FetchContent)
get_filename_component(TIDY_ROOT "${CMAKE_CURRENT_SOURCE_DIR}/../../../.." ABSOLUTE)
set(TIDY_NATIVE_ARCHIVES "${TIDY_ROOT}/.native-sources/archives" CACHE PATH "Verified native source archive cache")
set(CMAKE_POSITION_INDEPENDENT_CODE ON)
set(BUILD_SHARED_LIBS OFF CACHE BOOL "Build dependencies statically" FORCE)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Apply to dependencies as well as JNI; __FILE__ and debug paths must not expose
# checkout, SDK, or build-machine paths. No opaque prebuilt codec is linked.
foreach(path IN ITEMS "${TIDY_ROOT}" "${CMAKE_BINARY_DIR}" "${TIDY_NATIVE_ARCHIVES}" "${CMAKE_SYSROOT}" "${ANDROID_NDK}")
    if(path)
        get_filename_component(real_path "${path}" REALPATH)
        add_compile_options("-ffile-prefix-map=${path}=tidy-source" "-fdebug-prefix-map=${path}=tidy-source")
        add_compile_options("-ffile-prefix-map=${real_path}=tidy-source" "-fdebug-prefix-map=${real_path}=tidy-source")
    endif()
endforeach()
add_compile_options(-fvisibility=hidden -ffunction-sections -fdata-sections)

# FetchContent verifies the same immutable archive whether cached or downloaded.
# Always extract the verified archive, never trust an arbitrary unpacked tree.
function(tidy_source name archive url sha256)
    string(TOUPPER "${name}" upper_name)
    if(FETCHCONTENT_SOURCE_DIR_${upper_name})
        message(FATAL_ERROR "${name}: unverified source-directory overrides are not supported; provide the pinned archive cache")
    endif()
    if(EXISTS "${TIDY_NATIVE_ARCHIVES}/${archive}")
        file(SHA256 "${TIDY_NATIVE_ARCHIVES}/${archive}" actual_sha256)
        if(NOT actual_sha256 STREQUAL sha256)
            message(FATAL_ERROR "${name}: cached source archive SHA256 mismatch")
        endif()
        set(url "${TIDY_NATIVE_ARCHIVES}/${archive}")
    endif()
    FetchContent_Declare(${name} URL "${url}" DOWNLOAD_NAME "${archive}" URL_HASH "SHA256=${sha256}")
    FetchContent_MakeAvailable(${name})
endfunction()

set(AOM_TARGET_CPU generic CACHE STRING "Portable C codec; no assembler required" FORCE)
foreach(option IN ITEMS CONFIG_AV1_ENCODER CONFIG_AV1_DECODER CONFIG_MULTITHREAD CONFIG_PIC CONFIG_SIZE_LIMIT)
    set(${option} 1 CACHE STRING "Tidy codec configuration" FORCE)
endforeach()
foreach(option IN ITEMS CONFIG_LIBYUV CONFIG_WEBM_IO CONFIG_HIGHWAY CONFIG_TUNE_BUTTERAUGLI CONFIG_TUNE_VMAF CONFIG_RUNTIME_CPU_DETECT CONFIG_AV1_HIGHBITDEPTH)
    set(${option} 0 CACHE STRING "Tidy codec configuration" FORCE)
endforeach()
set(DECODE_WIDTH_LIMIT 16384 CACHE STRING "Maximum decode width" FORCE)
set(DECODE_HEIGHT_LIMIT 16384 CACHE STRING "Maximum decode height" FORCE)
foreach(option IN ITEMS ENABLE_DOCS ENABLE_EXAMPLES ENABLE_TESTDATA ENABLE_TESTS ENABLE_TOOLS)
    set(${option} OFF CACHE BOOL "No auxiliary AOM targets" FORCE)
endforeach()
tidy_source(tidy_aom "aom-03087864cf4bea6abb0d28f95cf7843511413d8f.tar.gz"
    "https://aomedia.googlesource.com/aom/+archive/03087864cf4bea6abb0d28f95cf7843511413d8f.tar.gz"
    "74328f5160eb58ea3b560a7a4d388b9486779b8a298a425c674cb6d414f5cf45")
FetchContent_GetProperties(tidy_aom SOURCE_DIR tidy_aom_source BINARY_DIR tidy_aom_binary)
target_include_directories(aom INTERFACE "$<BUILD_INTERFACE:${tidy_aom_source}>" "$<BUILD_INTERFACE:${tidy_aom_binary}>")
set_property(TARGET aom PROPERTY AVIF_LOCAL ON)

# AOM's generated diagnostic config string otherwise embeds relative SDK and
# checkout paths. Regenerate only that generated file, preserving its template.
set(AOM_CMAKE_CONFIG "Tidy libaom 3.14.1; AOM_TARGET_CPU=generic; AV1 encoder+decoder; 8-bit; PIC; multithread; decode dimensions<=16384; LIBYUV=0; WEBM_IO=0; HIGHWAY=0; auxiliary targets disabled")
string(TIMESTAMP year "%Y")
configure_file("${tidy_aom_source}/cmake/aom_config.c.template" "${tidy_aom_binary}/config/aom_config.c")

# SYSTEM here means consume the already-defined, pinned source-built aom target;
# upstream does not perform system lookup when that target already exists.
set(AVIF_CODEC_AOM SYSTEM CACHE STRING "Use pinned source-built AOM target" FORCE)
set(AVIF_CODEC_AOM_ENCODE ON CACHE BOOL "AVIF encoder" FORCE)
set(AVIF_CODEC_AOM_DECODE ON CACHE BOOL "AVIF decoder" FORCE)
foreach(option IN ITEMS AVIF_CODEC_DAV1D AVIF_CODEC_LIBGAV1 AVIF_CODEC_RAV1E AVIF_CODEC_SVT AVIF_CODEC_AVM AVIF_LIBYUV AVIF_LIBSHARPYUV AVIF_LIBXML2 AVIF_ZLIBPNG AVIF_JPEG AVIF_GTEST)
    set(${option} OFF CACHE STRING "No external auxiliary dependency" FORCE)
endforeach()
foreach(option IN ITEMS AVIF_BUILD_APPS AVIF_BUILD_EXAMPLES AVIF_BUILD_TESTS AVIF_ENABLE_COMPLIANCE_WARDEN AVIF_ENABLE_GOLDEN_TESTS AVIF_ENABLE_EXPERIMENTAL_MINI AVIF_ENABLE_EXPERIMENTAL_EXTENDED_PIXI)
    set(${option} OFF CACHE BOOL "No auxiliary or experimental AVIF targets" FORCE)
endforeach()
tidy_source(tidy_libavif "libavif-c5240fc79fe5c2407e10afd35f5505ef6333ea49.tar.gz"
    "https://codeload.github.com/AOMediaCodec/libavif/tar.gz/c5240fc79fe5c2407e10afd35f5505ef6333ea49"
    "5e9aa73e43af8021a57d744712ee0bc145267863afb7c9b118723a15dbd4cfbf")

add_library(tidyavif SHARED tidyavif.cpp)
target_link_libraries(tidyavif PRIVATE avif android jnigraphics)
target_compile_options(tidyavif PRIVATE -Wall -Wextra -Werror -fexceptions)
target_link_options(tidyavif PRIVATE "LINKER:--gc-sections" "LINKER:--exclude-libs,ALL" "$<$<NOT:$<CONFIG:Debug>>:LINKER:--strip-debug>")
