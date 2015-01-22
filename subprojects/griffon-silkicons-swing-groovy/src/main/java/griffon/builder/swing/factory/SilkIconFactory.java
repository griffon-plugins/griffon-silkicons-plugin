/*
 * Copyright 2014-2015 the original author or authors.
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
package griffon.builder.swing.factory;

import griffon.plugins.silkicons.Silk;
import griffon.swing.support.silkicons.SilkIcon;
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import java.util.Map;

/**
 * @author Andres Almiray
 */
public class SilkIconFactory extends AbstractFactory {
    @Override
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        Object icon = attributes.remove("icon");
        if (icon == null) {
            icon = value;
        }

        if (icon == null) {
            throw new IllegalArgumentException("In " + name + " you must define a node value or icon:");
        }

        if (icon instanceof CharSequence) {
            return new SilkIcon(Silk.findByDescription(icon.toString()));
        } else if (icon instanceof Silk) {
            return new SilkIcon((Silk) icon);
        }

        throw new IllegalArgumentException(name + " cannot parse " + icon + " as a SilkIcon description.");
    }
}
