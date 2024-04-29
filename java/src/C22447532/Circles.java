package C22447532;

import processing.core.*;

public class Circles {
    OthnielsVisual sv;
    float rot = 0;

    public Circles(OthnielsVisual sv) {
        this.sv = sv;
    }

    
    public void render() {
        sv.noFill();
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.translate(0, 0, -500);
        sv.strokeWeight(4);
        sv.ellipseMode(PApplet.CENTER);
        sv.rotate(PApplet.radians(rot));
        
        float[] bands = sv.getSmoothedBands();
        for(int i = 0; i < bands.length; i++) {
            float colour = PApplet.map(i, 0, bands.length * 2, 0, 255);
            sv.stroke(colour, 255, 255);
            float size = bands[i];
            
            drawCircle(86, 86, size * sv.lerpedAverage * 20);
            drawCircle(-86, -86, size * sv.lerpedAverage * 20);  
            drawCircle(86, -86, size * sv.lerpedAverage * 20);
            drawCircle(-86, 86, size * sv.lerpedAverage * 20);
            drawCircle(100, 0, size * sv.lerpedAverage * 20);
            drawCircle(-100, 0, size * sv.lerpedAverage * 20);
            drawCircle(0, 100, size * sv.lerpedAverage * 20);
            drawCircle(0, -100, size * sv.lerpedAverage * 20);
            drawCircle(0, 0, size * sv.lerpedAverage * 20);
            drawCircle(186, 186, size * sv.lerpedAverage * 20);
            drawCircle(-186, -186, size * sv.lerpedAverage * 20);
            drawCircle(186, -186, size * sv.lerpedAverage * 20);
            drawCircle(-186, 186, size * sv.lerpedAverage * 20);
            
        }
        rot += sv.lerpedAverage * 20;
    }
    
    private void drawCircle(float x, float y, float size) {
        sv.circle(x, y, size);
    }

}
