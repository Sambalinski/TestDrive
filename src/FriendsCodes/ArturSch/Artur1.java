package FriendsCodes.ArturSch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Artur1 {

    public static final int CARS_COUNT = 4;
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT + 1);
    public static CountDownLatch cd2 = new CountDownLatch(CARS_COUNT + 1);
    public static volatile boolean isWinnerFound = false;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        start();
        finish();
    }

    static void start() {
        boolean isStart = false;
        while (!isStart) {
            if (cdl.getCount() == 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                cdl.countDown();
                isStart = true;
            }
        }
    }

    static void finish() {
        boolean isFinish = false;
        while (!isFinish) {
            if (cd2.getCount() == 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                cdl.countDown();
                isFinish = true;
            }
        }
    }

}

class Car implements Runnable {
    private static int CARS_COUNT;


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Artur1.cdl.countDown();
            Artur1.cdl.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (!Artur1.isWinnerFound) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + getName() + ":ПОБЕДИТЕЛЬ!");
            Artur1.isWinnerFound = true;
        }
        Artur1.cd2.countDown();
    }
}

abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}

class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tunnel extends Stage {
    private Semaphore smp = new Semaphore(1);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
