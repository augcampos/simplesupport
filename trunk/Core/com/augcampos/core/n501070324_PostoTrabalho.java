/**
 *      Copyright 2008 Augusto Campos <b>augcampos&#64augcampos.pt></b><br>
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 3 of the License.
 *      <p>
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      <p>
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */
package com.augcampos.core;

//~--- non-JDK imports --------------------------------------------------------
import com.augcampos.core.storage.n501070324_BinStorageItem;

/**
 * <b>Class description:</b><br>
  * This class implements the representation of PostoTrabalho.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_PostoTrabalho implements n501070324_BinStorageItem {

    private static final long serialVersionUID = 3000L;
    private int numero = Integer.MIN_VALUE;
    private String cpu;
    private String descricao;
    private String disco;
    private String ram;
    private String so;

    /**
     * Get CPU of PostoTrabalho.
     * @return the cpu
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * Sets CPU for PostoTrabalho.
     * @param cpu the cpu to set
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Gets Disco of PostoTrabalho.
     * @return the disco
     */
    public String getDisco() {
        return disco;
    }

    /**
     * Sets Disco for PostoTrabalho.
     * @param disco the disco to set
     */
    public void setDisco(String disco) {
        this.disco = disco;
    }

    /**
     * Gets Numero of PostoTrabalho.
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets Numero for PostoTrabalho.
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Gets RAM of PostoTrabalho.
     * @return the ram
     */
    public String getRam() {
        return ram;
    }

    /**
     * Sets RAM for PostoTrabalho.
     * @param ram the ram to set
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Get Sistema Operativo of PostoTrabalho.
     * @return the so
     */
    public String getSo() {
        return so;
    }

    /**
     * sets Sistema Operativo for PostoTrabalho.
     * @param so the so to set
     */
    public void setSo(String so) {
        this.so = so;
    }

    /**
     * Gets Descrição of PostoTrabalho.
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets Descrição for PostoTrabalho.
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}



