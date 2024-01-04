import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
  const navBarContainer = {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "flex-start",
    background:
      "linear-gradient(to right, black, purple, red ,orange, yellow, orange, red, purple, black)",
    height: "7%",
    position: "fixed",
    width: "100vw",
    top: 10,
    zIndex: 1000,
  };
  return (
    <div style={navBarContainer}>
      <header>
        <nav>
          <Link to="#" className="nav-btn">
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
