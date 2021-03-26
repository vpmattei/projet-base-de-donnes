public class ImageFile {
    private int ID;
    private int ClientID;

    private String path;
    private String cameraWork;
    private int pixelSize;

    private boolean isShared;

    public ImageFile(int ID, int ClientID, String path, String cameraWork, int pixelSize) {
        this.ID = ID;
        this.ClientID = ClientID;
        this.path = path;
        this.cameraWork = cameraWork;
        this.pixelSize = pixelSize;
    }

    public ImageFile(int ID, int ClientID, String path, int pixelSize) {
        this.ID = ID;
        this.ClientID = ClientID;
        this.path = path;
        this.pixelSize = pixelSize;
    }

    public ImageFile(int ID, int ClientID, String path) {
        this.ID = ID;
        this.ClientID = ClientID;
        this.path = path;
    }

    public int ID() {
        return ID;
    }

    public int ClientID() {
        return ClientID;
    }

    public String path() {
        return path;
    }

    public int pixelSize() {
        return pixelSize;
    }

    public String cameraWork() {
        return cameraWork;
    }

    public boolean isShared() {
        return isShared;
    }

    public void changeClientID(int newClientID) {
        ClientID = newClientID;
    }

    public void changepath(String newpath) {
        path = newpath;
    }

    public void changepixelSize(int newPixelSize) {
        pixelSize = newPixelSize;
    }

    public void changeShareStatus(Boolean status) {
        isShared = status;
    }

    public void changePostalAdress(String newCameraWork) {
        cameraWork = newCameraWork;
    }
}
