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

import pdg.dto.mapper.ICoacheeMapper;

import pdg.modelo.*;

import pdg.modelo.dto.CoacheeDTO;

import pdg.presentation.businessDelegate.IBusinessDelegatorView;

import java.util.List;


@RestController
@RequestMapping("/coachee")
public class CoacheeRestController {
    private static final Logger log = LoggerFactory.getLogger(CoacheeRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICoacheeMapper coacheeMapper;

    @PostMapping(value = "/saveCoachee")
    public void saveCoachee(@RequestBody
    CoacheeDTO coacheeDTO) throws Exception {
        try {
            Coachee coachee = coacheeMapper.coacheeDTOToCoachee(coacheeDTO);

            businessDelegatorView.saveCoachee(coachee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCoachee/{idCoachee}")
    public void deleteCoachee(@PathVariable("idCoachee")
    Double idCoachee) throws Exception {
        try {
            Coachee coachee = businessDelegatorView.getCoachee(idCoachee);

            businessDelegatorView.deleteCoachee(coachee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCoachee/")
    public void updateCoachee(@RequestBody
    CoacheeDTO coacheeDTO) throws Exception {
        try {
            Coachee coachee = coacheeMapper.coacheeDTOToCoachee(coacheeDTO);

            businessDelegatorView.updateCoachee(coachee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCoachee")
    public List<CoacheeDTO> getDataCoachee() throws Exception {
        try {
            return businessDelegatorView.getDataCoachee();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCoachee/{idCoachee}")
    public CoacheeDTO getCoachee(@PathVariable("idCoachee")
    Double idCoachee) throws Exception {
        try {
            Coachee coachee = businessDelegatorView.getCoachee(idCoachee);

            return coacheeMapper.coacheeToCoacheeDTO(coachee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
