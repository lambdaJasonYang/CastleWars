package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;

//Save file encoding w/ base64

public class DatasManager
{


    private static final String PROFILE_DATA_FILE = "save.json";
   

    private datas savedfile;


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

         
                
                String savefileAsCode =  Base64Coder.decodeString(savefileAsCode1);
                savedfile = json.fromJson(datas.class, savefileAsCode);

            } catch( Exception e ) {


                savedfile = new datas();
                persist( savedfile );

            }

        } else {
           
            savedfile = new datas();
            persist( savedfile );
        }

        
        return savedfile;
    }


    protected void persist(
        datas sfile )
    {

        Json json = new Json();


        FileHandle savedDataFile = Gdx.files.local( PROFILE_DATA_FILE );

        String savefileAsText = json.toJson( sfile );
        String savefileAsCode = Base64Coder.encodeString( savefileAsText );
     

       savedDataFile.writeString( savefileAsCode, false );
   

    }



    public void persist()
    {
        if( savedfile != null ) {
            persist( savedfile );
        }
    }
}
