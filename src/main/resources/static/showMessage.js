function simpleMessage(msg) {
    console.log(msg)
}
function complexMessage(msg) {
    console.log(new Date()+":"+msg)
}
function f() {
    console.log("sssss")
}
export default {simpleMessage,complexMessage}