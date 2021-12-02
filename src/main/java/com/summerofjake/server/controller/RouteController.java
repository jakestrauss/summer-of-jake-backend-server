package com.summerofjake.server.controller;

import com.summerofjake.server.model.Route;
import com.summerofjake.server.repository.RouteRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @CrossOrigin(origins = {"http://localhost:3000","https://www.summerofjake.com"})
    @GetMapping("routes")
    public List<Route> getRoutes() {
        return this.routeRepository.findAll();
    }

    @PostMapping(path = "postRoutes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> postRoutes(@RequestBody List<Route> routes) {
        if(routes == null || routes.size() == 0) {
            throw new ServiceException("No routes to post!");
        }

        //write each route to db if it's not already in database
        List<Route> postedRoutes = new ArrayList<>();
        for (Route r : routes) {
            try {
                if (this.routeRepository.findByActivityId(r.getActivityId()).isEmpty()) {
                    postedRoutes.add(this.routeRepository.saveAndFlush(r));
                } else {
                    System.out.println("Route with activityId " + r.getActivityId() +
                            " not written to db because it's already present");
                }
            } catch (Exception e) {
                System.out.println("Route with activityId " + r.getActivityId() + " not written to db because of exception:");
                System.out.println(e.getLocalizedMessage());
            }
        }

        if(postedRoutes.size() == routes.size()) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            System.out.println("Not all routes posted to database. "
                    + postedRoutes.size() + " routes posted when "
                    +  routes.size() + " were available to post.");
        }


        if (postedRoutes.size() > 0) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
        }
    }
}
