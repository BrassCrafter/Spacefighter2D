import GLOOP.*;

import java.io.IOException;

public class UI {
    GLTastatur kb;
    GLTafel resetButton, backButton, quitButton, stopWatch, scoreBoard, highScoreBoard, volumeBar;
    Clock stopWatchClock;
    int tempButton;
    int score;
    TextFileReaderWriter highScoreFile;
    UI(){
        resetButton = new GLTafel(0, 0, 20, 75, 75*0.75, "src/img/ResetOff.png");
        resetButton.setzeSichtbarkeit(false);
        backButton = new GLTafel(0, 75, 20, 75, 75*0.75, "src/img/BackOff.png");
        backButton.setzeSichtbarkeit(false);
        quitButton = new GLTafel(0, -75, 20, 75, 75*0.75, "src/img/QuitOff.png");
        quitButton.setzeSichtbarkeit(false);
        stopWatchClock = new Clock();
        stopWatch = new GLTafel(0, 400, 20, 150, 150*0.75, "src/img/invisible.png");
        stopWatch.setzeTextfarbe(1, 0, 0);
        scoreBoard = new GLTafel(0, 200, 20, 150, 150*0.75, "src/img/invisible.png");
        scoreBoard.setzeAutodrehung(true);
        scoreBoard.setzeTextfarbe(1, 1, 0);
        highScoreBoard = new GLTafel(0, 300, 20, 150, 150*0.75, "src/img/invisible.png");
        highScoreBoard.setzeAutodrehung(true);
        highScoreBoard.setzeTextfarbe(1, 0, 0);
        highScoreFile = new TextFileReaderWriter("src/HighScore.txt");
        volumeBar = new GLTafel(0, -400, 20, 150, 150*0.75, "src/img/BarAt100.png");
        volumeBar.setzeAutodrehung(true);
        volumeBar.setzeSichtbarkeit(false);

        kb = new GLTastatur();
    }
    public void updateStopwatch(){
        if(kb.istGedrueckt('r')){stopWatch.setzeText(stopWatchClock.stopWatchToString(false, true), 20);}
        else if (kb.istGedrueckt('t')){
            stopWatch.setzeText(stopWatchClock.stopWatchToString(true, false), 20);
        }
        else{
            stopWatch.setzeText(stopWatchClock.stopWatchToString(false, false), 20);
        }
    }
    public void resetStopwatch(){
        stopWatch.setzeText(stopWatchClock.stopWatchToString(false, true), 20);
    }
    public void startMenu(){
        resetButton.setzeSichtbarkeit(true);
        quitButton.setzeSichtbarkeit(true);
        backButton.setzeSichtbarkeit(true);
    }
    public void updateMenu(int pButton){
        switch(pButton){
            case 0:
                resetButton.setzeTextur("src/img/ResetOff.png");
                quitButton.setzeTextur("src/img/QuitOn.png");
                tempButton = pButton;
                break;
            case 1:
                if(tempButton == 0){
                    quitButton.setzeTextur("src/img/QuitOff.png");
                }
                if(tempButton == 2) {
                    backButton.setzeTextur("src/img/BackOff.png");
                }
                resetButton.setzeTextur("src/img/ResetOn.png");
                tempButton = pButton;
                break;
            case 2:
                resetButton.setzeTextur("src/img/ResetOff.png");
                backButton.setzeTextur("src/img/BackOn.png");
                tempButton = pButton;
                break;
        }

    }
    public void endMenu(){
        resetButton.setzeSichtbarkeit(false);
        quitButton.setzeSichtbarkeit(false);
        backButton.setzeSichtbarkeit(false);
        switch (tempButton){
            case 0:
                quitButton.setzeTextur("src/img/QuitOff.png");
            case 1:
                resetButton.setzeTextur("src/img/ResetOff.png");
        }
    }
    public void updateScoreBoard(int pScore) throws IOException {
        int boardScore = pScore + stopWatchClock.getTimeBasedScore();
        scoreBoard.setzeText("Score: " + score, 50);
        score = boardScore;
        highScoreBoard.setzeText("High Score: " + highScoreFile.readScoreLine(), 50);
    }
    public void startDeathMenu(){
        resetButton.setzeSichtbarkeit(true);
        quitButton.setzeSichtbarkeit(true);
        resetButton.setzeTextur("src/img/ResetOn.png");
    }
    public void updateDeathMenu(int pButton){
        switch(pButton){
            case 0:
                resetButton.setzeTextur("src/img/ResetOff.png");
                quitButton.setzeTextur("src/img/QuitOn.png");
                tempButton = pButton;
                break;
            case 1:
                quitButton.setzeTextur("src/img/QuitOff.png");
                break;
        }

    }
    public void endDeathMenu(){
        resetButton.setzeSichtbarkeit(false);
        quitButton.setzeSichtbarkeit(false);
    }
    public void resetScore(){
        stopWatchClock.resetTimeBasedScore();
    }
    public int getScore(){
        return score;
    }
    public void startSettingsMenu(){
        volumeBar.setzeSichtbarkeit(true);
        backButton.setzeSichtbarkeit(true);
        resetButton.setzeTextur("src/img/BackOn.png");
    }
    public void updateSettingsMenu(int pButton, int pVolume){
        switch(pButton){
            case 0:
                switch (pVolume){
                    case 0:
                        volumeBar.setzeTextur("src/img/BarAt0.png");
                        break;
                    case 1:
                        volumeBar.setzeTextur("src/img/BarAt10.png");
                        break;
                    case 2:
                        volumeBar.setzeTextur("src/img/BarAt20.png");
                        break;
                    case 3:
                        volumeBar.setzeTextur("src/img/BarAt30.png");
                        break;
                    case 4:
                        volumeBar.setzeTextur("src/img/BarAt40.png");
                        break;
                    case 5:
                        volumeBar.setzeTextur("src/img/BarAt50.png");
                        break;
                    case 6:
                        volumeBar.setzeTextur("src/img/BarAt60.png");
                        break;
                    case 7:
                        volumeBar.setzeTextur("src/img/BarAt70.png");
                        break;
                    case 8:
                        volumeBar.setzeTextur("src/img/BarAt80.png");
                        break;
                    case 9:
                        volumeBar.setzeTextur("src/img/BarAt90.png");
                        break;
                    case 10:
                        volumeBar.setzeTextur("src/img/BarAt100.png");
                        break;
                }
                resetButton.setzeTextur("src/img/ResetOff.png");
                quitButton.setzeTextur("src/img/QuitOn.png");
                tempButton = pButton;
                break;
            case 1:
                quitButton.setzeTextur("src/img/QuitOff.png");
                break;
        }

    }
    public void endSettingsMenu(){
        resetButton.setzeSichtbarkeit(false);
        quitButton.setzeSichtbarkeit(false);
    }
}