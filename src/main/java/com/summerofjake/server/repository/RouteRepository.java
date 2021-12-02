package com.summerofjake.server.repository;

import com.summerofjake.server.model.Marker;
import com.summerofjake.server.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Marker> findByActivityId(String activityId);
}
