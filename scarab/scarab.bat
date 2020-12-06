@echo off
java -Dsource.properties.filename=source.properties -Dtransformer.properties.filename=transformer.properties -Dsink.properties.filename=sink.properties -cp target\scarab-0.0.1-SNAPSHOT-jar-with-dependencies.jar;components\*;.	org.scarab.Scarab
