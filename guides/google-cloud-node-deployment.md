# Instructions for Deploying Node/Express Projects to a Google Cloud Server

The following instructions will guide you through process of deploying your projects to a Google cloud server. Note, that these instructions will work for most application configurations. If your project differed from our class configurations you may have to modify some of these steps.

## 1 - Create and launch a Google VM from a Preconfigured Image

Download and Follow the instructions here: [Create-Preconfigured-Google-Compute-Engine-Virtual-Machines.docx](deployment/Create-Preconfigured-Google-Compute-Engine-Virtual-Machines.docx)

**IMPORTANT:** Some of the following steps should be run on the server and some will run on your local machine.

## 2 - Create your Postgres User and Database

_Note: Do these steps if you are using Postgres database. Skip if you are using MongoDB._

Log into your Google VM and create your Postgres User and Database with the following commands:

```
$ sudo su - postgres
# createuser -P -s -e PG_USERNAME
# createdb MYAPPNAME_development
# exit
```

Replace `PG_USERNAME` and `MYAPPNAME_development` with your projects corresponding configuration.

## 3 - Sync your code onto the Google cloud server

These instructions will allow you to upload your latest code changes to your Google VM Instance.

_Note: you should run this on your local machine in your code directory. You can run this multiple times on your local machine to sync new changes to the server._

### Instructions

1. Ensure you're able to SSH into your Google VM Instance
2. Ensure that you have **created the directory** in your Google VM instance in which you want store your files.
    - For example: `/opt/apps/ctp`
3. Fill in this command with your unique credentials/values:

```
rsync -avz -e "ssh -i /PATH/TO/THE/SSH/KEY/ON/YOUR/MACHINE" --rsync-path="sudo rsync" --delete [source] [destination]
```

Replace the following:
- `PATH/TO/THE/SSH/KEY/ON/YOUR/MACHINE`: With your Google Compute Engine SSH Key (_Note, this should be the full path or it can use the `$HOME` env var instead of `~`_)
- `source`: The directory which you want to sync.
- `destination`: Where in the remote server you want to store your files.
   - It should follow the following format:
     - `[user]@[remote server]:[remote path]`

Your end command should look similar to this:
```
rsync -avz -e "ssh -i $HOME/.ssh/my_google_key" --rsync-path="sudo rsync" --delete ./ google-vm-username@remote-address:/opt/apps/ctp
```

### If you are using Sequelize Migrations:

If you are using Sequelize and Migrations, login to the google cloud server, and run your migrations. You should also do this everytime you rsync your code and new migrations have been added.

```
$ cd /opt/apps/PROJECT_DIRECTORY
$ sequelize db:migrate
```

## 4 - Setup NGINX configuration file

The NGINX configuration file will allow NGINX to proxy incoming requests and send them to your web applications.

### Things to note:

1. Your `NGINX configuration` file should be stored inside of `/etc/nginx/sites-available`
2. You must link the configuration in `/etc/nginx/sites-available` to `/etc/nginx/sites-enabled`
3. You can use the following command to do so:

```
    ln -s /etc/nginx/sites-available/FILE-NAME-HERE /etc/nginx/sites-enabled/SAME-FILE-NAME-HERE
```

4. Everything that has the comment: ` # LOOK BELOW FOR ADDITIONAL NOTES` is unique to every project.

### Sample Configuration File:

```nginx
server {
    listen 80;

    access_log {{ log_root }}/nginx.access.log;             # LOOK BELOW FOR ADDITIONAL NOTES
    error_log {{ log_root }}/nginx.error.log error;         # LOOK BELOW FOR ADDITIONAL NOTES

    client_max_body_size 20M;

    location ~ ^/(assets/|images/|img/|javascript/|js/|css/|stylesheets/|flash/|media/|static/|robots.txt|humans.txt|favicon.ico) {
        root {{ source_root }}/public;                      # LOOK BELOW FOR ADDITIONAL NOTES
        access_log off;
        expires 24h;
    }

    location / {
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header Host $host;
        proxy_set_header X-NginX-Proxy true;
        proxy_pass http://localhost:{{ app_port }};               # LOOK BELOW FOR ADDITIONAL NOTES
        proxy_redirect off;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";

        proxy_redirect off;
        proxy_set_header   X-Forwarded-Proto $scheme;
        proxy_cache_key sfs$request_uri$scheme;
    }
}
```

### Changes Needed To Be Made:

1. `access_log {{ log_root }}/nginx.access.log;`
    - This line is responsible for telling NGINX where to log all information in regards to requests trying to access the server.
    - `{{ log_root }}` can be a directory of your choosing. Personally, I create a log directory inside of my project and use that.
    - **You need to replace this line with your information. For example:**
        ```
        access_log /opt/apps/blog/log/nginx.access.log;
        ```
2. `error_log {{ log_root }}/nginx.error.log error;`
    - This line is responsible for telling NGINX where to log all errors when making requests to your server.
    - `{{ log_root }}` can be a directory of your choosing. Personally, I create a log directory inside of my project and use that.
    - The error at the end of the line tells NGINX to `only` log errors.
    - **You need to replace this line with your information. For example:**
        ```
        access_log /opt/apps/blog/log/nginx.error.log error;
        ```
3. `root {{ source_root }}/public;`
    - This code block is responsible to telling NGINX where to look for static files (JavaScript, CSS, Images, etc.)
    - If you followed the blog file structure then you should already be storing this information in your public directory.
    - `{{ source_root }}` Is the absolute path to the directory in which your project is stored.
    - **You need to replace this line with your information. For example:**
        ```
        root /opt/apps/blog/public;
        ```
4. `proxy_pass http://localhost:{{ app_port }};`
    - This line is responsible for telling NGINX where to pass the request to. In this case, we want to pass the request to our application so it can respond to the request.
    - `3000` We're running our app on port `3000`. You should change this value if you're running your application on a different port.
    - **You need to replace this line with your port number. For example:**
        ```
        proxy_pass http://localhost:3000;
        ```
5. After all of these changes run the following command:
    ```
    sudo service nginx restart
    ```

6. Now enter your VM External IP address on your browser and you should see your project if your application is running.

## 5 - Run your application with PM2 

The last thing left to do is to run our application on the server. Since this is a server, we need to use a process manager to launch the application and not close when we exit the terminal. We will use the PM2 process manager to do this for us. PM2 is already installed on the server.

Launch your app on the google cloud server like this:

```
$ cd /opt/apps/PROJECT_DIRECTORY
$ pm2 start app.js --watch
```

_Note: the `--watch` is typically not something you want in production environments, but if you don't use it, you will need to restart the process everytime you rsync new changes to the server._

### Make sure it always gets launched even if the server is restarted:

Run:

```
$ pm2 start ubuntu
```

Copy the command it gives you and run it on the cloud server.

