public interface TrainingPlan {
    void describePlan();
}

class BasicTrainingPlan implements TrainingPlan {
    @Override
    public void describePlan() {
        System.out.println("обикновен тренировачен план.");
    }
}

// Decorator - TrainingPlanDecorator
abstract class TrainingPlanDecorator implements TrainingPlan {
    protected TrainingPlan decoratedPlan;

    public TrainingPlanDecorator(TrainingPlan decoratedPlan) {
        this.decoratedPlan = decoratedPlan;
    }

    public TrainingPlan decorate(TrainingPlan plan) {
        this.decoratedPlan = plan;
        return this;
    }
}

class CardioDecorator extends TrainingPlanDecorator {
    public CardioDecorator(TrainingPlan decoratedPlan) {
        super(decoratedPlan);
    }

    @Override
    public void describePlan() {
        decoratedPlan.describePlan();
        System.out.println("Добавя кардио упражнения към тренировачния план.");
    }
}

class StrengthTrainingDecorator extends TrainingPlanDecorator {
    public StrengthTrainingDecorator(TrainingPlan decoratedPlan) {
        super(decoratedPlan);
    }

    @Override
    public void describePlan() {
        decoratedPlan.describePlan();
        System.out.println("Добавя упражнения за сила към тренировачния план.");
    }
}
