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
import com.augcampos.core.storage.n501070324_TxtStorageItem;

//~--- JDK imports ------------------------------------------------------------

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

/**
 * <b>Class description:</b><br>
 * Abstract class that handles the common feature for the all Pedidos Suporte.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public abstract class n501070324_PedidoAssistencia implements n501070324_TxtStorageItem {

    private int numero = Integer.MIN_VALUE;
    private Date data = new Date();
    private char tipo;
    private int utilizador;

    /**
     * Text Representations of the Object
     * @return string representations of the Object
     */
    @Override
    public abstract String toString();

    /**
     * Gets Numero of PedidoAssistencia
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * sets Numero for PedidoAssistencia
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Get Data for PedidoAssistencia
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * Get Data in string format.
     * @return String the Data as string
     * @see #getData() 
     */
    public String getDataStr() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        return df.format(getData());
    }

    /**
     * Sets Data for PedidoAssistencia
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Gets Utilizador of PedidoAssistencia.
     * @return the utilizador
     */
    public int getUtilizador() {
        return utilizador;
    }

    /**
     * Sets Utilizador for PedidoAssistencia.
     * @param utilizador the utilizador to set
     */
    public void setUtilizador(int utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Gets Tipo Assistencia of PedidoAssistencia.
     *  S - Systema
     *  F - Formação
     * @return the tipo
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * Parses the commom field for PedidoAssistencia
     * @param scanner
     */
    protected void sub_parse(Scanner scanner) {
        scanner.next();    // leap type
        this.setNumero(scanner.nextInt());
        this.setData(new Date(scanner.nextLong()));
        this.setUtilizador(scanner.nextInt());
    }

    /**
     * Sets the tipo of PedidoAssistencia
     * @param tipo the tipo to set
     */
    protected void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * Encodes the commom fields for PedidoAssistencia
     * @return encoded string
     */
    protected String sub_encode() {
        StringBuilder sb = new StringBuilder();

        sb.append(getTipo()).append(" ");
        sb.append(getNumero()).append(" ");
        sb.append(getData().getTime()).append(" ");
        sb.append(getUtilizador()).append(" ");

        return sb.toString();
    }
}



