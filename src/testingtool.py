import json
import subprocess as sub

with open('test.json') as json_file:
    data = json.load(json_file)
    for c in data["classes"]:
        print(c["name"] + " is compiling..")
        sub.call('javac -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar; Test/' + c["name"] + '.java', shell=True)
    for c in data["classes"]:
        print("\n\n\n++++++++++++++++++++++++++++++++")
        print(c["name"] + " is running..")
        sub.call('java -cp junit-4.13-rc-1.jar;json-simple-1.1.1.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore Test.' + c["name"], shell=True)
        print("\n\n\n++++++++++++++++++++++++++++++++")
