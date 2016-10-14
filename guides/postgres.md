**CUNY Tech Prep 2016-2017**
# Installing Postgres

[Postgres](https://www.postgresql.org/) is a widely used and open source relational database. The applications we are developing in this program make use of postgres, so it is important that we make sure it is installed.

_Note:_ If you are using Vagrant and multiple virtual environments, you will have to install Postgres on each virtual machine (or alternatively, you can setup one Postgres server which is shared to multiple VM's. I will not go over how to do that here).

## On Windows

Follow the [Windows Installation Instructions](https://github.com/medgardo/ctp-microblog/blob/master/install-node-postgres-on-windows.md#getting-and-installing-postgresql).

If you already have the CTP-Microblog working, you don't have to repeat all steps. You should only follow the steps to create new databases.

## On Ubuntu 14.04

On Ubuntu 14.04 you will run the following commands only once per VM setup:

```
$ sudo apt-get update
$ sudo apt-get install -y postgresql-9.3 postgresql-server-dev-9.3 python-psycopg2
$ sudo su - postgres
# createuser -P -s -e pg_user
# exit
```

Note that the `sudo su ...` command changes the user you are logged in as. This will allow us to create the first DB user (which will be a superuser). Make sure to immediately `exit` once you are done with this.

I have used the username `pg_user`, but feel free to call the user anything you like. And make sure to write down the password, you will need it.

You are now ready to create a database for development with the following command. Change `MYAPPNAME_development` to your applications database name.

```
$ createdb -h localhost -U pg_user MYAPPNAME_development
```

You now have a database name, username, and password ready for development.

## On Ubuntu 16.04


On Ubuntu 16.04 you will run the following commands only once per VM setup:

```
$ sudo apt-get update
$ sudo apt-get install -y postgresql-9.5 postgresql-server-dev-9.5 python-psycopg2
$ sudo su - postgres
# createuser -P -s -e pg_user
# exit
```

Note that the `sudo su ...` command changes the user you are logged in as. This will allow us to create the first DB user (which will be a superuser). Make sure to immediately `exit` once you are done with this.

I have used the username `pg_user`, but feel free to call the user anything you like. And make sure to write down the password, you will need it.

You are now ready to create a database for development with the following command. Change `MYAPPNAME_development` to your applications database name.

```
$ createdb -h localhost -U pg_user MYAPPNAME_development
```

You now have a database name, username, and password ready for development.

## Additional Resources

* [Postgres Guide](http://postgresguide.com/)

