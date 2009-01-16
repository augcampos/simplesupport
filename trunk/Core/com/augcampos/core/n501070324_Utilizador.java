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
 * This class implements the representation of Utilizador.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_Utilizador extends n501070324_Pessoa {

     /** Constant of Tipo Utilizador. **/
    public static char        COD_TIPO         = 'U';
    private static final long serialVersionUID = 2000L;

    /**
     * Constructs a new Utilizador handler.
     */
    public n501070324_Utilizador() {
        this.setTipo(COD_TIPO);
    }
}



