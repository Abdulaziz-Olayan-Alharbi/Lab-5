package com.example.lab_5_event.Controller;

import com.example.lab_5_event.Api.ApiResponse;
import com.example.lab_5_event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Successfully added event");
    }

    @GetMapping("/get/{index}")
    public Event getEvent(@PathVariable int index) {
        return events.get(index);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@RequestBody Event event , @PathVariable int index) {
        events.set(index, event);
        return new ApiResponse("Successfully updated event");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Successfully deleted event");
    }

    @GetMapping("/events")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PutMapping("/capacity/{index}")
    public ApiResponse changeCapacity (@PathVariable int index , @RequestBody int capacity){
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Successfully updated capacity");
    }

    @GetMapping("search/{id}")
    public Event getById(@PathVariable String id) {
        for (Event event : events) {
            if (event.getId().equals(id)){
                return event;
            }
        }
        return null;
    }
}
