package servlet;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    public class PasswordEncrypt {

        public static String encryptPassword(String password) {
            try {

                MessageDigest digest = MessageDigest.getInstance("SHA-256");


                byte[] hashedBytes = digest.digest(password.getBytes());


                StringBuilder hexString = new StringBuilder();
                for (byte b : hashedBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {

                e.printStackTrace();
                return null;
            }
        }

}