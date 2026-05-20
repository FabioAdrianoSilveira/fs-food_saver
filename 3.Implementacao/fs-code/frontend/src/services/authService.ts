export async function login(email: string, senha: string) {
  const response = await fetch(
    `http://localhost:8080/auth/login?email=${email}&senha=${senha}`,
    { method: "POST" },
  );
  return await response.text();
}
