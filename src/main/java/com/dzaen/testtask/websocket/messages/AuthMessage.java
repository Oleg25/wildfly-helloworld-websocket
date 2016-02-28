package com.dzaen.testtask.websocket.messages;

/**
 * Created by velmi on 29.02.2016.
 */
public class AuthMessage extends Message {



    private String TYPE_MESSAGE;

    public AuthMessage(String TYPE_MESSAGE) {
        this.TYPE_MESSAGE = TYPE_MESSAGE;
        this.sequence_ID = sequence_ID;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthMessage that = (AuthMessage) o;

        return TYPE_MESSAGE != null ? TYPE_MESSAGE.equals(that.TYPE_MESSAGE) : that.TYPE_MESSAGE == null;

    }


    private String sequence_ID;


    private String data;

    public String getTYPE_MESSAGE() {
        return TYPE_MESSAGE;
    }

    public void setTYPE_MESSAGE(String TYPE_MESSAGE) {
        this.TYPE_MESSAGE = TYPE_MESSAGE;
    }

    public String getSequence_ID() {
        return sequence_ID;
    }

    public void setSequence_ID(String sequence_ID) {
        this.sequence_ID = sequence_ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
