import React from 'react'
import { Link } from 'react-router-dom'



const NavBar = () => {
  return (
    <div>
      <header>
        <nav>
          <Link to="#">Home</Link>
          <Link to="/ChatPage">Link here</Link>
        </nav>
      </header>
    </div>
  )
}

export default NavBar
