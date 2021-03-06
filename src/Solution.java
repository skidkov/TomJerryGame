public class Solution {
    public static void main(String[] args) {
        Dog spike = new Dog("Spike", 400);
        Cat tom = new Cat("Tom", 300);
        Mouse jerry = new Mouse("Jerry", 300);

        tom.move(100);
        jerry.move(100);
        System.out.println("tom.geoposition: " + tom.geoposition);
        System.out.println("spike.geoposition: " + spike.geoposition);
        System.out.println("jerry.geoposition: " + jerry.geoposition);

        if (tom.geoposition == jerry.geoposition) {
            jerry.status = false;
            tom.hungry = false;
            System.out.println("Is Jerry alive? " + jerry.status + ". Is Tom hungry? " + tom.hungry);
        } else {
            jerry.status = true;
            tom.hungry = true;
            System.out.println("Is Jerry alive? " + jerry.status + ". Is Tom hungry? " + tom.hungry);
        }

        if (spike.geoposition == tom.geoposition) {
            tom.status = false;
            spike.hungry = false;
            System.out.println("Is Tom alive? " + tom.status + ". Is Spike hungry? " + spike.hungry);
        } else {
            tom.status = true;
            spike.hungry = true;
            System.out.println("Is Tom alive? " + tom.status + ". Is Spike hungry? " + spike.hungry);
        }
    }

    public interface Movable {
        void move(int distance);
    }

    public interface Eatable {
        boolean eaten();
    }

    public interface Eat {
        boolean eat();
    }

    public static class Cat implements Eat, Eatable, Movable {
        String name;
        int geoposition;

        public Cat(String name, int geoposition) {
            this.name = name;
            this.geoposition = geoposition;
        }

        boolean status;
        boolean hungry;

        public boolean eat() {
            return hungry;
        }

        public boolean eaten() {
            return status;
        }

        public void move(int distance) {
            geoposition += distance;
        }
    }

    public static class Mouse implements Eatable, Movable {
        String name;
        int geoposition;

        public Mouse(String name, int geoposition) {
            this.name = name;
            this.geoposition = geoposition;
        }

        boolean status;

        public boolean eaten() {
            return status;
        }

        public void move(int distance) {
            geoposition += distance;
        }
    }

    public static class Dog implements Eat, Movable {
        String name;
        int geoposition;

        public Dog(String name, int geoposition) {
            this.name = name;
            this.geoposition = geoposition;
        }

        boolean hungry;

        public boolean eat() {
            return hungry;
        }

        public void move(int distance) {
        }
    }
}