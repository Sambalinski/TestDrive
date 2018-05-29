package TestDrive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Test2 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String s = "test string";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(s.getBytes());
        printMD5(byteArrayOutputStream); // 6f8db599de986fab7a21625b7916589c

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s);
        oos.flush();

        printMD5(bos); // 5a47d12a2e3f9fecf2d9ba1fd98152eb
        printMD5(s); //6f8db599de986fab7a21625b7916589c
        md5Custom(s); //6f8db599de986fab7a21625b7916589c

    }

    public static void printMD5(ByteArrayOutputStream byteArrayOutputStream) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(byteArrayOutputStream.toByteArray());
        byte[] bytes = messageDigest.digest();
        BigInteger bigInteger = new BigInteger(1, bytes);
        String s = bigInteger.toString(16);
        if (s.length() < 32) {
            s = "0" + s;
        }
        System.out.println(s);
    }

    public static void printMD5(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(s.getBytes());
        byte[] bytes = messageDigest.digest();
        BigInteger bigInteger = new BigInteger(1, bytes);
        String temp = bigInteger.toString(16);
//        if (s.length() < 32) {
//            temp = "0" + s;
//        }
        System.out.println(temp);
    }

    //пример из интернета
    public static void md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        System.out.println(md5Hex);
    }
}