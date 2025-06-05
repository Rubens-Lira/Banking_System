package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Conta implements Serializable {
  private static final long serialVersionUID = 1L;
  private String numero;
  private BigDecimal saldo;
  private boolean status;
  private LocalDateTime dataCriada;

  public Conta(String numero, BigDecimal saldo, boolean status, LocalDateTime dataCriada) {
    this.numero = numero;
    this.saldo = saldo != null ? saldo : BigDecimal.ZERO;
    this.status = status;
    this.dataCriada = dataCriada != null ? dataCriada : LocalDateTime.now();
  }

  public Conta(String numero) {
    this.numero = numero;
    this.saldo = BigDecimal.ZERO;
    this.dataCriada = LocalDateTime.now();
  }

  public void depositar(BigDecimal quantia) {
    if (status && quantia.compareTo(BigDecimal.ZERO) == 1) {
      saldo = saldo.add(quantia);
    }
  }

  public void sacar(BigDecimal quantia) {
    if (status && quantia.compareTo(BigDecimal.ZERO) == 1 && saldo.compareTo(quantia) != -1) {
      saldo = saldo.subtract(quantia);
    }
  }

  public void transferir(Conta destino, BigDecimal quantia) {
    if (status && destino.isStatus() && quantia.compareTo(BigDecimal.ZERO) == 1 && saldo.compareTo(quantia) != -1) {
      this.sacar(quantia);
      destino.depositar(quantia);
    }
  }

  public void ativvarConta() {
    status = true;
  }

  public void desativvarConta() {
    status = false;
  }

  @Override
  public String toString() {
    return "Conta [numero=" + numero + ", saldo=" + saldo + ", status=" + status + ", dataCriada=" + dataCriada + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
    Conta other = (Conta) obj;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    return true;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public LocalDateTime getDataCriada() {
    return dataCriada;
  }

  public void setDataCriada(LocalDateTime dataCriada) {
    this.dataCriada = dataCriada;
  }
}
