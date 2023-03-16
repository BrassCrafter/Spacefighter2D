import GLOOP.GLEntwicklerkamera;
import GLOOP.GLKamera;
import GLOOP.GLLicht;

public class Game {
GLKamera cam;
GLLicht light;
Ship ship;
    Game(){
        cam = new GLEntwicklerkamera(1280, 1440);
        light = new GLLicht();
        ship = new Ship(0, 0, 0, 50, 40, 1, 0, 0);
    }
}
