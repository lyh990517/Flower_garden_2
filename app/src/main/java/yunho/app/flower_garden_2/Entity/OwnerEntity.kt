package yunho.app.flower_garden_2.Entity

data class OwnerEntity(
    val id: String,
    val name: String,
    val nickName : String
) {
    constructor() : this( "", "", "")
}