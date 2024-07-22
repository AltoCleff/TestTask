package my.altocleff.testtask.service;

import jakarta.persistence.criteria.Predicate;
import my.altocleff.testtask.entity.Lot;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class LotSpecifications {
    public static Specification<Lot> withFilters(String name, String city, String address, Double minArea, Double maxArea, Integer minFloor, Integer maxFloor, Integer minRooms, Integer maxRooms) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (city != null) {
                predicates.add(criteriaBuilder.equal(root.get("city"), city));
            }
            if (address != null) {
                predicates.add(criteriaBuilder.like(root.get("address"), "%" + address + "%"));
            }
            if (minArea != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("area"), minArea));
            }
            if (maxArea != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), maxArea));
            }
            if (minFloor != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("floor"), minFloor));
            }
            if (maxFloor != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("floor"), maxFloor));
            }
            if (minRooms != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rooms"), minRooms));
            }
            if (maxRooms != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rooms"), maxRooms));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}