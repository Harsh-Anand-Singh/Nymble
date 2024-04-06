package com.harshanandsingh.nymble.endpoint;

import com.harshanandsingh.nymble.model.Activity;
import com.harshanandsingh.nymble.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ActivityEndpoint {
    private static final String NAMESPACE_URI = "http://harshanandsingh.com/nymble";

    private final ActivityService activityService;

    @Autowired
    public ActivityEndpoint(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getActivityRequest")
    @ResponsePayload
    public GetActivityResponse getActivity(@RequestPayload GetActivityRequest request) {
        GetActivityResponse response = new GetActivityResponse();
        Activity activity = activityService.getActivityById(request.getId());
        response.setActivity(activity);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createActivityRequest")
    @ResponsePayload
    public CreateActivityResponse createActivity(@RequestPayload CreateActivityRequest request) {
        CreateActivityResponse response = new CreateActivityResponse();
        Activity activity = activityService.createActivity(request.getActivity());
        response.setActivity(activity);
        return response;
    }

    public class GetActivityRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public class GetActivityResponse {
        private Activity activity;

        public Activity getActivity() {
            return activity;
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }
    }

    public class CreateActivityRequest {
        private Activity activity;

        public Activity getActivity() {
            return activity;
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }
    }

    public class CreateActivityResponse {
        private Activity activity;

        public Activity getActivity() {
            return activity;
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }
    }
}