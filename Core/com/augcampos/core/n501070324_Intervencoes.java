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

import com.augcampos.core.storage.n501070324_TxtStorage;

//~--- JDK imports ------------------------------------------------------------

import java.util.LinkedList;

/**
 * <b>Class description:</b><br>
 * This handles the list of Intervenções and his storage.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_Intervencoes extends n501070324_TxtStorage {
    private LinkedList<n501070324_Intervencao> listIntervencoes = new LinkedList<n501070324_Intervencao>();
    private int nextID = 0;

    /**
     *  Constructs a new Intervencoes handler.
     */
    public n501070324_Intervencoes() {
        super("Intervencoes.txt");
    }

    /**
     * Get the list of all elements Intervencao.
     * @return A linkedlist of all elements.
     */
    @SuppressWarnings({ "unchecked" })
    public LinkedList<n501070324_Intervencao> getList() {
        return listIntervencoes;
    }


    /**
     *
     * Look up a Intervencao in the list.
     * @param id to find in the list of Intervencao.
     * @return  - Element Intervencao.<br>
     *          - Null if not found.
     */
    public n501070324_Intervencao geIntervencao(int id) {
        for (n501070324_Intervencao p : getList()) {
            if (p.getNumero() == id) {
                return p;
            }
        }

        return null;    // not found
    }

    /**
     *  Get the list of all elements Intervencao for a specific Pedido Suporte.
     * @param pedidoSuporte Id od pedido Suporte
     * @return Linked List of Intervencao of the pedidoSuporte.
     */
    public LinkedList<n501070324_Intervencao> getList(int pedidoSuporte) {
        LinkedList<n501070324_Intervencao> tmp = new LinkedList<n501070324_Intervencao>();

        for (n501070324_Intervencao intervencao : getList()) {
            if (intervencao.getPedidoSuporte() == pedidoSuporte) {
                tmp.add(intervencao);
            }
        }

        return tmp;
    }

    /**
     * Add a Intervencao to the list.
     * Note: If Intervencao is resolved and the pedido suport alredu has one Intervencao resolved the previou will be makted as no resolved.
     * @param intervencao to be add to the list
     */
    public void add(n501070324_Intervencao intervencao) {
        intervencao.setNumero(++nextID);

        if (intervencao.isResolvido()) {
            checkResolvido(intervencao.getPedidoSuporte());
        }

        listIntervencoes.add(intervencao);
    }

    /**
     * Removes a Intervencao from the list.
     * @param intervencao to be removed
     */
    public void remove(n501070324_Intervencao intervencao) {
        listIntervencoes.remove(intervencao);
    }

    /**
     * Loads all data from the storage
     */
    public void load() {
        listIntervencoes.clear();

        for (Object object : super.storageLoad()) {
            n501070324_Intervencao psf = new n501070324_Intervencao();

            psf.parse(object);
            add(psf);
        }
    }

    /**
     * Saves the list to storage.
     */
    public void save() {
        super.storageSave(listIntervencoes.toArray());
    }

    /**
     * checks if a pedido suporte has a Intervention resolvido.
     * @param pedidoSuporte
     */
    private void checkResolvido(int pedidoSuporte) {
        for (n501070324_Intervencao intervencao : getList(pedidoSuporte)) {
            intervencao.setResolvido(false);
        }
    }
}



