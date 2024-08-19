package dev.revere.configmanager.format;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class PropertiesConfigSourceTest {
    private PropertiesConfigSource propertiesConfigSource;

    @Before
    public void setUp() throws IOException {
        File tempFile = File.createTempFile("config", ".properties");
        Properties props = new Properties();
        props.setProperty("key", "value");
        try (FileWriter writer = new FileWriter(tempFile)) {
            props.store(writer, null);
        }
        propertiesConfigSource = new PropertiesConfigSource(tempFile);
    }

    @Test
    public void testLoad() throws IOException {
        propertiesConfigSource.load();
        assertEquals("value", propertiesConfigSource.getValue("key"));
    }
}