package value_object

data class Name(val value: String) {
    init {
        require(Regex("^[a-zA-Z]+$").matches(input = value)) {
            "許可されていない文字が使われています。"
        }
    }
}
