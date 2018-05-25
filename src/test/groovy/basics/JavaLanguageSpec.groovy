package basics

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification

class JavaLanguageSpec extends Specification{

    @IgnoreIf({!jvm.java8})
    def "java 8 feature"() {
        def letters = ["A", "B", "C"]

        expect:
        letters.stream().findFirst() != null
    }

    @Requires( {jvm.java8})
    def "java8 feature jav8 requires"() {
        def letters = ["A", "B", "C"]

        expect:
        letters.stream().findFirst() != null
    }

}
