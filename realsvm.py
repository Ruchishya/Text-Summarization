import pandas as pd
import numpy as np
from Package.svm_demo import *
import Package.Manuplation as manip
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from nltk.corpus import stopwords
from nltk import word_tokenize
from nltk import sent_tokenize
from collections import Counter
def svm():
    PATH="C:/Users/Jyotsna/Desktop/medium15.txt"
    df=pd.read_csv(PATH,sep=" ",error_bad_lines=False)
    PATH="C:/Users/Jyotsna/Desktop/Kmeansout1.txt"
    df1=pd.read_csv(PATH,sep=" ",error_bad_lines=False)
    x=df.iloc[:,0:3]
    y=df1.iloc[:,-1]
    x=np.asarray(x)
    y=np.asarray(y)
    ind=[0]*912
    intrain=[0]*912
    x=x.tolist()
    y=y.tolist()
    print(x)
    print(y)
    from sklearn.cross_validation import train_test_split
    indices =(np.arange(911))
    x_train,x_test,y_train,y_test,indices_train,indices_test=train_test_split(x,y,indices,test_size=0.20,random_state=43)
    print(indices_test,"indices_test",len(indices_test))
    print(indices_train,"indices_train",len(indices_train))
    param=svm_parameter("-q")
    problem=svm_problem(y_train,x_train)
    count=0
    results=[]
    param.C,param.gamma,param.kernel_type=2**1,2**1,2
    m=svm_train(problem,param)
    p_lbl,p_acc,p_val=svm_predict(y_test,x_test,m)
    results.append([param.C,param.gamma,param.kernel_type,p_acc[0]])
    bestIdx=np.argmax(np.array(results)[:,3])
    print('best paramter',results[bestIdx])
    pred_lbl,pred_acc,pred_val=svm_predict(y_test,x_test,m)
    resultnp=np.array(results)
    param.C=resultnp[bestIdx,0]
    param.gamma=resultnp[bestIdx,1]
    ker=resultnp[bestIdx,2]
    param.kernel_type=int(ker)
    m=svm_train(problem,param)
    pred_lbl,pred_acc,pred_val=svm_predict(y_test,x_test,m)
    for i in range(0,len(pred_lbl)):
      if 1 == pred_lbl[i]:
        count=count+1
        ind[i]=indices_test[i]
    print(count)
    for i in range(0,len(indices_train)):
     if 1 == y_train[i]:
        intrain[i]=indices_train[i]
        count=count+1
    print(count,"count")
    num_lines = sum(1 for line in open("C:/Users/Jyotsna/Desktop/newcluster.txt", "r", encoding="utf8"))
    print(num_lines)
    #Cluster=np.chararray((num_lines,num_lines))
    Cluster = []

    lineslist = []
    for i in range(num_lines):
        Cluster.append([])
        lineslist.append([])
    i=0
    j=0
    k=0

    with open("C:/Users/Jyotsna/Desktop/newcluster.txt", "r",encoding="utf8")as f:
        for line in f:
            if(line.startswith('-')):
                i=i+1
            else:
                Cluster[i].append(line)
                j=j+1
    named = [0]*(count+1)
    for i in range(0,912):
          if (i in ind):
              named[k]=i
              k=k+1
          elif (i in intrain):
              named[k]=i
              k=k+1
    print(named)
    for i in range(0,912):
        for j in range(0,len(Cluster[i])):
          if (i in named):
            #print(Cluster[i][j],"i",i,"j",j)
            tweets_text = manip.removeURL(Cluster[i][j])
            tweets_text = manip.removeUserMentions(tweets_text)
            tweets_text = manip.removeRT(tweets_text)
            tweets_text = manip.convertMultipleWhiteSpacesToSingleWhiteSpace(tweets_text)
            word = tweets_text.split("-")
            #print(word[0])
            stop_words = set(stopwords.words('english'))
            word_tokens = word_tokenize(word[0])
            filtered_sentence = []
            for w in word_tokens:
              if w not in stop_words:
                  filtered_sentence.append(w)
                  lineslist[i].append(w)
        #print(i," ",len(Cluster[i]),lineslist[i],k)
    k=k+1

    for i in range(0,912):
      if i in named:
        counts = Counter(lineslist[i])
        print(counts)




