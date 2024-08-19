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