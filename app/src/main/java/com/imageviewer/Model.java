package com.imageviewer;

/**
 * Created by Akshay Jindam on 12-03-2017.
 */

public class Model {
    String imageID;
    private String imageUrl, imageName, designerName;


    public Model() {
    }


    public Model(String imageUrl, String imageName) {
    }

    public Model(String imageUrl, String imageID, String imageName, String designerName) {
        this.imageID = imageID;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
        this.designerName = designerName;
    }


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }
}
