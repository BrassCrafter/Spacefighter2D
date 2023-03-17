import GLOOP.*;

public class Game {
GLKamera cam;
GLLicht light;
GLKugel reff;
Ship ship;
    Game(){
        reff = new GLKugel(100, -200, 0, 10);
        reff.setzeFarbe(1, 0, 0);
        cam = new GLEntwicklerkamera(720, 1080);
        light = new GLLicht();
        ship = new Ship(0, -100, 0, 50, 40, 1, 1, 0);
    }
}
