package SuanFa;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IsValid {

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now1 = LocalDateTime.now();
        String freezeExpireTime = "2020-08-13 14:31:31";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime freezeTime = LocalDateTime.parse(freezeExpireTime,df);
        System.out.println(now1);
    }

    public static boolean isValid(String s) {
return false;

    }

}
