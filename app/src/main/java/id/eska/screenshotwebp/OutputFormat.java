package id.eska.screenshotwebp;

public enum OutputFormat {
    AVIF("avif"),
    WEBP("webp");

    private final String extension;

    OutputFormat(String extension) {
        this.extension = extension;
    }

    public String extension() {
        return extension;
    }
}
