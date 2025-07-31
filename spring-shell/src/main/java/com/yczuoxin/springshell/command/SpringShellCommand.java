package com.yczuoxin.springshell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class SpringShellCommand {

    @ShellMethod("say hello")
    public void hello(){
        System.out.println("hello");
    }

}
