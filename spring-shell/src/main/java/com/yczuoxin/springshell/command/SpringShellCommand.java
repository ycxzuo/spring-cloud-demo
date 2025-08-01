package com.yczuoxin.springshell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class SpringShellCommand {

    @ShellMethod("say hello")
    public void hello(@ShellOption(defaultValue = "world") String name){
        System.out.println("hello " + name + "!");
    }

}
