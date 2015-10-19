/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 *
 * @author N9943 王 永康
 */
@RunWith(Enclosed.class)
public class _KogakuKaigoServiceHiTest extends DbxTestBase {

    /**
     * コンストラクタのテストです。
     */
    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの識別コードにnullを指定した時_NullPointerExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(null, mock(FlexibleYearMonth.class), Decimal.TEN, new Decimal(100));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービス提供年月にnullを指定した時_NullPointerExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, null, Decimal.TEN, new Decimal(100));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの支給高額介護サービス費にnullを指定した時_NullPointerExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), null, new Decimal(100));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの利用者負担額にnullを指定した時_NullPointerExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), Decimal.TEN, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタの支給高額介護サービス費に負１を指定した時_IllegalArgumentExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), new Decimal(-1), new Decimal(100));
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタの利用者負担額に負１を指定した時_IllegalArgumentExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), Decimal.TEN, new Decimal(-1));
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタの利用者負担額に100_支給高額介護サービス費に200を指定した時_IllegalArgumentExceptionを返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), new Decimal(200), new Decimal(100));
        }
    }

    /**
     * get償還後利用者負担額のテストです。
     */
    public static class get償還後利用者負担額 extends DbxTestBase {

        @Test
        public void コンストラクタの利用者負担額に200_支給高額介護サービス費に100を指定した時_get償還後利用者負担額は100を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), new Decimal(100), new Decimal(200));
            assertThat(sut.get償還後利用者負担額(), is(new Decimal(100)));
        }

        @Test
        public void コンストラクタの利用者負担額に200_支給高額介護サービス費に200を指定した時_get償還後利用者負担額は0を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(RString.EMPTY, mock(FlexibleYearMonth.class), new Decimal(200), new Decimal(200));
            assertThat(sut.get償還後利用者負担額(), is(Decimal.ZERO));
        }
    }

    public static class get被保険者番号のテスト extends DbxTestBase {

        @Test
        public void LDNS_被保険者番号を設定する場合_get被保険者番号は_被保険者番号を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(new RString("被保険者番号"), mock(FlexibleYearMonth.class), new Decimal(100), new Decimal(200));
            assertThat(sut.get被保険者番号(), is(new RString("被保険者番号")));
        }
    }

    public static class getサービス提供年月のテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス提供年月を設定する場合_getサービス提供年月は_201312を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(new RString("被保険者番号"), new FlexibleYearMonth(new RString(("201312"))), new Decimal(100), new Decimal(200));
            assertThat(sut.getサービス提供年月(), is(new FlexibleYearMonth(new RString(("201312")))));
        }
    }

    public static class get支給高額介護サービス費のテスト extends DbxTestBase {

        @Test
        public void LDNS_支給高額介護サービス費を設定する場合_get支給高額介護サービス費は_100を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(new RString("支給高額介護サービス費"), mock(FlexibleYearMonth.class), new Decimal(100), new Decimal(200));
            assertThat(sut.get支給高額介護サービス費(), is(new Decimal(100)));
        }
    }

    public static class get利用者負担額のテスト extends DbxTestBase {

        @Test
        public void LDNS_利用者負担額を設定する場合_get利用者負担額は_200を返す() {
            IKogakuKaigoServiceHi sut = new _KogakuKaigoServiceHi(new RString("利用者負担額"), mock(FlexibleYearMonth.class), new Decimal(100), new Decimal(200));
            assertThat(sut.get利用者負担額(), is(new Decimal(200)));
        }
    }
}
