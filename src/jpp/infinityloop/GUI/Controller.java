package jpp.infinityloop.GUI;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import jpp.infinityloop.Board;
import jpp.infinityloop.generatoren.MatrixGenerator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public VBox buttonsMenu;
    public SplitPane splitpane;
    public VBox vbox;
    public AnchorPane anchroPaneTiles;
    public BorderPane mainBorder;

    public void startGame(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MatrixGenerator matrixGenerator = new MatrixGenerator(14, 14);
        Board board = matrixGenerator.next();
//        tilePanesParent.maxHeightProperty().bind(main.heightProperty());
//        tilePanesParent.maxWidthProperty().bind(main.widthProperty());
        TileGrid tileGrid = new TileGrid(board, vbox);
        tileGrid.maxHeightProperty().bind(splitpane.heightProperty());
        tileGrid.maxWidthProperty().bind(splitpane.widthProperty());

        splitpane.maxWidthProperty().bind(mainBorder.widthProperty());
        splitpane.maxHeightProperty().bind(mainBorder.heightProperty());

//        RowConstraints rowConstraints1 = new RowConstraints();
//        rowConstraints1.setPercentHeight(10);
//        RowConstraints rowConstraints2 = new RowConstraints();
//        rowConstraints2.setPercentHeight(10);
//        RowConstraints rowConstraints3 = new RowConstraints();
//        rowConstraints3.setPercentHeight(10);
//        RowConstraints rowConstraints4 = new RowConstraints();
//        rowConstraints4.setPercentHeight(10);
//        RowConstraints rowConstraints5 = new RowConstraints();
//        rowConstraints5.setPercentHeight(10);
//        gridpane.getRowConstraints().addAll(rowConstraints1,rowConstraints2,rowConstraints3,rowConstraints4,rowConstraints5);
//
//
//        ColumnConstraints columnConstraints1 = new ColumnConstraints();
//        columnConstraints1.setPercentWidth(10);
//        ColumnConstraints columnConstraints2 = new ColumnConstraints();
//        columnConstraints2.setPercentWidth(10);
//        ColumnConstraints columnConstraints3 = new ColumnConstraints();
//        columnConstraints3.setPercentWidth(10);
//        ColumnConstraints columnConstraints4 = new ColumnConstraints();
//        columnConstraints4.setPercentWidth(10);
//
//        gridpane.getColumnConstraints().addAll(columnConstraints1,columnConstraints2,columnConstraints3,columnConstraints4);


//        tileGrid.layoutXProperty().bind(main.widthProperty().subtract(tileGrid.prefWidth(-1)).divide(2));
//        tileGrid.layoutYProperty().bind(main.heightProperty().subtract(tileGrid.prefHeight(-1)).divide(2));

        buttonsMenu.getChildren().add(new Button());
        vbox.setStyle("-fx-background-color: red");
    }
}
