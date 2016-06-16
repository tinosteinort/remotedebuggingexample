Example to show remote Debugging of a Java Application
======================================================

1. To create a standalone JAR, run
```
mvn package
```
2. Execute the follwing Command. This starts the standalone JAR with Parameter for remote Debugging
```
java -Xdebug -Xrunjdwp:transport=dt_socket,address=8810,server=y -jar remotedebuggingexample-1.0-SNAPSHOT.jar
```
3. Configure RemoteDebugging Run Config
    * Create new Remote Debugging Run Config in your IDE
    * Select a Name for the Run Config
    * Update the Server / Port Attributes, matching the Parameters in the executed Command
4. Place a BreakPoint in the ```de.tse.remote.debug.Main.go``` Method and click "Go!" in the GUI.
5. Run the new Configured Run Config from the IDE.
6. The Application is started externally, but debuggable with your IDE.