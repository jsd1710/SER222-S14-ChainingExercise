"""Compare the output of the students program to a reference prog."""

#pylint: disable=I0011, C0103

import argparse
import subprocess
import os

parser = argparse.ArgumentParser()

parser.add_argument('testcase', help="The test case to check")


args = parser.parse_args()

if not os.path.exists(args.testcase + '.in'):
    print
    print "No testcase name '{}.in'".format(args.testcase)
    print "Save the users input to a file with that name"
    print "Or, run the gentest script:"
    print
    print "  python gentest.py > {}.in".format(args.testcase)
    print
    exit(-1)


testinput = open(args.testcase + '.in', 'r')
testoutput = open(args.testcase + '.out', 'w')
subprocess.call(['java', 'Chaining'],  stdin=testinput, stdout=testoutput)

testoutput.close()
testinput.close()

testinput = open(args.testcase + '.in', 'r')
expectedoutput = open(args.testcase + '.expected', 'w')
subprocess.call(['python', 'referenceimp.py'],
                stdin=testinput,
                stdout=expectedoutput)
testinput.close()
expectedoutput.close()


with open(args.testcase + '.expected') as expectedoutput:
    expectedlines = expectedoutput.readlines()
with open(args.testcase + '.out') as testoutput:
    lines = testoutput.readlines()

lines = [line for line in lines if 'insert' in line or 'Looking' in line]

passed = True
for i in range(max(len(lines), len(expectedlines))):
    if lines[i] != expectedlines[i]:
        print "EXPECTED:", expectedlines[i].rstrip('\n')
        print "   FOUND:", lines[i].rstrip('\n')
        print
        passed = False

print "*" * 79
print "Passed" if passed else "Failed"
