#! /usr/bin/env python
import sys

def ack(m, n):
	if m == 0:
		return (n+1)
	elif n == 0:
		return ack(m-1, 1)
	else:
		return ack(m-1, ack(m, n-1))

if len(sys.argv) < 3:
  print("%s usage: [I] [J]" % sys.argv[0])
  exit()

print(ack(int(sys.argv[1]), int(sys.argv[2])))