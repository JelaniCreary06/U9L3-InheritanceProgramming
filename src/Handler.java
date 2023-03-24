import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Hashtable;
import java.util.Scanner;

public class Handler {
    private static Hashtable<String, PhysicalHardDrive> driveTable = new Hashtable();
    private  Hashtable<String, PhysicalVolume> volumeTable = new Hashtable();
    private Hashtable<String, VolumeGroup> volumegroupTable = new Hashtable();
    private Hashtable<String, LogicalVolume> logicalTable = new Hashtable();

    public void cmdList() {
        Method[] methods = this.getClass().getDeclaredMethods();

        System.out.println("\nAll commands:");
        for (int i = 0; i < methods.length; i++) {
            if (!Modifier.isStatic(methods[i].getModifiers())) System.out.println("" + methods[i].getName());
        }
    }

    public void install_drive(String cmdInput[]) {
        driveTable.put(cmdInput[1], new PhysicalHardDrive(cmdInput[1], Double.parseDouble(cmdInput[2])));
        System.out.println("New drive" + driveTable);
    }

    public void install_drive() {
        System.out.println("Test");
    }
}
