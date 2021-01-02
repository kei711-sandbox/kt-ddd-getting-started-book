package value_object

data class ModelNumber(val productCode: String, val branch: String, val lot: String) {
    override fun toString(): String = "$productCode-$branch-$lot"
}
