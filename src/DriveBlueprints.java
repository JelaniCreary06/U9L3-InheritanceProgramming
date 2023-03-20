import java.util.UUID;
public class DriveBlueprints {
    protected String name, uuid = UUID.randomUUID().toString();;
    protected double size;

    public DriveBlueprints(String name, double size) {
        this.name = name; this.size = size;
    }

    public DriveBlueprints(String name) {
        this.name = name;
    }

    public String name() { return this.name; }
    public String uuid() { return this.uuid; }
    public double size() { return this.size; }

    public void name(String name) { this.name = name; }
    public void size(double size) { this.size += size; }
}
