package dev.revere.configmanager.profile;

import dev.revere.configmanager.ConfigSource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ProfileManagerTest {
    private ProfileManager profileManager;

    @Before
    public void setUp() {
        profileManager = new ProfileManager();
        profileManager.addProfile("dev", new MockConfigSource("devConfigValue"));
        profileManager.addProfile("prod", new MockConfigSource("prodConfigValue"));
    }

    @Test
    public void testActivateProfile() throws IOException {
        profileManager.activateProfile("prod");
        assertEquals("prodConfigValue", profileManager.getProfileValue("key"));
    }

    private record MockConfigSource(String value) implements ConfigSource {

        @Override
        public void load() {
        }

        @Override
        public String getValue(String key) {
            return "key".equals(key) ? value : null;
        }
    }
}