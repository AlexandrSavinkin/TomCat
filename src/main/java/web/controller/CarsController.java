package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;

import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarDAO carsDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carsDAO = carDAO;
    }

    @GetMapping
    public String allCars(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carsDAO.allCars(count.orElse(0)));
        return "cars";
    }

}

