package xyz.johannainggolan.webhozz.Model;

public class KendaraanModel2 {

    String name="";
    String numberPlate="";
    int imageResource=0;

    public KendaraanModel2(String name, String numberPlate, int imageResource){
         this.name = name;
         this.numberPlate = numberPlate;
         this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getImageResource() {
        return imageResource;
    }

}
