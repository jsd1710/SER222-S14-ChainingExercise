"""Reference for the *correct* output of Chaining.java."""

#pylint: disable=I0011,C0103
import sys

table = {}

for line in sys.stdin:
    line = line.rstrip('\n')

    if '=' in line:
        key, value = line.split('=')[:2]
        key = key.strip()
        if key in table:
            last = table[key]
        else:
            last = None
        table[key] = value

        print "inserted", key + ":" + value,
        if last:
            print "returned previous value of", last
        else:
            print
    else:
        key = line.strip()
        print "Looking up", key, "found", table.get(key, "null")
