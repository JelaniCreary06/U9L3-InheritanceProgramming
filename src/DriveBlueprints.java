import java.util.UUID;
public class DriveBlueprints {
    protected String name, uuid = UUID.randomUUID().toString();;
    protected double size, availableSpace;

    public DriveBlueprints(String name, double size) {
        this.name = name; this.size = size; this.availableSpace = size;
    }

    public DriveBlueprints(String name) {
        this.name = name;
    }

    public String name() { return this.name; }
    public String uuid() { return this.uuid; }
    public double size() { return this.size; }

    public void name(String name) { this.name = name; }
    public void availableSpace(double toSubtract) { this.availableSpace -= toSubtract; }
}
