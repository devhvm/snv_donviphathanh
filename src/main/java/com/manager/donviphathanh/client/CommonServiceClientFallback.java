package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.ChiTieuDTO;
import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.web.rest.errors.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommonServiceClientFallback implements CommonServiceClient {


    @Override
    public List<ChiTieuDTO> getAllChiTieus(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sort") String[] sort) {
        return new ArrayList<>();
    }

    @Override
    public MauPhatHanhDTO createMauPhatHanh(@Valid CreateMauPhatHanhDTO createMauPhatHanhDTO) throws RuntimeException {
        throw new ResourceNotFoundException("Created ERROR");
    }
}
