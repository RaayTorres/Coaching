//package pdg.rest.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import pdg.dto.mapper.ICategoriaMapper;
//
//import pdg.modelo.*;
//
//import pdg.modelo.dto.CategoriaDTO;
//
//import pdg.presentation.businessDelegate.IBusinessDelegate;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/categoria")
//public class CategoriaRestController {
//    private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);
//    @Autowired
//    private IBusinessDelegate businessDelegatorView;
//    @Autowired
//    private ICategoriaMapper categoriaMapper;
//
//    @PostMapping(value = "/saveCategoria")
//    public void saveCategoria(@RequestBody
//    CategoriaDTO categoriaDTO) throws Exception {
//        try {
//            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
//
//            businessDelegatorView.saveCategoria(categoria);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @DeleteMapping(value = "/deleteCategoria/{idCat}")
//    public void deleteCategoria(@PathVariable("idCat")
//    Double idCat) throws Exception {
//        try {
//            Categoria categoria = businessDelegatorView.getCategoria(idCat);
//
//            businessDelegatorView.deleteCategoria(categoria);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @PutMapping(value = "/updateCategoria/")
//    public void updateCategoria(@RequestBody
//    CategoriaDTO categoriaDTO) throws Exception {
//        try {
//            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
//
//            businessDelegatorView.updateCategoria(categoria);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @GetMapping(value = "/getDataCategoria")
//    public List<CategoriaDTO> getDataCategoria() throws Exception {
//        try {
//            return businessDelegatorView.getDataCategoria();
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @GetMapping(value = "/getCategoria/{idCat}")
//    public CategoriaDTO getCategoria(@PathVariable("idCat")
//    Double idCat) throws Exception {
//        try {
//            Categoria categoria = businessDelegatorView.getCategoria(idCat);
//
//            return categoriaMapper.categoriaToCategoriaDTO(categoria);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//
//        return null;
//    }
//}
