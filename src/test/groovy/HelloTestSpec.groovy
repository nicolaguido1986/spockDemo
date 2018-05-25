import spock.lang.Specification
import spock.lang.Unroll

class HelloTestSpec extends Specification {

//    //feature methods
//    def "pushing an element on the stack"() {
//        setup: "setup and initialization of..."
//        def stack = new Stack()
//        def elem = "push me"
//
//        when: //stimulus
//        stack.push(elem)
//
//        then: //response
//        !stack.empty
//        stack.size() == 1
//        stack.peek() == elem
//
//        when:
//        stack.pop()
//
//        then:
//        thrown(EmptyStackException)
//        stack.empty()
//
//        when:
//        stack.pop()
//
//        then:
//        EmptyStackException e = thrown()
//        e.cause == null
//
//    }

    @Unroll
    def "computing the maximum of two numbers (#a, #b)"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
        5 | 9 | 9
    }

    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        map.get(null) == "elem"
    }

    //helper methods
    def matchesPreferredConfigurationB(pc){
        pc.vendor == "Sunny" && pc.clockRate >=2333
    }

    void matchesPreferredConfiguration(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
    }

}
