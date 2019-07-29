var app = new function () {
    var countries = [];
    var mode = "";
   var url="https://employeedevi.herokuapp.com/api/Employees/";
    this.FetchAll = function () {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {

            if (this.readyState == 4 && this.status == 200) {
                countries = JSON.parse(xhttp.responseText);
                app.printtable();
            }
        };
        xhttp.open("GET", url, true);
        xhttp.send();
    };
    this.printtable = function () {
        // console.log(countries);
        var data = '';
        for (var i in countries) {
            data += '<tr>';
            data += '<td>' + countries[i].empid + '</td>';
            data += '<td>' + countries[i].empname + '</td>';
            data += '<td><button onclick="app.Edit(' + countries[i].empid + ')">Edit</button></td>';
            data += '<td><button onclick="app.Delete(' + countries[i].empname + ')">Delete</button></td>';
            data += '</tr>';
            data += '<br>';
            data += '<br>';
        }
        document.getElementById("countries").innerHTML = data;
    };

    this.Edit = function (empid) {
        mode = "edit";
        document.getElementById('btn').innerHTML = "Update";
        for (var i = 0; i < countries.length; i++) {

            if (countries[i].empid == empid) {
                // alert(empid);
                document.getElementById('empid').value = countries[i].empid;
                document.getElementById('empname').value = countries[i].empname;
            }
        }
    };

    this.saveorupdate = function () {
        var id = document.getElementById('empid').value;
        var name = document.getElementById('empname').value;
        if (mode == "") {
            alert("save called");
            // {"empid": 0, "empname": "TeamIndia"}
            var newTeam = { "empid": 0, "empname": name };
            alert(newTeam);
            // var url = "https://employeedevi.herokuapp.com/api/Employees/";
            var xhr = new XMLHttpRequest();
            xhr.onload = function () {
                if (xhr.readyState == 4 && xhr.status == "200") {
                    app.FetchAll();
                }
            }
            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.send(JSON.stringify(newTeam));
            app.FetchAll();
        }
        else {
            alert("update called");
            // alert("empid" + empid + "empname " + empname);
            var updateTeam = { "empid": 0, "empname": name };
            alert(updateTeam);
            // var url = "https://employeedevi.herokuapp.com/api/Employees/";
            var xhr = new XMLHttpRequest();
            xhr.onload = function () {
                if (xhr.readyState == 4 && xhr.status == "200") {
                    app.FetchAll();
                }
            }
            xhr.open("PUT", url, true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.send(JSON.stringify(updateTeam));
            document.getElementById('btn').innerHTML = "Add";
            mode = "";
            app.FetchAll();
        }

        document.getElementById('empid').value = "";
        document.getElementById('empname').value = "";
    };
}