package impl

class Publisher {
    def subscribers = []

    def add (Subscriber subscriber) {
        subscribers << subscriber
    }

    def fire(String s){
        subscribers.each {
            try {
                it.receive(s)
            }catch (Exception ex){}
//            it.receive(s)
        }
    }
}
