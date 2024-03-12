package com.tradefinance.LC7.LC.sevices;

import com.tradefinance.LC7.LC.Entities.IssuedLcs;
import com.tradefinance.LC7.LC.repositories.IssuedLcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedLcService {

    @Autowired
    private IssuedLcRepository issuedLcRepository;

    public List<IssuedLcs> getAllIssuedLcs() {
        return issuedLcRepository.findAll();
    }

    public IssuedLcs getIssuedLcById(Long id) {
        return issuedLcRepository.findById(id).orElse(null);
    }

    public IssuedLcs saveIssuedLc(IssuedLcs issuedLc) {
        return issuedLcRepository.save(issuedLc);
    }

    public void deleteIssuedLc(Long id) {
        issuedLcRepository.deleteById(id);
    }
}