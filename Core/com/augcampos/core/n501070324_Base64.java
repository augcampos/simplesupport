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
 * This class implements the encoder and decoder for text fileds in the text storage.
 *
 * @author Augusto Campos <b>augcampos@augcampos.pt</b>
 */
public class n501070324_Base64 {

    private static String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /**
     * Encode a string in a base64 string representation.
     *
     * @param string string to encode
     * @return String base64 representation.
     */
    public static String encode(String string) {
        String encoded = "";

        // determine how many padding bytes to add to the output
        int paddingCount = (3 - (string.length() % 3)) % 3;

        // add any necessary padding to the input
        string += "\0\0".substring(0, paddingCount);

        // process 3 bytes at a time, churning out 4 output bytes
        // worry about CRLF insertions later
        for (int i = 0; i < string.length(); i += 3) {
            int j = (string.charAt(i) << 16) + (string.charAt(i + 1) << 8) + string.charAt(i + 2);

            encoded = encoded + base64code.charAt((j >> 18) & 0x3f) + base64code.charAt((j >> 12) & 0x3f) + base64code.charAt((j >> 6) & 0x3f) + base64code.charAt(j & 0x3f);
        }

        // replace encoded padding nulls with "="
        return encoded.substring(0, encoded.length() - paddingCount) + "==".substring(0, paddingCount);
    }

    /**
     * Decode a base64 representation into a string.
     * @param base64String base64 Repesenation
     * @return String of the decoded base64
     */
    public static String decode(String base64String) {
        int end = 0;    // end state

        if (base64String.endsWith("=")) {
            end++;
        }

        if (base64String.endsWith("==")) {
            end++;
        }

        int len = (base64String.length() + 3) / 4 * 3 - end;
        byte[] result = new byte[len];
        int dst = 0;

        try {
            for (int src = 0; src < base64String.length(); src++) {
                int code = base64code.indexOf(base64String.charAt(src));

                if (code == -1) {
                    break;
                }

                switch (src % 4) {
                    case 0:
                        result[dst] = (byte) (code << 2);

                        break;

                    case 1:
                        result[dst++] |= (byte) ((code >> 4) & 0x3);
                        result[dst] = (byte) (code << 4);

                        break;

                    case 2:
                        result[dst++] |= (byte) ((code >> 2) & 0xf);
                        result[dst] = (byte) (code << 6);

                        break;

                    case 3:
                        result[dst++] |= (byte) (code & 0x3f);

                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return (new String(result));
    }
}



