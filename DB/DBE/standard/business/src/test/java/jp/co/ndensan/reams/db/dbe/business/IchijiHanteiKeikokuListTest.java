/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定警告リストのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKeikokuListTest {

    private static IchijiHanteiKeikokuList sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 警告配列コードがnullの場合_NullPointerExceptionが発生する() {
            new IchijiHanteiKeikokuList(null, IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, createList(0));
        }

        @Test(expected = NullPointerException.class)
        public void 警告種別がnullの場合_NullPointerExceptionが発生する() {
            new IchijiHanteiKeikokuList(new RString("001010"), null, createList(0));
        }

        @Test(expected = NullPointerException.class)
        public void 警告Listがnullの場合_NullPointerExceptionが発生する() {
            new IchijiHanteiKeikokuList(new RString("001010"), IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, null);
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void リストが空のとき_trueが返る() {
            sut = new IchijiHanteiKeikokuList(new RString("001010"), IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, createList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void リストが空でないとき_falseが返る() {
            sut = new IchijiHanteiKeikokuList(new RString("001010"), IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, createList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void リストが3件の要素を持っているとき_3が返る() {
            sut = new IchijiHanteiKeikokuList(new RString("001010"), IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, createList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<IchijiHanteiKeikoku> createList(int 件数) {
        List<IchijiHanteiKeikoku> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(new IchijiHanteiKeikoku(new Code("code" + i), RString.EMPTY, RString.EMPTY));
        }
        return list;
    }
}
