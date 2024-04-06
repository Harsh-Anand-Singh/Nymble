package com.harshanandsingh.nymble.endpoint;

import com.harshanandsingh.nymble.model.Destination;
import com.harshanandsingh.nymble.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DestinationEndpoint {
    private static final String NAMESPACE_URI = "http://harshanandsingh.com/nymble";

    private final DestinationService destinationService;

    @Autowired
    public DestinationEndpoint(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDestinationRequest")
    @ResponsePayload
    public GetDestinationResponse getDestination(@RequestPayload GetDestinationRequest request) {
        GetDestinationResponse response = new GetDestinationResponse();
        Destination destination = destinationService.getDestinationById(request.getId());
        response.setDestination(destination);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createDestinationRequest")
    @ResponsePayload
    public CreateDestinationResponse createDestination(@RequestPayload CreateDestinationRequest request) {
        CreateDestinationResponse response = new CreateDestinationResponse();
        Destination destination = destinationService.createDestination(request.getDestination());
        response.setDestination(destination);
        return response;
    }

    public class GetDestinationRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public class GetDestinationResponse {
        private Destination destination;

        public Destination getDestination() {
            return destination;
        }

        public void setDestination(Destination destination) {
            this.destination = destination;
        }
    }

    public class CreateDestinationRequest {
        private Destination destination;

        public Destination getDestination() {
            return destination;
        }

        public void setDestination(Destination destination) {
            this.destination = destination;
        }
    }

    public class CreateDestinationResponse {
        private Destination destination;

        public Destination getDestination() {
            return destination;
        }

        public void setDestination(Destination destination) {
            this.destination = destination;
        }
    }
}