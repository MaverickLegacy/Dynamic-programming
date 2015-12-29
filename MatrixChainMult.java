package Algorithms;

import java.io.*;

class MatrixChainMult 
{
      int[][] mat;
      int[][] sol; 
      	      


      public MatrixChainMult(int num)
      {
	//mat=new int[num][num];	
	//sol=new int[num][num];	
	mat=raggedArray(num,mat);
	sol=raggedArray(num,sol);
      }

      private int[][] raggedArray(int num,int[][] a)
      {
	a=new int[num][];	
	int len=1;	
	for(int i=0; i<num; i++)
	 	a[i]=new int[len++];
	return a;
      }		     	 
      public int MatrixChainMultiplication(int[] p)
      {   
	int j=0, q=0,n=p.length-1,arlen=0,ival=0;
		
	for(int i=1; i<=n;i++)
	  mat[i][i]=0;	
	
  	 for(int l=2;l<=n;l++)
		for(int i=1; i<=n-l+1;i++)
		{
			j=i+l-1;
			arlen=mat[i].length;			
			ival=j;			
			mat[j][i]=99999999;			
			for(int k=i; k<j; k++)
			{	q=mat[k][i]+mat[j][k+1]+p[i-1]*p[k]*p[j];
				if(q<mat[j][i])
				{
				 mat[j][i]=q;
				 sol[j][i]=k;
				}
			} 
		}
	}
	
	return mat[n][1];
      
       }
       
       public static String getInput() throws IOException
       {
	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	String inp=br.readLine();
	return inp;

       }
       public static void main(String[] args) throws IOException
       {
	System.out.println(" Enter the dimensions of the Matrices: ");
	String input=MatrixChainMult.getInput(); 
	String dims[] = input.split("\\s+");
	int[] p=new int[dims.length];
	for(int i=0;i< p.length; i++)
	   p[i]=Integer.parseInt(dims[i]);
				
	MatrixChainMult m= new MatrixChainMult(p.length);
	System.out.println("Minimum multiplications required: "+m.MatrixChainMultiplication(p));
       }
}
