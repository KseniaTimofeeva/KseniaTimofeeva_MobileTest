package setup;

import enums.PropertyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private static final Logger LOG = LogManager.getLogger(TestProperties.class);

    private Properties currentProps = new Properties();
    private PropertyFile propertyFile;

    public TestProperties() {
        LOG.debug("Test properties init");
    }

    public void setPropertyFile(PropertyFile propertyFile) {
        this.propertyFile = propertyFile;
        LOG.debug("Set property file {}", propertyFile);
    }

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(propertyFile.getFileName());
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
