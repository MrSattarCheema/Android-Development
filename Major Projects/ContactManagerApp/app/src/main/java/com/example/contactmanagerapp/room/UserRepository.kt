package com.example.contactmanagerapp.room
// repository is used to fetch data from local or external database or internet
// A repository class provides a clean API for data access to the rest of the application
class UserRepository(private val dao: UserDAO) {
    val users = dao.getAllUsersFromDB()
    suspend fun insert(user: User): Long{
        return dao.insertUser(user)
    }
    suspend fun delete(user: User){
        return dao.deleteUser(user)
    }
    suspend fun update(user: User){
        return dao.updateUser(user)
    }
    suspend fun deleteAll(){
        return dao.deleteAll()
    }
}