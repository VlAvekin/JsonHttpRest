<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>JSON HTTP REST</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
              integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
              crossorigin="anonymous"/>
    </head>
    <body>
        <div class="container mt-5">
            <h2>JSON HTTP REST</h2>

            <form method="post">
                <div class="form-group row">
                    <div class="col-sm-11">
                        <input  class="form-control" type="text" name="data"/>
                    </div>

                    <div class="col-sm-1">
                        <button class="btn btn-primary" type="submit">Add</button>
                    </div>
                </div>
            </form>
            <hr>

            <table class="table table-striped" id="data-list">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Data Json</th>
                </tr>
                </thead>
                <tbody>
                <#list dataJsons as data>
                <tr id="list-col">
                    <td scope="row">${data.id}</td>
                    <td>${data.data}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </body>
</html>