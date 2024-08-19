package dev.revere.configmanager;

import java.io.IOException;

/**
 * Interface for a configuration source.
 *
 * <p>This interface defines the contract for any configuration source used in the system.
 * It requires methods to load the source data and to retrieve configuration values based on keys.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public interface ConfigSource {
    /**
     * Loads the configuration source data.
     *
     * <p>This method is responsible for reading and initializing the configuration data
     * from the source. Implementations should handle the specifics of loading the data,
     * such as reading from files, databases, or other sources. It may throw an {@link IOException}
     * if the source cannot be loaded due to an error.</p>
     *
     * @throws IOException If the source could not be loaded due to an I/O error.
     */
    void load() throws IOException;

    /**
     * Retrieves the value associated with the specified key from the source.
     *
     * <p>This method allows querying the configuration source for a value corresponding
     * to the given key. If the key is not present in the source, the method returns {@code null}.</p>
     *
     * @param key The key to search for.
     * @return The value associated with the key, or {@code null} if the key does not exist.
     */
    String getValue(String key);
}