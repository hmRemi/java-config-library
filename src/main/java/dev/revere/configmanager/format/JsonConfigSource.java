package dev.revere.configmanager.format;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.revere.configmanager.ConfigSource;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * {@code ConfigSource} implementation for JSON files.
 *
 * <p>This class loads configuration data from a JSON file using Jackson's ObjectMapper and provides access to the configuration values.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class JsonConfigSource implements ConfigSource {
    private final File file;
    private Map<String, String> configMap;

    /**
     * Constructs a {@code JsonConfigSource} with the specified file.
     *
     * @param file The JSON file to load configuration from.
     */
    public JsonConfigSource(File file) {
        this.file = file;
    }

    /**
     * Loads configuration data from the JSON file into the internal {@code Map}.
     *
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Override
    public void load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        configMap = mapper.readValue(file, new TypeReference<Map<String, String>>() {});
    }

    /**
     * Retrieves the value associated with the specified key from the loaded configuration.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or {@code null} if the key does not exist.
     */
    @Override
    public String getValue(String key) {
        return configMap.get(key);
    }
}