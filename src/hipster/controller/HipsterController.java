package hipster.controller;

import javax.swing.JOptionPane;

import hipster.model.Hipster;
import hipster.view.HipsterFrame;


public class HipsterController
{	
	private HipsterFrame appFrame;
	private Hipster selfHipster;
	private Hipster[]  classHipsters;
	private int hipsterCount;

	public HipsterController()
	{
		selfHipster = new Hipster();
		classHipsters = new Hipster [50];
		hipsterCount = 0;
		
	}
	
	 public Hipster getSelfHipster()
	 {
		return selfHipster;
		 
	 }
	 public Hipster[] getClassHipsters()
	 {
		 return classHipsters;
	 }
	 
	 public void setSelfHipster(Hipster selfHipster)
	 {
		 
	 }
	 
	 public void start()
	 {
		 
	 }
	 
	 public Hipster getSpecifiedHipster(int position)
	 {
		 Hipster currentHipster = null;
		 
		 if(position < classHipsters.length && position >= 0)
		 {
			 currentHipster = classHipsters[position];
		 }
		 
		 return currentHipster;
	 }
		 
	 
	 public Hipster getRandomHipster()
	 {
		 Hipster currentHipster = null;
		 
		 int randomIndex = 0;
		 double random = Math.random();
		 randomIndex = (int) (random * classHipsters.length);
		 currentHipster = classHipsters[randomIndex];
		 
		 return currentHipster;
	 }
	 
	 public void addHipster(String [] books, String name, String type, String phrase)
	 {
		 if(hipsterCount < classHipsters.length)
		 {
			 Hipster tempHipster = new Hipster(name, type, phrase, books);
			 classHipsters[hipsterCount] = tempHipster;
			 hipsterCount++;
			 
		 }
		 else
		 {	
			 JOptionPane.showMessageDialog(appFrame, "The class is full you are too mainstream to be added");
		 }
			 
	 }
}
	 
		 	 
