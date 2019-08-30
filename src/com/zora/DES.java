package com.zora;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>DES和3DES</p>
 *
 * @author : jyh
 * @date : 2019/08/27
 **/
public class DES {
    public static void main(String[] args) {
        try {
            String msg =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<Transaction>\n" +
                            "    <Transaction_Header>\n" +
                            "        <SYS_TX_CODE><![CDATA[P1OPME001]]></SYS_TX_CODE>\n" +
                            "        <SYS_MSG_LEN><![CDATA[0000000777]]></SYS_MSG_LEN>\n" +
                            "        <SYS_REQ_TIME><![CDATA[20190827133334399]]></SYS_REQ_TIME>\n" +
                            "        <SYS_TX_VRSN><![CDATA[01]]></SYS_TX_VRSN>\n" +
                            "        <TXN_DT><![CDATA[20190827]]></TXN_DT>\n" +
                            "        <TXN_TM><![CDATA[133334]]></TXN_TM>\n" +
                            "        <TXN_STFF_ID><![CDATA[555555]]></TXN_STFF_ID>\n" +
                            "        <MULTI_TENANCY_ID><![CDATA[CN000]]></MULTI_TENANCY_ID>\n" +
                            "        <LNG_ID><![CDATA[zh-cn]]></LNG_ID>\n" +
                            "        <REC_IN_PAGE></REC_IN_PAGE>\n" +
                            "        <PAGE_JUMP></PAGE_JUMP>\n" +
                            "        <STS_TRACE_ID></STS_TRACE_ID>\n" +
                            "        <CHNL_CUST_NO><![CDATA[JS32000009020921001]]></CHNL_CUST_NO>\n" +
                            "        <IttParty_Jrnl_No></IttParty_Jrnl_No>\n" +
                            "        <Txn_Itt_IP_Adr><![CDATA[128.3.81.208]]></Txn_Itt_IP_Adr>\n" +
                            "    </Transaction_Header>\n" +
                            "    <Transaction_Body></Transaction_Body>\n" +
                            "</Transaction>";
            ;
            String password = "zZ6U4IzV/kq2fHYTXkwNL82elOCM1f5K";
            String s1 = DES3.DESedeEncrypt(msg, password);
            System.out.println("加密:" + s1);
            //s1 = DES3.DESedeDecrypt(s1, password);
            byte[] bt = s1.getBytes();
            System.out.println("解密:" + Arrays.toString(bt));
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

}

class DES3 {

    private static final String KEY_ALGORITHM = "DESede";
    /**
     * 默认的加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * DESede 加密操作
     *
     * @param content 待加密内容
     * @param key     加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String DESedeEncrypt(String content, String key) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            // 通过Base64转码返回
            return encoder.encodeToString(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * DESede 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String DESedeDecrypt(String content, String key) {
        try {
            // 实例化
            Base64.Decoder decoder = Base64.getDecoder();
            // 使用密钥初始化，设置为解密模式
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 执行操作
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            byte[] result = cipher.doFinal(decoder.decode(content));
            return new String(result, "utf-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(new SecureRandom(key.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            // 转换为DESede专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}