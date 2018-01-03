import sys
import array
import re
import json
from textblob import TextBlob, Word, Blobber
from textblob.taggers import NLTKTagger
from nltk.corpus import webtext
import nltk.data
from nltk.corpus import stopwords
from nltk import word_tokenize
from nltk import sent_tokenize

'''print("hi")


lines=0
sentences=0
blanklines=0
words=1
Count=[0]*100
filename = 'C:/Users/Jyotsna/Desktop/First1.txt'
textf = open(filename, 'r')
for line in textf:
  lines += 1
  if line.startswith('\n'):
    blanklines += 1
  else:
      sentences +=line.count('.') + line.count('!') + line.count('?')
      tempwords = line.split(None)
      words += len(tempwords)

print ("Lines      : ", lines)
print ("Sentences  : ", sentences)
print("words    :",words)
word1=[ ]
words=[ ]
count=[ ]
with open("C:/Users/Jyotsna/Desktop/First1.txt") as fp:

 for line in fp:
  file = open("C:/Users/Jyotsna/Desktop/First.txt", "a")
  for i in range(0,sentences):
   stop_words = set(stopwords.words('english'))
   word_tokens = word_tokenize(line)
   filtered_sentence = []
   for w in word_tokens:
    if w not in stop_words:
        filtered_sentence.append(w)
  file.write(" ".join(map(str,filtered_sentence))+"\n")
 # print(word_tokens)
 # print(filtered_sentence)
file.close()
for i in range(0, sentences):

   word1=['']*sentences
   words=[''] * sentences
   count=[''] * sentences
   break
with open("C:/Users/Jyotsna/Desktop/First1.txt") as fp:
 for line in fp:
     #print(line)
     for i in range (0,sentences):
      for word in line.split("."):
        count[i]=len(re.findall(r'\w+', line))
        word1[i]=word
        #print(word1[i])
     #print(count[i])
     for i in range(0, sentences):
         for word in line.split(" "):
           words[i]=word
          # print(words[i])

list1 = []'''
global list2,list5
def sentiment(line):
        zen = TextBlob(line)
        #print(zen)
        list1 = []
        list1 = zen.words
        #print(list1)
        list1=list1.lower()
        word = []
        word = zen.pos_tags
        #print(word)
        list3 = []
        for i in range(0, len(list1)):
                if "JJ" in word[i-1]:
                    list3.append(list1[i])
                elif "JJR" in word[i-1]:
                    list3.append(list1[i])
        #print(list3[0:])
        list4 = []
        for k in range(0, len(list1)):
                if "NN" in word[k-1]:
                    list4.append(list1[k])
        #print(list4[0:])
        list2 = []
        for i in range(0, len(list1)):
                list2 = [0] *1000000
                break
        for i in range(0, len(list1)):
                list5 = [0] *1000000
                break
        #print(len(list1))
        with open('C:/Users/Jyotsna/Desktop/Plus Sentiment.txt', 'r') as f1:
            with open('C:/Users/Jyotsna/Desktop/Minus Sentiment.txt', 'r') as f:
                with open('C:/Users/Jyotsna/Desktop/Privaties.txt', 'r') as f3:
                    with open('C:/Users/Jyotsna/Desktop/Modifiers1.txt', 'r') as f4:
                        with open('C:/Users/Jyotsna/Desktop/Modifiers2.txt', 'r') as f5:
                            with open('C:/Users/Jyotsna/Desktop/Modifiers3.txt', 'r') as f6:
                                with open('C:/Users/Jyotsna/Desktop/Modifiers4.txt', 'r') as f7:
                                    with open('C:/Users/Jyotsna/Desktop/Modifiers5.txt', 'r') as f8:
                                        for i in range(0, len(list1)):
                                            for j in range(0, i + 1):
                                                for k in range(0, i + 1):
                                                    for z in range(k - 1, k + 1):

                                                        for line in f1:
                                                                if (list1[i] in line):
                                                                    list2[i] = 1
                                                                    list5[i] = list2[i]
                                                                else:
                                                                    for line in f:
                                                                        if (list1[i] in line):
                                                                            list2[i] = -1
                                                                            list5[i] = list2[i]
                                                                        else:
                                                                            break
                                                                    for line in f3:
                                                                        if (list1[j] in line):
                                                                            list2[i] *= -1
                                                                            list5[i] = list2[i]
                                                                if (list1[k] in list4[0:]):
                                                                 if (list1[z] in list3[0:]):
                                                                    for line in f4:
                                                                        if (list1[z] in line):
                                                                            list2[i] = list2[i] * 5
                                                                            list5[i] = list2[i]
                                                                            break
                                                                        else:
                                                                            for line in f5:
                                                                                if (list1[z] in line):
                                                                                    list2[i] = list2[i] * 4
                                                                                    list5[i] = list2[i]
                                                                                    break
                                                                                else:
                                                                                    for line in f6:
                                                                                        if (list1[z] in line):
                                                                                            list2[i] = list2[i] * 3
                                                                                            list5[i] = list2[i]
                                                                                            break
                                                                                        else:
                                                                                            for line in f7:
                                                                                                if (list1[z] in line):
                                                                                                    list2[i] = list2[
                                                                                                                   i] * 2
                                                                                                    list5[i] = list2[i]
                                                                                                    break
                                                                                                else:
                                                                                                    for line in f8:
                                                                                                        if (list1[z] in line):
                                                                                                            list2[i] = list2[i] * 1
                                                                                                            list5[i] = list2[i]
                                                                                                            break
                                                                                                break
                                                                                        break
                                                                                break
                                                                break
                                            #print(" %s = %d " % (list1[i], list5[i]))
                                            list5[i] += list5[i - 1]
                                        #print("value", list5[i])
                                        return list5[i]


