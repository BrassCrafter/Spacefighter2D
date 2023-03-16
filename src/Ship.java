import GLOOP.*;
public class Ship {
    GLKegelstumpf leftRocket, rightRocket;
    GLQuader body, leftWing, rightWing;
    GLVektor vShip;
    Ship(double pX, double pY, double pZ, double pLength, double pWidth, double pRed, double pGreen, double pBlue){
        vShip = new GLVektor(pX, pY, pZ);
        body = new GLQuader(vShip, pWidth/5, pLength, 2.5);
        body.setzeFarbe(pRed, pGreen, pBlue);
        rightWing = new GLQuader(vShip.x + pWidth/3 - pWidth/10, vShip.y - pLength*0.25 + pLength/12, vShip.z, pWidth/3, pLength/6, 2.5);
        rightWing.setzeFarbe(pRed, pGreen, pBlue);
        leftWing= new GLQuader(vShip.x - pWidth/3 + pWidth/10, vShip.y - pLength*0.25 + pLength/12, vShip.z, pWidth/3, pLength/6, 2.5);
        leftRocket = new GLKegelstumpf(vShip.x - pWidth/2 + pWidth/7.5, vShip.y - pLength*0.25 + pLength/12 + pLength/8, vShip.z, pWidth/20, 0, pLength/2);
        leftWing.setzeFarbe(pRed, pGreen, pBlue);
        leftRocket.drehe(90, 0, 0);
        leftRocket = new GLKegelstumpf(vShip.x + pWidth/2 - pWidth/7.5, vShip.y - pLength*0.25 + pLength/12 + pLength/8, vShip.z, pWidth/20, 0, pLength/2);
        leftRocket.drehe(90, 0, 0);
    }
}
