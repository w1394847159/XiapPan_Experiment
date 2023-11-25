package cn.wugm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class JavaFx_test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button chooseButton = new Button("选择文件夹");
        chooseButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("文件夹", "*/*")
            );
            fileChooser.setTitle("选择文件夹");
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                System.out.println("选择的文件夹路径：" + selectedFile.getPath());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(chooseButton);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("文件选择器示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
