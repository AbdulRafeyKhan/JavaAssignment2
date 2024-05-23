package com.example.JavaAssignment2.Controller;

import com.example.JavaAssignment2.Service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/assembly")
public class AssemblyController {

    @Autowired
    AssemblyService assemblyService;

    @PostMapping("/program")
    public Map<String, Integer> AssemblyProgramExecutor(@RequestBody String query) {
        try {
            String[] program = query.split("\r\n");
            return assemblyService.AssemblyProgramExecutor(program);
        } catch (Exception e) {
            System.out.println("Error executing assembly language program"+e);
            return new HashMap<>();
        }
    }
}
