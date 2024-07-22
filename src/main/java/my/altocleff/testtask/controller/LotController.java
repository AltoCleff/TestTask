package my.altocleff.testtask.controller;

import my.altocleff.testtask.entity.Lot;
import my.altocleff.testtask.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lots")
public class LotController {

    @Autowired
    private LotService lotService;

    @GetMapping
    public List<Lot> getLots(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double minArea,
            @RequestParam(required = false) Double maxArea,
            @RequestParam(required = false) Integer minFloor,
            @RequestParam(required = false) Integer maxFloor,
            @RequestParam(required = false) Integer minRooms,
            @RequestParam(required = false) Integer maxRooms) {
        return lotService.findAvailableLots(name, city, address, minArea, maxArea, minFloor, maxFloor, minRooms, maxRooms);
    }
}
