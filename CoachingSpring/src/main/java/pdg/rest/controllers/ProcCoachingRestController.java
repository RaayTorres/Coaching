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

import pdg.dto.mapper.IProcCoachingMapper;

import pdg.modelo.*;

import pdg.modelo.dto.ProcCoachingDTO;

import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.util.List;


@RestController
@RequestMapping("/procCoaching")
public class ProcCoachingRestController {
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingRestController.class);
    @Autowired
    private IBusinessDelegate businessDelegatorView;
    @Autowired
    private IProcCoachingMapper procCoachingMapper;

    @PostMapping(value = "/saveProcCoaching")
    public void saveProcCoaching(@RequestBody
    ProcCoachingDTO procCoachingDTO) throws Exception {
        try {
            ProcCoaching procCoaching = procCoachingMapper.procCoachingDTOToProcCoaching(procCoachingDTO);

            businessDelegatorView.saveProcCoaching(procCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteProcCoaching/{idProc}")
    public void deleteProcCoaching(@PathVariable("idProc")
    Double idProc) throws Exception {
        try {
            ProcCoaching procCoaching = businessDelegatorView.getProcCoaching(idProc);

            businessDelegatorView.deleteProcCoaching(procCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateProcCoaching/")
    public void updateProcCoaching(@RequestBody
    ProcCoachingDTO procCoachingDTO) throws Exception {
        try {
            ProcCoaching procCoaching = procCoachingMapper.procCoachingDTOToProcCoaching(procCoachingDTO);

            businessDelegatorView.updateProcCoaching(procCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataProcCoaching")
    public List<ProcCoachingDTO> getDataProcCoaching()
        throws Exception {
        try {
            return businessDelegatorView.getDataProcCoaching();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getProcCoaching/{idProc}")
    public ProcCoachingDTO getProcCoaching(@PathVariable("idProc")
    Double idProc) throws Exception {
        try {
            ProcCoaching procCoaching = businessDelegatorView.getProcCoaching(idProc);

            return procCoachingMapper.procCoachingToProcCoachingDTO(procCoaching);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
