package com.example.iproid_test.Quizzes_Levels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.iproid_test.Quizzes_Levels.QuizContract.*;

import java.util.ArrayList;

public class QuizHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "QuizDB";
    private static final int DATABASE_VERSION = 19;

    private SQLiteDatabase db;

    QuizHelper(Context context){
        super (context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_FINAL_ANSWER + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question L1q1L1 = new Question("It is a reserved memory location to store values.?",
                "Identifiers",
                "Variables",
                "Integers",
                "Data Type","Identifiers",
                Question.CATEGORY_LESSON1,1);
        addQuestions(L1q1L1);

        Question L1q2L1 = new Question("Variable names are not case sensitive?",
                "True, Because you can create variable name in any form of character",
                "True, Because variable can create even the first letter of variable are numbers",
                "False, Because variables has a rule that need to consider",
                "False, Because variables can only start with a Letter ",
                "False, Because variables has a rule that need to consider",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q2L1);

        Question L1q3L1 = new Question("What do you need to assign Variable? ",
                "Value",
                "Name",
                "Operations",
                "Output",
                "Value",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q3L1);

        Question L1q4L1 = new Question("It is used to perform mathematical operations like addition subtraction, multiplication and division.",
                "Algebra Expression",
                "Arithmetic Operator",
                "Mathematics",
                "Integers",
                "Arithmetic Operator",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q4L1);

        Question L1q5L1 = new Question("It is an Arithmetic operator that being use to add 2 values.",
                "Addition Operator",
                "Modulus Symbol (%)",
                "Expression",
                "String",
                "Addition Operator",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q5L1);

        Question L1q6L1 = new Question("What sign that we need to use when we want to get the remainder of the two operands?",
                "Addition Operator (+)",
                "Modulus (%)",
                "Subtraction Operator(-)",
                "Division Operator(/)",
                "Modulus (%)",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q6L1);

        Question L1q7L1 = new Question("It is an instruction that the Python interpreter can execute.",
                "Statement",
                "Compiler",
                "Expression",
                "String",
                "Statement",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q7L1);

        Question L1q8L1 = new Question("What are the two kinds of statements? ",
                "print and assignment",
                "print and operator",
                "assignment and operator",
                "operator and expression",
                "print and assignment",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q8L1);

        Question L1q9L1 = new Question("It is a combination of values, variables, and operators. ",
                "Expression",
                "declaration",
                "statement",
                "identifiers",
                "Expression",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q9L1);

        Question L1q10L1 = new Question("Is it true that 5 >= 4 ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON1,
                1);
        addQuestions(L1q10L1);
//LESSON 1 LEVEL 2
        Question L1q1L2 = new Question("It is a reserved memory location to store values.?",
                "Identifiers",
                "Variables",
                "Integers",
                "Data Type","Identifiers",
                Question.CATEGORY_LESSON1,2);
        addQuestions(L1q1L2);

        Question L1q2L2 = new Question("Variable names are not case sensitive?",
                "True, Because you can create variable name in any form of character",
                "True, Because variable can create even the first letter of variable are numbers",
                "False, Because variables has a rule that need to consider",
                "False, Because variables can only start with a Letter ",
                "False, Because variables has a rule that need to consider",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q2L2);

        Question L1q3L2 = new Question("What do you need to assign Variable? ",
                "Value",
                "Name",
                "Operations",
                "Output",
                "Value",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q3L2);

        Question L1q4L2 = new Question("It is used to perform mathematical operations like addition subtraction, multiplication and division.",
                "Algebra Expression",
                "Arithmetic Operator",
                "Mathematics",
                "Integers",
                "Arithmetic Operator",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q4L2);

        Question L1q5L2 = new Question("It is an Arithmetic operator that being use to add 2 values.",
                "Addition Operator",
                "Modulus Symbol (%)",
                "Expression",
                "String",
                "Addition Operator",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q5L2);

        Question L1q6L2 = new Question("What sign that we need to use when we want to get the remainder of the two operands?",
                "Addition Operator (+)",
                "Modulus (%)",
                "Subtraction Operator(-)",
                "Division Operator(/)",
                "Modulus (%)",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q6L2);

        Question L1q7L2 = new Question("It is an instruction that the Python interpreter can execute.",
                "Statement",
                "Compiler",
                "Expression",
                "String",
                "Statement",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q7L2);

        Question L1q8L2 = new Question("What are the two kinds of statements? ",
                "print and assignment",
                "print and operator",
                "assignment and operator",
                "operator and expression",
                "print and assignment",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q8L2);

        Question L1q9L2 = new Question("It is a combination of values, variables, and operators. ",
                "Expression",
                "declaration",
                "statement",
                "identifiers",
                "Expression",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q9L2);

        Question L1q10L2 = new Question("Is it true that 5 >= 4 ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q10L2);
        //LESSON 1 LEVEL 3
        Question L1q1L3 = new Question("It is a reserved memory location to store values.?",
                "Identifiers",
                "Variables",
                "Integers",
                "Data Type","Identifiers",
                Question.CATEGORY_LESSON1,3);
        addQuestions(L1q1L3);

        Question L1q2L3 = new Question("Variable names are not case sensitive?",
                "True, Because you can create variable name in any form of character",
                "True, Because variable can create even the first letter of variable are numbers",
                "False, Because variables has a rule that need to consider",
                "False, Because variables can only start with a Letter ",
                "False, Because variables has a rule that need to consider",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q2L3);

        Question L1q3L3 = new Question("What do you need to assign Variable? ",
                "Value",
                "Name",
                "Operations",
                "Output",
                "Value",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q3L2);

        Question L1q4L3 = new Question("It is used to perform mathematical operations like addition subtraction, multiplication and division.",
                "Algebra Expression",
                "Arithmetic Operator",
                "Mathematics",
                "Integers",
                "Arithmetic Operator",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q4L3);

        Question L1q5L3 = new Question("It is an Arithmetic operator that being use to add 2 values.",
                "Addition Operator",
                "Modulus Symbol (%)",
                "Expression",
                "String",
                "Addition Operator",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q5L3);

        Question L1q6L3 = new Question("What sign that we need to use when we want to get the remainder of the two operands?",
                "Addition Operator (+)",
                "Modulus (%)",
                "Subtraction Operator(-)",
                "Division Operator(/)",
                "Modulus (%)",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q6L3);

        Question L1q7L3 = new Question("It is an instruction that the Python interpreter can execute.",
                "Statement",
                "Compiler",
                "Expression",
                "String",
                "Statement",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q7L3);

        Question L1q8L3 = new Question("What are the two kinds of statements? ",
                "print and assignment",
                "print and operator",
                "assignment and operator",
                "operator and expression",
                "print and assignment",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q8L3);

        Question L1q9L3 = new Question("It is a combination of values, variables, and operators. ",
                "Expression",
                "declaration",
                "statement",
                "identifiers",
                "Expression",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q9L3);

        Question L1q10L3 = new Question("Is it true that 5 >= 4 ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON1,
                3);
        addQuestions(L1q10L3);
        //LESSON 1 LEVEL 4
        Question L1q1L4 = new Question("It is a reserved memory location to store values.?",
                "Identifiers",
                "Variables",
                "Integers",
                "Data Type","Identifiers",
                Question.CATEGORY_LESSON1,4);
        addQuestions(L1q1L4);

        Question L1q2L4 = new Question("Variable names are not case sensitive?",
                "True, Because you can create variable name in any form of character",
                "True, Because variable can create even the first letter of variable are numbers",
                "False, Because variables has a rule that need to consider",
                "False, Because variables can only start with a Letter ",
                "False, Because variables has a rule that need to consider",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q2L4);

        Question L1q3L4 = new Question("What do you need to assign Variable? ",
                "Value",
                "Name",
                "Operations",
                "Output",
                "Value",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q3L4);

        Question L1q4L4 = new Question("It is used to perform mathematical operations like addition subtraction, multiplication and division.",
                "Algebra Expression",
                "Arithmetic Operator",
                "Mathematics",
                "Integers",
                "Arithmetic Operator",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q4L4);

        Question L1q5L4 = new Question("It is an Arithmetic operator that being use to add 2 values.",
                "Addition Operator",
                "Modulus Symbol (%)",
                "Expression",
                "String",
                "Addition Operator",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q5L4);

        Question L1q6L4 = new Question("What sign that we need to use when we want to get the remainder of the two operands?",
                "Addition Operator (+)",
                "Modulus (%)",
                "Subtraction Operator(-)",
                "Division Operator(/)",
                "Modulus (%)",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q6L4);

        Question L1q7L4 = new Question("It is an instruction that the Python interpreter can execute.",
                "Statement",
                "Compiler",
                "Expression",
                "String",
                "Statement",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q7L4);

        Question L1q8L4 = new Question("What are the two kinds of statements? ",
                "print and assignment",
                "print and operator",
                "assignment and operator",
                "operator and expression",
                "print and assignment",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q8L4);

        Question L1q9L4= new Question("It is a combination of values, variables, and operators. ",
                "Expression",
                "declaration",
                "statement",
                "identifiers",
                "Expression",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q9L4);

        Question L1q10L4 = new Question("Is it true that 5 >= 4 ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON1,
                4);
        addQuestions(L1q10L4);

        //LESSON 1 LEVEL 5
        Question L1q1L5 = new Question("It is a reserved memory location to store values.?",
                "Identifiers",
                "Variables",
                "Integers",
                "Data Type","Identifiers",
                Question.CATEGORY_LESSON1,5);
        addQuestions(L1q1L5);

        Question L1q2L5 = new Question("Variable names are not case sensitive?",
                "True, Because you can create variable name in any form of character",
                "True, Because variable can create even the first letter of variable are numbers",
                "False, Because variables has a rule that need to consider",
                "False, Because variables can only start with a Letter ",
                "False, Because variables has a rule that need to consider",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q2L5);

        Question L1q3L5 = new Question("What do you need to assign Variable? ",
                "Value",
                "Name",
                "Operations",
                "Output",
                "Value",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q3L5);

        Question L1q4L5 = new Question("It is used to perform mathematical operations like addition subtraction, multiplication and division.",
                "Algebra Expression",
                "Arithmetic Operator",
                "Mathematics",
                "Integers",
                "Arithmetic Operator",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q4L5);

        Question L1q5L5 = new Question("It is an Arithmetic operator that being use to add 2 values.",
                "Addition Operator",
                "Modulus Symbol (%)",
                "Expression",
                "String",
                "Addition Operator",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q5L5);

        Question L1q6L5 = new Question("What sign that we need to use when we want to get the remainder of the two operands?",
                "Addition Operator (+)",
                "Modulus (%)",
                "Subtraction Operator(-)",
                "Division Operator(/)",
                "Modulus (%)",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q6L5);

        Question L1q7L5 = new Question("It is an instruction that the Python interpreter can execute.",
                "Statement",
                "Compiler",
                "Expression",
                "String",
                "Statement",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q7L5);

        Question L1q8L5 = new Question("What are the two kinds of statements? ",
                "print and assignment",
                "print and operator",
                "assignment and operator",
                "operator and expression",
                "print and assignment",
                Question.CATEGORY_LESSON1,
                2);
        addQuestions(L1q8L5);

        Question L1q9L5 = new Question("It is a combination of values, variables, and operators. ",
                "Expression",
                "declaration",
                "statement",
                "identifiers",
                "Expression",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q9L5);

        Question L1q10L5 = new Question("Is it true that 5 >= 4 ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON1,
                5);
        addQuestions(L1q10L5);
        // LESSON 2 LEVEL 1

        Question l2q1L1 = new Question("Perform different computations or actions depending on whether a specific Boolean constraint evaluates to true or false. Conditional statements are handled by IF statements in Python ",
                "Conditional Statement",
                "Print Statement",
                "Assignment Statement",
                "Statement",
                "Conditional Statement",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q1L1);
        Question l2q2L1 = new Question("The boolean expression after the if statement is called? ",
                "Statement",
                "Condition",
                "Comment",
                "Initialization",
                "Condition",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q2L1);
        Question l2q3L1 = new Question("Name the keyword which helps in writing code involves condition  ",
                "if",
                "unless",
                "rather than",
                "neither",
                "if",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q3L1);
        Question l2q4L1 = new Question("Function is a block of code which only runs when it is?",
                "called",
                "Determine",
                "put",
                "instantiate",
                "called",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q4L1);
        Question l2q5L1 = new Question("What will be the output of the following code?\n" +
                "a = 10\n" +
                "def myfunction():\n" +
                "a = 20\n" +
                "return\n" +
                "print(‘a=’,a)\n",
                "a = 20",
                "a = 30",
                "a = 10",
                "a = -10",
                "a = 10",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q5L1);
        Question l2q6L1 = new Question("What is not true about formal and actual parameters?",
                "Their names must be identical ",
                "Their name must be not identical",
                "name must be unique",
                "name must be common",
                "Their names must be identical",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q6L1);
        Question l2q7L1 = new Question("Strings are arrays of bytes representing ",
                "Unicode characters",
                "Characters",
                "ASCII Character",
                "String",
                "Unicode characters",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q7L1);
        Question l2q8L1 = new Question("Python has a built-in string class named rts",
                "True",
                "False",
                "depends on the version",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q8L1);
        Question l2q9L1 = new Question("Python strings are immutable which means they cannot be changed after they are created ",
                "True",
                "False",
                "Sometimes",
                "Depends on the version",
                "True",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q9L1);
        Question l2q10L1 = new Question("Characters in a string can be accessed using the standard [ ] syntax ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "True",
                Question.CATEGORY_LESSON2,
                1);
        addQuestions(l2q10L1);

        // LESSON 2 LEVEL 2

        Question l2q1L2 = new Question("Perform different computations or actions depending on whether a specific Boolean constraint evaluates to true or false. Conditional statements are handled by IF statements in Python ",
                "Conditional Statement",
                "Print Statement",
                "Assignment Statement",
                "Statement",
                "Conditional Statement",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q1L2);
        Question l2q2L2 = new Question("The boolean expression after the if statement is called? ",
                "Statement",
                "Condition",
                "Comment",
                "Initialization",
                "Condition",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q2L2);
        Question l2q3L2 = new Question("Name the keyword which helps in writing code involves condition  ",
                "if",
                "unless",
                "rather than",
                "neither",
                "if",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q3L2);
        Question l2q4L2 = new Question("Function is a block of code which only runs when it is?",
                "called",
                "Determine",
                "put",
                "instantiate",
                "called",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q4L2);
        Question l2q5L2 = new Question("What will be the output of the following code?\n" +
                "a = 10\n" +
                "def myfunction():\n" +
                "a = 20\n" +
                "return\n" +
                "print(‘a=’,a)\n",
                "a = 20",
                "a = 30",
                "a = 10",
                "a = -10",
                "a = 10",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q5L2);
        Question l2q6L2 = new Question("What is not true about formal and actual parameters?",
                "Their names must be identical ",
                "Their name must be not identical",
                "name must be unique",
                "name must be common",
                "Their names must be identical",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q6L2);
        Question l2q7L2 = new Question("Strings are arrays of bytes representing ",
                "Unicode characters",
                "Characters",
                "ASCII Character",
                "String",
                "Unicode characters",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q7L2);
        Question l2q8L2 = new Question("Python has a built-in string class named rts",
                "True",
                "False",
                "depends on the version",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q8L2);
        Question l2q9L2 = new Question("Python strings are immutable which means they cannot be changed after they are created ",
                "True",
                "False",
                "Sometimes",
                "Depends on the version",
                "True",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q9L2);
        Question l2q10L2 = new Question("Characters in a string can be accessed using the standard [ ] syntax ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "True",
                Question.CATEGORY_LESSON2,
                2);
        addQuestions(l2q10L2);
        // LESSON 2 LEVEL 3

        Question l2q1L3 = new Question("Perform different computations or actions depending on whether a specific Boolean constraint evaluates to true or false. Conditional statements are handled by IF statements in Python ",
                "Conditional Statement",
                "Print Statement",
                "Assignment Statement",
                "Statement",
                "Conditional Statement",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q1L3);
        Question l2q2L3 = new Question("The boolean expression after the if statement is called? ",
                "Statement",
                "Condition",
                "Comment",
                "Initialization",
                "Condition",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q2L3);
        Question l2q3L3 = new Question("Name the keyword which helps in writing code involves condition  ",
                "if",
                "unless",
                "rather than",
                "neither",
                "if",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q3L3);
        Question l2q4L3 = new Question("Function is a block of code which only runs when it is?",
                "called",
                "Determine",
                "put",
                "instantiate",
                "called",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q4L3);
        Question l2q5L3 = new Question("What will be the output of the following code?\n" +
                "a = 10\n" +
                "def myfunction():\n" +
                "a = 20\n" +
                "return\n" +
                "print(‘a=’,a)\n",
                "a = 20",
                "a = 30",
                "a = 10",
                "a = -10",
                "a = 10",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q5L3);
        Question l2q6L3 = new Question("What is not true about formal and actual parameters?",
                "Their names must be identical ",
                "Their name must be not identical",
                "name must be unique",
                "name must be common",
                "Their names must be identical",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q6L3);
        Question l2q7L3 = new Question("Strings are arrays of bytes representing ",
                "Unicode characters",
                "Characters",
                "ASCII Character",
                "String",
                "Unicode characters",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q7L3);
        Question l2q8L3 = new Question("Python has a built-in string class named rts",
                "True",
                "False",
                "depends on the version",
                "Maybe",
                "False",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q8L3);
        Question l2q9L3 = new Question("Python strings are immutable which means they cannot be changed after they are created ",
                "True",
                "False",
                "Sometimes",
                "Depends on the version",
                "True",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q9L3);
        Question l2q10L3 = new Question("Characters in a string can be accessed using the standard [ ] syntax ",
                "True",
                "False",
                "Wrong Statement",
                "Maybe",
                "True",
                Question.CATEGORY_LESSON2,
                3);
        addQuestions(l2q10L3);
    }
    private void addQuestions(Question question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_FINAL_ANSWER,question.getfinal_answer());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        cv.put(QuestionTable.COLUMN_LEVELS_ID,question.getLevels());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }
    public ArrayList<Question> getAllQuestions() {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_FINAL_ANSWER
        };



        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setfinal_answer(c.getString(c.getColumnIndex(QuestionTable.COLUMN_FINAL_ANSWER)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionsWithCategory(String Category) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_FINAL_ANSWER,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setfinal_answer(c.getString(c.getColumnIndex(QuestionTable.COLUMN_FINAL_ANSWER)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionByLevelsAndCategory( String Category,int LevelsID) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_FINAL_ANSWER,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? "
                + " AND " + QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = new String[] {String.valueOf(LevelsID),Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setfinal_answer(c.getString(c.getColumnIndex(QuestionTable.COLUMN_FINAL_ANSWER)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));
                //question.setDifficulty(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }
}
