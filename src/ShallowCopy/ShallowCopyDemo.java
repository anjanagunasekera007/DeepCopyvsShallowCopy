package ShallowCopy;

/**
 * Created by anjana on 8/15/17.
 * medium :
 * github :
 *
 */

class Person implements Cloneable{

    String name;
    String telephone;
    Car car;

    public Person(String name, String telephone,Car car)
    {
        this.name = name;
        this.telephone = telephone;
        this.car = car;
    }

    protected Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

class Car {
    String make;
    String model;
    String color;

    public Car(String make,String model,String color)
    {
        this.make = make;
        this.model = model;
        this.color = color;
    }
}


public class ShallowCopyDemo
{
    public static void main(String[] args) {

        //Creating the car object
        Car c1 = new Car("Chevrolet","Camaro","yellow");

        //Creating the Person object
        Person p1 = new Person("Tom","65789354",c1);

        Person p2 = null;

        //cloning the p1 object to p2
        p2 = (Person)p1.clone();

        //Lets check the original object.
        System.out.println("Person 1 : " + p1.name + " , " +p2.car.color ); //OUTPUT  => Person 1 : Tom , yellow

        //Let's change the color of P2s car and check the results
        p2.car.color = "red";

        //Lets check the results after the change
        System.out.println("Person 1 : " + p1.name + " , " +p1.car.color );  //OUTPUT => Person 1 : Tom , red
        System.out.println("Person 2 : " + p2.name + " , " +p2.car.color );  //OUTPUT => Person 2 : Tom , red

    }
}
