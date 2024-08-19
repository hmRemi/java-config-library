package dev.revere.configmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Manages configuration sources and provides access to configuration values.
 *
 * <p>This class allows adding multiple configuration sources, loading configurations from all sources,
 * and retrieving configuration values based on a key. It iterates through the sources in the order they were added
 * and returns the value from the first source that contains the specified key.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigManager {
    private final List<ConfigSource> sources = new ArrayList<>();

    /**
     * Adds a configuration source to the manager.
     *
     * <p>This method registers a new configuration source. The source will be used
     * when loading configurations and retrieving values.</p>
     *
     * @param source The {@link ConfigSource} to add.
     */
    public void addSource(ConfigSource source) {
        sources.add(source);
    }

    /**
     * Loads configurations from all registered sources.
     *
     * <p>This method iterates through all added configuration sources and loads their
     * configuration data. It may throw an {@link IOException} if any of the sources cannot
     * be loaded.</p>
     *
     * @throws IOException If an error occurs while loading a source.
     */
    public void loadConfig() throws IOException {
        for (ConfigSource source : sources) {
            source.load();
        }
    }

    /**
     * Retrieves the value associated with the specified key from the sources.
     *
     * <p>This method searches for the specified key in the order the sources were added.
     * It returns the value from the first source that contains the key. If the key does not exist
     * in any of the sources, it returns {@code null}.</p>
     *
     * @param key The key to search for.
     * @return The value associated with the key, or {@code null} if the key does not exist.
     */
    public String getValue(String key) {
        for (ConfigSource source : sources) {
            String value = source.getValue(key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}