package api.mercado.service.impl;

import api.mercado.dto.ActivityResponse;
import api.mercado.dto.CreateActivityRequest;
import api.mercado.dto.UpdateActivityRequest;
import api.mercado.entity.Activity;
import api.mercado.repository.ActivityRepository;
import api.mercado.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository repository;

    public ActivityServiceImpl(ActivityRepository repository) {
        this.repository = repository;
    }

    private ActivityResponse toResponse(Activity activity) {
        ActivityResponse res = new ActivityResponse();
        res.setId(activity.getId());
        res.setTitle(activity.getTitle());
        res.setDescription(activity.getDescription());
        res.setStatus(activity.getStatus());
        res.setPriority(activity.getPriority());
        res.setDueDate(activity.getDueDate());
        res.setDone(activity.getDone());
        return res;
    }

    private Activity fromCreateRequest(CreateActivityRequest req) {
        Activity a = new Activity();
        a.setTitle(req.getTitle());
        a.setDescription(req.getDescription());
        a.setStatus(req.getStatus());
        a.setPriority(req.getPriority());
        a.setDueDate(req.getDueDate());
        a.setDone(false);
        return a;
    }

    private void updateEntity(Activity a, UpdateActivityRequest req) {
        a.setTitle(req.getTitle());
        a.setDescription(req.getDescription());
        a.setStatus(req.getStatus());
        a.setPriority(req.getPriority());
        a.setDueDate(req.getDueDate());
    }

    @Override
    public ActivityResponse create(CreateActivityRequest request) {
        Activity saved = repository.save(fromCreateRequest(request));
        return toResponse(saved);
    }

    @Override
    public List<ActivityResponse> list() {
        return repository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public ActivityResponse getById(Long id) {
        Activity a = repository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        return toResponse(a);
    }

    @Override
    public ActivityResponse update(Long id, UpdateActivityRequest request) {
        Activity a = repository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        updateEntity(a, request);
        Activity saved = repository.save(a);
        return toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ActivityResponse markDone(Long id) {
        Activity a = repository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        a.setDone(true);
        Activity saved = repository.save(a);
        return toResponse(saved);
    }

    @Override
    public ActivityResponse changeStatus(Long id, String value) {
        Activity a = repository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        a.setStatus(value);
        Activity saved = repository.save(a);
        return toResponse(saved);
    }
}