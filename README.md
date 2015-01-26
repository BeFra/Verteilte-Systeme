# Verteilte-Systeme

#### 1-Aufgabe
SerialPrimeServer.java is a seriell Implementation of a Server, which tests whether a number is a prime number or not.
The class SyncPrimeClinet is a Clinet which sends the first ten numbers from 10^^18 to the SerialPrimeServer. The clinet waits synchron for the result.
PollingPromeClinet is a client which waits nonblocking for the result from the SerialPrimeServer.
The ThreadedPooledPrimeServer provides a thread pool for the requests.
The PrimeClinet4ServerMesurement class measures the times of the calculation time of a request to the SerialPrimeServer and the ThreadedPooledPrimeServer.

#### 2-Aufgabe
A extension of "1-Aufgabe" with the Posion-Pill-Technik to stop the Server.

#### 3-Aufgabe
This project deals with the hierarchical localization linear names.

#### 4-Aufgabe
This Projekts deals with the Algorithm of Ricart and Agrawala for the mutual exclusion in a distributed system.

#### 5-Aufgabe
This project provides the basis for a distributed MVC architecture(Model View Controller).
