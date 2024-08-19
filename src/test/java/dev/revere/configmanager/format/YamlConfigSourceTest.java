package dev.revere.configmanager.format;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class YamlConfigSourceTest {
    private YamlConfigSource yamlConfigSource;

    @Before
    public void setUp() throws IOException {
        File tempFile = File.createTempFile("config", ".yaml");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("key: value");
        }
        yamlConfigSource = new YamlConfigSource(tempFile);
    }

    @Test
    public void testLoad() throws IOException {
        yamlConfigSource.load();
        assertEquals("value", yamlConfigSource.getValue("key"));
    }
}