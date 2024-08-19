package dev.revere.configmanager.encryption;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class ConfigEncryptorTest {
    private static final String SECRET_KEY = "ErrIFtuvOm/kGowL/rgu22sQeHzITNVr/TXs4mLpLFQ="; // random key for testing
    private final ConfigEncryptor encryptor = new ConfigEncryptor(SECRET_KEY);

    @Test
    public void testEncryptDecrypt() throws Exception {
        String plainText = "SensitiveData";
        String encryptedValue = encryptor.encryptConfigValue(plainText);
        String decryptedValue = encryptor.decryptConfigValue(encryptedValue);

        assertEquals(plainText, decryptedValue);
    }
}