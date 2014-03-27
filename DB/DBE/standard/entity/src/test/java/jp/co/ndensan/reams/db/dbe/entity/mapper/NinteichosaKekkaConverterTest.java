/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査結果を変換するConverterクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaConverterTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査票定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaKekkaConverter(null);
        }
    }

    public static class create調査結果_String {

        @Test
        public void 調査項目がある時_create調査結果は_調査結果を返す() {
            assertThat(createConverter().create調査結果(NinteichosaItemKubunOfGaikyo.概況特記事項, new RString("概況特記事項")).get調査結果(), is(new RString("概況特記事項")));
        }

        @Test
        public void 調査項目がない時_create調査結果は_NULLを返す() {
            assertThat(createConverter().create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, new RString("1")), nullValue());
        }
    }

    public static class create調査結果_int {

        @Test
        public void 調査項目がある時_create調査結果は_調査結果を返す() {
            assertThat(createConverter().create調査結果(NinteichosaItemKubunOfGaikyo.訪問看護, 2).get調査結果(), is(new RString("2")));
        }

        @Test
        public void 調査項目がない時_create調査結果は_NULLを返す() {
            assertThat(createConverter().create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, 123), nullValue());
        }
    }

    public static class get調査結果ByStringValue {

        @Test
        public void 調査項目がある時_get調査結果ByStringValueは_調査結果を返す() {
            assertThat(createConverterForResult().get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.概況特記事項), is(new RString("概況特記事項")));
        }

        @Test
        public void 調査項目がない時_get調査結果ByStringValueは_NULLを返す() {
            assertThat(createConverterForResult().get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢), nullValue());
        }
    }

    public static class get調査結果ByIntValue {

        @Test
        public void 調査項目がある時_get調査結果ByIntValueは_調査結果を返す() {
            assertThat(createConverterForResult().get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.訪問看護), is(2));
        }

        @Test
        public void 調査項目がない時_get調査結果ByIntValueは_0を返す() {
            assertThat(createConverterForResult().get調査結果ByIntValue(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢), is(0));
        }
    }

    public static class get調査結果ByCodeValue {

        @Test
        public void 調査項目がある時_get調査結果ByCodeValueは_調査結果を返す() {
            assertThat(createConverterForResult().get調査結果ByCodeValue(NinteichosaItemKubunOfGaikyo.サービス区分コード), is(new Code("2")));
        }

        @Test
        public void 調査項目がない時_get調査結果ByCodeValueは_NULLを返す() {
            assertThat(createConverterForResult().get調査結果ByCodeValue(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢), nullValue());
        }
    }

    private static NinteichosaKekkaConverter createConverter() {
        return new NinteichosaKekkaConverter(NinteichosahyoFactory.createサービス状況Instance(KoroshoIFKubun.V09A));
    }

    private static NinteichosaKekkaConverter createConverterForResult() {
        return new NinteichosaKekkaConverter(NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get認定調査票());
    }
}
