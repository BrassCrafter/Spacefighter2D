import GLOOP.*;
public class Ship {
    GLTafel ship;
    GLVektor vShip;
    Ship(double pX, double pY, double pZ, double pLength, double pWidth, double pRed, double pGreen, double pBlue){
        vShip = new GLVektor(pX, pY, pZ);
        ship = new GLTafel(vShip, pWidth*(1/0.931), pLength, "src/Ship2D.png");
        ship.setzeSelbstleuchten(1, 1, 1);
        ship.skaliere(1.25, 1, 1);
        ship.setzeAutodrehung(true);
    }


    public double getX(){return ship.gibX();}
    public double getY(){return ship.gibY();}
    public double getZ(){return ship.gibZ();}
    public GLVektor getPos(){return vShip;}
}
