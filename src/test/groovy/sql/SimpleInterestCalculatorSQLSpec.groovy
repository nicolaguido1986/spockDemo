package sql

import com.example.demo.examples.SimpleInterestCalculator
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static groovy.sql.Sql.newInstance

class SimpleInterestCalculatorSQLSpec extends Specification {

    @Shared
            sql = newInstance("jdbc:h2:mem", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table calcdata (id int primary key, year integer, interest decimal, amt integer)")
        sql.execute("insert into calcdata values(1, 2, 1000.0, 10000), (2,5,25.0,100)")
    }

    @Unroll
    def "showing off var list in calc"() {
        def calc = SimpleInterestCalculator(rate: 0.5)

        expect:
        interest == calc.calculate(amt, year)

        where:
        [year, interest, amt] << sql.row("""select year, interest, amt from calcdata""")

    }
}
