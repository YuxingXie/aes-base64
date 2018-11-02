package hello.angular;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.AESUtils;
import hello.Greeting;
import hello.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AngularController {
    private List<Hero> heroes = new ArrayList<>();
    public AngularController() {
        Hero hero1 =new Hero(11,  "Mr. Nice" );
        Hero hero2 =new Hero(12,  "Narco" );
        Hero hero3 =new Hero(13,  "Bombasto" );
        Hero hero4 =new Hero(14,  "Celeritas" );
        Hero hero5 =new Hero(15,  "Magneta" );
        Hero hero6 =new Hero(16,  "RubberMan" );
        Hero hero7 =new Hero(17,  "Dynama" );
        Hero hero8 =new Hero(18,  "Dr IQ" );
        Hero hero9 =new Hero(19,  "Magma" );
        Hero hero10 =new Hero(20,  "Tornado");
        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        heroes.add(hero4);
        heroes.add(hero5);
        heroes.add(hero6);
        heroes.add(hero7);
        heroes.add(hero8);
        heroes.add(hero9);
        heroes.add(hero10);

    }

    @RequestMapping("/api/hero/{id}")
    public Hero hero(@PathVariable int id){
        System.out.println("request hero id "+id);
        for(Hero hero:heroes){
            if (id==hero.getId()){
                return hero;
            }
        }
        return null;
    }
    @RequestMapping("/api/heroes")
    public List<Hero> heroes(){
        System.out.println("request heroes");
        return heroes;
    }

}
