# Simple library manager

A simple Client-Server based library manager

## Description

This is a library manager that I build while practising sockets and Client/Server conections and requests. It is made up to be simple so his options arent nothing out of this world.
## Getting Started

### Dependencies

* Ideally two VM or (more) computers, but it works in two different java consoles.
* Java (Pretty much any JDK should work. I used 21 LTS)

### Installing

* It is made up to be basically plug&play. Just run the files and you should be good

### Executing program

* First run the app.java in server folder
* Second input the port where you want to listen to the clients requests

* Here you should get prompted with this message

```
-- DIGITAL LIBRARY --
Server Side
Server running
Waiting for the client request
```

* Third run the app.java in the client folder
* Forth and last input both the port and IP address where you want the client to connect

* You should get prompted with this menu:

```
-- DIGITAL LIBRARY --
 0.- Show menu (again)
 1.- List all books
 2.- Add a book
 3.- Delete a book
 4.- Load data from file
 5.- Save data to file
 6.- Clear loaded data
 7.- Clear data file
 8.- Quit
Select an option or type 0 to show menu again.:
```

## Authors

Luis Fernández  
[@lufer](https://mastodon.social/@lufer)

## Version History

* 1.0
    * Final release
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.8
    * Added some few options
* 0.7
    * Now it works!
* 0.6 
    * Added this Readme.md file
* 0.5 
    * Configured both services. WIP
* 0.4
    * Deleted the Don Quixote book
* 0.3
    * Added .gitignore file
* 0.2
    * Created the basic system and Book/BookShelf objects
* 0.1
    * Initial commit
