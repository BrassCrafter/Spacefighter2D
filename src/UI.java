import GLOOP.*;
public class UI {
    GLTafel resetButton, backButton, quitButton;
    int tempButton;
    UI(){
        resetButton = new GLTafel(0, 0, 0, 75, 75*0.75, "src/img/ResetOff.png");
        resetButton.setzeSichtbarkeit(false);
        backButton = new GLTafel(0, 250, 0, 75, 75*0.75, "src/img/BackOff.png");
        backButton.setzeSichtbarkeit(false);
        quitButton = new GLTafel(0, -200, 0, 75, 75*0.75, "src/img/QuitOff.png");
        quitButton.setzeSichtbarkeit(false);
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
}
