import GLOOP.*;
public class Laser {
    GLTafel laser;
    GLVektor vOffPosition, vPosition;
    public void load(double pX, double pY, double pWidth, double pLength){
        vOffPosition = new GLVektor(pX, pY, 0);
        vPosition = new GLVektor(pX, pY, 0);
        laser = new GLTafel(pX, pY, 0, pWidth, pLength, "src/img/Laser.png");
        laser.setzeAutodrehung(true);
    }
    public void shoot(double pSpeed){
        if(!(vPosition == vOffPosition)){
            laser.verschiebe(0, pSpeed, 0);
        }
    }
    public void reset(){
        vPosition = vOffPosition;
    }
    public void setPosition(double pX, double pY){
        vPosition.x = pX;
        vPosition.y = pY;
    }
    public GLVektor getPosition(){
        return vPosition;
    }
    public GLVektor getOffPosition(){
        return vOffPosition;
    }
}
