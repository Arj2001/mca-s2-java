class Animal{

    void makeSound(){
        System.out.println("Some generic sound");
    }
}
class Dog extends Animal{

    void makeSound(){
        System.out.println("Bark");
    }
}
class Cat extends Animal{

    void makeSound(){
        System.out.println("Meow");
    }
}
class Cow extends Animal{

    void makeSound(){
        System.out.println("Moo");
    }
}
public class OverridingAnimal {
    
    public static void main(String[] args) {
        
        Dog d = new Dog();
        d.makeSound();
        Cat c = new Cat();
        c.makeSound();
        Cow co = new Cow();
        co.makeSound();
    }
}
