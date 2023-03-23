import java.util.Hashtable;

public class VolumeGroup extends LogicalVolume {
    private Hashtable<String, PhysicalVolume> pvTable = new Hashtable();

    public VolumeGroup(String name) {
        super(name);
    }

    public boolean addPhysicalVolume(PhysicalVolume physicalVolume) {
        if (physicalVolume.volumeGroup(this) || !pvTable.contains(physicalVolume)) {
            pvTable.put(physicalVolume.name, physicalVolume);
            return true;
        }
        return false;
    }

    public double totalGB() {
        final double[] toReturn = {0};

        pvTable.forEach((k, v) -> {
            toReturn[0] += v.physicalHardDrive().size;
        });

        return toReturn[0];
    }


    public double availableSpace() {
        final double[] toReturn = {0};

        pvTable.forEach((k, v) -> {
            toReturn[0] += v.physicalHardDrive().availableSpace;
        });

        return toReturn[0];
    }

    @Override
    public String toString() {
        String toReturn = this.name + ": total:[" + totalGB() + "G] available: [" + availableSpace + "] [" ;

        for (int i = 0; i < pvTable.size(); i++) {
            toReturn += pvTable.get(i).name;

            if (i == pvTable.size() - 1) break;
            else toReturn += ", ";
        }

        toReturn += "] [" + this.uuid + "]";

        return toReturn;
    }
}
