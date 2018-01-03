from mcl_clustering import *
import numpy as np
import pandas as pd
from numpy import *

def remove_duplicates(values):
    output = []
    output1 = []
    seen = set()
    for value in values:
        if value not in output:
            output.append(value)
    return output
PATH="C:/Users/Jyotsna/Desktop/output5.txt"
filename =pd.read_csv(PATH,sep=" ",error_bad_lines=False)
A =np.array(filename)
print(A)
where_are_NaNs = isnan(A)
A[where_are_NaNs] = 0
print(A)
M, clusters = mcl(A)
n=len(clusters)
values=list(clusters.values())
clusters1=remove_duplicates(values)
no_clusters=len(clusters1)
print("No of Clusters",no_clusters)
print("clusters:")
print(clusters1)
with open("C:/Users/Jyotsna/Desktop/clusteroutput.txt","w")as filename:
    for item in clusters1:
     filename.write(str(item) +"\n")
