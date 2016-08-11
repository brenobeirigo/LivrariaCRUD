package livrariacrud;

import dao.LivrariaDAOException;
import dao.LivrariaDao;
import java.util.List;
import model.Livro;

/**
 *
 * @author BBEIRIGO
 */
public class LivrariaCRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LivrariaDAOException {
        //Cria objeto DAO
        LivrariaDao dao = new LivrariaDao();

        //Cria objetos Livro
        Livro livro1 = new Livro(1, "Bíblia", 1000, 2012, "Palavra de Deus.");
        Livro livro2 = new Livro(2, "A Revolta de Atlas", 10, 2016, "Quem é John Galt?");
        Livro livro3 = new Livro(3, "As seis lições", 3, 2010, "Capitalismo - Socialismo - Intervencionismo - Inflação - Investimento Estrangeiro - Política e Idéias.");

        //Salva os objetos Livro
        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        //Listar todos os livros
        System.out.println("LISTA DE LIVROS:");
        for (Livro l : (List<Livro>) dao.todosLivros()) {
            System.out.println(l);
            l.getIsbn();
        }
        
        //Procura livro com isbn 1
        Livro livroId1 = dao.procurarLivro(1);
        System.out.println("Livro de ID = 1:");
        System.out.println(livroId1);
        
        //Procura livro com isbn 1
        dao.excluir(livroId1);
        System.out.println("LISTA DE LIVROS APÓS EXCLUSÃO DO LIVRO DE ID=1:");
        for (Livro l : (List<Livro>) dao.todosLivros()) {
            System.out.println(l);
            l.getIsbn();
        }
    }
}
