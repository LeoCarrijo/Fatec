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

@app.route('/calcular_imc_get', methods=['GET'])
def calcularIMC_get():
    args = request.args
    altura = float(args.get('altura'))
    peso = float(args.get('peso'))
    imc = peso / altura**2
    if(imc < 18.5):
        classificacao = 'MAGREZA'
    if(imc >= 18.5 and imc <= 24.9):
        classificacao = 'NORMAL'
    if(imc >= 25 and imc <= 29.9):
        classificacao = 'GORDO'

app.run()