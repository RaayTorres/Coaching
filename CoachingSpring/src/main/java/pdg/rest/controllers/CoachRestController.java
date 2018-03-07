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

import pdg.dto.mapper.ICoachMapper;

import pdg.modelo.*;

import pdg.modelo.dto.CoachDTO;

import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.util.List;


@RestController
@RequestMapping("/coach")
public class CoachRestController {
    private static final Logger log = LoggerFactory.getLogger(CoachRestController.class);
    @Autowired
    private IBusinessDelegate businessDelegatorView;
    @Autowired
    private ICoachMapper coachMapper;

    @PostMapping(value = "/saveCoach")
    public void saveCoach(@RequestBody
    CoachDTO coachDTO) throws Exception {
        try {
            Coach coach = coachMapper.coachDTOToCoach(coachDTO);

            businessDelegatorView.saveCoach(coach);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCoach/{idCoach}")
    public void deleteCoach(@PathVariable("idCoach")
    Double idCoach) throws Exception {
        try {
            Coach coach = businessDelegatorView.getCoach(idCoach);

            businessDelegatorView.deleteCoach(coach);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCoach/")
    public void updateCoach(@RequestBody
    CoachDTO coachDTO) throws Exception {
        try {
            Coach coach = coachMapper.coachDTOToCoach(coachDTO);

            businessDelegatorView.updateCoach(coach);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCoach")
    public List<CoachDTO> getDataCoach() throws Exception {
        try {
            return businessDelegatorView.getDataCoach();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCoach/{idCoach}")
    public CoachDTO getCoach(@PathVariable("idCoach")
    Double idCoach) throws Exception {
        try {
            Coach coach = businessDelegatorView.getCoach(idCoach);

            return coachMapper.coachToCoachDTO(coach);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
