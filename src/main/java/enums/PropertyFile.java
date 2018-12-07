package enums;

public enum PropertyFile {
    NATIVE_TEST_PROPERTIES("nativetest.properties", "native"),
    WEB_TEST_PROPERTIES("webtest.properties", "web");

    private String fileName;
    private String propertyName;

    PropertyFile(String fileName, String propertyName) {
        this.fileName = fileName;
        this.propertyName = propertyName;
    }

    public String getFileName() {
        return fileName;
    }

    public static PropertyFile getPropertyFile(String usePropFile) {
        for (PropertyFile file : PropertyFile.values()) {
            if (file.propertyName.equals(usePropFile)) {
                return file;
            }
        }
        throw new IllegalArgumentException("File was not found");
    }
}
