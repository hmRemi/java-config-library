package dev.revere.configmanager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigManagerTest {
    private ConfigManager configManager;

    @Before
    public void setUp() {
        configManager = new ConfigManager();
        configManager.addSource(new MockConfigSource());
    }

    @Test
    public void testGetValue() throws IOException {
        configManager.loadConfig();
        assertEquals("value", configManager.getValue("key"));
    }

    private static class MockConfigSource implements ConfigSource {
        @Override
        public void load() {
        }

        @Override
        public String getValue(String key) {
            return "key".equals(key) ? "value" : null;
        }
    }
}