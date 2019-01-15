# sense-hat.ixi
An Iota ICT IXI module to display TXs on Raspberry SensHat led pannel

#Hardware
You will need a Raspberry (3B / 3B+) and the SensHat connected on top of it..

# Build
This module is dependant on the cinci/rpi-sense-hat-java project and on Python library for Sense Hat on RPi.
First, follow instructions to build rpi-sense-hat-java project. Here : https://github.com/cinci/rpi-sense-hat-java

Then compile this module : gradle fatjar

# Execution
Copy the raspberry.ixi-version.jar in your ICT module directory, and restart the ICT service.

