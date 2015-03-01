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
package griffon.swing.support.silkicons;

import griffon.plugins.silkicons.Silk;

import javax.annotation.Nonnull;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.net.URL;

import static griffon.util.GriffonNameUtils.requireNonBlank;
import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class SilkIcon extends ImageIcon {
    private static final String ERROR_SILK_NULL = "Argument 'silk' must not be null";
    private Silk silk;

    public SilkIcon() {
        this(Silk.STAR);
    }

    public SilkIcon(@Nonnull Silk silk) {
        super(toURL(silk));
        this.silk = silk;
    }

    public SilkIcon(@Nonnull String description) {
        this(Silk.findByDescription(description));
    }

    @Nonnull
    private static URL toURL(@Nonnull Silk silk) {
        requireNonNull(silk, ERROR_SILK_NULL);
        String resource = silk.asResource();
        return Thread.currentThread().getContextClassLoader().getResource(resource);
    }

    @Nonnull
    public Silk getSilk() {
        return silk;
    }

    public void setSilk(@Nonnull Silk silk) {
        this.silk = requireNonNull(silk, ERROR_SILK_NULL);
        setImage(Toolkit.getDefaultToolkit().getImage(toURL(silk)));
    }

    public void setSilk(@Nonnull String description) {
        requireNonBlank(description, "Argument 'description' must not be blank");
        setSilk(Silk.findByDescription(description));
    }
}
