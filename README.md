# tensorframes-artifacts
Custom jar artifacts compiled for the TensorFrames project. This requirement may go away once
 javacpp-presets version 1.2 is published.

## Install

Simply publish locally the artifacts:

```bash
build/sbt publishLocal
```

## Build artifacts yourself

Here is the procedure to recreate the files.

Requirements:
 - docker

Get the latest docker image for tensorflow:

```bash
docker run -it --name=tf-build b.gcr.io/tensorflow/tensorflow-full "bash"
```

Inside the container, install bazel, maven, javacpp and finally javacpp-presets:

```bash
apt-get update
apt-get -y install git

cd
wget https://github.com/bazelbuild/bazel/releases/download/0.1.5/bazel-0.1.5-installer-linux-x86_64.sh
bash bazel-0.1.5-installer-linux-x86_64.sh
echo "source /usr/local/lib/bazel/bin/bazel-complete.bash" >> ~/.bashrc
source ~/.bashrc

cd
rm -f unzip apache-maven-3.*-bin.zip
wget http://www.trieuvan.com/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip
unzip apache-maven-3.3.9-bin.zip
echo "export PATH=~/apache-maven-3.3.9/bin:$PATH" >> ~/.bashrc
source ~/.bashrc

cd
git clone https://github.com/bytedeco/javacpp.git
cd javacpp
mvn install
```

Finally, install a custom version of javacpp-presets:
```bash
cd
git clone https://github.com/bytedeco/javacpp-presets.git
cd javacpp-presets
git remote update
git reset --hard
bash cppbuild.sh -platform linux-x86_64 install tensorflow
mvn package --projects .,tensorflow
```

Get the files out and deploy them:

