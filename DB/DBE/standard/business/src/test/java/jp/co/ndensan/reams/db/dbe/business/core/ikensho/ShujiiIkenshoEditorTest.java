/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書を編集するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoEditorTest extends DbeTestBase {

    private static final IShujiiIkenshoItemKubun ITEM_KUBUN = ShujiiIkenshoItemKubun.麻痺_右上肢;
    private static final RString STRING_VALUE = new RString("123");
    private static final int INT_VALUE = 123;
    private static final boolean BOOL_VALUE = true;
    private static final Code CODE_VALUE = new Code("123");

    public static class setItem extends DbeTestBase {

        @Test
        public void 意見書項目の指定がある時_setItemは_指定値を設定する() {
            ShujiiIkenshoEditor sut = createEditor(createNewIkensho());
            sut.setItem(createIkensho().get意見書項目(ITEM_KUBUN));
            assertThat(sut.getShujiiIkensho().get意見書項目(ITEM_KUBUN).get意見書項目区分(), is(ITEM_KUBUN));
        }
    }

    public static class setResult_string extends DbeTestBase {

        @Test
        public void 意見書結果の指定がある時_setResultは_指定値を設定する() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, STRING_VALUE);
            assertThat(((ShujiiIkenshoItemForResult) sut.getShujiiIkensho().get意見書項目(ITEM_KUBUN)).get意見書結果(), is(STRING_VALUE));
        }
    }

    public static class setResult_int extends DbeTestBase {

        @Test
        public void 意見書結果の指定がある時_setResultは_指定値を設定する() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, INT_VALUE);
            assertThat(((ShujiiIkenshoItemForResult) sut.getShujiiIkensho().get意見書項目(ITEM_KUBUN)).get意見書結果(), is(STRING_VALUE));
        }
    }

    public static class setResult_boolean extends DbeTestBase {

        @Test
        public void 意見書結果の指定がある時_setResultは_指定値を設定する() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, BOOL_VALUE);
            assertThat(((ShujiiIkenshoItemForResult) sut.getShujiiIkensho().get意見書項目(ITEM_KUBUN)).get意見書結果(), is(new RString("1")));
        }
    }

    public static class getResultByString extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_getResultByStringは_設定値を返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, STRING_VALUE);
            assertThat(sut.getResultByString(ITEM_KUBUN), is(STRING_VALUE));
        }
    }

    public static class getResultByInt extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_getResultByIntは_設定値を返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, INT_VALUE);
            assertThat(sut.getResultByInt(ITEM_KUBUN), is(INT_VALUE));
        }
    }

    public static class getResultByCode extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_getResultByIntは_設定値を返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, CODE_VALUE.value());
            assertThat(sut.getResultByCode(ITEM_KUBUN), is(CODE_VALUE));
        }
    }

    public static class getResultByBool extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_getResultByBoolは_設定値を返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, BOOL_VALUE);
            assertThat(sut.getResultByBool(ITEM_KUBUN), is(BOOL_VALUE));
        }
    }

    public static class isResultSet extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_isResultSetは_TRUEを返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            sut.setResult(ITEM_KUBUN, BOOL_VALUE);
            assertThat(sut.isResultSet(ITEM_KUBUN), is(true));
        }

        @Test
        public void 意見書結果の設定がない時_isResultSetは_FALSEを返す() {
            ShujiiIkenshoEditor sut = createEditor(createIkensho());
            assertThat(sut.isResultSet(ITEM_KUBUN), is(false));
        }
    }

    public static class getShujiiIkensho extends DbeTestBase {

        @Test
        public void 意見書の設定がある時_getShujiiIkenshoは_意見書のインスタンスを返す() {
            ShujiiIkenshoEditor sut = createEditor(createNewIkensho());
            sut.setItem(createIkensho().get意見書項目(ITEM_KUBUN));
            assertThat(sut.getShujiiIkensho(), instanceOf(ShujiiIkensho.class));
        }
    }

    private static ShujiiIkenshoEditor createEditor(ShujiiIkensho ikensho) {
        return new ShujiiIkenshoEditor(ikensho);
    }

    private static ShujiiIkensho createNewIkensho() {
        return new ShujiiIkensho(new EnumMap<>(ShujiiIkenshoItemKubun.class), ShujiiIkenshoItemGroupOf2009.values());
    }

    private static ShujiiIkensho createIkensho() {
        return ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A);
    }
}
