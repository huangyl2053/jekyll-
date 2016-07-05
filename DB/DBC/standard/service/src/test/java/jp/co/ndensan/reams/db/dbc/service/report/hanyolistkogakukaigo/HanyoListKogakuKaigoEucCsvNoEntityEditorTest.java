/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(Enclosed.class)
public class HanyoListKogakuKaigoEucCsvNoEntityEditorTest {

    public static class convertDayOfWeekTest extends DbcTestBase {

        private static HanyoListKogakuKaigoEucCsvNoEntityEditor sut;
        private static Method method;

        @BeforeClass
        public static void test() throws NoSuchMethodException {
            sut = new HanyoListKogakuKaigoEucCsvNoEntityEditor(FlexibleDate.getNowDate());
            method = HanyoListKogakuKaigoEucCsvNoEntityEditor.class
                    .getDeclaredMethod(
                            "convertDayOfWeek", FlexibleDate.class);
            method.setAccessible(true);
        }

        @Test
        public void 引数がnullの場合_戻り値は空のRStringになる()
                throws NoSuchMethodException,
                       SecurityException,
                       IllegalAccessException,
                       IllegalArgumentException,
                       InvocationTargetException {
            RString actual = (RString) method.invoke(sut, new Object[]{null});

            assertThat(actual, is(RString.EMPTY));
        }

        @Test
        public void 引数がEmptyの場合_戻り値は空のRStringになる()
                throws NoSuchMethodException,
                       SecurityException,
                       IllegalAccessException,
                       IllegalArgumentException,
                       InvocationTargetException {
            RString actual = (RString) method.invoke(sut, FlexibleDate.EMPTY);

            assertThat(actual, is(RString.EMPTY));
        }

        @Test
        public void 引数が非歴上日の場合_戻り値は空のRStringになる()
                throws NoSuchMethodException,
                       SecurityException,
                       IllegalAccessException,
                       IllegalArgumentException,
                       InvocationTargetException {
            RString actual = (RString) method.invoke(sut, new FlexibleDate(9999, 12, 32));

            assertThat(actual, is(RString.EMPTY));
        }

        @Test
        public void 引数が歴上日の場合_戻り値は引数の曜日になる()
                throws NoSuchMethodException,
                       SecurityException,
                       IllegalAccessException,
                       IllegalArgumentException,
                       InvocationTargetException {
            RString actual = (RString) method.invoke(sut, new FlexibleDate(2016, 5, 21));

            assertThat(actual, is(new RString(DayOfWeek.SATURDAY.toString())));
        }
    }

}
