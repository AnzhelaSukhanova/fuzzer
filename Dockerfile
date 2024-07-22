ARG REQUEST=jvmAllRegressions.json
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
 && git checkout 8c21c8e2

# prepare fuzzer
WORKDIR /root/fuzzer
RUN sed -i -e 's,/usr/lib/jvm/java-11-openjdk-amd64,/lib/jvm/java-11-openjdk,g' watcher.sh gradle.properties test.sh \
 && sed -i -e 's,pkill -f /usr/lib/jvm/java-21-openjdk-amd64/bin/java,,g' watcher.sh test.sh \
 && ./gradlew JVMCompiler:download
 
# download standalone compilers
RUN curl -LO https://github.com/JetBrains/kotlin/releases/download/v1.8.0/kotlin-compiler-1.8.0.zip \
 && unzip kotlin-compiler-1.8.0.zip \
 && rm -rf kotlin-compiler-1.8.0.zip \
 && mv kotlinc kotlinc1.8.0
RUN curl -LO https://github.com/JetBrains/kotlin/releases/download/v1.9.0/kotlin-compiler-1.9.0.zip \
 && unzip kotlin-compiler-1.9.0.zip \
 && rm -rf kotlin-compiler-1.9.0.zip \
 && mv kotlinc kotlinc1.9.0
 
# run fuzzer
ARG REQUEST
ENV REQUEST_FILENAME=$REQUEST
CMD sh watcher.sh $REQUEST_FILENAME

