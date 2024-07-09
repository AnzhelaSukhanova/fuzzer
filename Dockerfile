FROM archlinux

# preinstall
RUN pacman -Syy \
 && pacman --noconfirm -S git jdk11-openjdk
 		
# setup JAVA_HOME
ENV JAVA_HOME=/lib/jvm/java-11-openjdk
RUN export JAVA_HOME
                       
# download fuzzer
RUN cd /root \
 && git clone https://github.com/AnzhelaSukhanova/fuzzer.git \
 && cd fuzzer \
 && git checkout 165e439b

# prepare fuzzer
WORKDIR /root/fuzzer
RUN sed -i -e 's,/usr/lib/jvm/java-11-openjdk-amd64,/lib/jvm/java-11-openjdk,g' watcher.sh gradle.properties test.sh \
 && sed -i -e 's,pkill -f /usr/lib/jvm/java-21-openjdk-amd64/bin/java,,g' watcher.sh test.sh \
 && ./gradlew JVMCompiler:download
 
# run fuzzer
ARG REQUEST=jvmAllRegressions.json
RUN echo $REQUEST
CMD sh watcher.sh $REQUEST

