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