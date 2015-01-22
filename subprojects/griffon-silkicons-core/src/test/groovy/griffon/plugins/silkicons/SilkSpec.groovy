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
package griffon.plugins.silkicons

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andres Almiray
 */
class SilkSpec extends Specification {
    @Unroll("Description '#desc' is invalid")
    def "Invalid silk description"() {
        when:
        Silk.findByDescription(desc)

        then:
        thrown(IllegalArgumentException)

        where:
        desc  | _
        null  | _
        ''    | _
        ' '   | _
        'foo' | _
    }

    @Unroll('Icon #icon can be resolved')
    def 'Validate all Silk icons'() {
        expect:
        silk.asResource()
        silk.description == silk.toString().toLowerCase()

        where:
        silk << Silk.values()
    }
}
