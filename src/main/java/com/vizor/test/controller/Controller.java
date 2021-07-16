package com.vizor.test.controller;

import com.vizor.test.model.Model;
import com.vizor.test.view.View;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model){
        this.view=view;
        this.model=model;
    }
}
