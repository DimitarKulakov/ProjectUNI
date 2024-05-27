public interface Trainee {
    void update();
}

class ConcreteTrainee implements Trainee {
    private String name;
    private TrainingPlan personalPlan;

    public ConcreteTrainee(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        Gym gym = Gym.getInstance();
        this.personalPlan = gym.getTrainingPlan();
        System.out.println("Клиента " + name + " е информиран за новия тренировачен план.");
    }

    public void personalizePlan(TrainingPlanDecorator decorator) {
        this.personalPlan = decorator.decorate(personalPlan);
        System.out.println("Клиента " + name + " е персонализирал своя план за тренировка.");
    }

    public TrainingPlan getPersonalPlan() {
        return personalPlan;
    }
}
