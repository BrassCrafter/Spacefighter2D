import GLOOP.*;
public class Laser {
    GLTafel laser;
    boolean ready = false, shot = false;
    public void load(double pX, double pY, double pWidth, double pLength){
        laser = new GLTafel(pX, pY, 0, pWidth, pLength, "src/Laser.png");
        laser.setzeAutodrehung(true);
    }
    public void getReady(double pX, double pY){
        laser.setzePosition(pX, pY, 0);
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooo");
        ready = true;
        shot = true;
    }
    public void shoot(double pSpeed){
        laser.verschiebe(0, pSpeed, 0);
        //System.out.println(pSpeed);
    }
    public void goToReserve(double pX, double pY){
        laser.setzePosition(pX, pY, 0);
        ready = false;
        shot = false;
    }
    public boolean getReadyState(){
        return ready;
    }
    public boolean getShotState(){
        return shot;
    }
}
