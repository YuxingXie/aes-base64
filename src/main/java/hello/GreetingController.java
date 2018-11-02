package hello;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.angular.Hero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GreetingController {

    @PostMapping("/greeting")
    public ResponseMessage decryptString(@RequestBody String encryptString) {


        try {
            ObjectMapper objectMapper=new ObjectMapper();
            String decryptString=AESUtils.getDecryptString(encryptString);
            Greeting greeting = objectMapper.readValue(decryptString, Greeting.class);
            if(greeting.getUserName()==null || greeting.getPassword()==null){
                return new ResponseMessage(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED,"用户名或密码不能为空");
            }
            if(!greeting.getUserName().equals("zhangsan")&&!greeting.getPassword().equals("123")){
                return new ResponseMessage(HttpStatus.UNAUTHORIZED);
            }
            /**
             * do something here! such as:
             * 持久化对象
             */
            return new ResponseMessage(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        } catch (NoSuchPaddingException e) {

            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());

        } catch (InvalidKeyException e) {

            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());

        } catch (IllegalBlockSizeException e) {

            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());

        } catch (BadPaddingException e) {
            e.printStackTrace();
            return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }


}
