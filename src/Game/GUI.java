package Game;

//Import statements

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.shape.*;

import java.io.FileInputStream;
import java.util.List;

public class GUI extends Application {

    /**
     * Fields
     */
    Button button;
    int x;
    int y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the Window");

        DropShadow shadow = new DropShadow();
        x = 20;
        y = 20;

        /**
         * Inputs files and sets them to an image
         */
        FileInputStream istream = new FileInputStream("/Users/celestegambardella/Downloads/resources/button.png");
        Image image = new Image(istream);

        /**
         * Creates a square: needs four inputs for the side sizes
         *
         * CHANGE VARIABLE IN RECTANGLE.
         * 5 x 5: (45)
         * 6 x 6: (48)
         * 7 x 7: (51)
         * 8 x 8: (56)
         * 9 x 9: (57)
         *
         */
        Group box = new Group();
        Rectangle rectangle = new Rectangle(45, 45, 45, 45);
        rectangle.setFill(Color.RED);
        box.getChildren().add(rectangle);

        /**
         * Creates a horizontal line
         * v, v2: the square length
         * v1, v3: the stroke
         */
        Group lineX = new Group();
        Rectangle line_x = new Rectangle(47, 10, 47, 10);
        line_x.setFill(Color.BLACK);
        lineX.getChildren().add(line_x);

        /**
         * Creates a vertical line
         * v, v2: the square length
         * v1, v3: the stroke
         */
        Group lineY = new Group();
        Rectangle line = new Rectangle(10, 47, 10, 47);
        line.setFill(Color.BLACK);
        lineY.getChildren().add(line);

        /**
         * Sets color for grid background
         */
        Color redColor = Color.rgb(255, 0, 0, 0.5);
        BackgroundFill backgroundFill = new BackgroundFill(redColor, null, null);
        Background background = new Background(backgroundFill);

        /**
         * Makes Tilepane:Grid and sets its values.
         * Make sure that the Pref columns, # of dots, and distance between them are related.
         *
         * CHANGE THE VARIABLE HERE
         */
        TilePane grid = new TilePane();
        grid.setPrefColumns(5);     // SET the amount of columns needed here
        grid.setBackground(background);
        grid.resize(490, 540);

        /**
         * Adds hover effect to the dots and gets the number of dots created.
         *
         * CHANGE VARIABLE IN FOR LOOP.
         * 5 x 5: (25)
         * 6 x 6: (36)
         * 7 x 7: (49)
         * 8 x 8: (64)
         * 9 x 9: (81)
         *
         */
        for (int x = 0; x < 25; x++) {  // SET the of total num of dots here
            ImageView imageView = new ImageView(image);
            imageView.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    e -> imageView.setEffect(shadow));

            imageView.addEventHandler(MouseEvent.MOUSE_EXITED,
                    e -> imageView.setEffect(null));
            grid.getChildren().add(imageView);
        }

        /**
         * Sets the gap between each of
         * the dots both vertically
         * and horizontally.
         * CHANGE VARIABLE IN FOR LOOP.
         * 5 x 5: (20)
         * 6 x 6: (24)
         * 7 x 7: (28)
         * 8 x 8: (32)
         * 9 x 9: (32)

         */
        grid.setHgap(20);   // SET the gap between dots here
        grid.setVgap(20);
        Pane pane = new Pane();
        //pane.setBackground(background);
        pane.resize(490, 540);

        /**
         * Adds everything to the pane and relocates as necessary.
         *
         * CHANGE VARIABLE IN RELOCATE BOX.
         * 5 x 5: (19, 19)
         * 6 x 6: (19, 19)
         * 7 x 7: (19, 19)
         * 8 x 8: (19, 19)
         * 9 x 9: (19, 19)
         *
         * CHANGE VARIABLE IN RELOCATE LINEx.
         * 5 x 5: (19, 19)
         * 6 x 6: (19, 19)
         * 7 x 7: (19, 19)
         * 8 x 8: (19, 19)
         * 9 x 9: (19, 19)
         *
         * CHANGE VARIABLE IN RELOCATE LINEx.
         * 5 x 5: (19, 19)
         * 6 x 6: (19, 19)
         * 7 x 7: (19, 19)
         * 8 x 8: (19, 19)
         * 9 x 9: (19, 19)
         */
        pane.getChildren().add(grid);
        pane.getChildren().add(box);
        pane.getChildren().add(lineX);
        pane.getChildren().add(lineY);
        box.relocate(19, 19);  // SET the location of the squares
        lineX.relocate(19, 13);  // SET the location of lineX
        lineY.relocate(13, 19);     // SET the location of lineY

        /**
         * Sets up the scene and loads it into the stage(screen)
         * and
         */
        Scene scene2 = new Scene(pane, 490, 540);
        Stage k = new Stage();
        // k.setResizable(false);
        k.setScene((scene2));

        // Shows screen (DON'T CHANGE)
        k.show();
        // primaryStage.show();
    }

}