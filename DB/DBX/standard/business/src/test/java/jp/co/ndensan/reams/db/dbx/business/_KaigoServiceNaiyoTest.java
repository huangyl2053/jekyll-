/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * 介護サービス内容クラスのテストクラスです
 *
 * @author n9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class _KaigoServiceNaiyoTest extends DbxTestBase {

    private static _KaigoServiceNaiyo sut;
    private static _KaigoServiceCode kaigoServiceCode;
    private static IKaigoServiceCode サービスコード;
    private static Range<FlexibleYearMonth> 適用年月;
    private static int 履歴番号;
    private static RString サービス名称;
    private static RString サービス略称;
    private static IKaigoServiceTani 介護サービス単位;

    @BeforeClass
    public static void setUpClass() {
        kaigoServiceCode = new _KaigoServiceCode(new KaigoServiceShuruiCode("01"), new RString("2345"));
        サービスコード = kaigoServiceCode;
        適用年月 = new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201305"));
        履歴番号 = 1;
        サービス名称 = new RString("名称");
        サービス略称 = new RString("略称");
        介護サービス単位 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("01")), new TanisuSanteiTani(new RString("3000")));
    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービスコードにnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(null, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの提供年月にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, null, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービス名称にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, null, サービス略称, 介護サービス単位);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービス略称にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, null, 介護サービス単位);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護サービス単位にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, null);
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_コンストラクタの介護サービス単位にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceNaiyo(null);
        }

        @Test
        public void LDNS_コンストラクタの介護サービス単位にnullを指定した時_KaigoServiceNaiyoのインスタンスを返す() {
            sut = new _KaigoServiceNaiyo(サービスコード);
        }
    }

    public static class Getサービスコード extends DbxTestBase {

        @Test
        public void getサービスコードは_サービス種類コードに01_サービス項目コードに2345_サービスコードに012345を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            IKaigoServiceCode result = sut.getサービスコード();
            assertThat(result.getサービス種類コード(), is(new KaigoServiceShuruiCode("01")));
            assertThat(result.getサービス項目コード(), is(new RString("2345")));
            assertThat(result.getサービスコード(), is(new RString("012345")));
        }
    }

    public static class Get適用年月 extends DbxTestBase {

        @Test
        public void コンストラクタの適用年月に201304_201305を指定した時_get適用年月は_201304_201305を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            Range<FlexibleYearMonth> result = sut.get適用年月();
            assertThat(result.getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.getTo(), is(new FlexibleYearMonth("201305")));
        }
    }

    public static class Get履歴番号 extends DbxTestBase {

        @Test
        public void コンストラクタの履歴番号に1を指定した時_get履歴番号は_1を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            assertThat(sut.get履歴番号(), is(1));
        }
    }

    public static class Getサービス名称 extends DbxTestBase {

        @Test
        public void コンストラクタのサービス名称に名称を指定した時_getサービス名称は_名称を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            assertThat(sut.getサービス名称(), is(new RString("名称")));
        }
    }

    public static class Getサービス略称 extends DbxTestBase {

        @Test
        public void コンストラクタのサービス略称に略称を指定した時_getサービス略称は_略称を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            assertThat(sut.getサービス略称(), is(new RString("略称")));
        }
    }

    public static class Get介護サービス単位 extends DbxTestBase {

        @Test
        public void get介護サービス単位は_介護サービス単位型を返す() {
            sut = new _KaigoServiceNaiyo(サービスコード, 適用年月, 履歴番号, サービス名称, サービス略称, 介護サービス単位);
            assertThat(sut.get介護サービス単位(), instanceOf(IKaigoServiceTani.class));
        }
    }
}
