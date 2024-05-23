package com.example.JavaAssignment2.Implementation;

import com.example.JavaAssignment2.Entity.Program;
import com.example.JavaAssignment2.Repository.AssemblyRepository;
import com.example.JavaAssignment2.Service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssemblyServiceImpl implements AssemblyService {

    @Autowired
    AssemblyRepository assemblyRepository;

    @Override
    public Map<String, Integer> AssemblyProgramExecutor(String[] AssemblyProgram) {

        Map<String, Integer> registers = new HashMap<>();

        for (String instruction : AssemblyProgram) {
            String[] parts = instruction.split(" ");

            if (parts[0].equals("MV")) {
                String[] regAndVal = parts[1].split(",");
                String reg = regAndVal[0];
                int value = Integer.parseInt(regAndVal[1].replaceAll("#", ""));
                registers.put(reg, value);
                assemblyRepository.save(new Program(instruction,parts[0],reg,value));


            } else if (parts[0].equals("ADD")) {
                String[] regs = parts[1].split(",");
                int temp = registers.getOrDefault(regs[1], -1);
                int sum = registers.get(regs[0]) + ((temp != -1) ? registers.get(regs[1]) : Integer.parseInt(regs[1]));
                registers.put(regs[0], sum);
                assemblyRepository.save(new Program(instruction,parts[0],regs[0],sum));

            } else if (parts[0].equals("SHOW")) {
                assemblyRepository.save(new Program(instruction,parts[0],parts[1],registers.getOrDefault(parts[1],0)));
                return registers;
            }
        }
        return registers;
    }
}
