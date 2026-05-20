import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../pages/Login/Login";
import Home from "../pages/Home/Home";
import CreateAccount from "../pages/CreateAccount/CreateAccount";
export default function AppRoutes() {
  return (
    <BrowserRouter>
      {" "}
      <Routes>
        {" "}
        <Route path="/" element={<Login />} />{" "}
        <Route path="/home" element={<Home />} />{" "}
        <Route path="/createaccount" element={<CreateAccount />} />{" "}
      </Routes>{" "}
    </BrowserRouter>
  );
}
