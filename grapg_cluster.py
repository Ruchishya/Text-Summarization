
import numpy as np
from sklearn import metrics
import pandas as pd
from pylab import *
from sklearn.cluster import DBSCAN
from sklearn.datasets.samples_generator import make_blobs
from sklearn.preprocessing import StandardScaler
global str
from collections import Counter
import json
make_blobs=np.loadtxt(fname="C:/Users/Jyotsna/Desktop/output8.txt")## to load the above two column
X = StandardScaler().fit_transform(make_blobs)
# Compute DBSCAN
db = DBSCAN(eps=0.5, min_samples=1).fit(X)
core_samples_mask = np.zeros_like(db.labels_, dtype=bool)
core_samples_mask[db.core_sample_indices_] = True
labels = db.labels_
n_clusters_ = len(set(labels)) - (1 if -1 in labels else 0)
print('Estimated number of clusters: %d' % n_clusters_)
for i in range(0,n_clusters_):
 index = [x[0] for x, value in np.ndenumerate(labels) if value==i]
 print(index,i)

