import java.lang.reflect.Method;

public class Handler {

    public void cmdList() {
        Method[] methods = this.getClass().getDeclaredMethods();

        System.out.println("\nAll commands:");
        for (int i = 0; i < methods.length; i++) {
            System.out.println("" + methods[i].getName());
        }
    }
}
