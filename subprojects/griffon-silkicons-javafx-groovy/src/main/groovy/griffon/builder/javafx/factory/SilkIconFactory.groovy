/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.builder.javafx.factory

import griffon.javafx.support.silkicons.SilkIcon
import griffon.plugins.silkicons.Silk
import groovyx.javafx.factory.LabeledFactory

/**
 * @author Andres Almiray
 */
public class SilkIconFactory extends LabeledFactory {
    SilkIconFactory() {
        super(SilkIcon)
    }

    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        def icon = attributes.remove('icon') ?: value

        if (icon instanceof Silk) {
            return new SilkIcon(icon)
        } else if (icon instanceof CharSequence) {
            return new SilkIcon(Silk.findByDescription(icon.toString()))
        }

        throw new IllegalArgumentException("In $name you must define a node value or icon:")
    }
}
