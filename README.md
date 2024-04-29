# Music Visualiser Project

Name: Othniel Alfa

Student Number: C22447532


# Description of the assignment

The song I chose for this assignment is "IF YOU GO" by Eem Triplin. It holds a rather peculiar yet emotional chord progression, The 808's throughout the song speed up  the music with their wide and short bass, showcasing the ability of the lerpbuffer. 

I showed 2 cases of visuals in my project, 1 3D case and 1 2D case,  a sphere and circles. I made the sphere immersive as tocereate a more 3d effect around it while the circles i made to rotate and expand in multiple points as to make a almost dizzying sight.

# Instructions
- Press space to start
- Press space to play when paused
- Press space to pause when playing
- Press left to rewind
- Press 0 and 1 to switch visuals
- Key 0: Inside Rotating Circle
- Key 1 Circles in Square Formation

# How it works


I used inheritance to make OthnielsVisual extend to the Visual class.

```java
public class OthnielsVisual extends Visual {}
```

Each visual class includes an instance of OThnielsVisual as a parameter in its constructor. 
Below, you'll find an illustration of how this instance is utilized within the constructor of the ExpandingCircles class. 
The structure of each visual class follows a similar pattern.

```java
public class Sphere {
    OthnielsVisual sv;
    float rot = 0;
    float tate = 0;

    public Sphere(OthnielsVisual sv) {
        this.sv = sv;
    }
```
The KeyPressed method checks which key the user pressed. It then either pauses, plays, rewinds the song or changes the visuals. 

```java
public void keyPressed() {
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

	if (keyCode >= '0' && keyCode <= '5') {
		visual = keyCode - '0';
	}
}
```

I then used a switch case to switch between the visuals depending on whether 0 or 1 was pressed.

```java
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
```

# What I am most proud of in the assignment

What I find myself most proud of was not only my creation of the spere but the creativity I held to be able to think to make it immersive.


# Images
Key 1: Circles

![An image](images/Screenshot%202024-04-28%20234852.png)

Key 2: Sphere
![Another image](images/Screenshot%202024-04-28%20234903.png)

Youtube: [OOP Assignment 2024 - Music Visualiser | Othniel Alfa](https://youtu.be/-k9Wtb7JNf8)