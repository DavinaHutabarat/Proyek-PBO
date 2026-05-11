move:
cd src

compile:
javac -cp "../lib/*" db/*.java model/*.java mapper/*.java Main.java

test_01:
java -cp "../lib/*;." Main