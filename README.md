# Cassandra GUI client

This client is intended to be a simple GUI solution to work with cassandra 3.

What it already can:
* connect to cassandra
* load and show tables
* show table DDL
* show table data (simple editable table view with header)
* apply composite filters to loaded data
* execute query

Planned:
* lazy data load/pagination
* add/delete tables
* validation in filter values
* safe mode with manual commit-reset
* add/save connections
* select driver
* load driver files
* packaging

### Editor window
On selecting table data from context menu in table list all rows are loaded from cassandra
that is quite dangerous when having millions of entries in single table. Lazy loading and
pagination is planned but not implemented yet. <br/>
On cell edit updated row is immediately sent to cassandra - I'm planning to add *safe mode*
by executing DB queries only on *commit button* click with ability to reset all local uncommited
changes.

### Available filters
Type of cassandra column is respected. String value from filter is converted to same 
type using cassandra driver codecs and column metadata. Filters are combined with
`AND` `OR` keywords and parentheses brackets.

```SQL
var1 = val1 AND var2 <= val2 OR (var1 != val2 AND var5 LIKE .*test_value{1,2}.*)
```

* **equal check**<br/>
*field = value*<br/>

* **not equal**<br/>
*field != value*<br/>

* **less or equal**<br/>
*field <= value*<br/>

* **less than**<br/>
*field < value*<br/>

* **greater or equal**<br/>
*field >= value*<br/>

* **greater than**<br/>
*field > value*<br/>

* **string REGEX check**<br/>
*field LIKE value*<br/>
value should represent Java Pattern-style regex

### GUI

#### Main window
![main window](https://raw.githubusercontent.com/Kindrat/cassandra-client/master/doc/window.png)

#### Connect
![connect popup](https://raw.githubusercontent.com/Kindrat/cassandra-client/master/doc/connect_popup.png)

#### List tables
![list tables](https://raw.githubusercontent.com/Kindrat/cassandra-client/master/doc/list_tables.png)

#### Show DDL
![show DDL](https://raw.githubusercontent.com/Kindrat/cassandra-client/master/doc/show_ddl.png)

#### Show data
![show DDL](https://raw.githubusercontent.com/Kindrat/cassandra-client/master/doc/show_data.png)
