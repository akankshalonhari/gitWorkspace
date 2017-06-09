package SamplesProject.examples;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*** Hello world! ***/

@RestController
@EnableAutoConfiguration
public class App 
{	
	@RequestMapping("/")
    String hello() {
        return "Hello welcome to Akanksha`s world!";
    }
	
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
    

}