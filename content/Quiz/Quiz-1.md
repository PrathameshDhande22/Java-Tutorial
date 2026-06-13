---
title: Quiz 1
created: 2025-09-03
tags:
  - quiz
---
All the Questions are based on Pattern [[Strategy Pattern]], [[Singleton Pattern]], [[Observer Pattern]], [[Factory Method Pattern]], [[Facade Pattern]], [[Decorator Pattern]], [[Adapter Pattern]], [[Command Pattern]], and [[Abstract Factory Pattern]] Explanation is also provided.

#### Question 1

You are building a **payment system** for an e-commerce website.  
The system should support multiple payment methods (Credit Card, PayPal, UPI).  
The way the payment is processed should be **easily interchangeable** at runtime without changing the core checkout flow.

👉 Which pattern should you use?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Strategy Pattern  
> **Explanation:**  
> - The checkout process (algorithm skeleton) is fixed, but the **payment method (CreditCard/PayPal/UPI)** can change dynamically.  
> - Strategy Pattern is used to **define a family of algorithms** (different payment strategies) and make them interchangeable at runtime.  

---
#### Question 2

In a **stock market app**, whenever the price of a stock changes, you want all the subscribed users and analytics modules to get notified automatically.  

👉 Which pattern fits here?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Observer Pattern  
> **Explanation:**  
> - When the stock (subject) changes, all observers (users, analytics modules) should be automatically notified.  
> - Observer Pattern allows **one-to-many dependency** between objects.  

---
#### Question 3

You are designing a **coffee shop ordering system**.  
A base coffee can be ordered, but customers can add extras like milk, sugar, whip, or mocha — and these add-ons should be flexible and combinable without creating hundreds of coffee subclasses.  

👉 Which pattern should you apply?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Decorator Pattern  
> **Explanation:**  
> - Instead of creating subclasses like `CoffeeWithMilkAndSugarAndWhip`, we use the **Decorator Pattern** to wrap objects dynamically with additional functionality.  
> - This allows flexible and combinable add-ons.  

---
#### Question 4

You want to build a **document creation tool** that allows users to create different types of documents (Word, PDF, Excel).  
You need a way to let subclasses decide which type of document object to create without altering the client code.  

👉 Which pattern works best?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Factory Method Pattern  
> **Explanation:**  
> - Factory **Method** allows subclasses (`WordDocumentFactory`, `PdfDocumentFactory`) to decide which object to create without changing the client code.  
> - Plain **Factory Pattern** is more general, but in GoF terms, this case is specifically **Factory Method**.  

---
#### Question 5

You are building a **cross-platform UI toolkit** (Windows, macOS, Linux).  
Each platform needs its own **Button, Checkbox, and Dropdown** components.  
You want to create families of related objects (UI components) without depending on their concrete classes.  

👉 Which pattern should you use?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Abstract Factory Pattern  
> **Explanation:**  
> - Each platform (Windows/macOS/Linux) needs a **family of related objects** (Button, Checkbox, Dropdown).  
> - Abstract Factory provides an interface to create families of related objects **without specifying their concrete classes**.  

---
#### Question 6

In your application, you need to ensure that there is **only one instance of a logging service** available throughout the system, and it should be globally accessible.  

👉 Which pattern fits here?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Singleton Pattern  
> **Explanation:**  
> - Singleton ensures **only one instance** of a class exists and provides a **global access point** to it.  
> - Perfect for cases like logging service, configuration manager, database connection pool.  

---
#### Question 7

You are designing a **remote control system** for a smart home.  
Each button (e.g., Light On, Light Off, Fan On, Fan Off) should trigger a specific action.  
You want to encapsulate these requests as objects so that you can also **undo/redo actions** later.  

👉 Which pattern is most suitable?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Command Pattern  
> **Explanation:**  
> - Each button press is a **command** (`LightOnCommand`, `FanOffCommand`, etc.).  
> - Commands can be stored in a history stack to **undo/redo** actions.  
> - Very common in remote controls, menu actions, and macro recording.  

---
#### Question 8

You are integrating a **third-party payment gateway** into your existing e-commerce system.  
The interface of the third-party gateway is incompatible with your current system’s payment interface.  
You need a way to make them work together without changing existing code.  

👉 Which pattern should you apply?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Adapter Pattern  
> **Explanation:**  
> - Your system expects a specific **payment interface**, but the third-party gateway has a different API.  
> - Adapter Pattern acts as a **bridge** between the two incompatible interfaces.  

---
#### Question 9

You are designing a **complex library management system** with multiple subsystems (catalog, user management, notifications, reporting).  
You want to provide a **simplified interface** to these subsystems, so clients don’t have to deal with the complexity directly.  

👉 Which pattern should you use?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Facade Pattern  
> **Explanation:**  
> - You have many complex subsystems (catalog, user, notifications, reporting).  
> - Facade Pattern provides a **unified, simplified interface** so clients don’t need to know the internal details.  

---
#### Trick Question 1

You are building a **text editor**.  
- You want to support multiple text formatting operations (bold, italic, underline).  
- You also want to support an **undo/redo system** for these operations.  
- Additionally, you may want to store a history of commands for “macro recording” (replaying a sequence of edits).  

👉 Which pattern fits best?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Command Pattern  
> **Explanation:**  
> - Each operation is a **Command object**.  
> - Commands can be stored in a **history stack** to support **undo/redo**.  
> - They can also be replayed for macro recording.  

---
#### Trick Question 2

In a **video game**, you have different types of enemies (Orc, Troll, Dragon).  
- Each enemy has different attack behaviors (melee, ranged, magic).  
- You want to change enemy behaviors **dynamically at runtime** (e.g., make Troll use ranged attack instead of melee).  

👉 Which pattern should you choose?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Strategy Pattern  
> **Explanation:**  
> - Attack behavior is the **algorithm** that can vary independently from the Enemy class.  
> - With Strategy, you can swap behaviors dynamically at runtime (`meleeAttack`, `rangedAttack`, `magicAttack`).  

---
#### Trick Question 3

You are working on a **plugin-based architecture**.  
- A core application should be able to load different plugins (authentication, reporting, visualization) **without modifying its source code**.  
- The plugins should conform to a common interface, but the actual plugin implementations may vary.  

👉 Which pattern makes the most sense here?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Factory Method (or Abstract Factory if multiple families)  
> **Explanation:**  
> - Adapter is for **incompatible interfaces** (not the case here).  
> - The correct approach is **Factory Method**: the core app knows only the `Plugin` interface and lets factories decide which plugin implementation to instantiate at runtime.  

---
#### Trick Question 4

You are designing a **shopping cart system**.  
- Discounts can be applied in different ways: percentage discount, flat discount, buy-one-get-one.  
- You also want to allow **stacking discounts** (e.g., percentage + flat).  

👉 Which pattern should you use?  
> [!FAQ]- Answer & Explanation
> **Pattern**: Decorator Pattern  
> **Explanation:**  
> - You start with a base `Discount`.  
> - Each discount (percentage, flat, BOGO) can **wrap** the existing discount and add its own behavior.  
> - This allows stacking and combining discounts flexibly.  

