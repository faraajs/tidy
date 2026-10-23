# Tidy 2.3.1-night.1 — kompresi saat tidur

## Catatan pembuat — faraajs

Versi ini berangkat dari pengalaman memakai Tidy 2.3.1 selama beberapa waktu. Hasil kompresinya sudah pas buat kebutuhan saya, tetapi pemakaian baterai di latar belakang terasa terlalu besar, bahkan ketika aplikasinya jarang dibuka. Saya ingin tetap mendapat manfaat kompresinya tanpa harus mengorbankan baterai saat memakai HP sepanjang hari.

Karena itu, perubahan versi ini sengaja dibatasi pada kapan Tidy bekerja. Kompresi dipindahkan ke batch malam sekitar pukul 03.00, ketika saya tidur dan HP sedang dicas. Pemantauan folder terus-menerus dihapus. Algoritma, kualitas, target ukuran, dan perlindungan file dari 2.3.1 tetap dipertahankan.

Tujuannya sederhana: biarkan foto terkumpul saat siang, lalu kerjakan ketika HP tidak sedang dipakai. Setelah izin dan kategori diaktifkan sekali, jadwal berjalan otomatis; tidak perlu membuka Tidy setiap malam. Konsekuensinya, hasil kompresi dan penghematan ruang baru muncul setelah batch malam berhasil berjalan.

Keluhan baterai pada versi sebelumnya berasal dari pengalaman pemakaian saya, bukan hasil pengukuran untuk semua perangkat. Versi ini belum memiliki angka penghematan baterai harian atau hasil pengamatan semalam penuh. Saya tidak menjanjikan konsumsi 0 mAh: Android tetap dapat mengirim callback, dan file yang sedang diproses boleh diselesaikan dengan aman.

— **faraajs**, 23 Oktober 2026

## Perubahan yang dipublikasikan

- Satu jadwal Android persisten menargetkan pukul **03.00 waktu lokal**, dengan jendela kerja **03.00–06.00**, hanya saat **charging, layar mati, dan perangkat idle**. Android dapat menunda waktu mulai.
- Tidak ada pemantauan folder terus-menerus, scan berkala, foreground monitoring service, atau batch otomatis siang hari. Membuka dashboard hanya memulihkan jadwal.
- Cabut charger, layar menyala, Pause, atau pukul 06.00 mencegah file berikutnya mulai. File yang sudah berjalan dapat selesai dengan aman. Sisa pekerjaan dan jadwal yang terlewat menunggu malam berikutnya; tidak dikejar pada siang hari.
- Izin otomasi dan batas waktu aktivasi kategori tetap tersimpan antar sesi agar foto yang terkumpul pada siang hari tetap memenuhi syarat. Jadwal dipulihkan setelah reboot/unlock/update/perubahan waktu, tanpa mengaktifkan scan langsung.
- Kompresi, resize, metadata, folder yang didukung, pemeriksaan Gallery, serta persetujuan penghapusan file asli tetap mengikuti 2.3.1. Tidak ada profil kompresi atau dependensi scheduler baru.

## Unduh dan penggunaan

Prarilis ini menyediakan **APK ARM64 saja**, untuk Android 11/API 30 ke atas. Dukungan build x86_64 tetap ada di source, tetapi tidak ada APK x86_64 atau universal yang diterbitkan untuk versi ini.

- `tidy-2.3.1-night.1-arm64.apk`
- `tidy-v2.3.1-night.1-corresponding-source.tar.gz`
- `SHA256SUMS.txt`

Verifikasi kedua file di atas dengan `sha256sum -c SHA256SUMS.txt`. APK memakai application ID `id.eska.tidy`, versionCode **6**, dan sertifikat release yang sama dengan 2.3.1. SHA-256 sertifikat:

```text
27c165f0a6f13f8b01ed6628bd1a2e8f61daeb3b33438c6808f41f331aa45389
```

SHA-256 APK:

```text
10b759e92833850d6ce6b2669c080cea57ec65556a0472bfe206b9a446bd5ef7
```

Update dari APK resmi bertanda tangan sama dapat dipasang tanpa uninstall/clear data. Setelah izin akses file dan kategori dipilih, aktifkan **Enable night batch** sekali bila belum aktif. Biarkan HP dicas dengan layar mati saat tidur; aplikasi tidak perlu dibiarkan terbuka. Pertahankan salinan cadangan media yang penting. Penghapusan file asli tetap memerlukan persetujuan terpisah dan tidak diperlukan untuk mencoba versi ini.

Force-stop, izin yang dicabut, atau pembatasan Android/vendor dapat menghentikan otomatisasi. Buka kembali Tidy dan periksa status jadwal jika itu terjadi. Jika malam tersebut terlewat, foto tetap menunggu malam berikutnya. Ini prarilis karena eksekusi pukul 03.00 semalam penuh dan penghematan baterai harian belum diamati.

## Verifikasi sebelum publikasi

- **24 tes host lulus**, tanpa kegagalan/error/skipped.
- **42 pemeriksaan di HP Android 13 ARM64 lulus**: 16 batch malam, 3 lifecycle jadwal, 20 converter, dan 3 Gallery. Tes waktu/daya batch memakai kondisi terinjeksi dan file buatan; lifecycle juga memeriksa job Android nyata.
- Empat hasil screenshot/foto × WebP/AVIF memiliki hash identik dengan baseline 2.3.1. Pustaka native ARM64 juga identik dengan APK 2.3.1.
- Pengamatan idle terkontrol selama 45.001 ms mencatat 3 ms CPU proses tes, tanpa scan atau konversi otomatis. Ini bukan pengukuran konsumsi baterai harian.
- Build debug/release, verifikasi tanda tangan, dan zipalign 16 KiB lulus. Lint debug dan release masing-masing mencatat 0 error dan 10 warning.
- APK yang sama sudah dipasang sebagai update pada HP pengembang. Job terdaftar otomatis setelah update dan tetap menunggu setelah proses aplikasi direklamasi secara normal, tanpa service pemantau aktif.

Lihat [rincian perilaku dan pengujian](../../docs/BATTERY-PATCH.md). Source/build/test dan sumber dependensi yang sesuai disertakan dalam arsip corresponding source; kunci penandatanganan dan konfigurasi pribadi tidak disertakan. Ketentuan [GPL-3.0-only](../../LICENSE) dan [lisensi dependensi](../../docs/THIRD-PARTY-NOTICES.md) tetap berlaku.
