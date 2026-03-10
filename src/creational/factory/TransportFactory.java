package creational.factory;

public class TransportFactory {
    public Transport createTransport(String type){
        if(type.equalsIgnoreCase("car"))
            return new Car();
        if(type.equalsIgnoreCase("bike"))
            return new Bike();
        return null;
    }
}
