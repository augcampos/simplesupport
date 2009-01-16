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



package com.augcampos.core.storage;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

/**
 * Class description
 * Storage file Handler.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public abstract class n501070324_Storage {

    /** Field   File    File - File handler. */
    protected File file = null;

    /**
     * Constructs a new Storage file Handler.
     *
     *
     * @param filename  String  Name of the file.
     */
    protected n501070324_Storage(String filename) {
        file = new File(filename);
    }

    /**
     * Loads from file an array of Objects.
     *
     * @return  Object[] - array of objects to stored in the file.
     */
    protected abstract Object[] storageLoad();

    /**
     * Stores the array objs in a file.
     *
     * @param objs  Object[] - array of objects to store.
     */
    protected abstract void storageSave(Object[] objs);
}



