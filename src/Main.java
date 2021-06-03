public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();
        engine.run();


//        Quiz quiz = new Quiz();
//        Quiz quiz2 = new Quiz();
//        User user = new User();
//        user.setUsername("Ivan Ivanov");
//        quiz.setAuthor(user);
//        quiz2.setAuthor(user);
//        quiz.setDescription("Easy one");
//        quiz2.setDescription("Getting complicated");
//        quiz.setExpectedDuration(1);
//
//        Question question = new Question("Exceptions extends:....");
//        Answer answer = new Answer("Throwable");
//        question.getAnswers().add(answer);
//        quiz.addQuestion(question);
//
//        // todo add questions and answers;
//
//        QuizRepository quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
//        Quiz[] quizz ={quiz,quiz2};
//        Arrays.asList(quizz).forEach(quizRepository::create);
//
//        List<PrintUtil.ColumnDescriptor> metadataColumns = List.of(
//                new PrintUtil.ColumnDescriptor("created", "Created", 19, CENTER),
//                new PrintUtil.ColumnDescriptor("updated", "Updated", 19, CENTER)
//        );
//
//
//
//
//
//        List<PrintUtil.ColumnDescriptor> quizColumns = new ArrayList<>(List.of(
//                new PrintUtil.ColumnDescriptor("id", "ID", 5, CENTER),
//                new PrintUtil.ColumnDescriptor("title", "Title", 5, LEFT),
//                new PrintUtil.ColumnDescriptor("author", "Author", 12, LEFT),
//                new PrintUtil.ColumnDescriptor("description", "Description", 20, LEFT),
//                new PrintUtil.ColumnDescriptor("expectedDuration", "Duration", 8, RIGHT, 2),
////                new PrintUtil.ColumnDescriptor("text", "Question", 8, RIGHT, 2),
////                new PrintUtil.ColumnDescriptor("answer", "Answer", 8, RIGHT, 2),
//                new PrintUtil.ColumnDescriptor("URL", "Picture URL", 11, CENTER)
//        ));
//
//        quizColumns.addAll(metadataColumns);
//
//        String quizReport = PrintUtil.formatTable(quizColumns, quizRepository.findAll(), "Quiz List:");
//        System.out.println(quizReport);
//
//
//    }

    }
}
