package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Maksym_Hromyk on 08.08.2017.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String templatePost = "Hello, %s! This is a Post Request";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value="/greetingPost", method=RequestMethod.POST)
    public Greeting greetingPost(@RequestParam(value="name", defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(), String.format(templatePost, name));
    }
}
