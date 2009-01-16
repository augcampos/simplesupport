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
 * This handles the list of Pessoas and his storage.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_Pessoas extends n501070324_BinStorage {
    private LinkedList<n501070324_Pessoa> listPessoas = new LinkedList<n501070324_Pessoa>();
    private int                           nextUserID  = Integer.MIN_VALUE;
    private int                           nextTecID   = Integer.MIN_VALUE;

    /**
     *  Constructs a new Pessoas handler.
     */
    public n501070324_Pessoas() {
        super("Pessoas.dat");
    }

    /**
     * Get the list of all elements Pessoa.
     * @return A linkedlist of all elements.
     */
    @SuppressWarnings("unchecked")
    public LinkedList<n501070324_Pessoa> getList() {
        return listPessoas;
    }

    /**
     * Get the list of all elements Utilizador in pessoas list.
     * @return A linkedlist of all elements Utilizador.
     */
    public LinkedList<n501070324_Utilizador> getUsers() {
        LinkedList<n501070324_Utilizador> list = new LinkedList<n501070324_Utilizador>();

        for (n501070324_Pessoa p : getList()) {
            if (p instanceof n501070324_Utilizador) {
                list.add((n501070324_Utilizador) p);
            }
        }

        return list;
    }

    /**
     *
     * Look up a Utilizador in the list.
     * @param id to find in the list of Pesoas.
     * @return  - Element Utilizador.<br>
     *          - Null if not found.
     */
    public n501070324_Utilizador getUser(int id) {
        for (n501070324_Pessoa p : listPessoas) {
            if (p instanceof n501070324_Utilizador) {
                if (p.getNumero() == id) {
                    return (n501070324_Utilizador) p;
                }
            }
        }

        return null;    // not found
    }

    /**
     * Get the list of all elements Tecnico in pessoas list.
     * @return A linkedlist of all elements Tecnico.
     */
    public LinkedList<n501070324_Tecnico> getTecnics() {
        LinkedList<n501070324_Tecnico> list = new LinkedList<n501070324_Tecnico>();

        for (n501070324_Pessoa p : getList()) {
            if (p instanceof n501070324_Tecnico) {
                list.add((n501070324_Tecnico) p);
            }
        }

        return list;
    }

    /**
     *
     * Look up a Tecnico in the list.
     * @param id to find in the list of Pesoas.
     * @return  - Element Tecnico.<br>
     *          - Null if not found.
     */
    public n501070324_Tecnico getTecnic(int id) {
        for (n501070324_Pessoa p : listPessoas) {
            if (p instanceof n501070324_Tecnico) {
                if (p.getNumero() == id) {
                    return (n501070324_Tecnico) p;
                }
            }
        }

        return null;    // not found
    }

    /**
     * Add a pessoa to the list.
     * Note: If pessoa as Numero not define will be auto generated
     * @param pessoa to be add to the list
     */
    public void add(n501070324_Pessoa pessoa) {
        if (pessoa.getNumero() == Integer.MIN_VALUE) {
            int nID = 0;

            if (pessoa instanceof n501070324_Utilizador) {
                nID = ++nextUserID;
            }

            if (pessoa instanceof n501070324_Tecnico) {
                nID = ++nextTecID;
            }

            pessoa.setNumero(nID);
        } else {
            if (pessoa instanceof n501070324_Utilizador) {
                if (pessoa.getNumero() > nextUserID) {
                    nextUserID = pessoa.getNumero();
                }
            }

            if (pessoa instanceof n501070324_Tecnico) {
                if (pessoa.getNumero() > nextTecID) {
                    nextTecID = pessoa.getNumero();
                }
            }
        }

        listPessoas.add(pessoa);
    }

    /**
     * Removes a pessoa from the list.
     * @param pessoa to be removed
     */
    public void remove(n501070324_Pessoa pessoa) {
        listPessoas.remove(pessoa);
    }

    /**
     * Loads all data from the storage.
     */
    public void load() {
        listPessoas.clear();

        for (Object object : super.storageLoad()) {
            if (object instanceof n501070324_Tecnico) {
                add((n501070324_Tecnico) object);
            }

            if (object instanceof n501070324_Utilizador) {
                add((n501070324_Utilizador) object);
            }
        }
    }

    /**
     * Saves the list to storage.
     */
    public void save() {
        super.storageSave(listPessoas.toArray());
    }
}



