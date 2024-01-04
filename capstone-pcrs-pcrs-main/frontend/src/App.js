import React from "react";
import NavBar from "./components/NavBar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ChatPage from "./pages/ChatPage";

const App = () => {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/ChatPage" element={<ChatPage />} />
        
      </Routes>
    </Router>
  );
};

export default App;