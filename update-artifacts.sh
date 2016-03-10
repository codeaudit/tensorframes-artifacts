GROUPID="org.tensorframes"
VERSION="0.0.2-0.7.1"

for file in "javacpp" "tensorflow-linux-x86_64" "tensorflow"; do
	mvn install:install-file \
	 -DgroupId=$GROUPID \
	 -DartifactId=$file \
	 -Dversion=$VERSION \
	 -Dpackaging=jar \
	 -Dfile=binaries/$file.jar \
	 -DlocalRepositoryPath=deploy/
done
