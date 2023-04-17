import GLOOP.*;
public class UI {
    GLTastatur kb;
    GLTafel resetButton, backButton, quitButton, stopWatch, scoreBoard;
    Clock stopWatchClock;
    int tempButton;
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
    public void updateScoreBoard(int pScore){
        int score = pScore + stopWatchClock.getTimeBasedScore();
        scoreBoard.setzeText("Score: " + score, 50);
    }
    public void startDeathMenu(){
        resetButton.setzeSichtbarkeit(true);
        quitButton.setzeSichtbarkeit(true);
        backButton.setzeSichtbarkeit(false);
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
}