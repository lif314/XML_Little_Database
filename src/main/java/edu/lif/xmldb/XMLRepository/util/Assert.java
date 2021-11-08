package edu.lif.xmldb.XMLRepository.util;
public abstract class Assert {

    public static void notNull(@Nullable Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }

}
