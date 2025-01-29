---
title: Design Patterns
---
### What is Design Pattern ?

**Design patterns** are typical solutions to commonly occurring problems in software design. They are like pre-made blueprints that you can customize to solve a recurring design problem in your code.

## Three Main Patterns

- **Creational patterns** provide object creation mechanisms that increase flexibility and reuse of existing code.
- **Structural patterns** explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.
- **Behavioral patterns** take care of effective communication and the assignment of responsibilities between objects.

> [!Important] Prerequisite
>Must have knowledge of **OOPS (Object-Oriented Programming Principles)** and **Java**. The design patterns are primarily based on OOPS concepts. The code in this tutorial is mainly written in Java and related frameworks.
>
>**OOPS Concepts:**
> - Inheritance
>- Abstraction
>- Polymorphism
>- Encapsulation
 
Before diving into design patterns, it’s important to understand the **SOLID Principles**, **Tightly Coupled Classes**, and **Loosely Coupled Classes**. Additionally, some tips and tricks for writing clean code.

---
## Tightly Coupled and Loosely Coupled Classes

In software design, **coupling** refers to the degree of dependency between two classes or modules. It determines how closely one class is connected to another. 
### 1. Tightly Coupled Classes
**Definition:** These classes are highly dependent on each other. Changes in one class often require changes in the other, making the system rigid and harder to maintain. These classes violates the **Single Responsibility Principle** which is the part of the SOLID Principle. 

**Example :** 
Consider a `MessageService` class that sends messages via Email, SMS, or other techniques. The implementation might look like the following code:
```java title:MessageService.java
class MessageService {

	public static void sendMessage(string message){
		// Tightly Coupled on the email only
		EmailClient emailclient = new EmailClient();
		emailclient.sendEmail(message);
	}
	
}
```
In this code, you can see that the `sendMessage` method sends the message exclusively via Email. The `EmailClient` class is tightly coupled with this method. If you need to send messages using other providers (e.g., SMS or other techniques), you would have to create separate services for each provider. This approach is inefficient and leads to code repetition.
### 2. Loosely Coupled Classes
**Definition:** These classes have minimal dependency on each other. They interact through interfaces or abstractions, making the system flexible, maintainable, and reusable.
These Approach Follows **Dependency Inversion Principle** which is again the part of the SOLID Principle. 

**Example:**
In the earlier example, the `MessageService` class was heavily dependent on `EmailClient`. In such cases, if you need to create another service, it becomes inefficient. We can avoid this dependency by passing the `ProviderClient` interface as a parameter to the `sendMessage` method. Then, we implement the `ProviderClient` interface for various provider services.
```java title:MessageService.java

// Interface to be implemented by various provider services
interface ProviderClient {
    void send(String message, String to);
}

// Email Service implementing the ProviderClient interface
public class EmailClient implements ProviderClient {
    public void send(String message, String to) {
        // Code to send an email
    } 
}

// SMS Service implementing the ProviderClient interface
public class SMSClient implements ProviderClient {
    public void send(String message, String to) {
        // Code to send an SMS
    }
}

// MessageService class using ProviderClient
class MessageService {
    public static void sendMessage(ProviderClient client, String message, String to) {
        client.send(message, to);
    }
}

```
Now, you can add as many providers as needed, and `MessageService` will continue to work without being tightly coupled to `EmailClient`.

---
## SOLID Principle



---
## Contents:

1. [[Strategy Pattern]]
2. [[Observer Pattern]]

---
> [!Note] 
> All the Patterns and code Examples are taken from the Book titled [Head First Design Patterns](https://www.oreilly.com/library/view/head-first-design/9781492077992/?_gl=1*xxiqn6*_ga*MTk1NDU5NDczNi4xNzM2MjcwMTgz*_ga_092EL089CH*MTczNzA0OTQ2MC4yLjAuMTczNzA0OTQ2My41Ny4wLjA.) 




