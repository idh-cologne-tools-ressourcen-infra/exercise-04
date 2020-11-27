import csv
import re

#Semikolon in Komma umwandeln
train = csv.reader(open("train.csv", "rU"), delimiter=';')
trainKomma = csv.writer(open("trainKomma.csv", 'w'), delimiter=',')
trainKomma.writerows(train)
traintemp = csv.reader(open("trainKomma.csv", "rU"), delimiter=',')

re.sub(r'(?"".*"")?', '', traintemp)
#Test-Output
with open("trainKomma.csv", 'r') as file:
    reader = csv.reader(file)
    for row in reader:
        print(row)

