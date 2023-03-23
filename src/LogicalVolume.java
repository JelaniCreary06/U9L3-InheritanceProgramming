import java.util.UUID;
public class LogicalVolume {
    protected String name, uuid = UUID.randomUUID().toString();;
    protected double size, availableSpace;

    private VolumeGroup volumeGroup = null;

    public LogicalVolume(String name, double size, VolumeGroup volumeGroup) {
        this(name, size);
    }
    public LogicalVolume(String name, double size) {
        this.name = name; this.size = size; this.availableSpace = size;
    }

    public LogicalVolume(String name) {
        this.name = name;
    }

    final public boolean volumeGroup(VolumeGroup volumeGroup) {
        if (this.volumeGroup == null) {
            this.volumeGroup = volumeGroup;
            return true;
        } return false;
    }

    public String name() { return this.name; }
    public String uuid() { return this.uuid; }
    public double size() { return this.size; }

    public void name(String name) { this.name = name; }
    public void availableSpace(double toSubtract) { this.availableSpace -= toSubtract; }

    public String toString() {
        return "[" + this.size + "G] [" + this.volumeGroup + "] [" + this.uuid + "]";
    }
}
