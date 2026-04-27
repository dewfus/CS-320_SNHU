# CS-320: Software Test, Automation, and Quality Assurance

This repository contains work from CS-320, including the Contact Service files from Project One and the Summary and Reflections Report from Project Two. The contact service files demonstrate unit testing with JUnit 5, and the report summarizes the testing approach, techniques, and mindset applied throughout the course.

---

## Reflection

**How can I ensure that my code, program, or software is functional and secure?**

The biggest thing I took away from this course is that functionality has to be proven, not assumed. Writing unit tests for every method and every constraint means you have actual evidence that the code does what it is supposed to do. For the contact, task, and appointment services, that meant testing both the happy path and every invalid input I could think of. On the security side, a lot of it comes down to the same discipline: validating inputs strictly, not trusting that data coming in will be well-formed, and making sure fields that should not be changeable cannot be changed.

**How do I interpret user needs and incorporate them into a program?**

In this course the user needs came in the form of a requirements specification, and my job was to translate those requirements into working code and then into tests that verified the code met them. The way I tried to stay honest about that was by writing tests directly from the requirements rather than from my memory of the implementation. If the spec said a phone number had to be exactly 10 digits, there was a test for 9 digits, 10 digits, and 11 digits. That approach keeps the focus on what the user actually needs rather than what the developer assumed they needed.

**How do I approach designing software?**

I tend to think about the constraints and failure cases before I think about the happy path. What are the rules this system has to enforce, and what happens when someone violates them? Starting from that angle made it easier to write clean validation logic and then write tests that mapped directly to each rule. It also pushed me to keep things simple and focused. Each class had one job, each method had one responsibility, and each test checked one behavior. That separation made everything easier to read, easier to test, and easier to maintain.
