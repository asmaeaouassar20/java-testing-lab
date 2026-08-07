package org.algostyle;

public class PlayerScoreCalculator {
    private int resScore;

    public void calculateResScore(int score1, int score2){
        if(score1 < 0  || score2 < 0 ){
            resScore = -1;
        }else{
            resScore = score1 * score2;
        }
    }
    public int getResScore(){
        return this.resScore;
    }
}
