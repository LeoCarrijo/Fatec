from flask import Flask, render_template, request
import mysql.connector

app = Flask(__name__)

@app.route("/")
def root():
    return render_template('index.html')

@app.route("/cadastrar_usuario")
def cadastrar_usuario():
    return render_template('formulario.html')

@app.route("/cadastrar_cliente")
def cadastrar_cliente():
    return render_template('formulario.html')

app.run()