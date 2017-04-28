package com.app.koreq.commlistview.utils;

import android.util.Base64;
import android.util.Log;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * project : CommListView
 * author : YanBin on 3/31/17
 * version : v3.0
 * description : AES Utils
 * <p>
 * secret key length:   128bit, default:    128 bit<br/>
 * mode:    ECB/CBC/PCBC/CTR/CTS/CFB/CFB8 to CFB128/OFB/OBF8 to OFB128<br/>
 * padding: Nopadding/PKCS5Padding/ISO10126Padding/
 */
public class AESUtils {

    public static final String TAG = AESUtils.class.getSimpleName();

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static final String AESKey = "dfdf390a074130d157a2305fd2f7d1dc"; //test

    /**
     * 初始化密钥 example : baf2712390e5495db4f21b67275c0ea0
     *
     * @return byte[] 密钥
     * @throws Exception
     */
    public static byte[] initSecretKey() {
        //返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //初始化此密钥生成器，使其具有确定的密钥大小
        //AES 要求密钥长度为 128
        kg.init(128);
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 转换密钥
     *
     * @param key 二进制密钥
     * @return 密钥
     */
    private static Key toKey(byte[] key) {
        //生成密钥
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    /**
     * 加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, Key key) throws Exception {
        return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 加密
     *
     * @param data 待加密数据
     * @param key  二进制密钥
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 加密
     *
     * @param data            待加密数据
     * @param key             二进制密钥
     * @param cipherAlgorithm 加密算法/工作模式/填充方式
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        //还原密钥
        Key k = toKey(key);
        return encrypt(data, k, cipherAlgorithm);
    }

    /**
     * 加密
     *
     * @param data            待加密数据
     * @param key             密钥
     * @param cipherAlgorithm 加密算法/工作模式/填充方式
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }


    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  二进制密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, Key key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data            待解密数据
     * @param key             二进制密钥
     * @param cipherAlgorithm 加密算法/工作模式/填充方式
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        //还原密钥
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }

    /**
     * 解密
     *
     * @param data            待解密数据
     * @param key             密钥
     * @param cipherAlgorithm 加密算法/工作模式/填充方式
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    public static String decryptFormTr(String sKey, String sSrc) throws Exception {
        //Fatal Exception: java.lang.OutOfMemoryError
        //java.lang.AbstractStringBuilder.enlargeBuffer
        // log 信息组装在低配置手机可能造成崩溃
//        LOG.i(DBG, TAG, "Encrypt key:" + sKey + "  src:" + sSrc);
        // 判断Key是否正确
        if (sKey == null) {
            Log.e(TAG, "Key为空null");
            return null;
        }
        // 判断Key是否为16位
//        if (sKey.length() != 16) {
//            LOG.e(DBG, TAG, "Key长度不是16位");
//            return null;
//        }

        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted1 = Base64.decode(sSrc, Base64.NO_WRAP);//先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, "utf-8");
    }

    private static String showByteArray(byte[] data) {
        if (null == data) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        for (byte b : data) {
            sb.append(b).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

//    public static void main(String[] args) throws Exception {
//        byte[] key = initSecretKey();
//        System.out.println("key：" + showByteArray(key));
//
//        Key k = toKey(key);
//
//        String data = "AES数据";
//        System.out.println("加密前数据: string:" + data);
//        System.out.println("加密前数据: byte[]:" + showByteArray(data.getBytes()));
//        System.out.println();
//        byte[] encryptData = encrypt(data.getBytes(), k);
//        System.out.println("加密后数据: byte[]:" + showByteArray(encryptData));
//        System.out.println("加密后数据: hexStr:" + HexUtils.encodeHexStr(encryptData));
//
//        //下面代码会抛出异常：Exception in thread "main" java.lang.RuntimeException: Stub! 原因：java和Android的库不能混用
//        System.out.println("加密后数据: Base64:" + Base64.encodeToString(encryptData, Base64.NO_WRAP));
//
//
//        System.out.println();
//        byte[] decryptData = decrypt(encryptData, k);
//        System.out.println("解密后数据: byte[]:" + showByteArray(decryptData));
//        System.out.println("解密后数据: string:" + new String(decryptData));
//
//    }
}
