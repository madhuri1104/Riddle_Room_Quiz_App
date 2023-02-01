package com.example.riddleroom;

public class QueAnsAdapter {
    private int mQuestionID;
    private boolean mAnswer;

    public QueAnsAdapter(int questionResID,boolean tOrF)
    {
        mQuestionID=questionResID;
        mAnswer=tOrF;
    }

    public int getmQuestionID() {
        return mQuestionID;
    }

    public void setmQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
