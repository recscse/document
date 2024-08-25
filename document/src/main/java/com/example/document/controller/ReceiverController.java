package com.example.document.controller;

import com.example.document.model.Receiver;
import com.example.document.service.ReceiverService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/receivers")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;

    @GetMapping("/{uniqueId}")
    public ResponseEntity<Optional<Receiver>> getReceiver(@PathVariable String uniqueId) {
        Optional<Receiver> receiver = receiverService.getReceiverByUniqueId(uniqueId);
        return receiver != null ? ResponseEntity.ok(receiver) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Receiver> registerReceiver(@RequestBody Receiver receiver){
        try{
            return ResponseEntity.ok(receiverService.registerReceiver(receiver));
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

//    @GetMapping("/{uniqueId}")
//    public ResponseEntity<Receiver> getReceiverByUniqueId(@PathVariable String uniqueId){
//        Receiver receiver = receiverService.getReceiverByUniqueId(uniqueId);
//
//    }
}
