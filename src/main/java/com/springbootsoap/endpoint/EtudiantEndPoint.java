package com.springbootsoap.endpoint;

import allapis.springbootsoap.com.*;
import com.springbootsoap.model.Etudiant;
import com.springbootsoap.services.EtudiantService;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EtudiantEndPoint {
    private static final String NameSpace_URI="http://com.springbootsoap.allapis";

    @Autowired
    public EtudiantService etudiantService;

    @PayloadRoot(namespace = NameSpace_URI, localPart = "addEtudiantRequest")
    @ResponsePayload
    public AddEtudiantResponse addEtudiant(@RequestPayload AddEtudiantRequest request) {
        AddEtudiantResponse response = new AddEtudiantResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(request.getEtudiantInfo(), etudiant);
        etudiantService.addEtudiant(etudiant); // Note: Method name updated to match standard Java naming conventions.
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NameSpace_URI, localPart = "updateEtudiantRequest")
    @ResponsePayload
    public UpdateEtudiantResponse updateEtudiant(@RequestPayload JAXBElement<UpdateEtudiantRequest> request) {
        Etudiant etudiant = new Etudiant();

        BeanUtils.copyProperties(request.getValue().getEtudiantInfo(), etudiant);
        etudiantService.updateEtudiant(etudiant);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateEtudiantResponse response = new UpdateEtudiantResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NameSpace_URI, localPart = "deleteEtudiantRequest")
    @ResponsePayload
    public DeleteEtudiantResponse deleteEtudiant(@RequestPayload DeleteEtudiantRequest request) {
        etudiantService.deleteEtudiant(request.getEtudiantId());
        ServiceStatus serviceStatus = new ServiceStatus();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteEtudiantResponse response = new DeleteEtudiantResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NameSpace_URI, localPart = "getEtudiantByIdRequest")
    @ResponsePayload
    public GetEtudiantResponse getEtudiant(@RequestPayload GetEtudiantByIdRequest request) {
        GetEtudiantResponse response = new GetEtudiantResponse();
        EtudiantInfo etudiantInfo = new EtudiantInfo();
        BeanUtils.copyProperties(etudiantService.getEtudiantById(request.getEtudiantId()), etudiantInfo);
        response.setEtudiantInfo(etudiantInfo);
        return response;

    }





}
