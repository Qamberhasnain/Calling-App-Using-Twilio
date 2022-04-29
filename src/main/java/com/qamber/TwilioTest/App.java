package com.qamber.TwilioTest;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.net.URISyntaxException;

public class App {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
	public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    

    public static void main(String[] args) throws URISyntaxException {
    	Say say = new Say.Builder("Hello, Sir How are you? You are requied to be present at the Car service agency urgently as your car's wheels need to be checked and replaced as soon as possible to avoid any accident in unforseen future.").voice(Say.Voice.WOMAN)
                .language(Say.Language.FR_FR).build();
            VoiceResponse response = new VoiceResponse.Builder().say(say).build();

            try {
                System.out.println(response.toXml());
            } catch (TwiMLException e) {
                e.printStackTrace();
            }
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String from = "+1985xxxxxxx";
        String to = "+9184xxxxxxxx";

        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),//new URI("http://demo.twilio.com/docs/classic.mp3")).create();
                 new URI("http://demo.twilio.com/docs/voice.xml")).create();

        System.out.println(call.getSid());
    }
}