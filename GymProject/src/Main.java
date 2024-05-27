public class Main {
    public static void main(String[] args) {
        Gym gym = Gym.getInstance();

        TrainingPlan basicPlan = new BasicTrainingPlan();
        gym.setTrainingPlan(basicPlan);

        ConcreteTrainee trainee1 = new ConcreteTrainee("Петър Петров");
        ConcreteTrainee trainee2 = new ConcreteTrainee("Иван Иванов");

        gym.addTrainee(trainee1);
        gym.addTrainee(trainee2);

        gym.notifyAllTrainees();

        // Personalizing plans for trainees
        TrainingPlanDecorator cardioDecorator = new CardioDecorator(basicPlan);
        TrainingPlanDecorator strengthDecorator = new StrengthTrainingDecorator(basicPlan);

        trainee1.personalizePlan(cardioDecorator);
        trainee2.personalizePlan(strengthDecorator);

        trainee1.getPersonalPlan().describePlan();
        trainee2.getPersonalPlan().describePlan();
    }
}