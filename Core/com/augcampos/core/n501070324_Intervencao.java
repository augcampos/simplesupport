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
 * Class Representation of the Intervenção.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 *
 */
public class n501070324_Intervencao implements n501070324_TxtStorageItem {

    private Date data = new Date();
    private String descricao;
    private int duracao;
    private int numero;
    private int pedidoSuporte;
    private boolean resolvido;
    private int tecnico;

    @Override
    public void parse(Object obj) {
        String str = (String) obj;
        Scanner scanner = new Scanner(str);

        setPedidoSuporte(scanner.nextInt());
        setNumero(scanner.nextInt());
        setData(new Date(scanner.nextLong()));
        setDescricao(n501070324_Base64.decode(scanner.next()));
        setTecnico(scanner.nextInt());
        setDuracao(scanner.nextInt());
        setResolvido(scanner.nextBoolean());
    }

    @Override
    public String encode() {
        StringBuilder sb = new StringBuilder();

        sb.append(getPedidoSuporte()).append(" ");
        sb.append(getNumero()).append(" ");
        sb.append(getData().getTime()).append(" ");
        sb.append(n501070324_Base64.encode(getDescricao())).append(" ");
        sb.append(getTecnico()).append(" ");
        sb.append(getDuracao()).append(" ");
        sb.append(isResolvido());

        return sb.toString();
    }

    /**
     * The date of the Intervenção
     * @return The date of the Intervenção
     */
    public Date getData() {
        return data;
    }

    /**
     * String reprsentation of Data.
     * @return String reprsentation of Data
     * @see #getData()
     */
    public String getDataStr() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm");

        return df.format(getData());
    }

    /**
     * Sets the Data for the Intervenção.
     * @param data for the Intervenção
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Descrição of the Intervenção.
     * @return Srting The Descrição of the Intervenção.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets Descrição for the Intervenção.
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Duração of the Intervenção in Hours.
     * @return Duração of the Intervenção.
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Sets Duração for the Intervenção.
     * @param duracao  Duração for the Intervenção.
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Numero for the Intervenção
     * @return Numero for the Intervenção
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets Numero for the Intervenção
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Pedido Suporte of the Intervenção.
     * @return Pedido Suporte of the Intervenção.
     */
    public int getPedidoSuporte() {
        return pedidoSuporte;
    }

    /**
     * Sets Pedido Suporte for the Intervenção.
     * @param pedidoSuporte Pedido Suporte for the Intervenção.
     */
    public void setPedidoSuporte(int pedidoSuporte) {
        this.pedidoSuporte = pedidoSuporte;
    }

    /**
     * Resolvido of the Intervenção.
     * @return Resolvido of the Intervenção.
     */
    public boolean isResolvido() {
        return resolvido;
    }

    /**
     * Sets Resolvido for the Intervenção.
     * @param resolvido the resolvido to set.
     */
    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    /**
     * Tecnico of the Intervenção
     * @return the tecnico
     */
    public int getTecnico() {
        return tecnico;
    }

    /**
     * Sets Tecnicofor the Intervenção
     * @param tecnico the tecnico to set
     */
    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }
}



