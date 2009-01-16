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
import com.augcampos.core.storage.n501070324_BinStorage;

//~--- JDK imports ------------------------------------------------------------

import java.util.LinkedList;

/**
 * <b>Class description:</b><br>
 * This handles the list of PostosTrabalho and his storage.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_PostosTrabalho extends n501070324_BinStorage {

    private LinkedList<n501070324_PostoTrabalho> listPostosTrabalho = new LinkedList<n501070324_PostoTrabalho>();
    private int nextID = Integer.MIN_VALUE;

    /**
     *  Constructs a new Intervencoes handler.
     */
    public n501070324_PostosTrabalho() {
        super("Postos_trab.dat");
    }

    /**
     * Get the list of all elements PostoTrabalho.
     * @return A linkedlist of all elements.
     */
    public LinkedList<n501070324_PostoTrabalho> getList() {
        return listPostosTrabalho;
    }

        /**
     *
     * Look up a PostoTrabalho in the list.
     * @param id to find in the list of PostoTrabalho.
     * @return  - Element PostoTrabalho.<br>
     *          - Null if not found.
     */
    public n501070324_PostoTrabalho getPostoTrabalho(int id) {
        for (n501070324_PostoTrabalho p : getList()) {
            if (p.getNumero() == id) {
                return p;
            }
        }

        return null;    // not found
    }

    /**
     * Add a PostoTrabalho to the list.
     * Note: If PostoTrabalho as Numero not define will be auto generated
     * @param pt PostoTrabalho to be add to the list
     */
    public void add(n501070324_PostoTrabalho pt) {
        if (pt.getNumero() == Integer.MIN_VALUE) {
            pt.setNumero(++nextID);
        } else {
            if (pt.getNumero() > nextID) {
                nextID = pt.getNumero();
            }
        }

        listPostosTrabalho.add(pt);
    }

    /**
     * Removes a PostoTrabalho from the list.
     * @param posto to be removed
     */
    public void remove(n501070324_PostoTrabalho posto) {
        listPostosTrabalho.remove(posto);
    }

    /**
     * Loads all data from the storage
     */
    public void load() {
        listPostosTrabalho.clear();

        for (Object object : super.storageLoad()) {
            add((n501070324_PostoTrabalho) object);
        }
    }

    /**
     * Saves the list to storage.
     */
    public void save() {
        super.storageSave(listPostosTrabalho.toArray());
    }
}



