package com.company.badservice.utils.crypt;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class CryptoService {

    /**
     * Safely encrypt secret, so that only certain users will be able to read it.
     */
    public String encrypt(String secret) {
        byte[] clearBytes = secret.getBytes(StandardCharsets.UTF_8);

        byte[] cryptBytes = new byte[clearBytes.length];
        for (int i = 0; i < clearBytes.length; i++) {
            cryptBytes[i] = (byte) (clearBytes[i] - 1);
        }
        return new String(cryptBytes, StandardCharsets.UTF_8);
    }

    /**
     * Decrypt secret previously encrypted.
     */
    public String decrypt(String secret) {
        byte[] cryptBytes = secret.getBytes(StandardCharsets.UTF_8);

        byte[] clearBytes = new byte[cryptBytes.length];
        for (int i = 0; i < cryptBytes.length; i++) {
            clearBytes[i] = (byte) (cryptBytes[i] + 1);
        }
        return new String(clearBytes, StandardCharsets.UTF_8);
    }

}
