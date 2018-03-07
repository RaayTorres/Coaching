package pdg.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pdg.dto.mapper.ISesCoachingMapper;

import pdg.modelo.*;

import pdg.modelo.dto.SesCoachingDTO;

import pdg.presentation.businessDelegate.IBusinessDelegatorView;

import java.util.List;


@RestController
@RequestMapping("/sesCoaching")
public class SesCoachingRestController {
    private static final Logger log = LoggerFactory.getLogger(SesCoachingRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISesCoachingMapper sesCoachingMapper;

    @PostMapping(value = "/saveSesCoaching")
    public void saveSesCoaching(@RequestBody
    SesCoachingDTO sesCoachingDTO) throws Exception {
        try {
            SesCoaching sesCoaching = sesCoachingMapper.sesCoachingDTOToSesCoaching(sesCoachingDTO);

            businessDelegatorView.saveSesCoaching(sesCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSesCoaching/{idSesi}")
    public void deleteSesCoaching(@PathVariable("idSesi")
    Double idSesi) throws Exception {
        try {
            SesCoaching sesCoaching = businessDelegatorView.getSesCoaching(idSesi);

            businessDelegatorView.deleteSesCoaching(sesCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSesCoaching/")
    public void updateSesCoaching(@RequestBody
    SesCoachingDTO sesCoachingDTO) throws Exception {
        try {
            SesCoaching sesCoaching = sesCoachingMapper.sesCoachingDTOToSesCoaching(sesCoachingDTO);

            businessDelegatorView.updateSesCoaching(sesCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSesCoaching")
    public List<SesCoachingDTO> getDataSesCoaching() throws Exception {
        try {
            return businessDelegatorView.getDataSesCoaching();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSesCoaching/{idSesi}")
    public SesCoachingDTO getSesCoaching(@PathVariable("idSesi")
    Double idSesi) throws Exception {
        try {
            SesCoaching sesCoaching = businessDelegatorView.getSesCoaching(idSesi);

            return sesCoachingMapper.sesCoachingToSesCoachingDTO(sesCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
