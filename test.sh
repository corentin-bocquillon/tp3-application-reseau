#!/bin/sh

server="localhost"
port=1234

run_server()
{
    echo 'Lancement du serveur…'
    java -jar EchoTCPServer/target/EchoTCPServer-1.0.jar "$port"&
    sleep 1
}

run_clients()
{
    echo 'Lancement du client Python'
    python3 PythonTCPClient/app.py "$server" "$port"

    echo 'Lancement du client Java'
    java -jar EchoTCPClient/target/EchoTCPClient-1.0.jar "$server" "$port"

    echo 'Lancement de nc'
    nc "$server" "$port"
}

run_server
run_clients
