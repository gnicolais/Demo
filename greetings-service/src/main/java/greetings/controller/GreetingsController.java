package greetings.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import greetings.resource.GreetingResource;
import greetings.service.interfaces.GreetingsInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/greetings")
public class GreetingsController implements GreetingsInterface {

    private static final Log logger = LogFactory.getLog(GreetingsController.class);

    @Override
    @RequestMapping(value = "/{language}/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("language") String language, @PathVariable("name") String name) {
       return buildMessage(language,name);
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public GreetingResource sayHello(@RequestBody String greeting) {

        GreetingResource greetingResource = null;
        try {
            greetingResource = new ObjectMapper().readValue(greeting,GreetingResource.class);
        } catch (IOException e) {
            logger.error("sayHello error: ", e);
        }

        greetingResource.setMessage( buildMessage(greetingResource.getLanguage(),greetingResource.getName()));

        return greetingResource;
    }

    private String buildMessage(String language, String name){
        StringBuilder message = new StringBuilder();

        if (!StringUtils.isEmpty(language)) {
            if (language.toLowerCase().equals("english")) {
                message.append("Hello, ");
            }else{
                message.append("!£$=?%, ");
            }
        }
        return message.append(name).toString();
    }
}
