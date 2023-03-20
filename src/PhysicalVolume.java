public class PhysicalVolume extends DriveBlueprints {
    private VolumeGroup volumeGroup = null;
    private PhysicalHardDrive physicalHardDrive = null;

    public PhysicalVolume(String name) {
        super(name);
    }

    public boolean physicalHardDrive(PhysicalHardDrive physicalHardDrive) {
        if (physicalHardDrive.physicalVolume(this)) return true;
        return false;
    }

    public boolean volumeGroup(VolumeGroup volumeGroup) {
        if (volumeGroup == null) {
            this.volumeGroup = volumeGroup;
            return true;
        } return false;
    }

    @Override
    public String toString() {
        String toReturn = this.name + ": [" + physicalHardDrive.size + "] ";
        if (volumeGroup != null) toReturn += "[" + volumeGroup.name + "] ";

        toReturn += "[" + this.uuid + "]";
        return toReturn;
    }
}
