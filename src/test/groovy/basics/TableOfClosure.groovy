package basics

import spock.lang.Specification
import spock.lang.Unroll

class TableOfClosure extends Specification {

    @Unroll
    def "closure calling example"() {
        when:
        def value = example.replace('e', 'a')

        then:
        check.call(value)

        where:
        example  | check
        "test"   | { it.contains('a') }
        "testee" | { String s -> s.toCharArray().findAll({ it == 'a' }).size() == 3 }
    }

}
