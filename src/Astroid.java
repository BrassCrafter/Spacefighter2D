import GLOOP.*;
public class Astroid {
    Laser[] laser;
    Ship ship;
    int laserNum;
    GLKugel astroid;
    GLVektor vAstroid;

    Astroid(int pLaserNum){
        vAstroid = new GLVektor(0, 0, 0);
        astroid = new GLKugel(vAstroid, 10);
        laserNum = pLaserNum;
        laser = new Laser[laserNum];
    }
    public void knowShip(Ship pShip){
        ship = pShip;
    }
    public void knowLaser(Laser pLaser, int i){
        laser[i] = pLaser;
    }
    public void laserHit(){
        for(int i = 0; i < laserNum; i++){
            if(Math.sqrt(Math.pow(laser[i].vPosition.x - vAstroid.x, 2) + Math.pow(laser[i].vPosition.y - vAstroid.y, 2)) < 10){
                laser[i].reset();
            }
        }
    }

}
