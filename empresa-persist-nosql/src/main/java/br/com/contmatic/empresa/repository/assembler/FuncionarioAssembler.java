package br.com.contmatic.empresa.repository.assembler;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.joda.time.DateTime;

import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.model.Funcionario;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class FuncionarioAssembler.
 */
public class FuncionarioAssembler implements Assembler<Funcionario, Document> {

    /** The contato assembler. */
    private ContatoAssembler contatoAssembler;

    /** The endereco assembler. */
    private EnderecoAssembler enderecoAssembler;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Funcionario toResource(Document document) {
        Funcionario funcionario = null;
        if (document != null) {
            funcionario = new Funcionario();
            contatoAssembler = new ContatoAssembler();
            enderecoAssembler = new EnderecoAssembler();
            funcionario.setComissao(new BigDecimal(document.getDouble("comissao")));
            funcionario.setSalario(new BigDecimal(document.getDouble("salario")));
            funcionario.setDepartamento(document.getString("departamento"));
            funcionario.setCpf(document.getString("cpf"));
            funcionario.setDataNascimento(new DateTime(document.getString("dataNascimento")));
            funcionario.setEmail(document.getString("email"));
            funcionario.setNome(document.getString("nome"));
            funcionario.setSexo(document.getString("sexo"));

            Set<Contato> contatos = new HashSet<Contato>();
            Set<Endereco> enderecos = new HashSet<Endereco>();

            for(Document doc : document.getList("contatos", Document.class)) {
                contatos.add(contatoAssembler.toResource(doc));
            }
            for(Document doc : document.getList("endereco", Document.class)) {
                enderecos.add(enderecoAssembler.toResource(doc));
            }

            funcionario.setEndereco(enderecos);
            funcionario.setContatos(contatos);

        }
        return funcionario;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Funcionario model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
        }
        return document;
    }

}
