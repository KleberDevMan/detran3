package br.com.detran3.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 * Criptografa a senha
 * @author kleber       
 */
public class PassGenerator {
    
//    public static void main(String[] args) {
//        System.out.println(new PassGenerator().generate("123"));
//    }
    
    public String generate (String senhaTexto) {
        try {
            byte[] digest = MessageDigest.getInstance("sha-256")
                    .digest(senhaTexto.getBytes());
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
