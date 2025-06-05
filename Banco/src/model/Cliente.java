package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
  private static final long serialVersionUID = 1L;
  private String cpf;
  private String nome;
  private ArrayList<Conta> contas;

  public Cliente(String cpf, String nome) {
    this.cpf = cpf;
    this.nome = nome;
  }

  public Cliente(String cpf) {
    this.cpf = cpf;
  }

  public Conta localizarConta(String cpf) {
    Conta contaTemp = new Conta(cpf);
    int index = contas.indexOf(contaTemp);
    if (index != -1) {
      return contas.get(index);
    }
    return null;
  }

  public void adicionarConta(Conta conta) {
    Conta contaTemp = localizarConta(conta.getNumero());
    int index = contas.indexOf(contaTemp);
    if (index == -1) {
      contas.add(conta);
    }
  }

  public void removerConta(String numero) {
    Conta contaTemp = localizarConta(numero);
    int index = contas.indexOf(contaTemp);
    if (index != -1) {
      contas.remove(index);
    }
  }

  public void atualizarConta(Conta conta) {
    Conta contaTemp = localizarConta(conta.getNumero());
    int index = contas.indexOf(contaTemp);
    if (index != -1) {
      contas.add(index, conta);
    }
  }

  @Override
  public String toString() {
    return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    } else if (!cpf.equals(other.cpf))
      return false;
    return true;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Conta> getContas() {
    ArrayList<Conta> contas = this.contas;
    return contas;
  }
}
