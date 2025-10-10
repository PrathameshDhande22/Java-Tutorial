---
title: Design Patterns
created: 2025-02-07
---
### What is Design Pattern ?

**Design patterns** are typical solutions to commonly occurring problems in software design. They are like pre-made blueprints that you can customize to solve a recurring design problem in your code.
## Three Main Patterns

- **Creational patterns** provide object creation mechanisms that increase flexibility and reuse of existing code.  #creational 
- **Structural patterns** explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient. #structural 
- **Behavioral patterns** take care of effective communication and the assignment of responsibilities between objects. #behavioral 

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
```java title="MessageService.java"
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
```java title="MessageService.java"

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
## ## SOLID Principles

The **SOLID** principles are five key object-oriented design principles that should be followed when creating a class structure. Let’s go through each principle one by one:
### 1. Single Responsibility Principle (SRP)
This principle states that a class should have only one responsibility and, therefore, only one reason to change.

**Example:**  
Consider a `Book` class that contains all the methods and variables related to a book. You should not include code related to a `Student` class or methods that are not relevant to the `Book` class.
### 2. Open-Closed Principle (OCP)
This principle states that a class should be **open for extension but closed for modification**. Modification refers to changing the code of an existing class, while extension means adding new functionality without altering the existing code.

**Example:**  
If you have a well-tested and reliable class, modifying its code can introduce bugs and potential system crashes. Instead, you should extend the functionality using **abstract classes** or **interfaces** rather than modifying the tested code directly.
### 3. Liskov Substitution Principle (LSP)
This principle states that **subtypes of a base class must be substitutable without altering the correctness of the program**.

**Example:**  
Consider an abstract or base class `Shape` with a method to calculate the area. If you create a `Rectangle` class by inheriting from `Shape`, calling the area calculation method on a `Rectangle` object (using a `Shape` reference) should return the expected result without requiring changes to the base class.
### 4. Interface Segregation Principle (ISP)
This principle states that **a class should not be forced to implement interfaces it does not use**. It is better to have multiple **smaller, specific interfaces** rather than a large, general-purpose interface.

**Example:**  
Consider a `Programmer` class with methods like `work()`, `eat()`, `test()`, and `assign()`, all declared in an `IEmployee` interface. The problem arises when you introduce `Manager` and `TeamLead` classes—they require the `assign()` method, but it doesn't belong in the `Programmer` class. To fix this, you can **segregate** the interfaces:
- Common employee methods go in the `IEmployee` interface.
- Management-related methods go in an `IManage` interface.

This way, only relevant methods are implemented by each class.
### 5. Dependency Inversion Principle (DIP)
This principle states that **high-level modules should not depend on low-level modules; instead, both should depend on abstractions (interfaces or abstract classes)**.

**Example:**  
Consider an `SQLManager` class that performs CRUD operations. It has an `ILogger` interface for logging, which allows you to use different loggers like `FileLogger`, `ConsoleLogger`, or `TableLogger`. Since the `SQLManager` depends on the abstraction (`ILogger`) rather than a specific logging implementation, you can switch loggers without breaking the system.

---
## Contents:

1. [[Strategy Pattern]]
2. [[Observer Pattern]]
3. [[Decorator Pattern]]
4. [[Factory Method Pattern]]
5. [[Abstract Factory Pattern]]
6. [[Singleton Pattern]]
7. [[Command Pattern]]
8. [[Adapter Pattern]]
9. [[Facade Pattern]]
10. [[Quiz-1]]
11. [[Iterator Pattern]]

---
> [!Note] 
> All the Patterns and code Examples are taken from the Book titled [Head First Design Patterns](https://www.oreilly.com/library/view/head-first-design/9781492077992/?_gl=1*xxiqn6*_ga*MTk1NDU5NDczNi4xNzM2MjcwMTgz*_ga_092EL089CH*MTczNzA0OTQ2MC4yLjAuMTczNzA0OTQ2My41Ny4wLjA.) 




