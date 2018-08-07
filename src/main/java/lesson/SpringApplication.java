package lesson;

import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.net.www.http.HttpClient;

import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {

        //org.springframework.boot.SpringApplication.run(SpringApplication.class);


        String[] dicts = {"abcw","baz","foo","bar","xtfn","abcdef"};

        System.out.println( new SpringApplication().maxProduct(dicts) );
    }


    public int maxProduct(String[] words) {

        if (words == null || words.length < 2)
            return 0;

        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        Set<Integer>[] characterSet = new Set[26];
        for (int i = 0; i < 26; i++) {
            characterSet[i] = new HashSet<>();
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                characterSet[ch - 'a'].add(i);
            }
        }


        int maxResult = 0;
        for (int i = words.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (characterSet[k].contains(i) && characterSet[k].contains(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    maxResult = Math.max(words[i].length() * words[j].length(), maxResult);
                }
            }
        }

        return 0;
    }

}
