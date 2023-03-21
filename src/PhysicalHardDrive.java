public class PhysicalHardDrive extends DriveBlueprints {
    private PhysicalVolume physicalVolume = null;

    public PhysicalHardDrive(String name, double size) {
        super(name, size);
    }

    public boolean physicalVolume(PhysicalVolume physicalVolume) {
        if (physicalVolume != null) {
            this.physicalVolume = physicalVolume;
            return true;
        }
        return false;
    }

    public PhysicalVolume physicalVolume() { return this.physicalVolume; }

    @Override
    public String toString() {
        return this.name + " [" + this.size + "G] [" + this.uuid + "]";
    }
}
