package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;


/**
 * Profile operations.
 */
public class DatasManager
{

    // the location of the profile data file
    private static final String PROFILE_DATA_FILE = "log.json";
   
    // the loaded profile (may be null)
    private datas savedfile;
    Random r = new Random();
    char c = (char)(r.nextInt(26) + 'a');

    public DatasManager()
    {
    

    }

    /**
     * Retrieves the player's profile, creating one if needed.
     */
    public datas retrieve()
    {
        //Gdx.app.log( Tyrian.LOG, "Retrieving profile" );

        // if the profile is already loaded, just return it
        if( savedfile != null ) return savedfile;

        // create the handle for the profile data file
        FileHandle savedDataFile = Gdx.files.local( PROFILE_DATA_FILE );

        // create the JSON utility object
        Json json = new Json();

        // check if the profile data file exists
        if( savedDataFile.exists() ) {
        //	byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);
            // load the profile from the data file
            try {

                // read the file as text
         
                String savefileAsCode1 = Base64Coder.decodeString(savedDataFile.readString().substring(1));
                String savefileAsCode =  Base64Coder.decodeString(savefileAsCode1);
                savedfile = json.fromJson(datas.class, savefileAsCode);
                //System.out.println(savedfile.mapbought.get("3"));
            } catch( Exception e ) {

                // log the exception
              //  Gdx.app.error( Tyrian.LOG, "Unable to parse existing profile data file", e );

                // recover by creating a fresh new profile data file;
                // note that the player will lose all game progress
                savedfile = new datas();//profile = new Profile();
                persist( savedfile );

            }

        } else {
            // create a new profile data file
            savedfile = new datas();
            persist( savedfile );
        }

        // return the result
        return savedfile;
    }

    /**
     * Persists the given profile.
     */
    protected void persist(
        datas sfile )
    {
        //Gdx.app.log( Tyrian.LOG, "Persisting profile" );

        // create the JSON utility object
        Json json = new Json();

        // create the handle for the profile data file
        FileHandle savedDataFile = Gdx.files.local( PROFILE_DATA_FILE );
        // convert the given profile to text
        String savefileAsText = json.toJson( sfile );
        String savefileAsCode1 = Base64Coder.encodeString( savefileAsText );
        String savefileAsCode = c + Base64Coder.encodeString( savefileAsCode1 );
        // write the profile data file
       savedDataFile.writeString( savefileAsCode, false );
   

    }



    /**
     * Persists the player's profile.
     * <p>
     * If no profile is available, this method does nothing.
     */
    public void persist()
    {
        if( savedfile != null ) {
            persist( savedfile );
        }
    }
}