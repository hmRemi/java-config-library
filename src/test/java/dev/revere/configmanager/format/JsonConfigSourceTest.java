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
public class JsonConfigSourceTest {
    private JsonConfigSource jsonConfigSource;

    @Before
    public void setUp() throws IOException {
        File tempFile = File.createTempFile("config", ".json");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("{ \"key\": \"value\" }");
        }
        jsonConfigSource = new JsonConfigSource(tempFile);
    }

    @Test
    public void testLoad() throws IOException {
        jsonConfigSource.load();
        assertEquals("value", jsonConfigSource.getValue("key"));
    }
}