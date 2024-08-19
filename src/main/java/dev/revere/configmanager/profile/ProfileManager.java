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
package dev.revere.configmanager.profile;

import dev.revere.configmanager.ConfigSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages and activates configuration profiles.
 *
 * <p>This class allows adding, activating, and retrieving values from configuration profiles.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ProfileManager {

    private final Map<String, ConfigSource> profiles = new HashMap<>();
    private ConfigSource activeProfile;

    /**
     * Adds a configuration profile to the manager.
     *
     * @param name   The name of the profile.
     * @param source The source of the profile.
     */
    public void addProfile(String name, ConfigSource source) {
        profiles.put(name, source);
    }

    /**
     * Activates the specified profile.
     *
     * <p>The profile must be added to the manager before activation. Loading the profile might
     * throw an {@code IOException} if there are issues with the source.</p>
     *
     * @param name The name of the profile to activate.
     * @throws IOException If the profile could not be loaded.
     */
    public void activateProfile(String name) throws IOException {
        activeProfile = profiles.get(name);
        activeProfile.load();
    }

    /**
     * Retrieves the value associated with the specified key from the active profile.
     *
     * <p>Returns {@code null} if the key does not exist in the active profile.</p>
     *
     * @param key The key to search for.
     * @return The value of the key, or {@code null} if the key does not exist.
     */
    public String getProfileValue(String key) {
        return activeProfile.getValue(key);
    }
}