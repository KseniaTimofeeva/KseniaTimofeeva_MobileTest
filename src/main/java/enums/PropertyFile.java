package enums;

public enum PropertyFile {
    NATIVE_TEST_PROPERTIES("nativetest.properties"),
    WEB_TEST_PROPERTIES("webtest.properties");

    private String fileName;

    PropertyFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
