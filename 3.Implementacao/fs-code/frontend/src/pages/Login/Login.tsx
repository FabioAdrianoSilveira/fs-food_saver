import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import logo from "../../assets/logo.png";
import { login } from "../../services/authService";

export default function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");

  const navigate = useNavigate();

  async function handleLogin(e: React.FormEvent) {
    e.preventDefault();

    const resposta = await login(email, senha);

    if (resposta === "Login realizado com sucesso!") {
      navigate("/home");
    } else {
      setErro("E-mail ou senha incorretos");
    }
  }

  return (
    <main className="container">
      <header>
        <img src={logo} className="logo" alt="Food Saver Logo" />
      </header>

      <section className="card">

        <header className="card-header">
          <h1>Entrar</h1>
          <p>Acesse sua conta para continuar</p>
        </header>

        <form onSubmit={handleLogin}>

          <label htmlFor="email">E-mail</label>
          <input
            id="email"
            type="email"
            placeholder="seuemail@exemplo.com"
            onChange={(e) => setEmail(e.target.value)}
          />

          <label htmlFor="senha">Senha</label>
          <input
            id="senha"
            type="password"
            placeholder="*******"
            onChange={(e) => setSenha(e.target.value)}
          />

          {erro && <p className="erro">{erro}</p>}

          <button type="submit">Entrar</button>

        </form>

        <footer className="cadastro">
          <p>
            Não possui uma conta?
            <button
              type="button"
              className="link-button"
              onClick={() => navigate("/createaccount")}
            >
              Criar cadastro
            </button>
          </p>
        </footer>

      </section>
    </main>
  );
}