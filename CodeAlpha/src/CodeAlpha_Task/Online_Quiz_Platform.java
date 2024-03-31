package CodeAlpha_Task;

import java.util.Scanner;
import java.util.concurrent.*;
public class Online_Quiz_Platform {
	private static final int Questions = 5;
    private static final int Timelimit = 30;
    private static int score = 0;

    static class Quiz implements Runnable {
        private final String question;
        private final String[] options;
        private final String correctAnswer;

        Quiz(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        @Override
        public void run() {
            System.out.println(question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((char)('A' + i) + ". " + options[i]);
            }
            System.out.println("Enter your answer (A, B, C, or D):");

            Scanner s = new Scanner(System.in);
            String userAnswer = s.nextLine().toUpperCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswer);
            }
        }
    }

    public static void main(String[] args) {
        String[][] questions = {
                {"What is MS Dhoni's full name?", "A. Mahendra Singh Dhoni", "B. Mahesh Shantaram Dhoni", "C. Mukesh Suresh Dhoni", "D. Mohan Sharma Dhoni", "A"},
                {"In which year did MS Dhoni make his international cricket debut?", "A. 2003", "B. 2004", "C. 2005", "D. 2006", "C"},
                {"How many ICC Cricket World Cup titles has MS Dhoni won as captain of the Indian cricket team?", "A. One", "B. Two", "C. Three", "D. None", "B"},
                {"Which IPL team has MS Dhoni captained since the inception of the tournament?", "A. KKR", "B. RCB", "C. CSK", "D. MI", "C"},
                {"What is MS Dhoni's highest individual score in One Day Internationals (ODIs)?", "A. 248", "B. 171", "C. 181", "D. 183*", "D"},
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + Timelimit + " seconds to answer each question.");

        for (String[] q : questions) {
            String question = q[0];
            String[] options = {q[1], q[2], q[3], q[4]};
            String correctAnswer = q[5];

            Quiz quizTask = new Quiz(question, options, correctAnswer);
            Future<?> future = executor.submit(quizTask);

            try {
                future.get(Timelimit, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true); // Cancel the task if timeout occurs
                System.out.println("Time's up!");
            }
        }

        executor.shutdown();
        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + "/" + Questions);
    }

}
