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
package dev.revere.configmanager.validation;

import java.util.Map;

/**
 * Validates a configuration map against a schema.
 *
 * <p>This class checks if a configuration map adheres to a specified schema where each key is
 * a field name and each value is the expected type (e.g., "integer").</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigValidator {

    private final Map<String, String> schema;

    /**
     * Constructs a ConfigValidator with the given schema.
     *
     * @param schema A map defining the expected types for configuration fields.
     */
    public ConfigValidator(Map<String, String> schema) {
        this.schema = schema;
    }

    /**
     * Validates a configuration map against the schema.
     *
     * <p>Checks if each key in the schema is present in the configuration map and if its value
     * matches the expected type.</p>
     *
     * @param config The configuration map to validate.
     * @return {@code true} if the configuration is valid; {@code false} otherwise.
     */
    public boolean validate(Map<String, String> config) {
        for (Map.Entry<String, String> entry : schema.entrySet()) {
            String key = entry.getKey();
            String expectedType = entry.getValue();
            String value = config.get(key);

            if (value == null) {
                return false;
            }

            // Type check for integer
            if ("integer".equals(expectedType) && !value.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }
}