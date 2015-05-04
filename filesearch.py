import os

def lineNum(link, name):
	os.chdir(link)
	
	sum = 0
	file = open(name, "r")
	for l in file:
		sum += 1
	return sum
	
def isCode(f):
	list = [".java", ".py", ".c", ".cpp", ".html", ".css", ".m"]
	c = False
	
	for l in list:
		if f[-len(l):] in list:
			c = True
			break
	return c

list = []
path = os.path.abspath("")
for x, y, files in os.walk(path):
	for f in files:
		if isCode(f) and f != "filesearch.py":
			list.append((x, f))

for x, y in list:
	print x + "/" + y
print "\n"

sum = 0

for x, y in list:
	os.chdir(path)
	num = lineNum(x, y)
	sum += num
	
	z = y
	print z + "-" * (30 - len(z)) + str(num)

print "\n%s files, %s lines of code" % (len(list), sum)