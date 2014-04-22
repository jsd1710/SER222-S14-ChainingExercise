"""Generate test input for the Chaining.java program."""

#pylint: disable=I0011,C0103


import argparse
import os
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
p.add_argument("--words",
               default= None,
               help="Use a file with a list of words to generate "
               + "keys / values. If this is not supplied then we "
               + "generate random strings")

args = p.parse_args()

numentries = args.numentries or randrange(1, 100)
numqueries = args.numqueries or randrange(1, 100)
interleave = args.interleave

def generate_random_string():
   return ''.join(sample(characters, randrange(1, 32)))

def generate_random_word():
    return choice(words);



if args.words and os.path.isfile(args.words):
    with open(args.words) as f:
        words = [w.rstrip('\n') for w in f.readlines()]

    generate = generate_random_word
else:
    characters = [chr(x) for x in range(ord('a'), ord('z') + 1)]
    characters += [chr(x) for x in range(ord('A'), ord('Z') + 1)]
    characters += [chr(x) for x in range(ord('0'), ord('9') + 1)]
    characters += ['_', '-']
    generate = generate_random_string




keys = []

lines = []

for i in range(numentries):
    key = generate()
    value = generate()
    keys.append(key)
    lines.append(key + ' ' * randrange(0, 4) + '=' + value)

for i in range(numqueries):
    lines.append(choice(keys))

if interleave:
    shuffle(lines)

for line in lines:
    print line
