import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Model {

	private MControl firstMatrix, secondMatrix, resultMatrix;
	private boolean op1, op2 , op3;
	private double[][] firstMatrixArray, secondMatrixArray , resultMatrixArray;
	Model(){	
	}
	
	void showInputMatrix(int a,int b,int c,int d){
		if (op1 == true)
		firstMatrix.dispose();
		
		if (op2 == true)
			secondMatrix.dispose();
		if (op3 == true)
			resultMatrix.dispose();
		
		firstMatrix = new MControl(a,b,1,this);
		secondMatrix = new MControl(c,d,2,this);	
		op1=true;
		op2=true;
	}
	void showMatrixFromMemory(double[][] mem, MControl wm) {
		if(wm == firstMatrix) {
			if (op1 == true) {
				firstMatrix.dispose();
				}
				firstMatrix = new MControl(mem,1,this);
				op1 =true;
		}
		if(wm == secondMatrix) {
			if (op2 == true) {
				secondMatrix.dispose();
				}
				secondMatrix = new MControl(mem,2,this);
				op2 =true;
		}
		if(wm == resultMatrix)	{
			if (op3 == true) {
			resultMatrix.dispose();
			}
			resultMatrix = new MControl(mem,3,this);
			op3 =true;
		}
		
	}

	void showResultMatrix() {
		if (op3 == true) {
			resultMatrix.dispose();
		}
		System.out.println(resultMatrixArray[0][0]);
		resultMatrix = new MControl(resultMatrixArray,3,this);
		op3 = true;
	}
		
	boolean sumMatrix(){
		if (sumable()) {
			resultMatrixArray= new double[firstMatrixArray.length][firstMatrixArray[0].length];
			for(int i =0; i <firstMatrixArray.length; i++)
				for(int j=0; j< firstMatrixArray[0].length; j++)
					resultMatrixArray[i][j]= firstMatrixArray[i][j]+secondMatrixArray[i][j];
			showResultMatrix();	
			return true;
		}
		else
			return false;
	}
	
	boolean subtractMatrix(){
		if (sumable()) {
			resultMatrixArray= new double[firstMatrixArray.length][firstMatrixArray[0].length];
			for(int i =0; i <firstMatrixArray.length; i++)
				for(int j=0; j< firstMatrixArray[0].length; j++)
					resultMatrixArray[i][j]= firstMatrixArray[i][j]-secondMatrixArray[i][j];
			showResultMatrix();	
			return true;
		}
		else
			return false;
	}
	
	void transposeMatrix(){
		matrixArrayUpdate();
		resultMatrixArray= new double[firstMatrixArray[0].length][firstMatrixArray.length];
		for(int i =0; i <firstMatrixArray.length; i++)
			for(int j=0; j< firstMatrixArray[0].length; j++)
				resultMatrixArray[j][i]= firstMatrixArray[i][j];
		
		showResultMatrix();	
	}
	
	
	boolean dotmultiplyMatrix(){
		if (sumable()||dotmultipliable()) {
			if (firstMatrixArray.length<=secondMatrixArray.length)
				resultMatrixArray= new double[firstMatrixArray.length][secondMatrixArray[0].length];
			else
				resultMatrixArray= new double[secondMatrixArray.length][firstMatrixArray[0].length];
			for(int i =0; (i <firstMatrixArray.length)&&(i <secondMatrixArray.length); i++)
				for(int j=0; (j <firstMatrixArray[0].length)&&(j <secondMatrixArray[0].length); j++)
					if (firstMatrixArray.length<=secondMatrixArray.length) {
						for(int k=0;k<secondMatrixArray.length;k++ )
							resultMatrixArray[i][j] += firstMatrixArray[i][k]*secondMatrixArray[k][j];
					}
					else {
						for(int k=0;k<firstMatrixArray.length;k++ )
							resultMatrixArray[i][j] += firstMatrixArray[k][j]*secondMatrixArray[i][k];
					}
			
			showResultMatrix();	
			return true;
		}
		else
			return false;
	}
	boolean multiplyMatrix(){
		if (multipliable()) {
			resultMatrixArray= new double[firstMatrixArray.length][secondMatrixArray[0].length];
			for(int i =0; (i <firstMatrixArray.length); i++)
				for(int j=0; (j <secondMatrixArray[0].length); j++)
						for(int k=0;k<secondMatrixArray.length;k++ )
							resultMatrixArray[i][j] += firstMatrixArray[i][k]*secondMatrixArray[k][j];			
			showResultMatrix();	
			return true;
		}
		else
			return false;
	}
	boolean sumable() {
		matrixArrayUpdate();
		if(firstMatrixArray.length == secondMatrixArray.length && firstMatrixArray[0].length == secondMatrixArray[0].length)
			return true;
		else
			return false;
	}
	
	boolean dotmultipliable() {
		matrixArrayUpdate();
		if(firstMatrixArray[0].length == secondMatrixArray.length && firstMatrixArray.length == secondMatrixArray[0].length)
			return true;
		else
			return false;
	}
	boolean multipliable() {
		matrixArrayUpdate();
		if(firstMatrixArray[0].length == secondMatrixArray.length )
			return true;
		else
			return false;
	}
	
	void matrixArrayUpdate() {
		firstMatrixArray = firstMatrix.getArray();
	//	System.out.println(firstMatrixArray[0][0]);
		secondMatrixArray = secondMatrix.getArray();
	}
	
	
}
