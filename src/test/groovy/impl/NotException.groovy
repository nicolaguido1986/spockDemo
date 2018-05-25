package impl

class NotException {

    def thrownException(){
        try{
            throw IllegalArgumentException
        }catch(IllegalArgumentException){}
    }
}
