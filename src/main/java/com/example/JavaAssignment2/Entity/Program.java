package com.example.JavaAssignment2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="instruction")
    private String instruction;
    @Column(name="action")
    private String action;
    @Column(name="register name")
    private String registerName;

    @Column(name="register value")
    private int registerValue;

    public Program() {
    }

    public Program(String instruction, String action, String registerName, int registerValue) {
        this.instruction = instruction;
        this.action = action;
        this.registerName = registerName;
        this.registerValue = registerValue;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public int getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(int registerValue) {
        this.registerValue = registerValue;
    }
}
