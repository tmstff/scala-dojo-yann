scala-workshop
==============

Commandline
-----------
1. start the sbt console with ./sbt

2. In the sbt console, generate the configuration for your IDE:
- for eclipse: 'eclipse with-source=true'
- for IDEA (Before version 14): 'gen-idea'
  In Intellij, if you have an error concerning a shared output path, check if there is no `project` folder in the `macros` project. If there is one, just remove it.  

3. wait to have downloaded the whole internet

4. open the project in your IDE

5. In the sbt console, compile the project with 'compile' 

6. In the sbt console, let the tests run with 'test'
No surprise, the tests are not successful.

with IntelliJIDEA >= 14
-----------------------
1. Start your IDE and make sure, that you have installed the 'Scala' plugin
   Go to 'Settings' -> 'Plugins' -> 'Install JetBrains Plugins' and search for 'scala'

2. Go to 'File' -> 'Open' and open the 'build.sbt' file of this project.

3. In the Import Windows mark 'Use auto-import' and 'Download sources and Docs'

4. Wait to have downloaded the whole internet
 
5. You should now see the project structure and the 'src/main/scala' and 'src/test/scala' directory.

6. Open the context menu of 'src/test/scala', click 'Run' -> 'ScalaTests in Scala'