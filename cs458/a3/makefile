JFLAGS = -g
JC = javac

all: SslCli.class SslServ.class GenPass.class

SslCli: SslCli.class
	java -Djavax.net.ssl.trustStore=mykeystore/examplestore -Djavax.net.ssl.trustStorePassword=password SslCli $(DOMAIN) $(PORT)

SslCli.class: SslCli.java
	$(JC) $(JFLAGS) SslCli.java

SslServ: SslServ.class
	java -Djavax.net.ssl.keyStore=mykeystore/examplestore -Djavax.net.ssl.keyStorePassword=password -Djavax.net.debug=ssl SslServ $(PORT)

SslServ.class: SslServ.java
	$(JC) $(JFLAGS) SslServ.java

GenPass: GenPass.class
	java GenPass

GenPass.class: GenPass.java
	$(JC) $(JFLAGS) GenPass.java

clean:
	$(RM) -f *.class