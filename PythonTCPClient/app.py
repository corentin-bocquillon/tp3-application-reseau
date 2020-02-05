#!/usr/bin/env python3

import socket
from sys import argv

def print_help():
    print('Usage: {} server port'.format(argv[0]))

if len(argv) < 3:
    print_help()
    exit(1)

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

sock.connect((argv[1], int(argv[2])))

while True:
    msg = input() + '\n'
    sock.send(msg.encode('utf-8'))
    answer = sock.recv(1024).decode('utf-8')
    print(answer, end='');
