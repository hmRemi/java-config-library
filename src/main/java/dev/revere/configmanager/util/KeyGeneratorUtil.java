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
package dev.revere.configmanager.util;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * A utility class for generating AES keys.
 *
 * <p>This class provides methods to generate AES keys with a specified size and encode them in Base64 format.
 * The default key size is 256 bits, but this can be adjusted as needed.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class KeyGeneratorUtil {

    private static final int DEFAULT_KEY_SIZE = 256;

    /**
     * Generates a new AES key with the default size (256 bits) and encodes it in Base64 format.
     *
     * @return the Base64 encoded AES key, or {@code null} if an error occurs.
     */
    public static String generateKey() {
        return generateKey(DEFAULT_KEY_SIZE);
    }

    /**
     * Generates a new AES key with the specified size and encodes it in Base64 format.
     *
     * @param keySize the size of the key in bits (e.g., 128, 192, or 256).
     * @return the Base64 encoded AES key, or {@code null} if an error occurs.
     * @throws IllegalArgumentException if the keySize is not 128, 192, or 256 bits.
     */
    public static String generateKey(int keySize) {
        if (keySize != 128 && keySize != 192 && keySize != 256) {
            throw new IllegalArgumentException("Invalid key size. Allowed sizes are 128, 192, or 256 bits.");
        }

        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(keySize);

            SecretKey secretKey = keyGen.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating AES key: " + e.getMessage(), e);
        }
    }
}