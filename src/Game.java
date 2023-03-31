import GLOOP.*;

public class Game {
GLKamera cam;
Clock gunTimer, menuTimer;
GLLicht light;
GLHimmel sky;
    GLKugel reff1, reff2, reff3;
        Ship ship;
    Astroid astroid[];
    int astroidNum = 100;
    double maxHight = 450;
    GLTastatur kb;
    Laser[] laser;
    UI ui;
    int laserNum = 100;
    int menuButtonNum = 2;
    boolean runGame = true, runMenu = false, run = true;
    double speed = 1;
    Game(){
        sky = new GLHimmel("src/img/bg.png");
        gunTimer = new Clock();
        menuTimer = new Clock();
        kb = new GLTastatur();
        reff1 = new GLKugel(250, -235, 0, 10);
        reff2 = new GLKugel(-250, -235, 0, 10);
        reff3 = new GLKugel(0, -225, 0, 5);
        reff1.setzeFarbe(1, 0, 0);
        reff2.setzeFarbe(0, 0, 1);
        reff3.setzeFarbe(0, 1, 0);
        cam = new GLKamera(720, 1080);
        cam.setzePosition(0, 0, 750);
        cam.setzeBlickpunkt(0, 0, 0);
        light = new GLLicht();
        ship = new Ship(0, -200, 0, 50, 40, 1, 1, 0, laserNum);
        astroid = new Astroid[astroidNum];
        laser = new Laser[laserNum];
        ui = new UI();

        for(int i = 0; i<astroidNum; i++){
            astroid[i] = new Astroid(laserNum);
            astroid[i].knowShip(ship);
            for(int i1 = 0; i1<laserNum; i1++) {
                laser[i1] = ship.laser[i1];
                //System.out.println("1");
                ship.getKnowlage(laser[i1], i1);
                System.out.println(laser[i1] + " | " + i1);
                astroid[i].knowLaser(laser[i1], i1);
            }
        }
        while(run){
            this.gameLoop();
            this.menuLoop();
        }
    }
    private void gameLoop(){
        menuTimer.resetCoolDown(100);
        menuTimer.coolDown();
        while(runGame){
            ui.updateStopwatch();
            menuTimer.coolDown();
            ship.timer();
            if(kb.rechts()){
                ship.moveRight(speed);
            }
            if(kb.links()){
                ship.moveLeft(speed);
            }
            if(gunTimer.coolDownOver() && kb.istGedrueckt(' ')){
                gunTimer.resetCoolDown(100);
                ship.shoot();
                //hier scheint er nicht rauszugehen
            }
            ship.fly();
            gunTimer.coolDown();
            for(int i = 0; i < astroidNum; i++){
                astroid[i].laserHit();
            }
            for(int i = 0; i < laserNum; i++){
                if(laser[i].getPosition().y >= maxHight){
                    laser[i].reset();
                    //System.out.println("reset");
                    //Sys.warte(1000);
                }
            }

            Sys.warte();
            if(kb.esc() && menuTimer.coolDownOver){
                System.out.println("YEA");
                runGame = false;
                runMenu = true;
                menuTimer.resetCoolDown(5);
            }
        }
    }
    public void menuLoop(){
        ui.startMenu();
        ui.updateMenu(2);
        menuTimer.coolDown();
        while(runMenu){
            menuTimer.coolDown();
            System.out.println(menuButtonNum);
            if(kb.oben() && menuButtonNum < 2){
                menuButtonNum ++;
                ui.updateMenu(menuButtonNum);
            }
            if(kb.unten() && menuButtonNum > 0){
                menuButtonNum --;
                ui.updateMenu(menuButtonNum);
            }

            if(kb.esc() && menuTimer.coolDownOver){
                ui.endMenu();
                System.out.println("YEE");
                runMenu = false;
                runGame = true;
            }
            System.out.println("BREAK");
            Sys.warte(100);
        }
    }
}
