import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        String databasePath = "src/database.txt";

        Handler handler = new Handler();
        File database = new File(databasePath);
        FileWriter databaseWriter = null;
        if (!database.exists()) {
            databaseWriter = new FileWriter(databasePath);
        } else {
            scanner = new Scanner(databasePath);

            System.out.println("ssdfs");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        scanner = new Scanner(System.in);
        String currentCmd = "";

        do {
            System.out.print("Run commands.\nInput \"exit-setup\" to end.\nInput \"cmdList\" to view all commands.\nInput a command:");
            currentCmd = scanner.nextLine();
            currentCmd = removeFrontSpaces(currentCmd);

            try {
                Method method = handler.getClass().getMethod(currentCmd);
                if (!method.equals(null)) method.invoke(handler);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            System.out.println("\n");
        } while (!currentCmd.equals("exit-setup"));
    }

    public static String removeFrontSpaces(String cmd) {
        while (cmd.indexOf(" ") == 0) {
            cmd = cmd.substring(1, cmd.length());
        }
        return cmd;
    }
}
