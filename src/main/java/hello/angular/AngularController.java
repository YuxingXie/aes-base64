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
    private int maxId;
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
        maxId=20;
    }

    @GetMapping("/api/hero/{id}")
    public Hero hero(@PathVariable int id){
        System.out.println("request hero id "+id);
        for(Hero hero:heroes){
            if (id==hero.getId()){
                return hero;
            }
        }
        return null;
    }

    @GetMapping("/api/hero/search")
    public List<Hero> hero(@RequestParam String name){
        System.out.println("search hero name: "+name);
        List<Hero> heroList=null;
        for(Hero hero:heroes){
            if (hero.getName().contains(name)){
                if (heroList==null) heroList =new ArrayList<>();
                System.out.print(hero.getName()+",");
               heroList.add(hero);
            }

        }
        System.out.println("");
        return heroList;
    }
    @PutMapping("/api/hero")
    public CommonApiResponse updateHero(@RequestBody Hero hero){

        for(Hero _hero:heroes){
            if (hero.getId()==_hero.getId()){
                _hero.setName(hero.getName());
                System.out.println("hero update");
                return new CommonApiResponse(true,"hero is updated");
            }
        }
        return new CommonApiResponse(false,"没找到英雄");
    }
    @PostMapping("/api/hero/add")
    public Hero addHero(@RequestBody Hero hero){
        hero.setId(++maxId);
        heroes.add(hero);
        System.out.println("add hero "+hero.getName());
        return hero;
    }
    @GetMapping("/api/heroes")
    public List<Hero> heroes(){
        System.out.println("request heroes");
        return heroes;
    }

}
