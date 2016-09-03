package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;



public class DatasManager
{


    private static final String PROFILE_DATA_FILE = "log.json";
   

    private datas savedfile;
    Random r = new Random();
    char c = (char)(r.nextInt(26) + 'a');

    public DatasManager()
    {
    

    }


    public datas retrieve()
    {

        if( savedfile != null ) return savedfile;


        FileHandle savedDataFile = Gdx.files.local( PROFILE_DATA_FILE );

        Json json = new Json();

        if( savedDataFile.exists() ) {

            try {

         
                String savefileAsCode1 = Base64Coder.decodeString(savedDataFile.readString().substring(1));
                String savefileAsCode =  Base64Coder.decodeString(savefileAsCode1);
                savedfile = json.fromJson(datas.class, savefileAsCode);

            } catch( Exception e ) {


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


    protected void persist(
        datas sfile )
    {

        Json json = new Json();


        FileHandle savedDataFile = Gdx.files.local( PROFILE_DATA_FILE );

        String savefileAsText = json.toJson( sfile );
        String savefileAsCode1 = Base64Coder.encodeString( savefileAsText );
        String savefileAsCode = c + Base64Coder.encodeString( savefileAsCode1 );

       savedDataFile.writeString( savefileAsCode, false );
   

    }



    public void persist()
    {
        if( savedfile != null ) {
            persist( savedfile );
        }
    }
}
