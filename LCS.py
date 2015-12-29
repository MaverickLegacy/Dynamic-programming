#! /bin/env python


class LCS(object):

 def __init__(self,x,y):
	self.x=x	
	self.y=y	
	self.cost=[[-1 for i in range(0,len(self.y)+1)] for i in range(0,len(self.x)+1)]
 	self.base=[[0 for i in range(0,len(self.y)+1)] for i in range(0,len(self.x)+1)]
	for i in range(0,len(self.x)+1):
		self.cost[i][0]=0
	for j in range(0,len(self.y)+1):
		self.cost[0][j]=0
 	print self.cost
 def solve_memoized(self,i,j):
        if(self.cost[i][j] > -1):
		return self.cost[i][j]    	
	#try:        
	if( self.x[i-1]==self.y[j-1]):
		self.cost[i][j]= 1+ self.solve_memoized(i-1,j-1)
		self.base[i][j]=0	
	else: 
		self.cost[i][j]=max(self.solve_memoized(i-1,j),self.solve_memoized(i,j-1))
		if(self.cost[i][j]== self.cost[i-1][j]):
			self.base[i][j]=-1
		else:
	 		self.base[i][j]=1
	#except IndexError:
	#	print 'i,j: ',i,j
	return self.cost[i][j]
 def display_sequence(self,i,j):
	
	if(i==0 or j==0):
		return 
	if(self.base[i][j]==0):
		 self.display_sequence(i-1,j-1)
		 print self.x[i-1],
	elif(self.base[i][j]==-1):
		self.display_sequence(i-1,j)
	else:
		self.display_sequence(i,j-1)
 def max_length(self):
	return self.cost[len(self.x)][len(self.y)]				

	
if __name__=="__main__":
	x=raw_input("Enter String x:")
	y=raw_input("Enter String y:")
        sol=LCS(x,y)
	sol.solve_memoized(len(x),len(y))
	print "longest common subsequence:",sol.max_length()	
	sol.display_sequence(len(x),len(y))
	#print sol.cost
 
