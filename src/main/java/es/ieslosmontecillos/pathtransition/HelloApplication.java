package es.ieslosmontecillos.pathtransition;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        // Crear el círculo
        Circle circle = new Circle(200, 200, 100);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);

        // Crear el rectángulo que rodeará el borde círculo
        Rectangle rectangle = new Rectangle(0, 0, 50, 100);
        rectangle.setFill(Color.YELLOW);


        root.getChildren().addAll(circle, rectangle);

        // Crea la animación de PathTransition
        PathTransition pathTransition = new PathTransition();

        // Duración de la animación
        pathTransition.setDuration(Duration.millis(4000));

        // Hace que el rectángulo se mueva por el borde del círculo
        pathTransition.setPath(circle);
        pathTransition.setNode(rectangle);

        // Asigna el número de veces que se repite la animación
        pathTransition.setCycleCount(PathTransition.INDEFINITE);


        // Eventos del ratón sobre el círculo
        circle.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                pathTransition.pause();
            }
        });

        circle.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                pathTransition.play();
            }
        });

        // Comienza la animación
        pathTransition.play();

        stage.setScene(scene);
        stage.setTitle("PathTransition Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}