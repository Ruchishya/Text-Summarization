import sys
import pylab as plt
import numpy as np
from kmeans import kMeans
plt.ion()

def show(X, C, centroids, keep = False):
    import time
    time.sleep(0.5)
    plt.cla()
    plt.plot(X[C == 0, 0], X[C == 0, 1], '*b',
         X[C == 1, 0], X[C == 1, 1], '*r',
         X[C == 2, 0], X[C == 2, 1], '*g')
    plt.plot(centroids[:,0],centroids[:,1],'*m',markersize=20)
    plt.draw()
    if keep :
        plt.ioff()
        plt.show()

# generate 3 cluster data
filename="C:/Users/Jyotsna/Desktop/medium12.txt"
data = np.genfromtxt(filename)
'''m1, cov1 = [[80],[15.26],[-0.25],[40],[40]]
m2, cov2 = [5, 13], [[2.5, -1.5], [-1.5, 1.5]]
m3, cov3 = [3, 7], [[0.25, 0.5], [-0.1, 0.5]]
data1 = np.random.multivariate_normal(m1, cov1, 250)
data2 = np.random.multivariate_normal(m2, cov2, 180)
data3 = np.random.multivariate_normal(m3, cov3, 100)'''
X = np.vstack((data))
np.random.shuffle(X)
centroids, C = kMeans(X, K = 10)
print(C)
count=0
number=1
elsenumber=0
#show(X, C, centroids, True)
file=open("C:/Users/Jyotsna/Desktop/Kmeansout1.txt","w")
file.flush()
#index = [X[0] for X, value in np.ndenumerate(centroids) if value==]
ind = np.argsort(C)[::-1][:298]
print(ind)
for i in range(0,912):
      if i in ind:
        file.write("1\n")
      else:
        file.write("0\n")
file.close()