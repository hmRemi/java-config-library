package dev.revere.configmanager.encryption;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Remi
 * @project java-config-system
 * @date 8/19/2024
 */
public class AESEncryptionHandlerTest {
    private static final String SECRET_KEY = "ErrIFtuvOm/kGowL/rgu22sQeHzITNVr/TXs4mLpLFQ="; // random key for testing
    private final AESEncryptionHandler encryptionHandler = new AESEncryptionHandler(SECRET_KEY);

    @Test
    public void testEncryptionDecryption() throws Exception {
        String plainText = "Hello, World!";
        String encryptedText = encryptionHandler.encrypt(plainText);
        String decryptedText = encryptionHandler.decrypt(encryptedText);

        assertEquals(plainText, decryptedText);
    }
}