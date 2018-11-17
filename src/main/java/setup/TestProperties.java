package setup;

import enums.PropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(String.valueOf(PropertyFile.NATIVE_TEST_PROPERTIES));
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}
