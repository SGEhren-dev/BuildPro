package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Core;

public class CommandsHandler {

    public CommandsHandler(Core core) {
        core.getCommand("selector").setExecutor(new Selector());
        core.getCommand("copy").setExecutor(new Copy());
        core.getCommand("paste").setExecutor(new Paste());
        core.getCommand("set").setExecutor(new Set());
        core.getCommand("replace").setExecutor(new Replace());
    }

}
