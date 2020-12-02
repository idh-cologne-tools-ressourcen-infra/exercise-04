# Exercise 4

This exercise is about CSV data. You will work with a CSV file and convert it with a tool/library of your choice.

## Step 1

Please clone this repository onto your local computer. On the command line, you would enter: `git clone https://github.com/idh-cologne-tools-ressourcen-infra/exercise-04`, and create a new branch using your UzK username as a name.

## Step 2
The file `data/train.csv` contains a data set in the CSV format. The dataset contains data about the passengers of the RMS Titanic, [which sank in 1912](https://en.wikipedia.org/wiki/Sinking_of_the_Titanic). For each passenger, the file stores: PassengerId, Survived, Pclass, Name, Sex, Age, SibSp, Parch, Ticket, Fare, Cabin, Embarked. The table below describes these properties.

| Feature | Description |
| --------- | --------------- |
| PassengerId | An increasing number used as a unique identifier |
| Survived | 0 = Died, 1 = Survived |
| Pclass | The passenger class |
| Name | The name of the passenger |
| Sex | The gender of the passenger |
| Age | The age of the passenger |
| SibSp | Number of siblings / spouses aboard | 
| Parch | Number of parents / children aboard | 
| Ticket | The ticket number |
| Fare | The ticket price | 
| Cabin | Cabin number | 
| Embarked | Port of boarding the ship. C = Cherbourg, Q = Queenstown, S = Southampton | 

### Step 2.1
For each column, identify the proper data type, and complete the table `data/types.csv`. The data types to use are: `numeric` (for all kinds of numeric features, i.e., we don't distinguish between integers and decimal numbers), `string` (for features that can take arbitrary strings as values) and `nominal` features, which take one of previously defined categories. For nominal features, add a third column that lists all possible categories.

### Step 2.2
You may have noticed that some of the names contain nick names as well, for instance passenger 23. They are encoded with double double quotes inside single double quotes:
```
23,1,3,"McGowan, Miss. Anna ""Annie""",female,15,0,0,330923,8.0292,,Q
```

Because this encoding cannot be imported by Weka, we need to change it. Using a CSV library and/or tool of your choice, remove the nicknames for all passengers.

There are various paths you can pursue:

- Write code to read in the file, manipulate the feature value for each entry, and write it out again. This can be done in Java or Python, and I recommend using a library.
- Manipulate the column on the command line, with the toolkit `csvkit`. 
- If you're familiar with regular expressions, a tool like `sed` on the Unix command line could also be used. Alternatively, some text editors make this fairly easy (e.g., [Notepad++ on Windows](https://notepad-plus-plus.org), [TextMate on Mac](https://macromates.com)). 


## Step 3

If you have written code, make sure to commit it to the repository. In any case, commit the modified CSV file to the repository and push it to GitHub.
