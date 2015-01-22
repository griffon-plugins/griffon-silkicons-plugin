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
package griffon.javafx.support.silkicons;

import griffon.plugins.silkicons.Silk;
import javafx.scene.image.Image;

import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class SilkIcon extends Image {
    private final Silk silk;

    public SilkIcon(@Nonnull Silk silk) {
        super(toURL(silk), true);
        this.silk = silk;
    }

    public SilkIcon(@Nonnull String description) {
        this(Silk.findByDescription(description));
    }

    @Nonnull
    private static String toURL(@Nonnull Silk silk) {
        requireNonNull(silk, "Argument 'silk' must not be null.");
        String resource = silk.asResource();
        return Thread.currentThread().getContextClassLoader().getResource(resource).toExternalForm();
    }

    @Nonnull
    public Silk getSilk() {
        return silk;
    }
}