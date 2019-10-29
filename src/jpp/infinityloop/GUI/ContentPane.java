package jpp.infinityloop.GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ContentPane extends BorderPane {
        private TileGrid tileGrid;
        Text text;

        public ContentPane(TileGrid  tileGrid, Text text ){
            this.tileGrid = tileGrid;
            BorderPane borderPane = new BorderPane();
            GridPane gridPane = new GridPane();


        }
}
