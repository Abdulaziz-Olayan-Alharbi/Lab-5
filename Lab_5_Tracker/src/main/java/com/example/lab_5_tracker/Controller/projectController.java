package com.example.lab_5_tracker.Controller;

import com.example.lab_5_tracker.Api.ApiResponse;
import com.example.lab_5_tracker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/project")
public class projectController {

    ArrayList<Project> projects = new ArrayList<Project>();

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Successfully added project");
    }

    @GetMapping("/get/{index}")
    public Project getProject(@PathVariable int index) {
        return projects.get(index);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@RequestBody Project project ,@PathVariable int index) {
        projects.set(index, project);
        return new ApiResponse("Successfully updated project");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Successfully deleted project");
    }

    @PutMapping("/status/update/{index}")
    public ApiResponse updateStatus(@PathVariable int index,@RequestBody String status) {
        projects.get(index).setStatus(status);
        return new ApiResponse("Successfully updated status");
    }

    @GetMapping("/search/{title}")
    public Project searchProjectByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }

    @GetMapping("/projects")
    public ArrayList<Project> displayAllProjects() {
        return projects;
    }

    @GetMapping("/company/{company}")
    public ArrayList<Project> getProjectsByCompanyName(@PathVariable String company) {
        ArrayList<Project> sameCompanyName = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equals(company)) {
                sameCompanyName.add(project);
            }
        }
        return sameCompanyName;
    }


}
