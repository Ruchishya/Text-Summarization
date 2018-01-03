import numpy as np
import sys
import Package.Manuplation as manip
import Package.Sentiment as senti
from nltk.corpus import stopwords
from nltk import word_tokenize
from nltk import sent_tokenize
from collections import Counter

num_lines = sum(1 for line in open("C:/Users/Jyotsna/Desktop/newcluster.txt", "r", encoding="utf8"))
print(num_lines)
#Cluster=np.chararray((num_lines,num_lines))
Cluster = []
for i in range(num_lines):
    Cluster.append([])
i=0
j=0
with open("C:/Users/Jyotsna/Desktop/newcluster.txt", "r",encoding="utf8")as f:
    for line in f:
        if(line.startswith('-')):
            i=i+1
        else:
            Cluster[i].append(line)
            j=j+1
#print(len(Cluster),Cluster[0][1],",i")
k=0
h=0
lent = [' ']*len(Cluster)
arraylist = [' ']*len(Cluster)
newlist = [' ']*len(Cluster)
names = [' ']*len(Cluster)
arraynames = [' ']*len(Cluster)
arraynumbers = ['']*len(Cluster)
for i in range(0,912):
    for j in range(0,len(Cluster[i])):
        print(Cluster[i][j],"i",i,"j",j)
        tweets_text = manip.removeURL(Cluster[i][j])
        tweets_text = manip.removeUserMentions(tweets_text)
        tweets_text = manip.removeRT(tweets_text)
        tweets_text = manip.convertMultipleWhiteSpacesToSingleWhiteSpace(tweets_text)
        word = tweets_text.split("-")
        arraylist[k] = word[0]
        arraynames[k] = word[1]
        lent[k]=len(Cluster[i])
        print(lent[j],",",j)
        k = k + 1
for i in range(0,k):
   #print(arraylist[i],i)
    o=i
sentences=[' ']*k
vv=[0]*k
s=[0]*k
sent=[0]*k
value=[0]*k
Negative=[0]*k
Positive=[0]*k
length=k
print(length)
a = dict(Counter(arraylist))
print(a,"a")
print(len(a))
k=list(a.keys())
v=list(a.values())
file1= open("C:/Users/Jyotsna/Desktop/medium15.txt","w")
for i in range(0,912):
 for j in range(0,len(Cluster[i])):
    if(arraylist[j] in k):
         value[j]=a[arraylist[j]]/len(Cluster[i])
    vv[i]+=value[j]
    s[j]=senti.sentiment(arraylist[j])
    sent[i]+=s[j]
    if (s[j] > 0):
        Positive[i] += 1
    elif (s[j] < 0):
        Negative[i] += 1
    print(vv[i], "Response", sent[i],
          "Sentiment", Positive[i],"positive",Negative[i],"negative",i,"j,j",j)
 file1.write("%d" %len(Cluster[i]))
 file1.write(" ")
 file1.write("%0.2f" % vv[i])
 file1.write(" ")
 file1.write("%d\n" %sent[i])
file1.close()