package com.example.iproid_test.Quizzes_Levels;

public class Question {
    public static final String DIFFICULTY_EASY = "Easy";
    public static final String DIFFICULTY_MEDIUM = "Medium";
    public static final String DIFFICULTY_HARD = "Hard";

    public static final String CATEGORY_LESSON1 = "LESSON1";
    public static final String CATEGORY_LESSON2 = "LESSON2";
    public static final String CATEGORY_LESSON3 = "LESSON3";
    public static final String CATEGORY_LESSON4 = "LESSON4";
    public static final String CATEGORY_LESSON5 = "LESSON5";
    public static final String CATEGORY_LESSON6 = "LESSON6";

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String final_answer;
    private String category;
    private int levels;
    private String difficulty;

    public Question() {

    }

    public Question(String question, String option1, String option2, String option3, String option4,
                    String final_answer, String category, int levels) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.final_answer = final_answer;
        this.category = category;
        this.levels = levels;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getfinal_answer() {
        return final_answer;
    }

    public void setfinal_answer(String final_answer) {
        this.final_answer = final_answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }


//    public static String []getAllDifficultyLevels(){
//        return  new String[]{
//                DIFFICULTY_EASY,DIFFICULTY_MEDIUM,DIFFICULTY_HARD
//        };
//    }
}
