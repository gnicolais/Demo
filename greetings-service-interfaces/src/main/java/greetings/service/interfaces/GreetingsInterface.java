package greetings.service.interfaces;

public interface GreetingsInterface<T> {

    public String sayHello(String language, String name);

    public T sayHello(String greeting);

    //public <E> E sayHello(T greeting); //try with a signature like this

}