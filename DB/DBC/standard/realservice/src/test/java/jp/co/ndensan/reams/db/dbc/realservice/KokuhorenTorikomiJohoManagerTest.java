/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.model.relate.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N2810 久保 里史
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoManagerTest extends DbcTestBase {

    private static KokuhorenTorikomiJohoManager sut;
    private static final RYearMonth DEFAULT_処理年月 = new RYearMonth("201402");
    private static final RYearMonth DEFAULT_最大処理年月 = new RYearMonth("201411");
    private static final RYearMonth DEFAULT_現在年月 = new RYearMonth("201501");
    private static final RYearMonth DEFAULT_存在しない処理年月 = new RYearMonth("201504");
    private static final RString DEFAULT_交換情報識別番号 = new RString("121");

    public static class Test_get国保連IF管理Max処理年月 {

        @Test
        public void 国保連IF管理にデータがない時_get国保連IF管理Max処理年月は_現在の年月を返す() {
            sut = createManager();
            RYearMonth result = sut.get国保連IF管理Max処理年月();
            assertThat(result, is(DEFAULT_現在年月));
        }

        @Test
        public void 国保連IF管理にデータがある時_get国保連IF管理Max処理年月は_最大の年月を返す() {
            sut = createManager();
            RYearMonth result = sut.get国保連IF管理Max処理年月();
            assertThat(result, is(DEFAULT_最大処理年月));
        }
    }

    public static class Test_get国保連取込情報 {

        @Test
        public void 該当の処理年月がない時_get国保連取込情報は_NULLを返す() {
            sut = createManager();
            List<KokuhorenTorikomiJohoModel> result = sut.get国保連取込情報(DEFAULT_存在しない処理年月);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 該当の処理年月がある時_get国保連取込情報は_国保連取込情報を返す() {
            sut = createManager();
            List<KokuhorenTorikomiJohoModel> result = sut.get国保連取込情報(DEFAULT_処理年月);
            assertThat(result, is(notNullValue()));
        }
    }

    public static class Test_Save国保連IF管理の処理状態を起動にする {

        @Test
        public void saveに成功した場合_trueを返す() {
            sut = createManager();

            assertThat(sut.Save国保連IF管理の処理状態を起動にする(DEFAULT_処理年月, DEFAULT_交換情報識別番号), is(true));
        }
    }

    private static KokuhorenTorikomiJohoManager createManager() {
        return new KokuhorenTorikomiJohoManager();
    }

}
