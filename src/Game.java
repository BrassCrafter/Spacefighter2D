import GLOOP.*;

public class Game {
GLKamera cam;
Clock clock;
GLLicht light;
    GLKugel reff;
    GLTafel stopWatch, time, cooldown;
    Ship ship;
    Astroid astroid[];
    int astroidNum = 100;
    GLTastatur kb;
    Laser[] laser;
    int laserNum = 100;
    boolean run = true;
    double speed = 2.5;
    Game(){
        clock = new Clock();
        stopWatch = new GLTafel(0, 0, 0, 40, 20);
        stopWatch.setzeTextfarbe(1, 0, 1);
        kb = new GLTastatur();
        reff = new GLKugel(0, 400, 0, 10);
        reff.setzeFarbe(1, 0, 0);
        cam = new GLEntwicklerkamera(720, 1080);
        cam.setzePosition(0, 0, 750);
        light = new GLLicht();
        ship = new Ship(0, -200, 0, 50, 40, 1, 1, 0, laserNum);
        astroid = new Astroid[astroidNum];
        laser = new Laser[laserNum];

        for(int i = 0; i<astroidNum; i++){
            astroid[i] = new Astroid(laserNum);
            astroid[i].knowShip(ship);
            for(int i1 = 0; i1<laserNum; i1++) {
                laser[i1] = ship.laser[i];
                System.out.println("1");
                ship.getKnowlage(laser[i1], i1);
                astroid[i].knowLaser(laser[i1], i1);
            }
        }
        while(run){
            this.gameLoop();
        }
    }
    private void gameLoop(){
        while(!kb.esc()){
            ship.fly();
            ship.timer();
            if(kb.rechts()){
                ship.moveRight(speed);
            }
            if(kb.links()){
                ship.moveLeft(speed);
            }
            if(kb.istGedrueckt(' ') && clock.coolDownOver()){
                ship.shoot();
                clock.resetCoolDown(10000);
                //hier scheint er nicht rauszugehen
            }
            else{
                clock.coolDown();
            }
            if(kb.istGedrueckt('r')){stopWatch.setzeText(clock.stopWatchToString(false, true), 10);}
            else if (kb.istGedrueckt('t')){
                stopWatch.setzeText(clock.stopWatchToString(true, false), 10);
            }
            else{
                stopWatch.setzeText(clock.stopWatchToString(false, false), 10);
            }
            Sys.warte();

        }
    }
}
