import GLOOP.*;
public class Laser {
    GLTafel laser;
    GLVektor vOffPosition, vPosition;
    public void load(double pX, double pY, double pWidth, double pLength){
        vOffPosition = new GLVektor(pX, pY, 0);
        vPosition = new GLVektor(pX, pY, 0);
        //vPosition.x = vOffPosition.x;
        //vPosition.y = vOffPosition.y;
        laser = new GLTafel(pX, pY, 0, pWidth, pLength, "src/img/Laser.png");
        laser.setzeAutodrehung(true);
    }
    public void shoot(double pSpeed){
        if(!(vPosition.x == vOffPosition.x && vPosition.y == vOffPosition.y)){
            //System.out.println("flies");
            laser.verschiebe(0, pSpeed, 0);
        }
    }
    public void reset(){
        vPosition.x = vOffPosition.x;
        vPosition.y = vOffPosition.y;
        laser.setzePosition(vOffPosition);
    }
    public void setPosition(double pX, double pY){
        vPosition.x = pX;
        vPosition.y = pY;
        laser.setzePosition(vPosition.x, vPosition.y, 0);
        laser.setzeSichtbarkeit(true);
    }
    public GLVektor getPosition(){
        return laser.gibPosition();
    }
    public GLVektor getOffPosition(){
        return vOffPosition;
    }
}