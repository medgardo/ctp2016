# Setting up Node.js
Node.js is very frequently being updated. As a result, certain applications become dependent on a specific version. Developers may need to install multiple versions to support different projects. This can get messy, so we use a version manager to install multiple node.js versions and switch between them. 'nvm' is the node version manager I recommend.

## Install nvm
```bash
# Install nvm
sudo apt-get update
sudo apt-get install build-essential libssl-dev curl
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.31.2/install.sh | bash
source ~/.profile

# check that nvm is available
command -v nvm

# Install node.js version
nvm install 6.2.2

# Verify that it is installed
nvm ls

# check the node version
node -v

# Run node repl (read-eval-print loop)
node
```


## Installing other versions
You can look up other available versions by running `nvm ls-remote`
and switch among installed versions with the command `nvm use 5.x`

# About nvm
https://github.com/creationix/nvm

# Node versions and reading the changelog
https://nodejs.org/en/
https://github.com/nodejs/node/blob/master/doc/changelogs/CHANGELOG_V6.md#6.3.0

