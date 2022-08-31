package project.mykolaonyshchuk.chisoftwaretesttask

class User(val name: String, val age: Int, var isStudent: Boolean) {
    companion object {
        private var lastUserId = 0
        fun createContactsList(numContacts: Int): ArrayList<User> {
            val contacts = ArrayList<User>()
            for (i in 1..numContacts) {
                contacts.add(User("Person " + ++lastUserId, i, false))
            }
            return contacts
        }
    }
}