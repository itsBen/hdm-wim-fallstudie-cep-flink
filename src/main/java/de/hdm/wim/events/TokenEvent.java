package de.hdm.wim.events;

/**
 * Created by Ben on 15.01.2017.
 */
public class TokenEvent {
    private String token;

    public TokenEvent() {}

    /**
     * Instantiates a new event.
     *
     * @param token a token
     */
    public TokenEvent(String token) {
        this.setToken(token);
    }

    /**
     * Gets the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}