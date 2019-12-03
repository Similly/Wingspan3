import json
import subprocess as sub

with open('test.json') as json_file:
    data = json.load(json_file)
    print("Wingspan classes are compiling:\n")
    for c in data["wingspanClasses"]:
        print(c["name"] + " is compiling..")
        sub.call('javac -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar; Test/' + c["name"] + '.java', shell=True)

    print("\nMonopoly classes are compiling:\n")
    for c in data["monopolyClasses"]:
        print(c["name"] + " is compiling..")
        sub.call('javac -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar; MonopolyTest/' + c["name"] + '.java', shell=True)

    print("\nWingspan tests are running:\n");
    for c in data["wingspanClasses"]:
        print("\n\n\n++++++++++++++++++++++++++++++++")
        print(c["name"] + " is running..")
        sub.call('java -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore Test.' + c["name"], shell=True)
        print("\n\n\n++++++++++++++++++++++++++++++++")

    print("\nMonopoly tests are running:\n");
    for c in data["monopolyClasses"]:
        print("\n\n\n++++++++++++++++++++++++++++++++")
        print(c["name"] + " is running..")
        sub.call('java -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore MonopolyTest.' + c["name"], shell=True)
        print("\n\n\n++++++++++++++++++++++++++++++++")
