import GLOOP.*;

public class Game {
GLKamera cam;
Clock clock;
GLLicht light;
    GLKugel reff1, reff2, reff3;
    GLTafel stopWatch, time, cooldown;
    Ship ship;
    Astroid astroid[];
    int astroidNum = 100;
    double maxHight = 450;
    GLTastatur kb;
    Laser[] laser;
    Menu menu;
    int laserNum = 100;
    boolean run = true;
    double speed = 2.5;
    Game(){
        clock = new Clock();
        stopWatch = new GLTafel(0, 0, 0, 40, 20);
        stopWatch.setzeTextfarbe(1, 0, 1);
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
        menu = new Menu();

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
        }
    }
    private void gameLoop(){
        while(!kb.esc()){
            ship.timer();
            if(kb.rechts()){
                ship.moveRight(speed);
            }
            if(kb.links()){
                ship.moveLeft(speed);
            }
            if(clock.coolDownOver() && kb.istGedrueckt(' ')){
                clock.resetCoolDown(50);
                ship.shoot();
                //hier scheint er nicht rauszugehen
            }
            ship.fly();
            clock.coolDown();
            if(kb.istGedrueckt('r')){stopWatch.setzeText(clock.stopWatchToString(false, true), 10);}
            else if (kb.istGedrueckt('t')){
                stopWatch.setzeText(clock.stopWatchToString(true, false), 10);
            }
            else{
                stopWatch.setzeText(clock.stopWatchToString(false, false), 10);
            }

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

        }
    }
}
