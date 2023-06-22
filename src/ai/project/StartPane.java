/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.project;

/**
 *
 * @author Boody Shlby
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

// يمثل الحاوية التي سنظهرها عند تشغيل البرنامج StartPane الكلاس 
public class StartPane extends Pane {

    // هنا قمنا بإنشاء جميع الأشياء التي سنضعها في الحاوية
    Button singlePlayer = new Button("Single Player");
    Button multiPlayer = new Button("Multi Player");
    Button settings = new Button("Settings");
    Button about = new Button("About");
    Button exit = new Button("Exit");

    // about لأننا سنستخدمه لعرض نافذة منبثقة عندما يقوم المستخدم بالنقر على الزر Alert هنا قمنا بإنشاء كائن من الكلاس
    Alert alert = new Alert(AlertType.INFORMATION);

    // هذا كونستركور الكلاس
    public StartPane() {

        // StartPane هنا قمنا بتحديد حجم كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        singlePlayer.setPrefSize(240, 40);
        multiPlayer.setPrefSize(240, 40);
        settings.setPrefSize(240, 40);
        about.setPrefSize(240, 40);
        exit.setPrefSize(240, 40);

        // StartPane هنا قمنا بتحديد موقع كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        singlePlayer.setTranslateX(80);
        singlePlayer.setTranslateY(110);
        multiPlayer.setTranslateX(80);
        multiPlayer.setTranslateY(170);
        settings.setTranslateX(80);
        settings.setTranslateY(230);
        about.setTranslateX(80);
        about.setTranslateY(290);
        exit.setTranslateX(80);
        exit.setTranslateY(350);

        // StartPane هنا قمنا بإضافة كل شيء قمنا بإنشائه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        getChildren().add(singlePlayer);
        getChildren().add(multiPlayer);
        getChildren().add(settings);
        getChildren().add(about);
        getChildren().add(exit);

        // singlePlayer هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مكان الحاوية الحالية singlePlayerPane لعرض الحاوية التي يمثلها الكائن viewPane() سيتم إستدعاء الدالة الثابتة
        singlePlayer.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.singlePlayerPane);
        });

        // multiPlayer هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مكان الحاوية الحالية multiPlayerPane لعرض الحاوية التي يمثلها الكائن viewPane() سيتم إستدعاء الدالة الثابتة
        multiPlayer.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.multiPlayerPane);
        });

        // settings هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مكان الحاوية الحالية settings لعرض الحاوية التي يمثلها الكائن viewPane() سيتم إستدعاء الدالة الثابتة
        settings.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.settingsPane);
        });

        // about هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // alert سيتم تجهيز نص يمثل معلومات عامة عن اللعبة و الذي سنعرضه بداخل النافذة المنبثقة التي يمثلها الكائن
        about.setOnAction((Action) -> {
            String str
                    = "Prepared by :\n"
                    + "Zead Shalaby AbdelWahab  \n"
                   
                    + "Email:  shalabyziad0@gmain.com\n\n"
                    + "© Copyright 2022 - All Rights Reserved";

            alert.setTitle("About Tic Tac Toe");
            alert.setHeaderText("About Tic Tac Toe");
            alert.setContentText(str);
            alert.showAndWait();
        });

        // exit هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        exit.setOnAction((Action) -> {
            System.exit(0);
        });
    }

}
