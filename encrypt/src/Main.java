import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 加解密
 *
 * @author xstoop
 * @date 2021/8/29 下午8:40
 */
public class Main {
    public static void main(String[] args) throws Exception {

        String phone = "+86-18981925766";
        byte l = (byte) ((byte)phone.length() / 2);

        System.out.println((phone.length() / 2));
        System.out.println(phone.replaceFirst(phone.substring(l, l+4), "*"));

        System.out.println(phone.replace(phone.substring(l, l+4), "**"));
    }

    /**
     * 使用私钥进行消息签名
     *
     */
    public void signature() throws Exception {
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();

        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        byte[] message = "this is a secret message".getBytes(StandardCharsets.UTF_8);

        // 使用私钥生成签名
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(message);

        byte[] signed = signature.sign();
        System.out.println(String.format("签名结果: %x", new BigInteger(1, signed)));

        // 使用公钥对原始信息与签名进行验证
        Signature signature1 = Signature.getInstance("SHA1withRSA");
        signature1.initVerify(publicKey);
        signature1.update(message);
        boolean verify = signature1.verify(signed);
        System.out.println("验证结果 " + verify);
    }

    /**
     * RSA 进行加密解密
     */
    public void RSA() throws Exception {

        byte[] message = "this is a secret message".getBytes(StandardCharsets.UTF_8);
        Person xiaohong = new Person("xiao hong");

        byte[] encrypt = xiaohong.encrypt(message);

        System.out.println(String.format("公钥加密 %s", new BigInteger(1, xiaohong.getPublicKey())));
        System.out.println(String.format("加密结果 %s", new BigInteger(1, encrypt)));

        byte[] decrypt = xiaohong.decrypt(encrypt);

        System.out.println(String.format("私钥解密 %s", new BigInteger(1, xiaohong.getPrivateKey())));
        System.out.println(String.format("解密结果 %s", new String(decrypt, StandardCharsets.UTF_8.toString())));
    }

}

class Person {
    String name;

    PrivateKey sk;

    PublicKey pk;

    public Person(String name) throws GeneralSecurityException {
        this.name = name;

        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();

        this.sk = kp.getPrivate();
        this.pk = kp.getPublic();
    }

    public byte[] getPrivateKey() {
        return this.sk.getEncoded();
    }

    public byte[] getPublicKey() {
        return this.pk.getEncoded();
    }

    /**
     * 公钥加密
     */
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.pk);
        return cipher.doFinal(message);
    }

    /**
     * 私钥解密
     */
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.sk);
        return cipher.doFinal(input);
    }
}