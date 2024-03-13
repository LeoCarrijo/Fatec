from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/', methods=['GET'])
def root():
    return render_template('index.html')

@app.route('/calculadorIMC', methods=['POST'])
def calculadorIMC():
    altura = float(request.form['altura'])
    peso = float(request.form['peso'])
    imc = peso / (altura * altura)
    return render_template('index.html', var_imc=imc)

app.run()