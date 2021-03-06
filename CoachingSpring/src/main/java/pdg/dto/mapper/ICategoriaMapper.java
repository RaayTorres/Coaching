package pdg.dto.mapper;

import pdg.modelo.Categoria;

import pdg.modelo.dto.CategoriaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICategoriaMapper {
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria)
        throws Exception;

    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO)
        throws Exception;

    public List<CategoriaDTO> listCategoriaToListCategoriaDTO(
        List<Categoria> categorias) throws Exception;

    public List<Categoria> listCategoriaDTOToListCategoria(
        List<CategoriaDTO> categoriaDTOs) throws Exception;
}
