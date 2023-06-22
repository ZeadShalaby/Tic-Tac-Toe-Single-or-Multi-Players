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

// ( Single Player ) يمثل الحاوية التي سنظهرها عند النقر على زر اللعب ضد الكمبيوتر SinglePlayerPane الكلاس 
public class SinglePlayerPane extends Pane {

    // هنا قمنا بإنشاء جميع الأشياء التي سنضعها في الحاوية
    Label playerNameLabel = new Label("Player Name");
    TextField playerName = new TextField("player");
    Button start = new Button("Start");
    Button back = new Button("Back");

    // هذا كونستركور الكلاس
    public SinglePlayerPane() {

        // SinglePlayerPane هنا قمنا بتحديد حجم كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        playerNameLabel.setPrefSize(100, 30);
        playerName.setPrefSize(130, 30);
        start.setPrefSize(240, 40);
        back.setPrefSize(240, 40);

        // SinglePlayerPane هنا قمنا بتحديد موقع كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        playerNameLabel.setTranslateX(80);
        playerNameLabel.setTranslateY(170);
        playerNameLabel.setTextFill(Color.BLUE);
        playerName.setTranslateX(190);
        playerName.setTranslateY(170);
        start.setTranslateX(80);
        start.setTranslateY(220);
        back.setTranslateX(80);
        back.setTranslateY(280);

        // SinglePlayerPane هنا قمنا بإضافة كل شيء قمنا بإنشائه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس   
        getChildren().add(playerNameLabel);
        getChildren().add(playerName);
        getChildren().add(start);
        getChildren().add(back);

        // start هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مع وضع القيمة 0 كنتيجة أولية له و للكمبيوتر gamePane سيتم تمرير الإسم الذي يدخله المستخدم, كإسم اللاعب الذي سيظهر في الحاوية
        // gamePane بعدها سيتم وضع صورة الخلفية التي اختارها المستخدم أو الصورة المختارة إفتراضياً كخلفية للعبة في الحاوية
        // مكان الحاوية الحالية gamePane لعرض الحاوية التي يمثلها الكائن viewPane() في الأخير سيتم إستدعاء الدالة الثابتة
        start.setOnAction((Action) -> {
            AppManager.gamePane.firstPlayerName.setText(playerName.getText());
            AppManager.gamePane.secondPlayerName.setText("Computer");
            AppManager.gamePane.firstPlayerScore.setText("0");
            AppManager.gamePane.secondPlayerScore.setText("0");

            // للإشارة إلى أنه سيتم اللعب ضد الكمبيوتر AppManager الموضوع في الكلاس challengeComputer للمتغير الثابت true مررنا القيمة
            AppManager.challengeComputer = true;

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
