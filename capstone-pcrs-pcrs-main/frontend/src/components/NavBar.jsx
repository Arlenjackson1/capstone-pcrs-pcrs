import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
  const navBarContainer = {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "flex-start",
    position: "fixed",
    width: "100vw",
    top: 10,
    zIndex: 1000,
    back,
  };
  const navBtn = {
    textDecoration: "none",
    color: "white",
    padding: "10px 20px",
    borderRadius: "5px",
    boxShadow: "0 2px 4px rgba(0, 0, 0, 0.2)",
    transition: "background-color 0.3s, transform 0.1s",
  };
  return (
    <div style={navBarContainer}>
      <header>
        <nav>
          <Link to="#" style={navBtn}>
            {" "}
            Home
          </Link>
          <Link to="/ChatPage" className="nav-btn">
            {" "}
            Link here
          </Link>
        </nav>
      </header>
    </div>
  );
};

export default NavBar;
