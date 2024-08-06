package com.example.department.Controller;

import com.example.department.Entity.Department;
import com.example.department.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepo repo;

    @PostMapping("/submit")
    public ResponseEntity<Department> submitDepartment(@RequestBody Department department) {
        Department savedDepartment = repo.save(department);
        
        return ResponseEntity.ok().body(savedDepartment);
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = repo.findAll();
        
        return ResponseEntity.ok().body(departments);
    }

    @GetMapping("/{did}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int did) {
        Department department = repo.findByDid(did);
        
        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok().body(department);
    }
}