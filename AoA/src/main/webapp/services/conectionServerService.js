miapp.service('conectionServerService', function($http) {


    this.showUsers = function showUsers() {
        return $http.get("http://localhost:8080/avatar/listarAvatares");
    }
    this.userRegister = function userRegister(user) {
        return ($http.post("http://localhost:8080/avatar/register", user));


    }
    this.createEjercito = function userRegister(ejercito) {
        return ($http.post("http://localhost:8080/ejercito/crearEjercito", ejercito));


    }

    this.editUser = function editUser(id, user) {
        return ($http.put("http://localhost:8080/avatar/editar/" + id, user));


    }
    this.deleteUser = function deleteUser(id) {
        return ($http.delete("http://localhost:8080/avatar/eliminar/" + id));


    }
});