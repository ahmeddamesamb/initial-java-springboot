package com.example.projecttext.controller;

import com.example.projecttext.utlis.Endpoints;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.URL_APP)
@CrossOrigin(origins = "", allowedHeaders = "*")

public class LivreurController {
}
