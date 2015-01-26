# Verteilte-Systeme

#### 1-Aufgabe #### 
SerialPrimeServer.java is a seriell Implementation of a Server, which tests whether a number is a prime number or not.
The class SyncPrimeClinet is a Clinet which sends the first ten numbers from 10^^18 to the SerialPrimeServer. The clinet waits synchron for the result.
PollingPromeClinet is a client which waits nonblocking for the result from the SerialPrimeServer.
The ThreadedPooledPrimeServer provides a thread pool for the requests.
The PrimeClinet4ServerMesurement class measures the times of the calculation time of a request to the SerialPrimeServer and the ThreadedPooledPrimeServer.
