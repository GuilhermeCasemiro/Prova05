package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.sql.Timestamp.valueOf;
import static org.joda.time.DateTimeZone.UTC;

import java.sql.Timestamp;

import org.jeasy.random.api.Randomizer;
import org.joda.time.DateTime;

public class DateTimeRandom implements Randomizer<DateTime> {

    @Override
    public DateTime getRandomValue() {
        long rangeBegin = valueOf("1980-02-08 00:00:00").getTime();
        long rangeEnd = valueOf("1999-02-08 00:58:00").getTime();
        long diff = rangeEnd - rangeBegin + 1;
        Timestamp rand = new Timestamp(rangeBegin + (long) (Math.random() * diff));
        
        return new  DateTime(rand, UTC);
    }

}
