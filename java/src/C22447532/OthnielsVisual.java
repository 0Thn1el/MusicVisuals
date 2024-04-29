package C22447532;

import ie.tudublin.*;

public class OthnielsVisual extends Visual {

    Sphere sph;
    Circles circ;

    int visual = 0;
    float[] lerpedBuffer;
    float lerpedAverage = 0;
    float average;
    float sum;

    public void settings()
    {
        size(800, 630, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
                
        loadAudio("java/data/IF YOU GO.mp3");


        sph = new Sphere(this);
        circ = new Circles(this);

        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (keyCode == ' ')
        {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            }
            else {
                getAudioPlayer().play();
            }
        }

        if(keyCode == LEFT) {
            // Rewind song
            getAudioPlayer().cue(0);
        }

        if (keyCode >= '0' && keyCode <= '1') {
            visual = keyCode - '0';
        }
    }

    public void draw()
    {
        background(0);
        try
        {

            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        calculateFrequencyBands(); 


        calculateAverageAmplitude();   
        
        average = 0;
        sum = 0;


        for (int i = 0; i < getAudioBuffer().size(); i ++)
        {
            sum += abs(getAudioBuffer().get(i));
        }
        average = sum / getAudioBuffer().size();

        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (visual)
        {
            case 0:
            {
                sph.render();
                strokeWeight(10);
                break;
            }
            case 1:
            {
                circ.render();
                break;
            }
        }
    }
}