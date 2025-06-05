package model;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Persistencia {
  private ArrayList<Cliente> clientes;
  private static final String ARQUIVO = "dados";

  public Persistencia() {
    clientes = new ArrayList<Cliente>();
  }

  public Cliente localizarCliente(String cpf) {
    Cliente clienteTemp = new Cliente(cpf);
    int index = clientes.indexOf(clienteTemp);
    if (index != -1) {
      return clientes.get(index);
    }
    return null;
  }

  public void adicionarCliente(Cliente cliente) {
    Cliente clienteTemp = localizarCliente(cliente.getCpf());
    int index = clientes.indexOf(clienteTemp);
    if (index == -1) {
      clientes.add(cliente);
      salvarArquivo();
    }
  }

  public void removerCliente(String cpf) {
    Cliente clienteTemp = localizarCliente(cpf);
    int index = clientes.indexOf(clienteTemp);
    if (index != -1) {
      clientes.remove(index);
      salvarArquivo();
    }
  }

  public void atualzarCliente(Cliente cliente) {
    Cliente clienteTemp = localizarCliente(cliente.getCpf());
    int index = clientes.indexOf(clienteTemp);
    if (index != -1) {
      clientes.add(index, cliente);
      salvarArquivo();
    }
  }

  public void salvarArquivo() {
    try (
      FileOutputStream fos = new FileOutputStream(ARQUIVO);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ) {
      oos.writeObject(clientes);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked") // Siginifica que o java não consegue garantir que seja um ArrayList<Cliente>
  public void carregarArquivo() {
    try (
        FileInputStream fis = new FileInputStream(ARQUIVO);
        ObjectInputStream ois = new ObjectInputStream(fis);) {
      Object obj = ois.readObject();
      if (obj != null && obj instanceof ArrayList<?>) {
        clientes = (ArrayList<Cliente>) obj;
      } else {
        clientes = new ArrayList<Cliente>();
      }
    } catch (Exception e) {
      e.printStackTrace();
      clientes = new ArrayList<Cliente>();
    }
  }
}
