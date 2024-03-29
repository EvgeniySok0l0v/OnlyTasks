package org.example;

/*
3. Создать класс Park с внутренним классом,
с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Park
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Park {

    private String parkName;

    /**
     * Class for Attraction
     */
    @AllArgsConstructor
    @Getter
    @ToString
    public class Attraction {

        private String attractionName;
        private double ticketPrice;
        private String workTime;
    }
}
