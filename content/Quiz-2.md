---
tags:
  - quiz
created: 2026-02-11
title: Quiz 2
---
All the Question are based on the pattern [[Singleton Pattern]], [[Command Pattern]], [[Adapter Pattern]],  [[Facade Pattern]], [[Iterator Pattern]], [[Composite Pattern]], [[State Pattern]], [[Proxy Pattern]] & [[Compound Pattern]]. 
#### Question 1

You are building an **expense dashboard app (like your CashFlow project)**.  
The application needs **one shared database connection** so that:
- All modules use the same connection
- Creating multiple connections would waste memory and slow the system

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Singleton  
> **Explanation:**  
> A database connection is a classic **Singleton** use case because:
> - Only **one instance** is needed across the application  
> - It provides a **global access point**  
> - Prevents unnecessary memory usage and connection overhead  

---
#### Question 2

You are designing a **remote control app** for smart home devices.  
Each button can:
- Turn lights ON/OFF  
- Open/close curtains  
- Start the fan  

You also want to support **Undo** functionality.
**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Command  
> **Explanation:**  The **Command Pattern** encapsulates each action as an object.  
> This allows:
> - Storing commands  
> - Undoing operations  
> - Decoupling the invoker (remote) from receivers (devices)  

---
#### Question 3

You are integrating a **payment gateway** into an e-commerce system.  
Your system expects a **standard payment interface**, but the new gateway provides a **different API** that cannot be changed.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Adapter  
> **Explanation:**  The **Adapter Pattern** converts one interface into another expected by the client.  
> It allows integration of incompatible systems without modifying existing code.

---
#### Question 4

You are building a **movie streaming app**.  
Playing a movie involves:
- Authentication  
- Loading subtitles  
- Initializing decoder  
- Buffering video  

You want a simple method like:
`playMovie()`  

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Facade  
> **Explanation:**  The **Facade Pattern** provides a simplified interface to a complex subsystem, hiding internal operations from the user.

---
#### Question 5

You are developing a **music playlist app**.  
Users should move through songs without knowing whether songs are stored in arrays, lists, or databases.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Iterator  
> **Explanation:**  The **Iterator Pattern** provides a standard way to traverse a collection without exposing its internal structure.

---
#### Question 6

You are building a **file explorer system** where:
- A folder can contain files and other folders  
- Operations like `delete()` or `showSize()` should work uniformly

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Composite  
> **Explanation:**  The **Composite Pattern** allows treating individual objects and groups uniformly in tree structures.

---
#### Question 7

You are designing a **document editor** where documents can be:
- Draft  
- Review  
- Published  
Each state changes editing behavior.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** State  
> **Explanation:**  The **State Pattern** allows behavior to change dynamically based on the object's internal state.

---
#### Question 8

You are developing an **image viewer** where large images should load only when opened, while placeholders are shown initially.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Proxy  
> **Explanation:**  A **Virtual Proxy** delays object creation until needed, improving performance and memory usage.

---
#### Question 9

You are integrating a **complex third-party payment library** and create a simple class exposing only a few methods like `startPayment()` and `verifyPayment()`.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Facade  
> **Explanation:**  The **Facade Pattern** simplifies interaction with complex subsystems by providing a unified interface.

---
#### Question 10

You are building a **text editor** that supports:
- Copy  
- Paste  
- Cut  
- Undo / Redo  
Operations must be stored and reversible.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Command  
> **Explanation:**  Commands encapsulate operations as objects, enabling undo/redo and history tracking.

---
#### Question 11

You are designing a **company organizational hierarchy** where:
- Managers contain employees  
- Employees and managers should be treated uniformly

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Composite  
> **Explanation:**  Composite models hierarchical structures and allows uniform treatment of individuals and groups.

---
#### Question 12

A banking system performs authentication and validation before forwarding requests to the real transfer service.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Proxy  
> **Explanation:**  A **Protection Proxy** controls access to another object by performing checks before forwarding requests.

---
#### Question 13

You are designing a **vending machine** where behavior changes depending on:
- Coin inserted  
- Item selected  
- Item dispensed  

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** State  
> **Explanation:**  Each state defines behavior, eliminating large conditional logic and making transitions easier.

---
#### Question 14

Your application expects a logging interface, but a **legacy logging system** has a different method signature.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Adapter  
> **Explanation:**  Adapter translates one interface into another compatible interface without modifying existing systems.

---
#### Question 15

You are building a **graphics editor** where:
- Shapes can be individual or grouped  
- Calling `draw()` should work for both

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Composite  
> **Explanation:**  Composite allows treating single objects and groups uniformly in tree structures.

---
#### Question 16

A **library management system** stores books in multiple structures but must allow uniform traversal.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Iterator  
> **Explanation:**  Iterator enables traversal without exposing internal storage details.

---
#### Question 17

You are designing a **configuration manager** that must:
- Load configuration once  
- Share it globally  

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Singleton  
> **Explanation:**  Singleton ensures a single shared instance and controlled access.

---
#### Question 18

A **video streaming platform** uses a local cache server that decides whether to fetch from cache or the main server.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Proxy  
> **Explanation:**  A caching proxy controls access and improves performance by serving cached content.

---
#### Question 19

A **smart home system** combines:
- Command for actions  
- Composite for device groups  
- Iterator for traversal  
- Facade for simplified control  

**What is this approach called?**
> [!FAQ]- Answer and Explanation
> **Pattern:** Compound Pattern  
> **Explanation:**  Compound patterns combine multiple design patterns to solve complex design problems.

---
#### Question 20

A **game character system** has states like:
- Standing  
- Running  
- Jumping  
- Attacking  
Behavior changes dynamically with state.

**Which design pattern is most appropriate here, and why?**
> [!FAQ]- Answer and Explanation
> **Pattern:** State  
> **Explanation:**  The State Pattern encapsulates state-specific behavior into separate classes and enables dynamic transitions.

