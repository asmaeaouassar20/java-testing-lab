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

    public Float getSpecificScore(Integer score){
        if(score==null){
            return 0F;
        }
        score = verifyScoreArgument(score);
        return score*0.69F;
    }
    private Integer verifyScoreArgument(int score){
        if(score>10 || score<0 || score==(int)Double.NaN){
            throw new IllegalArgumentException("Calculator cannot accept score value : " + score);
        }
        return  score;
    }
}
