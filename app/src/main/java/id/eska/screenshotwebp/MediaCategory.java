package id.eska.screenshotwebp;

public enum MediaCategory {
    SCREENSHOTS("Screenshots"),
    PHOTOS("Photos");

    private final String label;

    MediaCategory(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
