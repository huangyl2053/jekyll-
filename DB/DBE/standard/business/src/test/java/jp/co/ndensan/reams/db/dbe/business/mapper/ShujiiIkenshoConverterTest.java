/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShujiiIkenshoConverter;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書の結果を変換するConverterクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoConverterTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 意見書定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ShujiiIkenshoConverter(null);
        }
    }

    public static class create意見書結果_String {

        @Test
        public void 意見書項目がある時_create意見書結果は_意見書結果を返す() {
            assertThat(createConverter().create意見書結果(ShujiiIkenshoItemKubun.特記事項, new RString("特記事項")).get意見書結果(), is(new RString("特記事項")));
        }

        @Test
        public void 意見書項目がない時_create意見書結果は_NULLを返す() {
            assertThat(createConverter().create意見書結果(ShujiiIkenshoItemKubun.特記事項イメージ, new RString("1")), nullValue());
        }
    }

    public static class create意見書結果_int {

        @Test
        public void 意見書項目がある時_create意見書結果は_意見書結果を返す() {
            assertThat(createConverter().create意見書結果(ShujiiIkenshoItemKubun.訪問看護, 1).get意見書結果(), is(new RString("1")));
        }

        @Test
        public void 意見書項目がない時_create調査結果は_NULLを返す() {
            assertThat(createConverter().create意見書結果(ShujiiIkenshoItemKubun.特記事項イメージ, 123), nullValue());
        }
    }

    public static class get意見書結果ByStringValue {

        @Test
        public void 意見書項目がある時_get意見書結果ByStringValueは_意見書結果を返す() {
            assertThat(createConverterForResult().get意見書結果ByStringValue(ShujiiIkenshoItemKubun.特記事項), is(new RString("特記事項")));
        }

        @Test
        public void 意見書項目がない時_get意見書結果ByStringValueは_NULLを返す() {
            assertThat(createConverterForResult().get意見書結果ByStringValue(ShujiiIkenshoItemKubun.特記事項イメージ), nullValue());
        }
    }

    public static class get意見書結果ByIntValue {

        @Test
        public void 意見書項目がある時_get意見書結果ByIntValueは_意見書結果を返す() {
            assertThat(createConverterForResult().get意見書結果ByIntValue(ShujiiIkenshoItemKubun.症状の安定性), is(1));
        }

        @Test
        public void 意見書項目がない時_get意見書結果ByIntValueは_0を返す() {
            assertThat(createConverterForResult().get意見書結果ByIntValue(ShujiiIkenshoItemKubun.特記事項イメージ), is(0));
        }
    }

    public static class get意見書結果ByCodeValue {

        @Test
        public void 意見書項目がある時_get意見書結果ByCodeValueは_意見書結果を返す() {
            assertThat(createConverterForResult().get意見書結果ByCodeValue(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度), is(new Code("4")));
        }

        @Test
        public void 意見書項目がない時_get意見書結果ByCodeValueは_NULLを返す() {
            assertThat(createConverterForResult().get意見書結果ByCodeValue(ShujiiIkenshoItemKubun.特記事項イメージ), nullValue());
        }
    }

    private static ShujiiIkenshoConverter createConverter() {
        return new ShujiiIkenshoConverter(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A));
    }

    private static ShujiiIkenshoConverter createConverterForResult() {
        return new ShujiiIkenshoConverter(ShujiiIkenshoResultMock.getSpiedShujiiIkenshoDetailsInstance().get主治医意見書());
    }
}
