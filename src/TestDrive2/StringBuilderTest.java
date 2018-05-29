package TestDrive2;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Mother mila Ramu";
        String[] sArr = s.split("\\s");
        System.out.println(sArr.length);
        for (int i = 0; i < sArr.length; i++) System.out.println(sArr[i]);
    }
//    public static void main(String[] args) {
//
//        StringBuilder sb = new StringBuilder();
//        for (char c = 'A'; c <= 'z'; c++) sb.append(c);
//        sb.delete(26, 32);
//        System.out.println(sb);
////        String s = sb.toString();
//        byte [] bytesAz = sb.toString().getBytes();
//        for (byte b = 0; b < bytesAz.length; b++) System.out.print(bytesAz[b] + " ");
//    }
}
