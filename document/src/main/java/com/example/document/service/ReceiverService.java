package com.example.document.service;

import com.example.document.model.Receiver;
import com.example.document.repository.ReceiverRepository;
import com.example.document.util.QRCodeGenerator;
import com.example.document.util.UniqueIdGenerator;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    public Optional<Receiver> getReceiverByUniqueId(String uniqueId) {
        return receiverRepository.findByUserName(uniqueId);
    }

    public Receiver registerReceiver(Receiver receiver) throws IOException, WriterException {
        if(!isUserRegistered(receiver.getUserName())){
            //TODO update according to the UI like id is already available
            throw new IllegalArgumentException("user name is already registered");
        }
        String uniqueId = UniqueIdGenerator.generateUniqueId();
        String qrCodePath = "src/main/resources/static/qr_codes/" + receiver.getUserName() + ".png";

        QRCodeGenerator.generateQRCode(receiver.getUserName(), qrCodePath);

        receiver.setQrCodePath(qrCodePath);
        return receiverRepository.save(receiver);
    }

    public boolean isUserRegistered(String userName){
        return !receiverRepository.findByUserName(userName).isPresent();

    }
}
