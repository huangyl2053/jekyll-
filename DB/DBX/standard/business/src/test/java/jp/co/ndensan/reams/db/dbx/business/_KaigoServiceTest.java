/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

/**
 * 介護サービスクラスのテストクラスです
 *
 * @author n9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class _KaigoServiceTest extends DbxTestBase {

    private static IKaigoServiceShurui kaigoServiceShurui;
    private static IKaigoServiceNaiyo KaigoServiceNaiyo1;
    private static IKaigoServiceNaiyo KaigoServiceNaiyo2;
    private static IKaigoServiceNaiyo KaigoServiceNaiyo3;
    private static List<IKaigoServiceNaiyo> kaigoServiceNaiyoList;
    private static _KaigoService sut;
    private static IKaigoServiceTani 介護サービス単位1;
    private static IKaigoServiceTani 介護サービス単位2;
    private static IKaigoServiceTani 介護サービス単位3;

    @BeforeClass
    public static void setUpClass() {

        kaigoServiceShurui = new _KaigoServiceShurui(new KaigoServiceShuruiCode(new RString("01")),
                new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201305")),
                new RString("種類名称"), new RString("種類名称略称"), new KaigoServiceBunruiCode(new RString("001")));
        介護サービス単位1 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("001")), new TanisuSanteiTani(new RString("3000")));
        介護サービス単位2 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("002")), new TanisuSanteiTani(new RString("4000")));
        介護サービス単位3 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("003")), new TanisuSanteiTani(new RString("5000")));
        KaigoServiceNaiyo1 = new _KaigoServiceNaiyo(
                new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("01")), new RString("2345")),
                new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201305")),
                1, new RString("名称１"), new RString("略称１"), 介護サービス単位1);
        KaigoServiceNaiyo2 = new _KaigoServiceNaiyo(
                new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("67")), new RString("8901")),
                new Range<>(new FlexibleYearMonth("201306"), new FlexibleYearMonth("201307")),
                2, new RString("名称２"), new RString("略称２"), 介護サービス単位2);
        KaigoServiceNaiyo3 = new _KaigoServiceNaiyo(
                new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("23")), new RString("4567")),
                new Range<>(new FlexibleYearMonth("201308"), new FlexibleYearMonth("201309")),
                3, new RString("名称３"), new RString("略称３"), 介護サービス単位3);
        kaigoServiceNaiyoList = new ArrayList();
        kaigoServiceNaiyoList.add(KaigoServiceNaiyo1);
        kaigoServiceNaiyoList.add(KaigoServiceNaiyo2);
        kaigoServiceNaiyoList.add(KaigoServiceNaiyo3);
    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護サービス種類にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoService(null, kaigoServiceNaiyoList);
        }
    }

    public static class Get介護サービス種類 extends DbxTestBase {

        @Test
        public void get介護サービス種類は_IKaigoServiceShuruiを返す() {
            sut = new _KaigoService(kaigoServiceShurui, kaigoServiceNaiyoList);
            IKaigoServiceShurui result = sut.get介護サービス種類();
            assertThat(result.getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
        }
    }

    public static class Get介護サービス内容 extends DbxTestBase {

        @Test
        public void get介護サービス内容は_サイズ3_履歴番号が1_2_3のIKaigoServiceNaiyoのListを返す() {
            sut = new _KaigoService(kaigoServiceShurui, kaigoServiceNaiyoList);
            List<IKaigoServiceNaiyo> result = sut.get介護サービス内容リスト();
            assertThat(result.size(), is(3));
            assertThat(result.get(0).get履歴番号(), is(1));
            assertThat(result.get(1).get履歴番号(), is(2));
            assertThat(result.get(2).get履歴番号(), is(3));
        }
    }
}
