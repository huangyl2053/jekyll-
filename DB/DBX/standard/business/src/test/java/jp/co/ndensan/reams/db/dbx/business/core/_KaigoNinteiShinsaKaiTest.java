/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * {@link _KaigoNinteiShinsaKai}のテストクラスです。
 *
 * @author N2204 三井 沙織
 */
@RunWith(Enclosed.class)
public class _KaigoNinteiShinsaKaiTest extends DbxTestBase {

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の資料作成年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _KaigoNinteiShinsaKai(null, mock(RDate.class), 0, mock(RDate.class));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の開催予定年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _KaigoNinteiShinsaKai(mock(RDate.class), null, 0, mock(RDate.class));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の回答年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _KaigoNinteiShinsaKai(mock(RDate.class), mock(RDate.class), 0, null);
        }
    }

    public static class 資料作成年月日_開催予定年月日_合議体番号_回答年月日Test extends DbxTestBase {

        private _KaigoNinteiShinsaKai create介護認定審査会() {
            return new _KaigoNinteiShinsaKai(new RDate("20140101"), new RDate("20140102"), 0, new RDate("20140303"));
        }

        @Test
        public void LDNS_資料作成年月日は20140101の場合_get資料作成年月日は_20140101を返す() {
            assertThat(create介護認定審査会().get資料作成年月日(), is(new RDate("20140101")));
        }

        @Test
        public void LDNS_開催予定年月日は20140102の場合_get開催予定年月日は_20140102を返す() {
            assertThat(create介護認定審査会().get開催予定年月日(), is(new RDate("20140102")));
        }

        @Test
        public void LDNS_合議体番号は0の場合_get合議体番号は_0を返す() {
            assertThat(create介護認定審査会().get合議体番号(), is(0));
        }

        @Test
        public void LDNS_回答年月日は20140303の場合_get回答年月日は_20140303を返す() {
            assertThat(create介護認定審査会().get回答年月日(), is(new RDate("20140303")));
        }
    }
}
