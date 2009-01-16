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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Class description:</b><br>
 * This class has the resposability to ahandle the Storage in Text format
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_TxtStorage extends n501070324_Storage {

    /**
     * Constructs an Text file storage handler.
     *
     * @param filename  Name of the file.
     */
    protected n501070324_TxtStorage(String filename) {
        super(filename);
    }

    /**
     * Load all objects from the file.
     *
     * @return  Object[] - Array of all objects load from the file.
     */
    @Override
    protected Object[] storageLoad() {
        LinkedList<Object> rt = new LinkedList<Object>();

        try {
            Scanner scanner = new Scanner(file);

            try {
                while (scanner.hasNextLine()) {
                    rt.add(scanner.nextLine());
                }
            } finally {
                scanner.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return rt.toArray();
    }

    /**
     * Save all objs in the file.
     *
     * @param objs Object[] - Array of objects to store.
     */
    @Override
    protected void storageSave(Object[] objs) {
        Writer output = null;

        try {
            output = new BufferedWriter(new FileWriter(file));

            try {
                for (Object object : objs) {
                    n501070324_TxtStorageItem tsi = (n501070324_TxtStorageItem) object;

                    output.write(tsi.encode());
                    output.write("\n");
                }
            } finally {
                output.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(n501070324_TxtStorage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(n501070324_TxtStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}



