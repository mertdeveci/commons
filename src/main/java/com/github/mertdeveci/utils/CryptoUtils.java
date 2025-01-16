package com.github.mertdeveci.utils;

import com.github.mertdeveci.exceptions.utils.CryptoEncryptionUtilsExceptions;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Objects;

public final class CryptoUtils {

    private CryptoUtils() {}

    private static final String SALT = "=^+_1>m/le[1gxb$";
    private static final String AES = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final Integer OP_MODE = 1;

    public static String encrypt(String plainText, String salt) {
        try{
            Key key = new SecretKeySpec(Objects.requireNonNull(salt).getBytes(), AES);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(OP_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
        } catch (Exception e){
            throw new CryptoEncryptionUtilsExceptions("Cannot encrypt string", e);
        }
    }

    public static String encrypt(String plainText){
        return encrypt(plainText, SALT);
    }

    public static String decrypt(String cipherText, String salt) {
        try{
            Key key = new SecretKeySpec(Objects.requireNonNull(salt).getBytes(), AES);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(OP_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } catch (Exception e){
            throw new CryptoEncryptionUtilsExceptions("Cannot decrypt string", e);
        }
    }

    public static String decrypt(String cipherText){
        return decrypt(cipherText, SALT);
    }

}
