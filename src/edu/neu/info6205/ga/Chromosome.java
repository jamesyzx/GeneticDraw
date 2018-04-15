/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.info6205.ga;

import static edu.neu.info6205.ga.GeneticAlgorithm.height;
import static edu.neu.info6205.ga.GeneticAlgorithm.width;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author BumbleBee
 */
public class Chromosome implements Comparable<Chromosome> {

    private int num;
    protected Gene[] genes;
    protected double difference;
    private Random random;

    public Chromosome(int num, int pointNum) {
        this.num = num;
        genes = new Gene[num];
        for (int i = 0; i < num; i++) {
            genes[i] = new Gene(pointNum);
        }
        random = new Random(System.nanoTime());
    }

    public void exprssion(Graphics2D g) {
        g.clearRect(0, 0, width, height);
        for (Gene gene : genes) {
            g.setColor(gene.color);
            g.fillPolygon(gene.polygon);
        }
    }

    public Chromosome copy(int pointNum, double p) {
        Chromosome c = new Chromosome(this.num, pointNum);
        for (int i = 0; i < this.num; i++) {
            c.genes[i] = this.genes[i].copy(p);
        }
        Arrays.sort(c.genes);
        return c;
    }
    
    public Chromosome clone(int pointNum){
        Chromosome c = new Chromosome(this.num, pointNum);
        for (int i = 0; i < this.num; i++) {
            c.genes[i] = this.genes[i].clone();
        }
        c.difference = this.difference;
        return c;
    }

    @Override
    public int compareTo(Chromosome that) {
        return Double.compare(this.difference, that.difference);
    }
}
