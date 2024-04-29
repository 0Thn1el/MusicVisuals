package C22447532;

import processing.core.*;

public class Sphere {
    OthnielsVisual sv;
    float rot = 0;
    float tate = 0;

    public Sphere(OthnielsVisual sv) {
        this.sv = sv;
    }

    public void render() {
        sv.noFill();
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.strokeWeight(1);

        float colour = PApplet.map(sv.average, 0, 1, 0, 255);
        sv.stroke(colour * 2, 255, 255);

        sv.pushMatrix();
        sv.noFill();
        sv.rotateX(PApplet.radians(rot));
        sv.rotateY(PApplet.radians(rot));
        sv.rotateZ(PApplet.radians(tate));
        sv.sphere(2000 * sv.lerpedAverage);
        sv.popMatrix();
        rot += sv.lerpedAverage * 20;
        tate += 1;
    }
}
 