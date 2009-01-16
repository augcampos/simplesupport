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
 * Implements the specific part of a PedidoSuporteSistema
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_PedidoSuporteSistema extends n501070324_PedidoAssistencia {

    /** Constant of Tipo PedidoSuporteSistema. **/
    public static char COD_TIPO = 'S';
    private String Descricao;
    private int postoTrabalho;

    /**
     * Constructs a new PedidoSuporteSistema.
     */
    public n501070324_PedidoSuporteSistema() {
        this.setTipo(COD_TIPO);
    }

    /**
     * Gets Posto Trabalho of PedidoSuporteSistema
     * @return the postoTrabalho
     */
    public int getPostoTrabalho() {
        return postoTrabalho;
    }

    /**
     * sets Posto Trabalho for PedidoSuporteSistema
     * @param postoTrabalho the postoTrabalho to set
     */
    public void setPostoTrabalho(int postoTrabalho) {
        this.postoTrabalho = postoTrabalho;
    }

    /**
     * Gets Descrição of PedidoSuporteSistema
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * Sets Descrição for PedidoSuporteSistema
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public void parse(Object obj) {
        String str = (String) obj;
        Scanner scanner = new Scanner(str);

        super.sub_parse(scanner);
        this.setDescricao(n501070324_Base64.decode(scanner.next()));
        this.setPostoTrabalho(scanner.nextInt());
    }

    @Override
    public String encode() {
        StringBuilder sb = new StringBuilder(super.sub_encode());

        sb.append(n501070324_Base64.encode(getDescricao())).append(" ");
        sb.append(getPostoTrabalho());

        return sb.toString();
    }

    @Override
    public String toString() {
        return "" + getNumero() + " - (" + n501070324_PedidoSuporteSistema.COD_TIPO + ") ";
    }
}



