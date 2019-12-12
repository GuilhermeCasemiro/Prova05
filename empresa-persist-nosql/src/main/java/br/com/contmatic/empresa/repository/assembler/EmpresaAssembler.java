package br.com.contmatic.empresa.repository.assembler;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;

import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.Empresa;
import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.model.Funcionario;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class EmpresaAssembler.
 */
public class EmpresaAssembler implements Assembler<Empresa, Document> {

    /** The funcionario assembler. */
    private FuncionarioAssembler funcionarioAssembler;

    /** The contato assembler. */
    private ContatoAssembler contatoAssembler;

    /** The endereco assembler. */
    private EnderecoAssembler enderecoAssembler;

    /** The estado assembler. */
    private EstadoAssembler estadoAssembler;

    /** The cidade assembler. */
    private CidadeAssembler cidadeAssembler;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Empresa toResource(Document document) {
        Empresa empresa = null;
        if (document != null) {
            empresa = new Empresa();
            funcionarioAssembler = new FuncionarioAssembler();
            contatoAssembler = new ContatoAssembler();
            enderecoAssembler = new EnderecoAssembler();
            estadoAssembler = new EstadoAssembler();
            cidadeAssembler = new CidadeAssembler();
            empresa.setCnpj(document.getString("_id"));
            empresa.setNomeFantasia(document.getString("nomeFantasia"));
            empresa.setRazaoSocial(document.getString("razaoSocial"));
            Set<Funcionario> funcionarios = new HashSet<>();
            Set<Contato> contatos = new HashSet<>();
            Set<Endereco> enderecos = new HashSet<>();

            for(Document doc : document.getList("funcionarios", Document.class)) {
                funcionarios.add(funcionarioAssembler.toResource(doc));
            }

            for(Document doc : document.getList("contatos", Document.class)) {
                contatos.add(contatoAssembler.toResource(doc));
            }
            for(Document doc : document.getList("enderecos", Document.class)) {
                enderecos.add(enderecoAssembler.toResource(doc));
            }
            empresa.setFuncionarios(funcionarios);
            empresa.setContatos(contatos);
            empresa.setEnderecos(enderecos);
            empresa.setEstado(estadoAssembler.toResource(document));
            empresa.setCidade(cidadeAssembler.toResource(document));

        }
        return empresa;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Empresa model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
            document.remove("cnpj");
            document.append("_id", model.getCnpj());
        }
        return document;
    }

}
