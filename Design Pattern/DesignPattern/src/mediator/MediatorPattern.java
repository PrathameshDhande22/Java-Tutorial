package mediator;
import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface ATCMediator {
    public void registerPlane(Plane plane);

    public void sendMessage(String message, Plane plane);
}

// Actual Objects want to communicate with each other
class Plane {
    private String planeName;
    private String route;
    // Mediator It only knows these Class
    private ATCMediator mediator;

    public Plane(String planeName, String route, ATCMediator mediator) {
        this.planeName = planeName;
        this.route = route;
        this.mediator = mediator;
    }

    public String getPlaneName() {
        return this.planeName;
    }

    public void send(String message) {
        System.out.printf("These is Plane %s --> ATC = %s%n", planeName, message);
        this.mediator.sendMessage(message, this);
    }

    public void recieve(String message) {
        System.out.printf("%s --> Recieved : %s%n", this.planeName, message);
    }
}

// Concrete Mediator
class ATCTower implements ATCMediator {
    private List<Plane> planes = new ArrayList<>();

    @Override
    public void registerPlane(Plane plane) {
        this.planes.add(plane);
    }

    @Override
    public void sendMessage(String message, Plane plane) {
        System.out.printf("Replaying Message From: %s  --> %s%n", plane.getPlaneName(), message);
        for (Plane senderPlane : this.planes) {
            if (plane != senderPlane) {
                senderPlane.recieve(message);
            }
        }
    }
}

// Client for Communicating with other planes
public class MediatorPattern {

    public static void main(String[] args) {
        ATCTower tower = new ATCTower();

        Plane planeA = new Plane("Indigo-123", "Ahemdabad", tower);
        Plane planeB = new Plane("SpiceJet-342", "Chennai", tower);
        Plane planeC = new Plane("AirIndia-412", "Mumbai", tower);

        tower.registerPlane(planeA);
        tower.registerPlane(planeB);
        tower.registerPlane(planeC);

        planeB.send("Request to Land Permission");
        planeC.send("I just about to takeoff");
    }
}
