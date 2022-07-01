/*

Given a 2D screen arr[][] where each arr[i][j] is an integer representing the color of that pixel, 
also given the location of a pixel (X, Y) and a color C, 
the task is to replace the color of the given pixel and all the adjacent same-colored pixels with the given color.

Example: 
 
Input: arr[][] = { 
{1, 1, 1, 1, 1, 1, 1, 1}, 
{1, 1, 1, 1, 1, 1, 0, 0}, 
{1, 0, 0, 1, 1, 0, 1, 1}, 
{1, 2, 2, 2, 2, 0, 1, 0}, 
{1, 1, 1, 2, 2, 0, 1, 0}, 
{1, 1, 1, 2, 2, 2, 2, 0}, 
{1, 1, 1, 1, 1, 2, 1, 1}, 
{1, 1, 1, 1, 1, 2, 2, 1}} 
Given: X = 4, Y = 4, C = 3 



queue (4,3), (4,5), (5,4)


Output: 
1 1 1 1 1 1 1 1 
1 1 1 1 1 1 0 0 
1 0 0 1 1 0 1 1 
1 3 3 3 3 0 1 0 
1 1 1 3 3 0 1 0 
1 1 1 3 3 3 3 0 
1 1 1 1 1 3 1 1 
1 1 1 1 1 3 3 1 

Given: X = 3 Y = 1, C = 5 

5 5 5 5 5 5 5 5
5 5 5 5 5 5 0 0 
5 0 0 5 5 0 1 1 
5 2 2 2 2 0 1 0 
5 5 5 2 2 0 1 0 
5 5 5 2 2 2 2 0 
5 5 5 5 5 2 1 1 
5 5 5 5 5 2 2 1


*/

package com.test;
import java.util.LinkedList;
import java.util.Queue;

public class ReplaceAdjacentElements {

	public static void main(String[] args) {
		
		int[][] a =  { 
				{1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 0, 0}, 
				{1, 0, 0, 1, 1, 0, 1, 1}, 
				{2, 2, 2, 2, 2, 0, 1, 0}, 
				{1, 1, 1, 2, 2, 0, 1, 0}, 
				{1, 1, 1, 2, 2, 2, 2, 0}, 
				{1, 1, 1, 1, 1, 2, 1, 1}, 
				{1, 1, 1, 1, 1, 2, 2, 1}} ;
		
		int x=3, y=3, c=3;
		
		int input = a[x][y];
		
		int iMaxLength = a.length, jMaxLength = a[0].length;
		
		Queue<Coords> queue = new LinkedList<>();
		queue.add(new Coords(x, y));
		while(!queue.isEmpty()) {
			Coords coords = queue.remove();
			System.out.println("from queue:"+ coords + " queue size:"+ queue.size());
			int i=coords.getX(), j=coords.getY();
			
			a[i][j]=c; //replace
			
			if(i>0) { // top
				if(a[i-1][j] == input) {
					Coords co = new Coords(i-1, j);
					queue.add(co);
					System.out.println("added top"+ co);
				}
			}
			if(i+1<iMaxLength) { // bottom
				if(a[i+1][j] == input) {
					queue.add(new Coords(i+1, j));
					System.out.println("added bottom"+ queue.peek());
				}
			}
			if(j>0) { // left
				if(a[i][j-1] == input) {
					Coords co = new Coords(i, j-1);
					queue.add(co);
					queue.add(new Coords(i, j-1));
					System.out.println("added left"+ co);
				}
			}
			if(j+1<jMaxLength) { // right
				if(a[i][j+1] == input) {
					Coords co = new Coords(i, j+1);
					queue.add(co);
					System.out.println("added rigth"+ co);
				}
				
			}
		}
		
		for(int i=0; i< a.length; i++) {
			System.out.print("\n");
			for( int j=0;j<a[i].length ; j++) {
				System.out.print(" "+ a[i][j]);
			}
		}
		
	}
	
	static class Coords{
		private int x;
		private int y;
		
		
		public Coords(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "Coords [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
}

