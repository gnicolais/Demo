package welcome.client;

import welcome.resource.WelcomeResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="greetings-service")
@RequestMapping("/greetings")
public interface GreetingClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public WelcomeResource sayHello(@RequestBody String greeting);

    @RequestMapping(value = "/{language}/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("language") String language, @PathVariable("name") String name);
}
