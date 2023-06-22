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
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// ( Multi Player ) و ( Single Player ) يمثل حاوية اللعب التي سنظهرها عند النقر على زر بدء اللعبة الموجود في كل من الحاويتين GamePane الكلاس 
public class GamePane extends Pane {

    // هنا قمنا بإنشاء جميع الأشياء التي سنضعها في الحاوية
    Label firstPlayerName = new Label();
    Label secondPlayerName = new Label();
    Label firstPlayerScore = new Label("0");
    Label secondPlayerScore = new Label("0");
    Label currentPlayerSymbol = new Label();
    GridPane boardPane = new GridPane();
    Button[] boardButtons = new Button[3 * 3];
    Button back = new Button("Back");
    Button newGame = new Button("New Game");
    ImageView boardBackground = new ImageView();

    // سنستخدم هذا المتغير أيضاً لتحديد ما إذا كان سيتم إيقاف اللعبة بسبب فوز أحد اللاعبين
    boolean isGameEnds;

    // سنستخدم هذا المتغير لتحديد دور من في اللعب
    boolean isFirstPlayerTurn = true;

    // سنستخدم هذا المتغير لحساب عدد النقرات و بالتالي لتحديد ما إذا كان سيتم إيقاف اللعبة أم لا
    int XOCounter = 0;

    // randomNumber لتوليد أرقام عشوائية عند اللعب ضد الكمبيوتر. و سنخزن الرقم في المتغير random سنستخدم الكائن
    Random random = new Random();
    int randomNumber;

    // O و X يمثلان الألوان الإفتراضية التي سنضعها للرموز Color هنا قمنا بإنشاء كائنين من الكلاس
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;

    // boardPane لأننا سنستخدمه لتحديد ما سيحدث عند النقر على أي زر موضوع في الحاوية EventHandler هنا قمنا بإنشاء كائن من الإنترفيس
    // e و تمرير الكائن الذي يمثل الزر الذي تم النقر عليه مكان الباراميتر actionPerformed() بشكل عام, سيتم استدعاء الدالة
    EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
        actionPerformed(e);
    };

    // سنستخدم هذه الدالة لتلوين خلفية المربعات التي بسببها فاز اللاعب باللون الأصفر
    private void colorBackgroundWinnerButtons(Button b1, Button b2, Button b3) {
        b1.setStyle("-fx-background-color: #FF99FF;");
        b2.setStyle("-fx-background-color: #FF99FF;");
        b3.setStyle("-fx-background-color: #FF99FF;");
    }

    // O و X سنستخدم هذه الدالة لإنشاء الأزرار التي يمكن النقر عليها لإظهار الرموز
    // أيضاَ boardPane و سنضيفها في الحاوية boardButtons كما أننا سنخزن هذه الأزرار في المصفوفة
    private void createGameBoard() {

        int row = 0;
        int column = 0;

        for (int i = 0; i < boardButtons.length; i++) {

            boardButtons[i] = new Button();

            boardButtons[i].setPrefSize(90, 90);
            boardButtons[i].setFocusTraversable(false);

            GridPane.setMargin(boardButtons[i], new Insets(5));
            boardButtons[i].setFont(Font.font("Arial", FontWeight.BOLD, 40));

            boardPane.add(boardButtons[i], column, row);

            boardButtons[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });

            column++;
            if (column == 3) {
                row++;
                column = 0;
            }
        }

    }

    // سنستخدم هذه الدالة في كل مرة يلعب فيها اللاعبون للتأكد ما إذا كان هناك فائز أم لا
    // لتلوين خلفية خلفية المربعات التي كانت سبب فوز الاعب colorBackgroundWinnerButtons و في حال كان يوجد فائز سيتم مناداة الدالة
    // لإيقاف اللعبة. و سيتم إضافة واحد في نتيجة اللاعب الفائز true إلى isGameEnds كما أننا سنقوم بتغيير قيمة المتغير
    private void checkIfGameEnds() {

        String t00 = boardButtons[0].getText();
        String t01 = boardButtons[1].getText();
        String t02 = boardButtons[2].getText();
        String t10 = boardButtons[3].getText();
        String t11 = boardButtons[4].getText();
        String t12 = boardButtons[5].getText();
        String t20 = boardButtons[6].getText();
        String t21 = boardButtons[7].getText();
        String t22 = boardButtons[8].getText();

        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[1], boardButtons[2]);
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[3], boardButtons[4], boardButtons[5]);
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[6], boardButtons[7], boardButtons[8]);
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[3], boardButtons[6]);
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[1], boardButtons[4], boardButtons[7]);
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[2], boardButtons[5], boardButtons[8]);
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[4], boardButtons[8]);
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[2], boardButtons[4], boardButtons[6]);
        }

        if (XOCounter >= 9) {
            isGameEnds = true;
            isFirstPlayerTurn = true;
            XOCounter = 0;
        }

        if (isGameEnds == true) {
            if (isFirstPlayerTurn) {
                firstPlayerScore.setText(Integer.valueOf(firstPlayerScore.getText()) + 1 + "");
            } else {
                secondPlayerScore.setText(Integer.valueOf(secondPlayerScore.getText()) + 1 + "");
            }

            XOCounter = 0;
            newGame.requestFocus();
        }

    }

    // موضوع  في الحاوية و لإزالة أي O و X نستخدم هذه الدالة في كل مرة عند بدء اللعب من جديد لإزالة أي رمز
    // و لتحديد دور اللاعب الذي سيبدأ colorBackgroundWinnerButtons() ألوان موضوعة بسبب الدالة 
    private void startNewGame() {

        isGameEnds = false;
        setCurrentPlayerSymbol();

        for (Button boardButton : boardButtons) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");
        }

    }

    // مما يجعلنا نعرف دور من الآن في اللعب currentPlayerSymbol كنص للكائن O أو X نستخدم هذه الدالة في كل مرة لإظهار الرمز
    private void setCurrentPlayerSymbol() {

        if (isFirstPlayerTurn == true) {
            currentPlayerSymbol.setText("X");
            currentPlayerSymbol.setTextFill(xForeground);
        } else {
            currentPlayerSymbol.setText("O");
            currentPlayerSymbol.setTextFill(oForeground);
        }

    }

    // boardPane في هذه الدالة قمنا بتحديد ما سيحدث عندما يقوم اللاعبون بالنقر على أي زر موضوع في الحاوية
    private void actionPerformed(ActionEvent e) {
        // clickedButton سيتم تخزين الزر الذي تم النقر عليه بشكل مؤقت في الكائن
        Button clickedButton = (Button) e.getSource();

        // سيحدث التالي O أو X إذا لم تكن اللعبة قد انتهت و كان المستخدم قد قام بالنقر على زر لا يوجد عليه رمز
        if (isGameEnds == false && clickedButton.getText().equals("")) {
            // إذا كان يوجد لاعبين يلعبان ضد بعضهما سيتم وضع رمز اللاعب الحالي على الزر الذي تم النقر عليه
            if (AppManager.challengeComputer == false) {
                if (isFirstPlayerTurn) {
                    clickedButton.setTextFill(xForeground);
                    clickedButton.setText("X");
                } else {
                    clickedButton.setTextFill(oForeground);
                    clickedButton.setText("O");
                }

                // بعدها سيتم التأكد ما إن فاز أم لا و سيتم تبديل الأدوار إن لم يكن قد فاز
                checkIfGameEnds();
                setCurrentPlayerSymbol();
                isFirstPlayerTurn = !isFirstPlayerTurn;
                setCurrentPlayerSymbol();
            }

            // إذا كان اللاعب يلعب ضد الكمبيوتر
            if (AppManager.challengeComputer == true) {
                // على الزر الذي نقر عليه و من ثم التأكد ما إن فاز أم لا X سيتم وضع الرمز
                XOCounter++;
                isFirstPlayerTurn = true;
                clickedButton.setTextFill(xForeground);
                clickedButton.setText("X");
                checkIfGameEnds();

                // إذا لم يكن المستخدم قد فاز, أي إذا لم يتم إيقاف اللعبة, سيحد التالي
                if (isGameEnds == false) {
                    // O هنا قمنا بجعل جميع الأزرار غير قابلة للنقر, لأننا نريد جعل الكمبيوتر الآن يقوم بالنقر و وضع الرمز
                    for (Button boardButton : boardButtons) {
                        boardButton.removeEventHandler(ActionEvent.ACTION, eventHandler);
                    }

                    // في مكان عشوائي و من ثم تأكدنا ما إن كان قد فاز أم لا O هنا جعلنا الكمبيوتر يضع الرمز
                    XOCounter++;
                    isFirstPlayerTurn = false;
                    for (;;) {
                        randomNumber = random.nextInt(9);
                        if (boardButtons[randomNumber].getText().equals("")) {
                            boardButtons[randomNumber].setTextFill(oForeground);
                            boardButtons[randomNumber].setText("O");
                            break;
                        }
                    }
                    checkIfGameEnds();

                    // X هنا قمنا بجعل جميع الأزرار قابلة للنقر من جديد, لأننا نريد جعل المستخدم قادر على النقر و وضع الرمز
                    for (Button boardButton : boardButtons) {
                        boardButton.addEventHandler(ActionEvent.ACTION, eventHandler);
                    }
                }
            }

        }
    }

    // هذا كونستركور الكلاس
    public GamePane() {

        // GamePane هنا قمنا بتحديد حجم كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        firstPlayerName.setPrefSize(150, 30);
        secondPlayerName.setPrefSize(150, 30);
        firstPlayerScore.setPrefSize(150, 30);
        secondPlayerScore.setPrefSize(150, 30);
        currentPlayerSymbol.setPrefSize(150, 30);
        boardPane.setPrefSize(300, 300);
        newGame.setPrefSize(140, 30);

        // GamePane هنا قمنا بتحديد موقع كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        firstPlayerName.setTranslateY(10);
        secondPlayerName.setTranslateX(250);
        secondPlayerName.setTranslateY(10);
        firstPlayerScore.setTranslateY(40);
        secondPlayerScore.setTranslateX(250);
        secondPlayerScore.setTranslateY(40);
        currentPlayerSymbol.setTranslateX(120);
        currentPlayerSymbol.setTranslateY(25);
        boardBackground.setFitWidth(300);
        boardBackground.setFitHeight(300);
        boardBackground.setTranslateX(45);
        boardBackground.setTranslateY(105);
        boardPane.setTranslateX(45);
        boardPane.setTranslateY(105);
        back.setPrefSize(140, 30);
        back.setTranslateX(20);
        back.setTranslateY(455);
        newGame.setTranslateX(230);
        newGame.setTranslateY(455);

        // هنا قمنا بجعل نصوص أسماء اللاعبين, و نتيجتهم تظهر في وسط المكان المخصص لظهورهم
        firstPlayerName.setAlignment(Pos.CENTER);
        secondPlayerName.setAlignment(Pos.CENTER);
        firstPlayerScore.setAlignment(Pos.CENTER);
        secondPlayerScore.setAlignment(Pos.CENTER);
        currentPlayerSymbol.setAlignment(Pos.CENTER);

        // boardPane و التي سيتم عرضها في الحاوية boardButtons حتى تنشئ الأزرار التي سيتم وضعها في المصفوفة createGameBoard() هنا قمنا باستدعاء الدالة
        createGameBoard();

        // GamePane هنا قمنا بإضافة كل شيء قمنا بإنشائه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس   
        getChildren().add(firstPlayerName);
        getChildren().add(secondPlayerName);
        getChildren().add(firstPlayerScore);
        getChildren().add(secondPlayerScore);
        getChildren().add(currentPlayerSymbol);
        getChildren().add(boardPane);
        getChildren().add(boardBackground);
        getChildren().add(back);
        getChildren().add(newGame);

        // لبدء لعبة جديدة startNewGame() هنا قمنا باستدعاء الدالة
        startNewGame();

        // back هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // لعرض الحاوية التي كانت معروضة قبل عرض الحاوية الحالية viewPane() سيتم إستدعاء الدالة الثابتة   
        back.setOnAction((Action) -> {

            startNewGame();

            if (AppManager.challengeComputer) {
                AppManager.viewPane(AppManager.singlePlayerPane);
            } else {
                AppManager.viewPane(AppManager.multiPlayerPane);
            }

        });

        // newGame هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // لبدء اللعبة من جديد startNewGame() سيتم استدعاء الدالة
        newGame.setOnAction((Action) -> {
            startNewGame();
        });

    }

}
