/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuUmu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定警告配列コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKeikokuHairetsuCodeTest {

    private static IchijiHanteiKeikokuHairetsuCode sut;
    private static RString 警告配列コード;
    private static FlexibleDate 判定年月日;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            警告配列コード = new RString("001001010101010000");
            判定年月日 = new FlexibleDate("20090401");
        }

        @Test(expected = NullPointerException.class)
        public void 警告配列コードにnullが渡されたとき_NullPointerExcetionが発生する() {
            sut = new IchijiHanteiKeikokuHairetsuCode(null, 判定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 警告コード種別にnullが渡されたとき_NullPointerExcetionが発生する() {
            sut = new IchijiHanteiKeikokuHairetsuCode(警告配列コード, null);
        }
    }

    public static class valueAtのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            警告配列コード = new RString("001001010101010000");
            判定年月日 = new FlexibleDate("20090401");
            sut = new IchijiHanteiKeikokuHairetsuCode(警告配列コード, 判定年月日);
        }

        @Test
        public void インデックスに2を指定した場合_警告有りが取得できる() {
            assertThat(sut.valueAt(2), is(IchijiHanteiKeikokuUmu.警告有り));
        }

        @Test
        public void インデックスに4を指定した場合_警告無しが取得できる() {
            assertThat(sut.valueAt(3), is(IchijiHanteiKeikokuUmu.警告無し));
        }

        @Test
        public void インデックスに9999を指定した場合_nullが返る() {
            assertThat(sut.valueAt(9999), is(nullValue()));
        }

        @Test
        public void インデックスに0より小さい値を指定した場合_nullが返る() {
            assertThat(sut.valueAt(-1), is(nullValue()));
        }
    }
}
