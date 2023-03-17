public class Astroid {
    Laser[] laser;
    Ship ship;
    int laserNum;

    Astroid(int pLaserNum){
        laserNum = pLaserNum;
        laser = new Laser[laserNum];
    }
    public void knowShip(Ship pShip){
        ship = pShip;
    }
    public void knowLaser(Laser pLaser, int i){
        laser[i] = pLaser;
    }

}
