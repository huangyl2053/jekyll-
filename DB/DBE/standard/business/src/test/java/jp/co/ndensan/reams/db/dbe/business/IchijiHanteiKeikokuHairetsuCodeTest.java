/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuUmu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static FlexibleDate 判定年月日_20090401;
    private static IchijiHanteiKeikokuShubetsu 警告種別;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            判定年月日_20090401 = new FlexibleDate("20090401");
            警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日_20090401);
            警告配列コード = create警告配列コード(IchijiHanteiKeikokuUmu.警告有り, IchijiHanteiKeikokuUmu.警告無し, 警告種別.get警告数());
        }

        @Test(expected = NullPointerException.class)
        public void 警告配列コードにnullが渡されたとき_NullPointerExcetionが発生する() {
            sut = new IchijiHanteiKeikokuHairetsuCode(null, 判定年月日_20090401);
        }

        @Test(expected = NullPointerException.class)
        public void 警告コード種別にnullが渡されたとき_NullPointerExcetionが発生する() {
            sut = new IchijiHanteiKeikokuHairetsuCode(警告配列コード, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 警告配列コードの長さが_警告種別で設定されている配列コード長と一致しないとき_IllegalArgumentExceptionが発生する() {
            sut = new IchijiHanteiKeikokuHairetsuCode(new RString("0011101010"), 判定年月日_20090401);
        }
    }

    public static class valueAtのテスト extends DbeTestBase {

        private int 警告配列コード長;

        @Before
        public void setUp() {
            判定年月日_20090401 = new FlexibleDate("20090401");
            警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日_20090401);
            警告配列コード = create警告配列コード(IchijiHanteiKeikokuUmu.警告有り, IchijiHanteiKeikokuUmu.警告無し, 警告種別.get警告数());
            sut = new IchijiHanteiKeikokuHairetsuCode(警告配列コード, 判定年月日_20090401);
            警告配列コード長 = sut.length();
        }

        @Test
        public void インデックスに警告配列コード長より1小さい値を指定した場合_警告無しが返る() {
            assertThat(sut.valueAt(警告配列コード長 - 1), is(IchijiHanteiKeikokuUmu.警告無し));
        }

        @Test(expected = IllegalArgumentException.class)
        public void インデックスに警告配列コード長と同じ値を指定した場合_IllegalArgumentExceptionが返る() {
            sut.valueAt(警告配列コード長);
        }

        @Test
        public void インデックスに0を指定した場合_警告有りが返る() {
            assertThat(sut.valueAt(0), is(IchijiHanteiKeikokuUmu.警告有り));
        }

        @Test(expected = IllegalArgumentException.class)
        public void インデックスに0より小さい値を指定した場合_IllegalArgumentExceptionが返る() {
            sut.valueAt(-1);
        }
    }

    private static RString create警告配列コード(IchijiHanteiKeikokuUmu 最初の項目有無, IchijiHanteiKeikokuUmu 最後の警告有無, int 警告数) {
        RStringBuilder 警告配列コードBuilder = new RStringBuilder(最初の項目有無.get警告有無区分コード());
        for (int i = 0; i < 警告数 - 2; i++) {
            警告配列コードBuilder.append("0");
        }
        警告配列コードBuilder.append(最後の警告有無.get警告有無区分コード());
        return 警告配列コードBuilder.toRString();
    }
}
