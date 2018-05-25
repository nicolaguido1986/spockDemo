package Mock

import impl.Publisher
import impl.Subscriber
import spock.lang.Specification

class PublisherSpec extends Specification {

    def "events are published to all subscribers"() {
        def subscriber1 = Mock(Subscriber)
        Subscriber subscriber2 = Mock()

        def publisher = new Publisher()

        publisher.add(subscriber1)
        publisher.add(subscriber2)

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event")

        then:
        1 * subscriber2.receive("event")
    }

    def "events are published to all subscribers with closures"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1
        publisher.subscribers << subscriber2

        when:
        publisher.fire("event")

        then:
        1*subscriber1.receive(!null)
        1*subscriber2.receive({a -> a.contains("eve")})
    }

    def "events are published to all subscribers with regex mocking"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1 << subscriber2

        when:
        publisher.fire("event")

        then:
        1 * subscriber1./rec.*/(!null)
        1 * subscriber2.receive(_ as String)

        then:
        0 * _._
    }

    def "events are published to all subscribers with abbr mocking"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher(subscribers: [subscriber1, subscriber2])

        when:
        publisher.fire("event")

        then:
        2 * _.receive("event")
    }

    def "events are published a subscriber throw an exception"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher(subscribers: [subscriber1, subscriber2])

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event") >> {throw new Exception()}

        then:
        1 * subscriber2.receive("event")
    }


}
