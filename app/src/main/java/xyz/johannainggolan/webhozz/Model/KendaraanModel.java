package xyz.johannainggolan.webhozz.Model;

public class KendaraanModel {
    String name = "";
    String numberPlate = "";


    public KendaraanModel(String name, String numberPlate, int imageSource) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }

    int imageSource = 0;
}
