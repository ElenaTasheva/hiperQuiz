import dao.PlayerRepository;
import dao.QuizRepository;
import dao.QuizResultRepository;
import dao.UserRepository;
import dao.impl.*;
import model.*;
import model.enums.Gender;
import util.Alignment;
import util.PrintUtil;
import util.ValidationUtil;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.Alignment.*;

public class Engine implements Runnable{

    private final Scanner scanner;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final QuizResultRepository quizResultRepository;
    private final PlayerRepository playerRepository;



    public Engine() {
        scanner = new Scanner(System.in);
        this.quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
        this.userRepository = new UserRepositoryImpl(new LongKeyGenerator());
        this.quizResultRepository = new QuizResultRepositoryImpl(new LongKeyGenerator());
        this.playerRepository = new PlayerRepositoryImpl(new LongKeyGenerator());
    }


    @Override
    public void run() {
        printMenu();

        int exNumber = 0;

            exNumber = Integer.parseInt(scanner.nextLine());


            while (exNumber != 0) {
                switch (exNumber) {
                    case 0:
                        System.out.println("Thank you! BYE :))");
                        break;
                    case 1:
                        String username;
                        System.out.println("Please create a profile to submit the quiz. If you already have a profile type 'yes' ");
                        username = scanner.nextLine();

                        if (username.equals("yes")) {
                            // todo make the method in the repo
                            User userExist = findUserByUserName();
                            // todo check if user is found
                            //doing it assuming credentials are correct
                            createTest(userExist);

                        }
                        System.out.println("Please enter a valid username: (Username must be between 2 and 15 characters long.");
                        username = scanner.nextLine();
                        while (!ValidationUtil.validateString(username, 2, 15)) {
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
                        String password = scanner.nextLine();
                        while (!ValidationUtil.validateString(password, 3, 15)) {
                            System.out.println("Invalid password.PLease try again");
                            password = scanner.nextLine();
                        }
                        User user = new User(username, email, password);
                        System.out.println("Please enter your gender: (type male or female)");
                        Gender gender = ValidationUtil.validateGender(scanner.nextLine());
                        while (gender == null) {
                            System.out.println("Invalid data. Please try again");
                            gender = ValidationUtil.validateGender(scanner.nextLine());
                        }
                        user.setGender(gender);
                        userRepository.create(user);
                        Player player = new Player(user.getUsername());
                        playerRepository.create(player);
                       Long userID = user.getId();


                        System.out.println("~~~Congratulations your profile was created successfully~~~");
                        System.out.println("Please enter a valid quiz title (Title must be between 2 and 80 characters");
                        Quiz quiz = createTest(user);
                        user.getQuizzes().add(quiz);
                        quizRepository.create(quiz);
                        System.out.println("Your first quiz was created");
                        break;
                    case 2:
                        User user1 = findUserByUserName();
                        System.out.println("Please enter a valid quiz title (Title must be between 2 and 80 characters");
                        createTest(user1);
                        break;
                    case 3:
                        printQuizez();
                        System.out.println("Please enter the id of the quiz you want to play");
                        long quizId = Long.parseLong(scanner.nextLine());
                        if (quizRepository.findById(quizId).isEmpty()) {
                            System.out.println("Please enter a valid id");
                        } else {
                            Player userPlaying = findPlayerByUserNameByUserName();
                            System.out.println();
                            // todo make a Player and a User;
                            Quiz quizToPlay = quizRepository.findById(quizId).get();
                            System.out.println("Starting the quiz....\n If you want to exit enter '0'");
                            String userInput = "";
                            List<Question> questions = quizToPlay.getQuestions();
                            QuizResult quizResult = createAQuizResultForTheChosenQuiz(userPlaying, quizToPlay);


                            while (!userInput.equals("0")) {
                                for (Question question : questions) {
                                    System.out.println(question);

                                    userInput = scanner.nextLine();
                                    String answer = question.getAnswers().get(0).getText();
                                    Answer answer1 = question.getAnswers().get(0);
                                    if (userInput.equals(answer)) {
                                        quizResult.calculateScore(answer1);
                                        System.out.println("Good job!");
                                    } else {
                                        System.out.println(":( May be next time");
                                    }
                                }
                                System.out.printf("Thank you for playing.\n Your score is %s", userPlaying.getOverallScore());
                                System.out.println();


                            }
                        }


                }
                printMenu();
                exNumber = Integer.parseInt(scanner.nextLine());
            }

                }

    private void printMenu() {
        System.out.println("What would you like to do? Please enter a number...\n"+
                "~0~ Exit\n" +
                "~1~ Create Quiz\n" +
                "~2~ Create User\n"+
                "~3~ Pick a Quiz\n"+ // printing quizzez
                "~4~ Print Users");
    }

    private QuizResult createAQuizResultForTheChosenQuiz(User userPlaying, Quiz quizToPlay) {
        QuizResult quizResult = new QuizResult((Player) userPlaying, quizToPlay);
        return quizResultRepository.create(quizResult);
    }



    private void printQuizez() {

        List<PrintUtil.ColumnDescriptor> metadataColumns = getMetaData();
;
        List<PrintUtil.ColumnDescriptor> quizColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("id", "ID", 5, CENTER),
                new PrintUtil.ColumnDescriptor("title", "Title", 5, LEFT),
                new PrintUtil.ColumnDescriptor("author", "Author", 12, LEFT),
                new PrintUtil.ColumnDescriptor("description", "Description", 20, LEFT),
                new PrintUtil.ColumnDescriptor("expectedDuration", "Duration", 8, RIGHT, 2),
                        //   new PrintUtil.ColumnDescriptor("text", "Question", 8, RIGHT, 2),
                new PrintUtil.ColumnDescriptor("URL", "Picture URL", 11, CENTER)
        ));

                quizColumns.addAll(metadataColumns);

        String quizReport = PrintUtil.formatTable(quizColumns, quizRepository.findAll(), "Quiz List:");
        System.out.println(quizReport);

    }

    private List<PrintUtil.ColumnDescriptor> getMetaData() {
        return  List.of(
                new PrintUtil.ColumnDescriptor("created", "Created", 19, CENTER),
                new PrintUtil.ColumnDescriptor("updated", "Updated", 19, CENTER)
        );
    }

    private User findUserByUserName() {
        System.out.println("Please enter your username");
        String username = scanner.nextLine();

        // todo check and throw exception the demo is assuming data is correct
        return  userRepository.findAll().stream().filter(user1 -> user1.getUsername().equals(username))
                .findFirst().get();
    }

    private Player findPlayerByUserNameByUserName() {
        System.out.println("Please enter your username");
        String username = scanner.nextLine();

        // todo check and throw exception the demo is assuming data is correct
        return  playerRepository.findAll().stream().filter(user1 -> user1.getUsername().equals(username))
                .findFirst().get();
    }

    // add exit number
    private Quiz createTest(User user) {
        Quiz quiz = null;
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
        System.out.println("Please start entering questions.\n If you want to exit type '0'. \n " +
                "Once ready type 'done'");
        String input = scanner.nextLine();
        while (!input.equals("0") && !input.equals("done")){
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
            System.out.println("Please enter a question");
            input = scanner.nextLine();

        }
        quiz.setExpectedDuration(60);
        return quiz;
    }


}



