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
package dev.revere.configmanager.encryption;

/**
 * Utility class for encrypting and decrypting configuration values using AES encryption.
 *
 * <p>This class provides methods to encrypt and decrypt configuration values using an AES encryption key.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigEncryptor {
    private final AESEncryptionHandler encryptionHandler;

    /**
     * Constructs a {@code ConfigEncryptor} with the specified Base64-encoded encryption key.
     *
     * @param base64Key The Base64-encoded key used for AES encryption.
     */
    public ConfigEncryptor(String base64Key) {
        this.encryptionHandler = new AESEncryptionHandler(base64Key);
    }

    /**
     * Encrypts a plain text configuration value.
     *
     * @param plainValue The value to encrypt.
     * @return The encrypted value encoded as a Base64 string.
     * @throws Exception If an error occurs during encryption.
     */
    public String encryptConfigValue(String plainValue) throws Exception {
        return encryptionHandler.encrypt(plainValue);
    }

    /**
     * Decrypts an encrypted configuration value.
     *
     * @param encryptedValue The Base64-encoded encrypted value to decrypt.
     * @return The decrypted plain text value.
     * @throws Exception If an error occurs during decryption.
     */
    public String decryptConfigValue(String encryptedValue) throws Exception {
        return encryptionHandler.decrypt(encryptedValue);
    }
}