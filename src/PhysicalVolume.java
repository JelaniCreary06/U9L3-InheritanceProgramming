public class PhysicalVolume extends LogicalVolume {
    private VolumeGroup volumeGroup = null;
    private PhysicalHardDrive physicalHardDrive = null;
    public PhysicalVolume(String name) {
        super(name);
    }
    public boolean physicalHardDrive(PhysicalHardDrive physicalHardDrive) {
        if (physicalHardDrive.physicalVolume(this)) return true;
        return false;
    }


    public boolean physicalVolumeGroup(VolumeGroup volumeGroup) {
        if (volumeGroup == null) {
            this.volumeGroup = volumeGroup;
            return true;
        } return false;
    }

    public PhysicalHardDrive physicalHardDrive() { return this.physicalHardDrive; }

    @Override
    public String toString() {
        String toReturn = this.name + ": [" + physicalHardDrive.size + "] ";
        if (volumeGroup != null) toReturn += "[" + volumeGroup.name + "] ";

        toReturn += "[" + this.uuid + "]";
        return toReturn;
    }
}
