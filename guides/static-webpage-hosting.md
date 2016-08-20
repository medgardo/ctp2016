# Static Webpage Hosting

_This guide will show you the basic steps to host your static personal webpages on your Google Compute Engine VM (Or any other Ubuntu machine)_

## Step 1: Setup your Google Compute Engine VM

Make sure you have gone through the ["Setup Google Compute Engine"](setup-google-vm.md) guide first.

## Step 2: Install Apache HTTP Server

Once you have your Google Cloud VM setup, you should login to your Compute Engine VM and run the following commands to install Apache, git, and curl:

```bash
sudo apt-get update
sudo apt-get install git curl apache2
```

Then, you should open a web browser and visit your Compute Engine VM's **external IP** on your web browser: http://111.222.333.444 (just an example, use your own external IP)

If you see the "_Apache Ubuntu Default Page_" proceed to the next step. Otherwise report your issue on Slack.

## Step 3: Publish your webpage

Assuming your static personal webpage code is in a Github repository (_where it should be!_), you can publish it with the following commands:

```bash
cd /var/www/html
sudo mv index.html ~/index.html.bak
sudo sh -c 'curl -sL https://github.com/USERNAME/REPO_NAME/archive/master.tar.gz | tar -xzv --strip 1'
```

In the last command, **replace** `USERNAME` with your own github username, and `REPO_NAME` with the name of the repo you gave your personal webpage.

> **NOTE:** _If you want to deploy a BRANCH other than *master*, replace master with the branch name (i.e. if your webpage code is in the `gh-pages` branch)_

## Done! Reload your browser and you should see your webpage

<br>

<br>

## Explanation and Additional Resources

### What did we just do? 

We just installed the Apache software, which is an open source HTTP web server, which also happens to be the most popular in the world. It's primary functionality is to serve files over port 80 of your machines IP address, to other computers on the network. For machines connected to the internet, like our Google Compute Engine VM, that means our files are accessible to all other machines on the internet.

By default, Apache serves all of the files it finds in the `/var/www/html/` directory. We removed the default Ubuntu page and we copied our own webpage files from our Github repository. Use [explainshell.com](http://explainshell.com) to learn about the commands.

Apache is not the only available webserver, Nginx is a modern open source web server gaining a lot of traction. There are also commercial web servers like Microsoft's IIS web server.

> Aside: Although I am using the term Apache to refer to the HTTP Web Server, you should be aware that the Apache Foundation now supports many, many more open source projects besides the HTTP Web Server software.

### Security Considerations

HTTP Web Servers are very complex, and Apache itself is very flexible in how it can be configured. These instructions are only meant for static pages that do not contain any private information at risk of exposure.

### Resources

Apache HTTP Server: [http://httpd.apache.org/](http://httpd.apache.org/)

Apache Foundation: [http://www.apache.org/](http://www.apache.org/)

Nginx (Open Source version): [http://nginx.org/](http://nginx.org/)

[N/A] Web Server Survey: [http://news.netcraft.com/archives/2016/02/22/february-2016-web-server-survey.html](http://news.netcraft.com/archives/2016/02/22/february-2016-web-server-survey.html)

[Advanced] Apache vs. Nginx: Practical Considerations [https://www.digitalocean.com/community/tutorials/apache-vs-nginx-practical-considerations](https://www.digitalocean.com/community/tutorials/apache-vs-nginx-practical-considerations)







