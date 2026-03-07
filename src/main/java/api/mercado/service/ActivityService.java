package api.mercado.service;

import api.mercado.dto.ActivityResponse;
import api.mercado.dto.CreateActivityRequest;
import api.mercado.dto.UpdateActivityRequest;
import java.util.List;

public interface ActivityService {
    ActivityResponse create(CreateActivityRequest request);
    List<ActivityResponse> list();
    ActivityResponse getById(Long id);
    ActivityResponse update(Long id, UpdateActivityRequest request);
    void delete(Long id);
    ActivityResponse markDone(Long id);
    ActivityResponse changeStatus(Long id, String value);
}