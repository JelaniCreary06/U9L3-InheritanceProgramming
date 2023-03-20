import java.util.Hashtable;

public class VolumeGroup extends DriveBlueprints {
    private Hashtable<String, PhysicalVolume> pvTable = new Hashtable();

    public VolumeGroup(String name, PhysicalVolume physicalVolume) {
        super(name);
    }

    public boolean addPhysicalVolume(PhysicalVolume physicalVolume) {
        if (physicalVolume.volumeGroup(this)) pvTable.put(physicalVolume.name, physicalVolume);
        return false;
    }

    @Override
    public String toString() {

    }
}
