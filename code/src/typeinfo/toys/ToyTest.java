// typeinfo/toys/ToyTest.java
// Testing class Class
// {java typeinfo.toys.ToyTest}

package typeinfo.toys;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Comment out the following no-arg constructor to see NoSuchMethodError
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

/**
 * ToyTest
 */
public class ToyTest {
    static void printInfo(Class<?> klass) {
        System.out.println("Class name: " + klass.getName() + " is interface? [" + klass.isInterface() + "]");
        System.out.println("Simple name: " + klass.getSimpleName());
        System.out.println("Canonical name: " + klass.getCanonicalName());
        System.out.println("");
    }

    public static void main(String[] args) {
        Class<?> klass = null;

        try {
            klass = Class.forName("typeinfo.toys.FancyToy");
        } catch (Exception e) {
            System.out.println("Cann't find FancyToy");
            System.exit(1);
        }
        printInfo(klass);

        for (Class<?> face : klass.getInterfaces()) {
            printInfo(face);
        }

        Class<?> up = klass.getSuperclass();
        Object obj = null;
        try {
            // Requires no-arg constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
