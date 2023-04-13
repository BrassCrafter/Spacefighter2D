import GLOOP.GLKugel;
import GLOOP.GLVektor;

public class Astroid {
    Laser[] laser;
    Ship ship;
    GLKugel astroid;
    GLVektor vAstroid;
    double[] a, b, c, e, f, g;
    double radius;
    double r, s;
    double speed;

    Astroid(Ship pShip, Laser[] pLaser, double pRadius, double pSpeed) {
        vAstroid = new GLVektor(0, 0, 0);
        astroid = new GLKugel(vAstroid, pRadius);
        this.knowShip(pShip);
        this.knowLaser(pLaser);
        a = new double[2];
        b = new double[2];
        c = new double[2];
        e = new double[2];
        f = new double[2];
        g = new double[2];
        radius = pRadius;
        speed = pSpeed;
        this.reset();
    }

    public void fallDown(double pSpeed) {
        astroid.verschiebe(0, -pSpeed, 0);
        vAstroid.y = vAstroid.y - pSpeed;
        if (vAstroid.y < -400) {
            this.reset();
        }
    }

    public void knowShip(Ship pShip) {
        ship = pShip;
    }

    public void knowLaser(Laser[] pLaser) {
        laser = new Laser[pLaser.length];
        laser = pLaser;
    }

    public void laserHit() {
        for (int i = 0; i < laser.length; i++) {
            if (Math.sqrt(Math.pow(laser[i].vPosition.x - vAstroid.x, 2) + Math.pow(laser[i].vPosition.y - vAstroid.y, 2)) < 10) {
                laser[i].reset();
            }
        }
    }

    public void update() {
        this.fallDown(speed);
        if (this.detectCollisionWithShip(radius)) {
            System.out.println("HIT");
            this.reset();
        }
        this.detectCollisionWithLaser();
    }

    public void reset() {
        astroid.setzePosition(Math.random() * 800 - 400, Math.random() * 2000 + 500, 0);
        vAstroid = astroid.gibPosition();
    }

    public boolean detectCollisionWithShip(double r) {
        double x0 = astroid.gibX();
        double y0 = astroid.gibY();
        a[0] = ship.getvA().x;
        a[1] = ship.getvA().y;
        b[0] = ship.getvB().x;
        b[1] = ship.getvB().y;
        c[0] = ship.getvC().x;
        c[1] = ship.getvC().y;
        e[0] = ship.getvE().x;
        e[1] = ship.getvE().y;
        f[0] = ship.getvF().x;
        f[1] = ship.getvF().y;
        g[0] = ship.getvShip().x;
        g[1] = ship.getvShip().y;
        double d1 = Math.sqrt(Math.pow(x0 - a[0], 2) + Math.pow(y0 - a[1], 2));
        double d2 = Math.sqrt(Math.pow(x0 - b[0], 2) + Math.pow(y0 - b[1], 2));
        double d3 = Math.sqrt(Math.pow(x0 - c[0], 2) + Math.pow(y0 - c[1], 2));
        double d4 = Math.sqrt(Math.pow(x0 - e[0], 2) + Math.pow(y0 - e[1], 2));
        double d5 = Math.sqrt(Math.pow(x0 - f[0], 2) + Math.pow(y0 - f[1], 2));
        double d6 = Math.sqrt(Math.pow(x0 - g[0], 2) + Math.pow(y0 - g[1], 2));
        return d1 <= r || d2 <= r || d3 <= r || d4 <= r || d5 <= r || d6 <= r;
    }
    public GLVektor getPosition(){
        return astroid.gibPosition();
    }
    public double getRadius(){
        return radius;
    }
    public void detectCollisionWithLaser(){
        for(int i = 0; i < laser.length; i++){
            double c = Math.sqrt(Math.pow(laser[i].getPosition().y - this.getPosition().y, 2) + Math.pow(laser[i].getPosition().x - this.getPosition().x, 2));
            if(c < radius){
                this.reset();
                laser[i].reset();
                ship.addAPointToScore();
            }
        }
    }

}
