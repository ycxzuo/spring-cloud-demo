package com.yczuoxin.springshell.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
public class SpringShellCommand {

    @ShellMethod("say hello")
    public void hello(@ShellOption(defaultValue = "world") String name){
        log.info("hello {}!", name);
    }

}
