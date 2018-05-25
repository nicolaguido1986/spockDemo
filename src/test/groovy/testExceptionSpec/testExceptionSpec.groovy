package testExceptionSpec

import impl.NotException
import spock.lang.Specification

class testExceptionSpec extends Specification{

    def "test Exception"(){
        when:
        new NotException().thrownException()

        then:
        notThrown(IllegalArgumentException)
    }
}
