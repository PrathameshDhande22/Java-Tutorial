package facade;

//Subsystem classes
class Amplifier {
	public void on() {
		System.out.println("Amplifier on");
	}

	public void off() {
		System.out.println("Amplifier off");
	}

	public void setDvd() {
		System.out.println("Amplifier setting DVD input");
	}

	public void setSurroundSound() {
		System.out.println("Amplifier surround sound on");
	}

	public void setVolume(int level) {
		System.out.println("Amplifier volume set to " + level);
	}
}

class Tuner {
	public void on() {
		System.out.println("Tuner on");
	}

	public void off() {
		System.out.println("Tuner off");
	}

	public void setFrequency(double freq) {
		System.out.println("Tuner frequency set to " + freq);
	}
}

class DvdPlayer {
	public void on() {
		System.out.println("DVD Player on");
	}

	public void off() {
		System.out.println("DVD Player off");
	}

	public void play(String movie) {
		System.out.println("DVD Player playing \"" + movie + "\"");
	}

	public void stop() {
		System.out.println("DVD Player stopped");
	}

	public void eject() {
		System.out.println("DVD Player eject");
	}
}

class Projector {
	public void on() {
		System.out.println("Projector on");
	}

	public void off() {
		System.out.println("Projector off");
	}

	public void wideScreenMode() {
		System.out.println("Projector in widescreen mode");
	}
}

class TheaterLights {
	public void dim(int level) {
		System.out.println("Theater Ceiling Lights dimming to " + level + "%");
	}

	public void on() {
		System.out.println("Theater Ceiling Lights on");
	}
}

class Screen {
	public void down() {
		System.out.println("Theater Screen going down");
	}

	public void up() {
		System.out.println("Theater Screen going up");
	}
}

class PopcornPopper {
	public void on() {
		System.out.println("Popcorn Popper on");
	}

	public void off() {
		System.out.println("Popcorn Popper off");
	}

	public void pop() {
		System.out.println("Popcorn Popper popping popcorn!");
	}
}

//Facade
class HomeTheaterFacade {
	private Amplifier amp;
	private Tuner tuner;
	private DvdPlayer dvd;
	private Projector projector;
	private Screen screen;
	private TheaterLights lights;
	private PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd, Projector projector, Screen screen,
			TheaterLights lights, PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popper = popper;
	}

	// High‑level operation
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amp.on();
		amp.setDvd();
		amp.setSurroundSound();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}

	// High‑level teardown
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amp.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}

public class FacadePattern {

	public static void main(String[] args) {
		// Instantiate all components
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		Projector projector = new Projector();
		Screen screen = new Screen();
		TheaterLights lights = new TheaterLights();
		PopcornPopper popper = new PopcornPopper();

		// Create facade
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, projector, screen, lights, popper);

		// Use facade to simplify operations
		homeTheater.watchMovie("Inception");
		System.out.println();
		homeTheater.endMovie();
	}

}

/*
 * Output:
 * Get ready to watch a movie...
Popcorn Popper on
Popcorn Popper popping popcorn!
Theater Ceiling Lights dimming to 10%
Theater Screen going down
Projector on
Projector in widescreen mode
Amplifier on
Amplifier setting DVD input
Amplifier surround sound on
Amplifier volume set to 5
DVD Player on
DVD Player playing "Inception"

Shutting movie theater down...
Popcorn Popper off
Theater Ceiling Lights on
Theater Screen going up
Projector off
Amplifier off
DVD Player stopped
DVD Player eject
DVD Player off

 */
