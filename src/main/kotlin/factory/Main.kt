package factory

enum class DialogType {
    CREATE,
    EDIT,
    DELETE
}

sealed class Dialog {
    object Create : Dialog()
    object Edit : Dialog()
    object Delete : Dialog()
}

object DialogFactory {

    fun createDialog(type: DialogType): Dialog = when (type) {
        DialogType.CREATE -> Dialog.Create
        DialogType.EDIT -> Dialog.Edit
        DialogType.DELETE -> Dialog.Delete
    }
}
