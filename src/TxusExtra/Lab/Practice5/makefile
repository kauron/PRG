
#
# This file is not part of the lab practise and you can ignore it in the case of using BlueJ.
#
# This file is for showing you the commands you can use and their syntax for compiling and for executing the program.
#
# As complementary information you can see the file treeOfDirectoriesAndFiles.txt which contains the tree structure of
# directories and subdirectories in my file system for the complete code of this lab practise.
#
#

all:
	mkdir -p classes
	javac -cp classes -d classes src/libPRG/linear/*.java
	javac -cp classes -d classes src/pract5/*.java

clean: 
	rm -rf classes

run:
	java -cp classes pract5.concor -o testForPractice5.txt
