import dao.QuizRepository;
import dao.UserRepository;
import dao.impl.LongKeyGenerator;
import dao.impl.QuizRepositoryImpl;
import dao.impl.UserRepositoryImpl;
import model.Answer;
import model.Question;
import model.Quiz;
import model.User;
import model.enums.Gender;
import util.ValidationUtil;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Engine implements Runnable{

    private final Scanner scanner;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;


    public Engine() {
        scanner = new Scanner(System.in);
        this.quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
        this.userRepository = new UserRepositoryImpl(new LongKeyGenerator());
    }


    @Override
    public void run() {
        System.out.println("What would you like to do? Please enter a number...\n"+
                "<0> Exit\n" +
                "<1> Create Quiz\n" +
                "<2> Create User\n"+
                "<3> Print Quizzes\n"+
                "<4> Print Users");

        int exNumber = 0;

            exNumber = Integer.parseInt(scanner.nextLine());


        switch (exNumber) {
            case 1:
                String username;
                System.out.println("Please create a profile to submit the quiz: ");
                System.out.println("Please enter a valid username: (Username must be between 2 and 15 characters long.");
                 username = scanner.nextLine();
                while (!ValidationUtil.validateString(username, 2, 15)){
                    System.out.println("The username you enter is not valid. Please try again");
                    username = scanner.nextLine();
                }
                System.out.println("Please enter a valid email address: ");
                String email = scanner.nextLine();
                // we can throw exceptions
                while (!ValidationUtil.validateEmail(email)) {
                    System.out.println("Invalid email. Please try again.");
                    email = scanner.nextLine();
                }
                System.out.println("Please enter password. (Must be between 3 and 15 characters.");
                String password  = scanner.nextLine();
                while (!ValidationUtil.validateString(password, 3, 15)){
                    System.out.println("Invalid password.PLease try again");
                    password = scanner.nextLine();
                }
                User user = new User(username, email, password);
                System.out.println("Please enter your gender: (type male or female)");
                Gender gender = ValidationUtil.validateGender(scanner.nextLine());
                while(gender == null){
                    System.out.println("Invalid data. Please try again");
                    gender = ValidationUtil.validateGender(scanner.nextLine());
                }
                user.setGender(gender);
                userRepository.create(user);
                Long userID = user.getId();


                System.out.println("~~~Congratulations your profile was created successfully~~~");
                Quiz quiz = createTest(user);
                user.getQuizzes().add(quiz);
                System.out.println("Your first quiz was created");



        }

                }

                // add exit number
    private Quiz createTest(User user) {
        Quiz quiz = null;
        System.out.println("Please enter a valid quiz title (Title must be between 2 and 80 characters");
        String title = scanner.nextLine();
        while(!ValidationUtil.validateString(title, 2, 80)){
            System.out.println("Please try again");
            title = scanner.nextLine();
        }
        // changing the requirements for the demo (20 and 250 constrains)
        System.out.println("Please enter a valid quiz description (Title must be 2 and 80  characters");
        String description = scanner.nextLine();
        while(!ValidationUtil.validateString(description, 2, 80)){
            System.out.println("Please try again");
            description = scanner.nextLine();
        }

        quiz = new Quiz(title, description);
        quiz.setAuthor(user);
        System.out.println("Please start entering questions.\n If you want to exit type 1");
        String input = scanner.nextLine();
        while (!input.equals("1")){
            while (!ValidationUtil.validateString(input, 10, 30)){
                System.out.println("Questions minimum length is 10, max 30. Try again");
                input = scanner.nextLine();
            }
            Question question = new Question(input);
            System.out.println("Please enter a valid answer for your question");
            String answer = scanner.nextLine();
            while (!ValidationUtil.validateString(answer, 2, 150)){
                System.out.println("Answer minimum length is 2, max 150. Try again");
                answer = scanner.nextLine();
            }
            Answer answer1 = new Answer(answer);
            System.out.println("Please enter how many points does the answer give.");
            String points = scanner.nextLine();
            while (!ValidationUtil.validateInt(points)) {
                System.out.println("Invalid number. Try again");
                points = scanner.nextLine();
            }
            answer1.setScore(Integer.parseInt(points));
            // todo check if we want uni or bi directional
            answer1.setQuestion(question);
            // todo make a separate methods
            question.getAnswers().add(answer1);
            quiz.getQuestions().add(question);
            input = scanner.nextLine();
        }
        return quiz;
    }


}



