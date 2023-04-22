import GLOOP.*;
public class Ship {
    Clock clock;
    GLTafel ship;
    GLVektor vShip, vA, vB, vC, vE, vF;
    Laser[] laser;
    int laserNum;
    int score = 0;
    int[] ready;
    double width, length;
    double bulletSpeed = 5;
    double shootrate;
    double border = 250;
    boolean STOP = false;
    SoundPlayer explosionPlayer;

    Ship(double pX, double pY, double pZ, double pLength, double pWidth, double pRed, double pGreen, double pBlue, int pLaserNum){
        clock = new Clock();
        width = pWidth / 0.93;
        length = pLength;
        vShip = new GLVektor(pX, pY, pZ);
        vA = new GLVektor(pX - width/2, pY - length/2, 0);
        vB = new GLVektor(pX + width/2, pY - length/2, 0);
        vC = new GLVektor(pX, pY + length/2, 0);
        vE = new GLVektor(pX - width/4, pY + length/4, 0);
        vF = new GLVektor(pX + width/4, pY + length/4, 0);
        ship = new GLTafel(vShip, width, length, "src/img/Ship2D.png");
        explosionPlayer = new SoundPlayer("src/sounds/Explosion.wav", 0);

        ship.setzeSelbstleuchten(1, 1, 1);
        ship.skaliere(1.25, 1, 1);
        ship.setzeAutodrehung(true);
        laserNum = pLaserNum;
        laser = new Laser[laserNum];
        ready = new int[2];
        for(int i = 0; i<laserNum; i++){
            laser[i] = new Laser();
            laser[i].load(-200000000, 1000000, 2.5, 10);
        }
    }


    public double getX(){return ship.gibX();}
    public double getY(){return ship.gibY();}
    public double getZ(){return ship.gibZ();}
    public GLVektor getPos(){return vShip;}
    public void moveRight(double pSpeed){
        if(border > this.getX() + width/2){
            vShip.x = vShip.x + pSpeed;
            ship.setzePosition(vShip);
        }
    }
    public void moveLeft(double pSpeed){
        if(-border < this.getX() - width/2){
            vShip.x = vShip.x - pSpeed;
            ship.setzePosition(vShip);
        }
    }
    public void getKnowlage(Laser pLaser, int i){
        laser[i] = pLaser;
    }
    public void shoot(){
            for(int i = 0; i < laserNum; i++){
                //laser[i].setPosition(100, 100);
                System.out.println(laser[i].getPosition().gibX() + " " + laser[i].getOffPosition().gibX());
                if(laser[i].getPosition().gibX() == laser[i].getOffPosition().gibX() && laser[i].getPosition().gibY() == laser[i].getOffPosition().gibY()){
                    laser[i].setPosition(this.getX(), this.getY() + this.length/2);
                    System.out.println(this.getY());
                    System.out.println("Laser");
                    break;
                }

        }
    }

    public void fly(){
        for(int i = 0; i < laserNum; i++){
            laser[i].shoot(bulletSpeed);
        }
    }
    public void timer(){
        if(shootrate>0){
            shootrate--;
            //System.out.println(shootrate);
        }
    }
    public void updateVectors(){
        vShip = ship.gibPosition();
        vA = new GLVektor(ship.gibX() - width/2, ship.gibY() - length/2, 0);
        vB = new GLVektor(ship.gibX() + width/2, ship.gibY() - length/2, 0);
        vC = new GLVektor(ship.gibX(), ship.gibY() + length/2, 0);
        vE = new GLVektor(ship.gibX() - width/4, ship.gibY() + length/4, 0);
        vF = new GLVektor(ship.gibX() + width/4, ship.gibY() + length/4, 0);

    }
    public void reset(){
        ship.setzeTextur("src/img/Ship2D.png");
        ship.setzePosition(0, -200, 0);
        this.updateVectors();
        STOP = false;
        this.resetScore();
    }
    public GLVektor getvA(){
        this.updateVectors();
        return vA;
    }
    public GLVektor getvB(){
        this.updateVectors();
        return vB;
    }
    public GLVektor getvC(){
        this.updateVectors();
        return vC;
    }
    public GLVektor getvE(){
        this.updateVectors();
        return vC;
    }
    public GLVektor getvF(){
        this.updateVectors();
        return vC;
    }
    public GLVektor getvShip(){
        this.updateVectors();
        return vShip;
    }
    public void addAPointToScore(){
        score++;
    }
    public int getScore(){
        return score;
    }
    public void explode(){
        ship.setzeTextur("src/img/Explosion.png");
        explosionPlayer.run();
        STOP = true;
    }
    public boolean doesSayStop(){
        return STOP;
    }
    public void resetScore(){
        score = 0;
    }
}
