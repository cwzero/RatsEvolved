Instructions:
In eclipse, click the open perspective button on the right side below the minimize/maximize/close buttons
Select the git perspective and open it

In the middle of the screen are the buttons for the git repositories pane, find the clone repository button and click it

Enter https://github.com/cwzero/RatsEvolved.git into the address and click next until the wizard finishes - on the third screen is the file location the project will be created in, copy this/keep track of it

Open a command prompt window and navigate using the cd <folder> command to where the project is located
Run "gradlew clean cleanEclipse eclipse" in the command prompt

Back in eclipse, switch to the git perspective, right click the rats evolved folder, and click import projects, follow the wizard to the end

Switch back to the java perspective and you're good to go