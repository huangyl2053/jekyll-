/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 要介護認定一次判定のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
@RunWith(Enclosed.class)
public class _YoKaigoNinteiIchijiHanteiTest extends DbxTestBase {

    private static _YoKaigoNinteiIchijiHantei sut;
    private static YoKaigoJotaiKubun 要介護状態区分;
    private static YoKaigoJotaiKubun 要介護状態区分_認知症加算;
    private static RDate 判定年月日;

    @BeforeClass
    public static void setUpClass() {
        要介護状態区分 = YoKaigoJotaiKubun.要介護1;
        要介護状態区分_認知症加算 = YoKaigoJotaiKubun.要介護1;
        判定年月日 = mock(RDate.class);
        sut = new _YoKaigoNinteiIchijiHantei(要介護状態区分, 要介護状態区分_認知症加算, 判定年月日);
    }

    public static class _YoKaigoNinteiIchijiHanteiInitTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiIchijiHantei(null, 要介護状態区分_認知症加算, 判定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分_認知症加算がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiIchijiHantei(要介護状態区分, null, 判定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 判定年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiIchijiHantei(要介護状態区分, 要介護状態区分_認知症加算, null);
        }

        @Test
        public void LDNS_YoKaigoNinteiIchijiHanteiは_生成した要介護認定一次判定を返す() {
            assertThat(new _YoKaigoNinteiIchijiHantei(要介護状態区分, 要介護状態区分_認知症加算, 判定年月日), instanceOf(_YoKaigoNinteiIchijiHantei.class));
        }
    }

    public static class getTest extends DbxTestBase {

        @Test
        public void LDNS_get要介護状態区分は_要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(要介護状態区分));
        }

        @Test
        public void LDNS_get要介護状態区分_認知症加算は_要介護状態区分_認知症加算を返す() {
            assertThat(sut.get要介護状態区分_認知症加算(), is(要介護状態区分_認知症加算));
        }

        @Test
        public void LDNS_get判定年月日は_判定年月日を返す() {
            assertThat(sut.get判定年月日(), is(判定年月日));
        }
    }
}
