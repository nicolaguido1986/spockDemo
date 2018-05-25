import com.example.demo.examples.SimpleInterestCalculator
import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class SimpleInterestCalculatorSpec extends Specification{

    def "interest rate calcs with Simple calculator"(){
        given:
        @Subject
        def calc = new SimpleInterestCalculator()
        calc.rate = 0.05

        when:
        def result = calc.calculate(10000, 2)

        then:
        result == 1000
    }

    def "showing off vars in calc"() {
        given:
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest = 1000.0
        amt = 10000
        year = 2
    }

    @Unroll("int: #interest amt: #amt year: #year")
    def "showing off vars list in calc"() {
        given:
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest    | amt   | year
        1000.0      |10000   | 2
        25.0        |100    | 5
    }

    @FailsWith(IllegalArgumentException)
    def "failure example on cal"(){
        def calc = new SimpleInterestCalculator(rate: 0.05)
        when:
        calc.calculate(10000, -1)
        then:
        calc.rate == 0.04
    }


}
