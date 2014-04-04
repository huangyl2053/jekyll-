/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoFactory;
import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票を編集するクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoEditorTest {

    private static final INinteichosaItemKubun ITEM_KUBUN = NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢;
    private static final RString STRING_VALUE = new RString("123");
    private static final int INT_VALUE = 123;
    private static final Code CODE_VALUE = new Code("123");

    public static class setItem {

        @Test
        public void 調査項目の指定がある時_setItemは_指定値を設定する() {
            NinteichosahyoEditor sut = createEditor(createNewChosahyo());
            sut.setItem(createChosahyo().get調査項目(ITEM_KUBUN));
            assertThat(sut.getNinteichosahyo().get調査項目(ITEM_KUBUN).get調査項目区分(), is(ITEM_KUBUN));
        }
    }

    public static class setResult_string {

        @Test
        public void 調査結果の指定がある時_setResultは_指定値を設定する() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, STRING_VALUE);
            assertThat(((NinteichosaItemForResult) sut.getNinteichosahyo().get調査項目(ITEM_KUBUN)).get調査結果(), is(STRING_VALUE));
        }
    }

    public static class setResult_int {

        @Test
        public void 調査結果の指定がある時_setResultは_指定値を設定する() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, INT_VALUE);
            assertThat(((NinteichosaItemForResult) sut.getNinteichosahyo().get調査項目(ITEM_KUBUN)).get調査結果(), is(STRING_VALUE));
        }
    }

    public static class getResultByString {

        @Test
        public void 調査結果の設定がある時_getResultByStringは_設定値を返す() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, STRING_VALUE);
            assertThat(sut.getResultByString(ITEM_KUBUN), is(STRING_VALUE));
        }
    }

    public static class getResultByInt {

        @Test
        public void 調査結果の設定がある時_getResultByIntは_設定値を返す() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, INT_VALUE);
            assertThat(sut.getResultByInt(ITEM_KUBUN), is(INT_VALUE));
        }
    }

    public static class getResultByCode {

        @Test
        public void 調査結果の設定がある時_getResultByIntは_設定値を返す() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, CODE_VALUE.value());
            assertThat(sut.getResultByCode(ITEM_KUBUN), is(CODE_VALUE));
        }
    }

    public static class isResultSet {

        @Test
        public void 調査結果の設定がある時_isResultSetは_TRUEを返す() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            sut.setResult(ITEM_KUBUN, CODE_VALUE.value());
            assertThat(sut.isResultSet(ITEM_KUBUN), is(true));
        }

        @Test
        public void 調査結果の設定がない時_isResultSetは_FALSEを返す() {
            NinteichosahyoEditor sut = createEditor(createChosahyo());
            assertThat(sut.isResultSet(ITEM_KUBUN), is(false));
        }
    }

    public static class getNinteichosahyo {

        @Test
        public void 調査票の設定がある時_getNinteichosahyoは_調査票のインスタンスを返す() {
            NinteichosahyoEditor sut = createEditor(createNewChosahyo());
            sut.setItem(createChosahyo().get調査項目(ITEM_KUBUN));
            assertThat(sut.getNinteichosahyo(), instanceOf(Ninteichosahyo.class));
        }
    }

    private static NinteichosahyoEditor createEditor(Ninteichosahyo chosahyo) {
        return new NinteichosahyoEditor(chosahyo);
    }

    private static Ninteichosahyo createNewChosahyo() {
        return new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfKihon.class), NinteichosaItemGroupOf2009.values());
    }

    private static Ninteichosahyo createChosahyo() {
        return NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A);
    }
}
