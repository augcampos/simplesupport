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
 * This handles the list of PedidoAssistencia and his storage.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_PedidosAssistencia extends n501070324_TxtStorage {
    private LinkedList<n501070324_PedidoAssistencia> listPedidosAssistencia =
        new LinkedList<n501070324_PedidoAssistencia>();
    private int nextID = 0;

    /**
     *  Constructs a new PedidoAssistencia.
     */
    public n501070324_PedidosAssistencia() {
        super("Pedidos.txt");
    }

    /**
     *
     * Get the list of all elements PedidoAssistencia.
     * @return A linkedlist of all elements.
     */
    @SuppressWarnings({ "unchecked" })
    public LinkedList<n501070324_PedidoAssistencia> getList() {
        return listPedidosAssistencia;
    }

    /**
     *
     * Look up a PedidoAssistencia in the list.
     * @param id to find in the list of PedidoAssistencia.
     * @return  - Element PedidoAssistencia.<br>
     *          - Null if not found.
     */
    public n501070324_PedidoAssistencia getPedido(int id) {
        for (n501070324_PedidoAssistencia p : getList()) {
            if (p.getNumero() == id) {
                return p;
            }
        }

        return null;    // not found
    }

    /**
     * Add a PedidoAssistencia to the list.
     * Note: If PedidoAssistencia as Numero nor define will be auto generated
     * @param assistencia to be add to the list
     */
    public void add(n501070324_PedidoAssistencia assistencia) {
        if (assistencia.getNumero() == Integer.MIN_VALUE) {
            assistencia.setNumero(++nextID);
        } else {
            if (assistencia.getNumero() > nextID) {
                nextID = assistencia.getNumero();
            }
        }

        listPedidosAssistencia.add(assistencia);
    }

    /**
     * Removes a PedidoAssistencia from the list.
     * @param assistencia to be removed
     */
    public void remove(n501070324_PedidoAssistencia assistencia) {
        listPedidosAssistencia.remove(assistencia);
    }

    /**
     * Loads all data from the storage.
     */
    public void load() {
        listPedidosAssistencia.clear();

        for (Object object : super.storageLoad()) {
            char type = ((String) object).charAt(0);

            if (type == n501070324_PedidoSuporteFormacao.COD_TIPO) {
                n501070324_PedidoSuporteFormacao psf = new n501070324_PedidoSuporteFormacao();

                psf.parse(object);
                add(psf);
            }

            if (type == n501070324_PedidoSuporteSistema.COD_TIPO) {
                n501070324_PedidoSuporteSistema pss = new n501070324_PedidoSuporteSistema();

                pss.parse(object);
                add(pss);
            }
        }
    }

    /**
     * Saves the list to storage.
     */
    public void save() {
        super.storageSave(listPedidosAssistencia.toArray());
    }
}



