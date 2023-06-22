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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

// ( Multi Player ) يمثل الحاوية التي سنظهرها عند النقر على زر اللعبة بين شخصين موجودين على نفس الجهاز MultiPlayerPane الكلاس 
public class MultiPlayerPane extends Pane {

    // هنا قمنا بإنشاء جميع الأشياء التي سنضعها في الحاوية
    Label playerXLabel = new Label("Player X");
    Label playerOLabel = new Label("Player O");
    TextField firstPlayerName = new TextField("player 1");
    TextField secondPlayerName = new TextField("player 2");
    Button start = new Button("Start");
    Button back = new Button("Back");

    // هذا كونستركور الكلاس
    public MultiPlayerPane() {

        // MultiPlayerPane هنا قمنا بتحديد حجم كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        playerXLabel.setPrefSize(70, 30);
        firstPlayerName.setPrefSize(160, 30);
        playerXLabel.setTextFill(Color.BLUE);
        playerOLabel.setPrefSize(70, 30);
        secondPlayerName.setPrefSize(160, 30);
        playerOLabel.setTextFill(Color.BLUE);
        start.setPrefSize(240, 40);
        back.setPrefSize(240, 40);

        // MultiPlayerPane هنا قمنا بتحديد موقع كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        playerXLabel.setTranslateX(80);
        playerXLabel.setTranslateY(130);
        firstPlayerName.setTranslateX(160);
        firstPlayerName.setTranslateY(130);
        playerOLabel.setTranslateX(80);
        playerOLabel.setTranslateY(190);
        secondPlayerName.setTranslateX(160);
        secondPlayerName.setTranslateY(190);
        start.setTranslateX(80);
        start.setTranslateY(250);
        back.setTranslateX(80);
        back.setTranslateY(310);

        // MultiPlayerPane هنا قمنا بإضافة كل شيء قمنا بإنشائه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس   
        getChildren().add(playerXLabel);
        getChildren().add(playerOLabel);
        getChildren().add(firstPlayerName);
        getChildren().add(secondPlayerName);
        getChildren().add(start);
        getChildren().add(back);

        // start هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مع وضع القيمة 0 كنتيجة أولية لكلا اللاعبين gamePane سيتم تمرير أسماء اللاعبين اللذين سيدخلوهما للحاوية
        // gamePane بعدها سيتم وضع صورة الخلفية التي اختاروها أو الصورة المختارة إفتراضياً كخلفية للعبة في الحاوية
        // مكان الحاوية الحالية gamePane لعرض الحاوية التي يمثلها الكائن viewPane() في الأخير سيتم إستدعاء الدالة الثابتة
        start.setOnAction((Action) -> {
            AppManager.gamePane.firstPlayerName.setText(firstPlayerName.getText());
            AppManager.gamePane.secondPlayerName.setText(secondPlayerName.getText());
            AppManager.gamePane.firstPlayerScore.setText("0");
            AppManager.gamePane.secondPlayerScore.setText("0");

            // للإشارة إلى أنه لن يتم اللعب ضد الكمبيوتر AppManager الموضوع في الكلاس challengeComputer للمتغير الثابت false مررنا القيمة
            AppManager.challengeComputer = false;

            AppManager.gamePane.boardBackground
                    .setImage(new Image(getClass().getResourceAsStream("board_1.png")));

            AppManager.viewPane(AppManager.gamePane);
        });

        // back هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مكان الحاوية الحالية startPane لعرض الحاوية التي يمثلها الكائن viewPane() سيتم إستدعاء الدالة الثابتة        
        back.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.startPane);
        });
    }

}
