package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "BMV", "black"));
        cars.add(new Car(2, "Mercedes", "green"));
        cars.add(new Car(3, "Toyota", "white"));
        cars.add(new Car(4, "LADA", "blue"));
        cars.add(new Car(5, "KIA", "red"));
    }

    public List<Car> allCars(int count) {
        if (count == 0 || count > 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
