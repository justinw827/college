#! /usr/bin/env python
import sys

def gcdI(i, j):
  while i != j:
  	if (i > j):
  		i = i - j
  	else:
  		j = j - i
  return i

def gcdF(i, j):
	if (j == 0):
		return i
	else:
		return gcdF(j, i % j)

if len(sys.argv) < 3:
  print("%s usage: [I] [J]" % sys.argv[0])
  exit()

print(gcdI(int(sys.argv[1]), int(sys.argv[2])))
print(gcdF(int(sys.argv[1]), int(sys.argv[2])))