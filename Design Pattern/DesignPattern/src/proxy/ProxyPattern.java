package proxy;

// Implementing the Proxy Common Interface such that both will make use of it
interface Subject {
    public void request();
}

// Implementing the RealSubject by implementing the Proxy Interface
class RealSubject implements Subject {
    private String resource;

    public RealSubject(String resource) {
        this.resource = resource;
        this.loadResource();
    }

    public void loadResource() {
        System.out.println("Loading the Resource: " + this.resource);
    }

    @Override
    public void request() {
        System.out.println("Requested: " + this.resource);
    }
}

// Creating the Proxy which implemented the Subject Interface
class Proxy implements Subject {
    private Subject subject = null;
    private String resource;

    public Proxy(String resource) {
        this.resource = resource;
    }

    public void request() {
        if (subject == null) {
            this.subject = new RealSubject(resource);
        }
        this.subject.request();
    }
}

/**
 * Creating the Actual Proxy Pattern where just loading oof the image will be handled.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject = new Proxy("new pdf download");
        subject.request();
        subject.request();
    }
}
