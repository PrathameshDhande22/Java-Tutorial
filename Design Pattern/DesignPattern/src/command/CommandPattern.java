package command;

import java.util.Arrays;

// Command.java
/**
 * Base Command Interface
 */
interface Command {
	/**
	 * Command to execute
	 */
	public void execute();

	/**
	 * Undo's the last Command executed.
	 */
	public void undo();
}

/**
 * ===================== Class want to Interact with Remote Control
 * =====================
 **/

// Light.java
class Light {
	public void off() {
		System.out.println("Light is Turned Off");
	}

	public void on() {
		System.out.println("Light is Turned On");
	}
}

// LivingRoom.java
class LivingRoom {
	public void off() {
		System.out.println("Living Room Light is turned off");
	}

	public void on() {
		System.out.println("Living room Light is Turned On");
	}

	public void fancyLightOn() {
		System.out.println("Living Room Fancy Light is Turned On");
	}

	public void fancyLightOff() {
		System.out.println("Living Room Fancy Light is Turned Off");
	}
}

// CeilingFan.java
class CeilingFan {
	public static final int OFF = 0;
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	private int speed;

	public void high() {
		this.speed = HIGH;
		System.out.println("CeilingFan is Set to High");
	}

	public void off() {
		this.speed = OFF;
		System.out.println("CeilingFan is turned off");
	}

	public void low() {
		this.speed = LOW;
		System.out.println("CeilingFan is set to Low");
	}

	public void medium() {
		this.speed = MEDIUM;
		System.out.println("CeilingFan is set to Medium");
	}

	public int getSpeed() {
		return this.speed;
	}
}

/** ================= Creating the Commands =================== **/

// LightOnCommand.java
/**
 * Command to Turn on the Light
 */
class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.on();
	}

	@Override
	public void undo() {
		this.light.off();
	}

	@Override
	public String toString() {
		return "LightOffCommand";
	}
}

// LightOffCommand.java
class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light ligth) {
		this.light = ligth;
	}

	@Override
	public void execute() {
		this.light.off();
	}

	@Override
	public void undo() {
		this.light.on();
	}

	@Override
	public String toString() {
		return "LightOffCommand";
	}
}

// LivingRoomOnCommand.java
class LivingRoomOnCommand implements Command {
	private LivingRoom _livingroom;

	public LivingRoomOnCommand(LivingRoom livingroom) {
		this._livingroom = livingroom;
	}

	@Override
	public void execute() {
		this._livingroom.on();
		this._livingroom.fancyLightOn();
	}

	@Override
	public void undo() {
		this._livingroom.fancyLightOff();
		this._livingroom.off();
	}

	@Override
	public String toString() {
		return "LivingRoomOnCommand";
	}
}

// LivingRoomOffCommand.java
class LivingRoomOffCommand implements Command {
	private LivingRoom _livingroom;

	public LivingRoomOffCommand(LivingRoom livingroom) {
		this._livingroom = livingroom;
	}

	@Override
	public void execute() {
		this._livingroom.fancyLightOff();
		this._livingroom.off();
	}

	@Override
	public void undo() {
		this._livingroom.on();
		this._livingroom.fancyLightOn();
	}

	@Override
	public String toString() {
		return "LivingRoomOffCommand";
	}
}

// CeilingFanOffCommand.java
class CeilingFanOffCommand implements Command {
	private CeilingFan _ceilingfan;
	private int fanspeed;

	public CeilingFanOffCommand(CeilingFan ceilingfan) {
		this._ceilingfan = ceilingfan;
	}

	@Override
	public void execute() {
		this.fanspeed = this._ceilingfan.getSpeed();
		this._ceilingfan.off();
	}

	@Override
	public void undo() {
		switch (this.fanspeed) {
		case CeilingFan.HIGH:
			this._ceilingfan.high();
			break;
		case CeilingFan.MEDIUM:
			this._ceilingfan.medium();
			break;
		default:
			this._ceilingfan.low();
		}
	}

	@Override
	public String toString() {
		return "CeilingFanOffCommand";
	}
}

// CeilingFanHighCommand.java
class CeilingFanHighCommand implements Command {
	private CeilingFan _ceilingfan;
	private int fanspeed;

	public CeilingFanHighCommand(CeilingFan ceilingfan) {
		this._ceilingfan = ceilingfan;
	}

	@Override
	public void execute() {
		this.fanspeed = this._ceilingfan.getSpeed();
		this._ceilingfan.high();
	}

	@Override
	public void undo() {
		switch (this.fanspeed) {
		case CeilingFan.OFF:
			this._ceilingfan.off();
			break;
		case CeilingFan.MEDIUM:
			this._ceilingfan.medium();
			break;
		default:
			this._ceilingfan.low();
		}
	}

	@Override
	public String toString() {
		return "CeilingFanHighCommand";
	}
}

// CeilingFanMediumCommand.java
class CeilingFanMediumCommand implements Command {
	private CeilingFan _ceilingfan;
	private int fanspeed;

	public CeilingFanMediumCommand(CeilingFan ceilingfan) {
		this._ceilingfan = ceilingfan;
	}

	@Override
	public void execute() {
		this.fanspeed = this._ceilingfan.getSpeed();
		this._ceilingfan.medium();
	}

	@Override
	public void undo() {
		switch (this.fanspeed) {
		case CeilingFan.HIGH:
			this._ceilingfan.high();
			break;
		case CeilingFan.OFF:
			this._ceilingfan.off();
			break;
		default:
			this._ceilingfan.low();
		}
	}

	@Override
	public String toString() {
		return "CeilingFanMediumCommand";
	}
}

// NoCommand.java
class NoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Empty Command");
	}

	@Override
	public void undo() {
		System.out.println("No Last Command");
	}

	@Override
	public String toString() {
		return "NoCommand";
	}

}

/** ============== Remote Control ==================== **/

// RemoteControl.java
/**
 * Remote Control which only has the button pressed method by pressing it
 * activates the command
 */
class RemoteControl {
	private Command[] _oncommands;
	private Command[] _offcommands;
	private Command _lastcommand = new NoCommand();

	public RemoteControl() {
		this._oncommands = new Command[7];
		this._offcommands = new Command[7];
		Arrays.fill(this._oncommands, new NoCommand());
		Arrays.fill(this._offcommands, new NoCommand());
	}

	/**
	 * Sets the Command in the Provided slot
	 * 
	 * @param slot       The index where to set the Command
	 * @param onCommand  The Command to be executed
	 * @param offCommand the Command for setting OFF.
	 */
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		this._oncommands[slot] = onCommand;
		this._offcommands[slot] = offCommand;
	}

	public void pressOnButton(int slot) {
		this._lastcommand = this._oncommands[slot];
		this._oncommands[slot].execute();
	}

	public void pressOffButton(int slot) {
		this._lastcommand = this._offcommands[slot];
		this._offcommands[slot].execute();
	}

	public void pressUndobutton() {
		this._lastcommand.undo();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n--------- Remote Control --------\n");
		for (int i = 0; i < this._oncommands.length; i++) {
			sb.append(String.format("[slot %d] %s\t%s\n", i, _oncommands[i].toString(), _offcommands[i].toString()));
		}
		sb.append("LastCommand = " + this._lastcommand.toString());
		return sb.toString();

	}

}

public class CommandPattern {
	public static void main(String[] args) {
		// Creating the Remote Control
		RemoteControl rc = new RemoteControl();
		System.out.println(rc);

		// Want to control using the single remote
		Light light = new Light();
		CeilingFan ceilingfan = new CeilingFan();
		LivingRoom livingroom = new LivingRoom();

		// Command Initialization
		LightOnCommand lightoncommand = new LightOnCommand(light);
		LightOffCommand lightoffcommand = new LightOffCommand(light);
		CeilingFanOffCommand ceilingfanoffcommand = new CeilingFanOffCommand(ceilingfan);
		CeilingFanHighCommand ceilingfanhighcommand = new CeilingFanHighCommand(ceilingfan);
		CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingfan);
		LivingRoomOnCommand livingrooomoncommand = new LivingRoomOnCommand(livingroom);
		LivingRoomOffCommand livingroomoffcommand = new LivingRoomOffCommand(livingroom);

		// Setting the Command into their Respective Slots
		rc.setCommand(0, livingrooomoncommand, livingroomoffcommand);
		rc.setCommand(1, ceilingFanMediumCommand, ceilingfanoffcommand);
		rc.setCommand(2, lightoncommand, lightoffcommand);
		rc.setCommand(3, ceilingFanMediumCommand, ceilingfanoffcommand);
		rc.setCommand(4, ceilingfanhighcommand, ceilingfanoffcommand);
		System.out.println(rc);
		System.out.println();
		
		// Pressing the Button -> Pressing any button it will execute the program inside that method.
		rc.pressOnButton(2);
		rc.pressOnButton(4);
		rc.pressOffButton(2);
		
		// Pushing the Undo Button
		rc.pressUndobutton();
		System.out.println(rc);

	}
}
