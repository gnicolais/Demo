package welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import welcome.client.GreetingClient;
import welcome.resource.WelcomeResource;
import welcome.service.interfaces.WelcomeInterface;

@RestController
@RequestMapping("/welcome")
public class WelcomeController implements WelcomeInterface {

    @Autowired
    GreetingClient greetingClient;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {

        String json = "{ \"language\" : \"english\", \"name\" : \"Stranger\" }";
        WelcomeResource out = greetingClient.sayHello(json);
        String outMessage = out.getMessage() + ", welcome to the world!";

        return outMessage;
    }
}
