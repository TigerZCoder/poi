
/* ====================================================================
   Copyright 2002-2004   Apache Software Foundation

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
        
package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/**
 * <p>This exception is thrown if HPSF encounters a variant type that isn't
 * supported yet. Although a variant type is unsupported the value can still be
 * retrieved using the {@link #getValue} method.</p>
 * 
 * <p>Obviously this class should disappear some day.</p>
 *
 * @author Rainer Klute <a
 * href="mailto:klute@rainer-klute.de">&lt;klute@rainer-klute.de&gt;</a>
 * @since 2003-08-05
 * @version $Id$
 */
public abstract class UnsupportedVariantTypeException extends HPSFException
{

    private Object value;

    private long variantType;



    /**
     * <p>Constructor.</p>
     * 
     * @param variantType The unsupported variant type
     * @param value The value who's variant type is not yet supported
     */
    public UnsupportedVariantTypeException(final long variantType,
                                           final Object value)
    {
        super("HPSF does not yet support the variant type " + variantType + 
              " (" + Variant.getVariantName(variantType) + ", " +
              HexDump.toHex(variantType) + "). If you want support for " +
              "this variant type in one of the next POI releases please " +
              "submit a request for enhancement (RFE) to " +
              "<http://nagoya.apache.org/bugzilla/>! Thank you!");
        this.variantType = variantType;
        this.value = value;
    }



    /**
     * <p>Returns the offending variant type.</p>
     *
     * @return the offending variant type.
     */
    public long getVariantType()
    {
        return variantType;
    }



    /**
     * <p>Return the value who's variant type is not yet supported.</p>
     *
     * @return the value who's variant type is not yet supported
     */
    public Object getValue()
    {
        return value;
    }

}
