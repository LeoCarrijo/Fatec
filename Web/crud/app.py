from flask import Flask, request, render_template

app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

app.run()