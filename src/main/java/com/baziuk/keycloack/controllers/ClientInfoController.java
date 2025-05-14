package com.baziuk.keycloack.controllers;

import com.baziuk.keycloack.entitys.ClientInfoEntity;
import com.baziuk.keycloack.service.ClientInfoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("client")
public class ClientInfoController {

    Logger logger = Logger.getLogger(ClientInfoController.class.getName());

    private ClientInfoService clientInfoService;

    @Autowired
    public ClientInfoController(ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

    @GetMapping("/info-user")
    @RolesAllowed("ROLE_ADMIN")
    public String infoUser() {
        return "html/info-user";
    }

    @PostMapping("/save")
    @RolesAllowed("ROLE_ADMIN")
    public String save(@RequestParam String name,
                       @Valid @RequestParam String email,
                       @RequestParam String location,
                       @RequestParam String taxNumber,
                       @RequestParam Integer userId) {
        ClientInfoEntity clientInfo = new ClientInfoEntity(name, email, taxNumber, location, userId);
        clientInfoService.save(clientInfo);
        logger.info("create:" + clientInfo);
        return "redirect:info-user";
    }

    @PostMapping("/")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<ClientInfoEntity> save(@RequestParam ClientInfoEntity clientInfo) {
        return ResponseEntity.status(200).body(clientInfoService.save(clientInfo));
    }

    @GetMapping("/getAll")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<List<ClientInfoEntity>> getAll() {
        return ResponseEntity.ok().body(clientInfoService.findAll());
    }
}
