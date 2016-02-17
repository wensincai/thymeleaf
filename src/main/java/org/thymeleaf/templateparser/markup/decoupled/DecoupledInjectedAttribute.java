/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.templateparser.markup.decoupled;

import org.thymeleaf.model.IElementAttributes;

/**
 * <p>
 *   Value class used for containing each of the attributes that should be injected during parsing into a
 *   template that is processed with associated <em>decoupled logic</em>.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 * @since 3.0.0
 * 
 */
public final class DecoupledInjectedAttribute {

    private final String name;
    private final IElementAttributes.ValueQuotes valueQuotes;
    private final String value;


    public DecoupledInjectedAttribute(
            final String name, final IElementAttributes.ValueQuotes valueQuotes, final String value) {
        super();
        this.name = name;
        this.valueQuotes = valueQuotes;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public IElementAttributes.ValueQuotes getValueQuotes() {
        return valueQuotes;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(this.name);
        if (this.value != null) {
            strBuilder.append('=');
            final char quoteC =
                    (this.valueQuotes == IElementAttributes.ValueQuotes.DOUBLE? '"' : this.valueQuotes == IElementAttributes.ValueQuotes.SINGLE? '\'' : (char)0x0);
            if (quoteC != (char)0x0) {
                strBuilder.append(quoteC);
            }
            strBuilder.append(this.value);
            if (quoteC != (char)0x0) {
                strBuilder.append(quoteC);
            }
        }
        return strBuilder.toString();
    }


}
