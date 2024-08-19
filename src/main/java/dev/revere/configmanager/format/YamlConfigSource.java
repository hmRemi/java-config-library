/*
 * MIT License
 *
 * Copyright (c) 2024 Revere Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.revere.configmanager.format;

import dev.revere.configmanager.ConfigSource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * {@code ConfigSource} implementation for YAML configuration files.
 *
 * <p>This class loads configuration data from a YAML file and provides access to the configuration values.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class YamlConfigSource implements ConfigSource {

    private final File file;
    private Map<String, String> configMap;

    /**
     * Constructs a {@code YamlConfigSource} with the specified file.
     *
     * @param file The YAML file to load configuration from.
     */
    public YamlConfigSource(File file) {
        this.file = file;
    }

    /**
     * Loads configuration data from the YAML file into the internal map.
     *
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Override
    public void load() throws IOException {
        Yaml yaml = new Yaml();
        try (FileInputStream fis = new FileInputStream(file)) {
            configMap = yaml.load(fis);
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
        return configMap.get(key);
    }
}