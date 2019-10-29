package jpp.infinityloop.GUI;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import jpp.infinityloop.Tile;

import javax.security.auth.callback.Callback;

public class TileView extends ImageView {

    private Animation animation;
    private Tile tile;
    private Callback callback;
    private ImageView imageView;

    public TileView(Tile tile){
        this.tile = tile;
        Images images = new Images(tile);
        ImageView imageView = new ImageView(images.getImage());

        //rotate the image to fit the tile in the Parameter
        while (!images.getKachelAufDemBild().equals(tile)){ //rotating the image so that it fits the tile
            images.getKachelAufDemBild().rotateTeil();
            imageView.setRotate(imageView.getRotate() + 90);
        }
        this.imageView = imageView;
        imageView.setFitHeight(75);
        imageView.setFitWidth(75);
//        imageView.setOnMouseClicked(event -> {
//            imageView.setRotate(imageView.getRotate() + 90);
//            tile.rotateTeil();
//        });
    }


    public ImageView getImageView() {
        return imageView;
    }

    public void rotateImageView(){
        tile.rotateTeil();
        imageView.setRotate(imageView.getRotate() + 90);
    }
}
