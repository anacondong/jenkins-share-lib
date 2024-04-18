// vars/myFunction.groovy

println "Start"
//call()

//def arguments = [arg1: "Value 1", arg2: "Value 2"]
//myMethod(arguments)

// Example usage:
//def arg = [arg1: "Value 1", arg2: "Value 2"]
//def myClosure = {
//    println "Inside closure"
//}
//myMethodBody(arg, myClosure)
//
//def helloClosure = { name ->
//    "Hello, ${name}!"
//}
//println helloClosure("Closure Dong")
//def call() {
////    echo 'Hello jenkins pipeline share lib'
//    println 'Hello from myFunction!'
//}
//def myMethod(Map args) {
//    println "Argument 1: ${args.arg1}"
//    println "Argument 2: ${args.arg2}"
//    // You can access other properties similarly
//}
//def myMethodBody(Map args, Closure body = {}) {
//    // Print properties of args map
//    println "Arguments:"
//    args.each { key, value ->
//        println "${key}: ${value}"
//    }
//
//    // Print contents of body closure
//    println "\nBody:"
//    body.delegate = [:] // Ensure no external variables are accessed inside the closure
//    body.resolveStrategy = Closure.DELEGATE_FIRST
//    body()
//}


def printValue(Closure jsonDataClosure) {
    def jsonData = jsonDataClosure()
    println "Name: ${jsonData.name}"
    println "Surname: ${jsonData.surname}"
}

// Example usage:
def jsonDataClosure = { [name: "dong", surname: "naja"] }
printValue(jsonDataClosure)
