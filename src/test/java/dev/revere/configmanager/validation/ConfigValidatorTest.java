package dev.revere.configmanager.validation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigValidatorTest {
    @Test
    public void testValidation() {
        Map<String, String> schema = new HashMap<>();
        schema.put("age", "integer");
        schema.put("name", "string");

        Map<String, String> validConfig = new HashMap<>();
        validConfig.put("age", "30");
        validConfig.put("name", "John");

        Map<String, String> invalidConfig = new HashMap<>();
        invalidConfig.put("age", "thirty");
        invalidConfig.put("name", "John");

        ConfigValidator validator = new ConfigValidator(schema);

        assertTrue(validator.validate(validConfig));
        assertFalse(validator.validate(invalidConfig));
    }
}