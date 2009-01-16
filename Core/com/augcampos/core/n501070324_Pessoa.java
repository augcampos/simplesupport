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
 * This class implements the abstract representation of Pessoa.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public abstract class n501070324_Pessoa implements n501070324_BinStorageItem {
    private int    numero = Integer.MIN_VALUE;
    private String nome;
    private char   tipo;

    /**
     * Get Numero of Pessoa
     * @return the numeor
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets Numero for Pessoa
     * @param id the id to set
     */
    public void setNumero(int id) {
        this.numero = id;
    }

    /**
     * Gets Nome of Pessoa
     * @return the Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets Nome for Pessoa
     * @param nome the Nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets Tipo from Pessoa
     * @return the Tipo
     */
    public char getTipo() {
        return this.tipo;
    }

    /**
     * Sets Tipo for Pessoa
     * @param tipo to set
     */
    protected void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return getNome();
    }
}



