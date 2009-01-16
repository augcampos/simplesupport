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

/**
 * <b>Class description:</b><br>
 * This class implements the abstract representation of Tecnico.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_Tecnico extends n501070324_Pessoa {

    /** Constant of Tipo Tecnico. **/
    public static char COD_TIPO = 'T';
    private static final long serialVersionUID = 1000L;

    /**
     * Constructs a new Tecnico handler.
     */
    public n501070324_Tecnico() {
        this.setTipo(COD_TIPO);
    }
}



