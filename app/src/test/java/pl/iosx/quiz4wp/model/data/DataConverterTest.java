package pl.iosx.quiz4wp.model.data;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lukaszwroblewski on 30.03.2018.
 */
public class DataConverterTest {
    @Test
    public void getDateFromDateString() throws Exception {

        Date date = DataConverter.getDateFromDateString("2018-03-27T15:36:33+0000");
        assertEquals(date.getTime(),1522157793000l);
    }

}