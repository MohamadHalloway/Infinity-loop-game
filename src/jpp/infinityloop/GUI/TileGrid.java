package jpp.infinityloop.GUI;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import jpp.infinityloop.Board;
import jpp.infinityloop.Tile;

import java.util.Iterator;

public class TileGrid extends VBox{

    public TileGrid(Board generated, VBox vBox) {
        Iterator<Tile> iterator = generated.getTiles().iterator();
        for (int j = 0; j < generated.getHeight(); j++) {
            HBox hBox = new HBox();
            for (int i = 0; i < generated.getWidth(); i++) {
                TileView tileView = new TileView(iterator.next());
                ImageView imageView = tileView.getImageView();
                hBox.getChildren().add(imageView);
            }
            vBox.getChildren().add(hBox);
        }


//        gridpane.setPadding(new Insets(10, 10, 10, 10));
//        for (int j = 0; j < generated.getHeight(); j++){
//            gridpane.addRow(j);
////            RowConstraints rowConstraints = new RowConstraints();
////            rowConstraints.setPercentHeight(100 / generated.getHeight());
////            gridpane.getRowConstraints().add(rowConstraints);
//        }
//        for (int i = 0; i < generated.getWidth(); i++){
//            gridpane.addColumn(i);
////            ColumnConstraints columnConstraints = new ColumnConstraints();
////            columnConstraints.setPercentWidth(100 / generated.getWidth());
////            gridpane.getColumnConstraints().add(columnConstraints);
//        }
////        tilePane.setPrefColumns(generated.getWidth());
////        tilePane.setPrefRows(generated.getHeight());
//        for (int j = 0; j < generated.getHeight(); j++){
//            for (int i = 0; i < generated.getWidth(); i++){
//                TileView tileView = new TileView(iterator.next());
//                ImageView imageView = tileView.getImageView();
//
//                Pane anchorpane = new Pane(imageView);
//                imageView.fitHeightProperty().bind(anchorpane.heightProperty());
//                imageView.fitWidthProperty().bind(anchorpane.widthProperty());
//                anchorpane.setStyle("-fx-background-color: blue");
//                imageView.setOnMouseClicked(event ->  tileView.rotateImageView());
////                anchorpane.setTopAnchor(imageView, 0.0);
////                anchorpane.setBottomAnchor(imageView, 0.0);
////                anchorpane.setLeftAnchor(imageView, 0.0);
////                anchorpane.setRightAnchor(imageView, 0.0);
//
//                gridpane.add(anchorpane , i , j);
////                gridpane.getChildren().add(imageView);
//            }
//        }
//        for (int i = 0; i < gridpane.getChildren().size(); i++) {
//            gridpane.setHgrow(gridpane.getChildren().get(i), Priority.ALWAYS);
//            gridpane.setVgrow(gridpane.getChildren().get(i), Priority.ALWAYS);
//            GridPane.setFillWidth(gridpane.getChildren().get(i), true);
//            GridPane.setFillHeight(gridpane.getChildren().get(i), true);
//
//        }
//        gridpane.setStyle("-fx-background-color: red ");








//        this.root = new Pane();
//
//        final int count = generated.getTiles().size(); //number of rectangles
//
//        NumberBinding minSide = Bindings
//                .min(root.heightProperty(), root.widthProperty())
//                .divide(count);
//
//        for (int x = 0; x < count; x++) {
//            for (int y = 0; y < count; y++) {
//                Rectangle rectangle = new Rectangle(0, 0, Color.LIGHTGRAY);
//
//                rectangle.xProperty().bind(minSide.multiply(x));
//                rectangle.yProperty().bind(minSide.multiply(y));
//                rectangle.heightProperty().bind(minSide.subtract(2));
//                rectangle.widthProperty().bind(rectangle.heightProperty());
//                root.getChildren().add(rectangle);
//            }
//        }
    }

//    private void gridsetup(GridPane gridPane) {
//        ColumnConstraints columnConstraints = new ColumnConstraints();
//        columnConstraints.setPercentWidth(50);
//        gridPane.getColumnConstraints().add(columnConstraints);
//
//        columnConstraints = new ColumnConstraints();
//        columnConstraints.setPercentWidth(50);
//        gridPane.getColumnConstraints().add(columnConstraints);
//
//
//    }
}
