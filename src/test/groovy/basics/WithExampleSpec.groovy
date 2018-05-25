package basics

import com.example.demo.examples.Account
import spock.lang.Specification

class WithExampleSpec extends Specification{
    def "working with with"() {
        def account = new Account(accountNo: "123", balance: 50.0)

        expect:
        with(account){
            accountNo == "123"
            balance == 50.0
        }
    }
}
