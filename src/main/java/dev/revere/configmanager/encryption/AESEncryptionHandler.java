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

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Provides AES encryption and decryption functionality using a Base64-encoded key.
 *
 * <p>This class uses the AES encryption algorithm to encrypt and decrypt strings. It requires a Base64-encoded key to initialize the encryption handler.</p>
 *
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class AESEncryptionHandler {
    private final SecretKey secretKey;

    /**
     * Constructs an {@code AESEncryptionHandler} with the specified Base64-encoded key.
     *
     * @param base64Key The Base64-encoded key used for AES encryption and decryption.
     */
    public AESEncryptionHandler(String base64Key) {
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        this.secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    /**
     * Encrypts a plain text string using AES encryption.
     *
     * @param plainText The string to encrypt.
     * @return The Base64-encoded encrypted string.
     * @throws Exception If an error occurs during encryption.
     */
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Decrypts a Base64-encoded encrypted string using AES decryption.
     *
     * @param cipherText The Base64-encoded encrypted string to decrypt.
     * @return The decrypted plain text string.
     * @throws Exception If an error occurs during decryption.
     */
    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        return new String(cipher.doFinal(decodedBytes));
    }
}