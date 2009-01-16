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

//~--- JDK imports ------------------------------------------------------------

import java.util.Scanner;

/**
 * <b>Class description:</b><br>
 * Implements the specific part of a Pedido Suporte Formacao
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_PedidoSuporteFormacao extends n501070324_PedidoAssistencia {
    /** Constant of Tipo PedidoSuporteFormacao. **/
    public static char COD_TIPO = 'F';
    private String     Tema;

    /**
     * Constructs a new Pedido Suporte Formacao.
     */
    public n501070324_PedidoSuporteFormacao() {
        this.setTipo(COD_TIPO);
    }

    /**
     * Gets Tema of PedidoSuporteFormacao.
     * @return the Tema
     */
    public String getTema() {
        return Tema;
    }

    /**
     * Sets Tema for PedidoSuporteFormacao.
     * @param Tema the Tema to set
     */
    public void setTema(String Tema) {
        this.Tema = Tema;
    }

    @Override
    public void parse(Object obj) {
        String  str     = (String) obj;
        Scanner scanner = new Scanner(str);

        super.sub_parse(scanner);
        this.setTema(n501070324_Base64.decode(scanner.next()));
    }

    @Override
    public String encode() {
        StringBuilder sb = new StringBuilder(super.sub_encode());

        sb.append(n501070324_Base64.encode(getTema()));

        return sb.toString();
    }

    @Override
    public String toString() {
        return "" + getNumero() + " - (" + n501070324_PedidoSuporteFormacao.COD_TIPO + ") ";
    }
}



