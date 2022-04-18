package baseball.model.tuple;

public class BettingResult {
    public int ball;
    public int strike;
    public int nothing;

    public BettingResult(int ball, int strike, int nothing){
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
    }
}
