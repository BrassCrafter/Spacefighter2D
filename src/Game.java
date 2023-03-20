import GLOOP.*;

public class Game {
GLKamera cam;
Clock clock;
GLLicht light;
    GLKugel reff;
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
            if(kb.istGedrueckt(' ')){
                ship.shoot(10);
                Sys.warte(1000);
            }
            System.out.println(clock.timerToString(false, false));

            Sys.warte();

        }
    }
}
