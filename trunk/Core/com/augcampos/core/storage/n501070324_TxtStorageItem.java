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

/**
 * <b>Interface description:</b><br>
 * This interface is required for storage in text format.
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public interface n501070324_TxtStorageItem {

    /**
     * Allows to parse a object of the text file.
     *
     * @param obj Object to parse.
     */
    public void parse(Object obj);

    /**
     * Allows to encode in to a line is the text file.
     *
     * @return String Encoded text line.
     */
    public String encode();
}



