

package com.example.flexible.speak;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

// [START example]
@WebServlet("/transcribe")
@SuppressWarnings("serial")
public class TranscribeServlet extends WebSocketServlet {

  // Timeout in milliseconds
  private static final int TIMEOUT = 10000;

  @Override
  public void configure(WebSocketServletFactory factory) {
    factory.getPolicy().setIdleTimeout(TIMEOUT);

    // The WebSocket to create on upgrade
    factory.register(TranscribeSocket.class);
  }
}
// [END example]
