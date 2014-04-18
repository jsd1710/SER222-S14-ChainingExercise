"""Generate test input for the Chaining.java program."""

#pylint: disable=I0011,C0103


import argparse
from random import randrange, sample, choice, shuffle

p = argparse.ArgumentParser()

p.add_argument("--numentries",
               default=None,
               type=int,
               help="The number of key value pairs to insert")
p.add_argument("--numqueries",
               default=None,
               type=int,
               help="The number of queries to make")
p.add_argument("--interleave",
               default=False,
               type=bool,
               help="Set this to mix inserteions with queries;"
               + "otherwise all queries will follow all "
               + "insertions")

args = p.parse_args()

numentries = args.numentries or randrange(1, 100)
numqueries = args.numqueries or randrange(1, 100)
interleave = args.interleave


characters = [chr(x) for x in range(ord('a'), ord('z') + 1)]
characters += [chr(x) for x in range(ord('A'), ord('Z') + 1)]
characters += [chr(x) for x in range(ord('0'), ord('9') + 1)]
characters += ['_', '-']

keys = []

lines = []

for i in range(numentries):
    key = ''.join(sample(characters, randrange(1, 32)))
    value = ''.join(sample(characters + [' '], randrange(1, 32)))
    keys.append(key)
    lines.append(key + ' ' * randrange(0, 4) + '=' + value)

for i in range(numqueries):
    lines.append(choice(keys))

if interleave:
    shuffle(lines)

for line in lines:
    print line
