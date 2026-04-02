package chainofresponsibility;

// User Class DTO
class User {
    String username;
    String role;
    String password;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}

// Handler Interface
interface Handle {
    void setNext(Handle handler);

    void handle(User requester);
}

// Base Handler
abstract class BaseHandler implements Handle {
    protected Handle next;

    //    Setting which next request can be handled.
    @Override
    public void setNext(Handle handler) {
        this.next = handler;
    }

    // Handling the Request
    @Override
    public void handle(User requester) {
        if (next != null) {
            next.handle(requester);
        }
    }
}

// Concrete Handlers Means Actual Handlers which can be added as the List
class UserCheckHandler extends BaseHandler {
    @Override
    public void handle(User requester) {
        if (!requester.getUsername().equals("admin")) {
            System.out.println("User Does not Exists");
            return;
        }
        System.out.println("User Verified");
        super.handle(requester);
    }
}

class PasswordCheckHandler extends BaseHandler {
    @Override
    public void handle(User requester) {
        if (!requester.getPassword().equals("1234")) {
            System.out.println("Invalid password");
            return;
        }

        System.out.println("Password verified");
        super.handle(requester);
    }
}

class RoleCheckHandler extends BaseHandler {

    @Override
    public void handle(User requester) {
        if (!requester.getRole().equals("ADMIN")) {
            System.out.println("Access denied: insufficient role");
            return;
        }

        System.out.println("Role verified → Access granted!");
        super.handle(requester);
    }
}

// Creating the Chain
class AuthBuilder {
    public static Handle buildChain() {
        Handle usercheck = new UserCheckHandler();
        Handle passwordcheck = new PasswordCheckHandler();
        Handle rolecheck = new RoleCheckHandler();

        usercheck.setNext(passwordcheck);
        passwordcheck.setNext(rolecheck);
        return usercheck;
    }
}


public class CORPattern {
    public static void main(String[] args) {
        User user = new User("admin", "1234", "ADMIN");

        // Creating the chain -> check for the request
        Handle chain = AuthBuilder.buildChain();
        chain.handle(user);

        System.out.println();
        User user1 = new User("admin", "12234", "ADMIN");
        chain.handle(user1);
    }
}
