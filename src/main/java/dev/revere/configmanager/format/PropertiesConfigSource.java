package dev.revere.configmanager.format;

import dev.revere.configmanager.ConfigSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * {@code ConfigSource} implementation for properties files.
 *
 * <p>This class loads configuration data from a properties file and provides access to the configuration values.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class PropertiesConfigSource implements ConfigSource {

    private final File file;
    private final Properties properties = new Properties();

    /**
     * Constructs a {@code PropertiesConfigSource} with the specified file.
     *
     * @param file The properties file to load configuration from.
     */
    public PropertiesConfigSource(File file) {
        this.file = file;
    }

    /**
     * Loads configuration data from the properties file into the internal {@code Properties} object.
     *
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Override
    public void load() throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        }
    }

    /**
     * Retrieves the value associated with the specified key from the loaded configuration.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or {@code null} if the key does not exist.
     */
    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}