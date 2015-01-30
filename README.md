# Verteilte-Systeme

#### 1-Aufgabe
SerialPrimeServer.java is a seriell Implementation of a Server, which tests whether a number is a prime number or not.
The class SyncPrimeClinet is a Clinet which sends the first ten numbers from 10^^18 to the SerialPrimeServer. The clinet waits synchron for the result.
PollingPromeClinet is a client which waits nonblocking for the result from the SerialPrimeServer.
The ThreadedPooledPrimeServer provides a thread pool for the requests.
The PrimeClinet4ServerMesurement class measures the times of the calculation time of a request to the SerialPrimeServer and the ThreadedPooledPrimeServer.

#### 2-Aufgabe
A extension of "1-Aufgabe" with the Posion-Pill-Technique to stop the Server.

#### 3-Aufgabe
This project implements the hierarchical localization linear names algorithm.

#### 4-Aufgabe
This project implements the algorithm of Ricart and Agrawala for the mutual exclusion in a distributed system.

#### 5-Aufgabe
This project implements the bully algorithmen. The bully algorithm is a method in distributed computing for dynamically electing a coordinator by process ID number. The process with the highest process ID number is selected as the coordinator.

#### 6-Aufgabe
This project provides the basis for a distributed MVC architecture(Model View Controller).
