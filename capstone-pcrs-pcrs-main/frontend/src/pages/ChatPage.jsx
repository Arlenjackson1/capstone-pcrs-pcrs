import React, { useState } from "react";
import Axios from "axios";
import '../style/ChatBot.css';

const ChatPage = () => {
  const baseUrl = "http://localhost:8080/bot/chat";
  const [data, setData] = useState({
    prompt: "",
    response: "",
  });

  const [chatHistory, setChatHistory] = useState([]);

  const submit = (e) => {
    e.preventDefault();

    const url = `${baseUrl}?prompt=${encodeURIComponent(data.prompt)}`;

    Axios.get(url)
      .then((res) => {
        const newChat = [...chatHistory, { user: data.prompt, bot: res.data }];
        setChatHistory(newChat);

        setData({
          prompt: "",
          response: res.data,
        });
      })
      .catch((error) => {
        console.error("Error submitting data:", error);
      });
  };

  const handle = (e) => {
    setData({
      ...data,
      prompt: e.target.value,
    });
  };

  return (
    <div className="page-container">
      <div className="sidebar">
        
        <h2>Chat Bot Sidebar</h2>
        
      </div>
      <div className="chat-container">
        <div className="chat-box">
          {chatHistory.map((chat, index) => (
            <div key={index} className="chat-message">
              <div className="user-message">{chat.user}</div>
              <div className="bot-message">{chat.bot}</div>
            </div>
          ))}
        </div>
        <form onSubmit={(e) => submit(e)}>
          <input
            onChange={(e) => handle(e)}
            value={data.prompt}
            placeholder="Enter your prompt"
            type="text"
          />
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
};

export default ChatPage;