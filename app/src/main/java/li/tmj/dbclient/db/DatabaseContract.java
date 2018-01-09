package li.tmj.dbclient.db;


import android.provider.BaseColumns;

public class DatabaseContract {
    public static class PersonEntry implements BaseColumns{// Standardklasse mit konventionalisierten Konstanten für DB Felder
        public static final String TABLE="persons";
        public static final String CLM_NAME_INDIV="name_indiv";
        public static final String CLM_NAME_FAMILY="name_family";
        public static final String CLM_SEX="sex";
        public static final String CLM_BIRTHDAY="birthday";
        public static final String CLM_BIRTHMONTH="birthmonth";
        public static final String CLM_BIRTHYEAR="birthyear";

        public static final String CREATE_TABLE ="create table if not exists "
                + TABLE+" ("
                + _ID+" integer primary key"
                + ", " + CLM_NAME_INDIV+" text"
                + ", " + CLM_NAME_FAMILY+" text"
                + ", " + CLM_SEX+" text"
                + ", " + CLM_BIRTHDAY+" integer"
                + ", " + CLM_BIRTHMONTH+" integer"
                + ", " + CLM_BIRTHYEAR+" integer"
                //Fremdschlüssel-Constrain:
                //+", foreign key ( " + COLUMN_BREEDER_ID+" ) references " + BreederEntry.TABLE +" ("+ BreederEntry._ID+")"
                +")";
    }


//    public static class AddressEntry implements BaseColumns{
//        public static final String TABLE="address";
//        public static final String COLUMN_PC="postcode";
//
//        public static final String CREATE_TABLE ="create table if not exists "
//                + TABLE+" "+"("
//                + _ID+" integer primary key, "
//                + COLUMN_NAME+" text not null "
//                +")";
//    }
}
