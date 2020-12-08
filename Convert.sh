#!bash

cat data/train.csv | sed -E 's/""[^"]+""//g' > data/train2.csv