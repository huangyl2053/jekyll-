/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JukyushaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 要介護認定結果のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
@RunWith(Enclosed.class)
public class _YoKaigoNinteiKekkaTest extends DbxTestBase {

    /**
     * コンストラクタのテストです。
     */
    public static class コンストラクタ extends DbxTestBase {

        private static RDate 認定年月日;
        private static YoKaigoJotaiKubun 要介護状態区分;
        private static Range<RDate> 認定有効期間;
        private static RString 介護認定審査会意見;
        private static RDate 異動年月日;
        private static RString 特定疾病;
        private static RDate 基準日;

        @BeforeClass
        public static void setUpClass() {
            認定年月日 = mock(RDate.class);
            要介護状態区分 = YoKaigoJotaiKubun.要介護1;
            認定有効期間 = mock(Range.class);
            介護認定審査会意見 = new RString("");
            異動年月日 = mock(RDate.class);
            特定疾病 = new RString("");
            基準日 = mock(RDate.class);
        }

        @Test(expected = NullPointerException.class)
        public void 認定年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(null, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, null, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定有効期間がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, null, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会意見がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, null, 異動年月日, 特定疾病, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 異動年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, null, 特定疾病, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 特定疾病がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, null, 基準日);
        }

        @Test(expected = NullPointerException.class)
        public void 基準日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, null);
        }
    }

    /**
     * get受給者区分のテストです。
     */
    public static class get受給者区分 extends DbxTestBase {

        private _YoKaigoNinteiKekka sut;
        private static RDate 認定年月日;
        private static YoKaigoJotaiKubun 要介護状態区分;
        private static Range<RDate> 認定有効期間;
        private static RString 介護認定審査会意見;
        private static RDate 異動年月日;
        private static RString 特定疾病;
        private static RDate 基準日;

        @BeforeClass
        public static void setUpClass() {
            認定年月日 = mock(RDate.class);
            要介護状態区分 = YoKaigoJotaiKubun.要介護1;
            認定有効期間 = new Range((new RDate(2013, 01, 01)), (new RDate(2015, 01, 01)));
            介護認定審査会意見 = new RString("");
            異動年月日 = mock(RDate.class);
            特定疾病 = new RString("");
        }

        @Test
        public void 基準日が認定有効期間内である場合_get要介護状態区分は_受給者を返す() {
            基準日 = new RDate(2014, 10, 20);
            sut = new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
            assertThat(sut.get受給者区分(), is(JukyushaKubun.受給者));
        }

        @Test
        public void 基準日が認定有効期間外である場合_get要介護状態区分は_非受給者を返す() {
            基準日 = new RDate(2011, 10, 20);
            sut = new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
            assertThat(sut.get受給者区分(), is(JukyushaKubun.非受給者));
        }
    }

    public static class LDNS_コンストラクタ extends DbxTestBase {

        private static _YoKaigoNinteiKekka sut;
        private static RDate 認定年月日;
        private static YoKaigoJotaiKubun 要介護状態区分;
        private static Range<RDate> 認定有効期間;
        private static RString 介護認定審査会意見;
        private static RDate 異動年月日;
        private static RString 特定疾病;
        private static RDate 基準日;

        @BeforeClass
        public static void setUpClass() {
            認定年月日 = new RDate(2015);
            要介護状態区分 = YoKaigoJotaiKubun.非該当;
            認定有効期間 = mock(Range.class);
            介護認定審査会意見 = new RString("123");
            異動年月日 = new RDate(2015);
            特定疾病 = new RString("123");
            基準日 = new RDate(2015);
            sut = new _YoKaigoNinteiKekka(認定年月日, 要介護状態区分, 認定有効期間, 介護認定審査会意見, 異動年月日, 特定疾病, 基準日);
        }

        @Test
        public void LDNS_認定年月日は2015の場合_get認定年月日は_2015を返す() {
            assertThat(sut.get認定年月日(), is(new RDate(2015)));
        }

        @Test
        public void LDNS_要介護状態区分は非該当の場合_get要介護状態区分は_非該当を返す() {
            assertThat(sut.get要介護状態区分(), is(YoKaigoJotaiKubun.非該当));
        }

        @Test
        public void LDNS_認定有効期間は認定有効期間の場合_get認定有効期間は_認定有効期間を返す() {
            assertThat(sut.get認定有効期間(), is(認定有効期間));
        }

        @Test
        public void LDNS_介護認定審査会意見は123の場合_get介護認定審査会意見は_123を返す() {
            assertThat(sut.get介護認定審査会意見(), is(new RString("123")));
        }

        @Test
        public void LDNS_認定年月日は2015の場合_get異動年月日は_2015を返す() {
            assertThat(sut.get異動年月日(), is(new RDate(2015)));
        }

        @Test
        public void LDNS_特定疾病は123の場合_get特定疾病は_123を返す() {
            assertThat(sut.get特定疾病(), is(new RString("123")));
        }

        @Test
        public void LDNS_認定有効期間between基準日はtrueの場合_get受給者区分は_受給者を返す() {
            when(認定有効期間.between(基準日)).thenReturn(true);
            assertThat(sut.get受給者区分(), is(JukyushaKubun.受給者));
        }

        @Test
        public void LDNS_認定有効期間between基準日はfalseの場合_get受給者区分は_非受給者を返す() {
            when(認定有効期間.between(基準日)).thenReturn(false);
            assertThat(sut.get受給者区分(), is(JukyushaKubun.非受給者));
        }

        @Test
        public void LDNS_get認定有効開始日を調用の場合_get認定有効開始日は_認定有効開始日を返す() {
            assertThat(sut.get認定有効開始日(), is(認定有効期間.getFrom()));
        }

        @Test
        public void LDNS_get認定有効終了日を調用の場合_get認定有効終了日は_認定有効終了日を返す() {
            assertThat(sut.get認定有効終了日(), is(認定有効期間.getTo()));
        }
    }
}
