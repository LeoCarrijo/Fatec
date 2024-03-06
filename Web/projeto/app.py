from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/sobre')
def about():
    return render_template('about.html')

@app.route('/contato')
def contact():
    return render_template('contato.html')

@app.route('/servicos')
def services():
    return render_template('servicos.html')

app.run()