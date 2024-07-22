package my.altocleff.testtask.service;

import my.altocleff.testtask.entity.Lot;
import my.altocleff.testtask.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotService {

    @Autowired
    private LotRepository lotRepository;

    public List<Lot> findAvailableLots(String name, String city, String address, Double minArea, Double maxArea, Integer minFloor, Integer maxFloor, Integer minRooms, Integer maxRooms) {
        Specification<Lot> specification = LotSpecifications.withFilters(name, city, address, minArea, maxArea, minFloor, maxFloor, minRooms, maxRooms);
        return lotRepository.findAll(specification);
    }
}
