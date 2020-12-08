import re

inputFile = "data/train.csv"
outputFile = "data/train2.csv"

inFile = open(inputFile, "r")
for line in inFile.readlines():
  line = re.sub(r'""[^"]+""', "", line)
  print(line,end='')