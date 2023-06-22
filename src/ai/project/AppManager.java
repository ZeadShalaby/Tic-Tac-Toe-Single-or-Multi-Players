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
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

// static قمنا بإنشائه لتمرير القيم المشتركة بين حاويات اللعبة بسهولة لهذا قمنا بتعريف كل شيء فيه كـ AppManager الكلاس
public class AppManager {

    // هنا قمنا بإنشاء كائن من كل كلاس يمثل حاوية قمنا بتجهيزه سابقاً
    static StartPane startPane = new StartPane();
    static SinglePlayerPane singlePlayerPane = new SinglePlayerPane();
    static MultiPlayerPane multiPlayerPane = new MultiPlayerPane();
    static SettingsPane settingsPane = new SettingsPane();
    static GamePane gamePane = new GamePane();



    // SettingsPane سنخزن فيه حجم خط كل زر, نص و مربع نص أضفناه في اللعبة و الذي يستطيع المستخدم تغييره من الحاوية preferredFont الكائن
    static Font preferredFont;

    // للإشارة إلى أنه سيتم اللعب ضد الكمبيوتر SinglePlayerPane الموضوع في الحاوية start عند النقر على الزر true سنخزن فيه القيمة challengeComputer المتغير
    static boolean challengeComputer;

    // pane الدالة التالية نستخدمها لإخفاء أي نافذة معروضة حالياً في النافذة و عرض الحاوية التي نمررها لها فقط مكان الباراميتر
    public static void viewPane(Pane pane) {
        startPane.setVisible(false);
        singlePlayerPane.setVisible(false);
        multiPlayerPane.setVisible(false);
        settingsPane.setVisible(false);
        gamePane.setVisible(false);

        pane.setVisible(true);
    }

    // settingsPane الدالة التالية نستخدمها لوضع الخيارات الإفتراضية التي يمكن تغييرها في الحاوية
    public static void setDefaultSettings() {
        // fontSizesComboBox و ثاني خيار في الكائن boardsComboBox هنا قلنا أنه سيتم إختيار أول خيار في الكائن
        settingsPane.boardsComboBox.getSelectionModel().selectFirst();
        settingsPane.fontSizesComboBox.getSelectionModel().select(1);

        // preferredFont لتغيير حجم خط كل زر, نص و مربع نص موضوع في اللعبة نسبةً لقيمة الكائن setFont() هنا قمنا باستدعاء الدالة
        setFont();
    }

    // preferredFont الدالة التالية نستخدمها لتحديد حجم خط كل زر, نص و مربع نص موضوع في اللعبة نسبةً لقيمة الكائن
    public static void setFont() {
        startPane.singlePlayer.setFont(preferredFont);
        startPane.multiPlayer.setFont(preferredFont);
        startPane.settings.setFont(preferredFont);
        startPane.about.setFont(preferredFont);
        startPane.exit.setFont(preferredFont);

        singlePlayerPane.playerNameLabel.setFont(preferredFont);
        singlePlayerPane.playerName.setFont(preferredFont);
        singlePlayerPane.start.setFont(preferredFont);
        singlePlayerPane.back.setFont(preferredFont);

        multiPlayerPane.playerXLabel.setFont(preferredFont);
        multiPlayerPane.playerOLabel.setFont(preferredFont);
        multiPlayerPane.firstPlayerName.setFont(preferredFont);
        multiPlayerPane.secondPlayerName.setFont(preferredFont);
        multiPlayerPane.start.setFont(preferredFont);
        multiPlayerPane.back.setFont(preferredFont);

//        gamePane.firstPlayerName.setFont(preferredFont);
//        gamePane.secondPlayerName.setFont(preferredFont);
//        gamePane.firstPlayerScore.setFont(preferredFont);
//        gamePane.secondPlayerScore.setFont(preferredFont);
//        gamePane.currentPlayerSymbol.setFont(preferredFont);
//        gamePane.restart.setFont(preferredFont);
//        gamePane.back.setFont(preferredFont);

        settingsPane.labelForBoards.setFont(preferredFont);
        settingsPane.labelForFontSizes.setFont(preferredFont);
        settingsPane.reset.setFont(preferredFont);
        settingsPane.back.setFont(preferredFont);

        // لتحديد لهما setStyle() لا يملكان دالة خاصة لتحديد حجم الخط, لذلك قمنا باستخدام الدالة fontSizesComboBox و boardsComboBox الكائنين
        settingsPane.boardsComboBox.setStyle(
                "-fx-font-family:" + preferredFont.getName() + ";"
                + "-fx-font-size: " + preferredFont.getSize() + "px;"
                + "-fx-font-weight: bold;"
        );
        settingsPane.fontSizesComboBox.setStyle(
                "-fx-font-family:" + preferredFont.getName() + ";"
                + "-fx-font-size: " + preferredFont.getSize() + "px;"
                + "-fx-font-weight: bold;"
        );
    }

}
