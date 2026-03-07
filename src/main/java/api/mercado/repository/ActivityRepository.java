package api.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.mercado.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
