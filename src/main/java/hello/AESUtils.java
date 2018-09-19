package hello;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @description: AES加密工具类
 * @author: maojialong
 * @date: 2017年11月7日 上午10:11:02
 */
public class AESUtils {

    //实例化密钥
    private static Key key;

    //原始密钥
    private static String KEY_STR = "ningxiang12345";

    //编码
    private static String CHARSETNAME = "UTF-8";

    //密钥算法
    private static String KEY_ALGORITHM = "AES";

    //加密-解密算法 / 工作模式 / 填充方式
    private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 初始化key
     */
    static {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(KEY_STR.getBytes());
            kgen.init(128, random);
            key = kgen.generateKey();
            kgen = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @description: AES对称加密字符串，并通过Jdk自带Base64转换为ASCII
     * @author: Administrator
     * @date: 2017年11月7日 上午9:37:48
     * @param str
     * @return
     */
    public static String getEncryptString(String str) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

            byte[] bytes = str.getBytes(CHARSETNAME);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return Base64.getEncoder().encodeToString(doFinal);

    }

    /**
     * @description: 对AES加密字符串进行解密
     * @param str
     * @return
     */
    public static String getDecryptString(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {

            byte[] bytes = Base64.getDecoder().decode(str);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, CHARSETNAME);

    }
}