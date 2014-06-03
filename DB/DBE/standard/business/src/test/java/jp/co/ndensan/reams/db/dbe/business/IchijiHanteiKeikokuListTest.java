/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuUmu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
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
    private static List<IchijiHanteiKeikoku> 警告List;
    private static IchijiHanteiKeikokuHairetsuCode 警告配列コード;
    private static IchijiHanteiKeikokuShubetsu 警告種別;
    private static FlexibleDate 判定年月日;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            判定年月日 = new FlexibleDate("20060401");
            警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日);
            警告配列コード = new IchijiHanteiKeikokuHairetsuCode(create配列コード(警告種別.get警告数()), 判定年月日);
            警告List = createList(警告種別.get警告数());
        }

        @Test(expected = NullPointerException.class)
        public void 警告配列コードがnullの場合_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiKeikokuList(null, 警告List);
        }

        @Test(expected = NullPointerException.class)
        public void 警告Listがnullの場合_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiKeikokuList(警告配列コード, null);
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            判定年月日 = new FlexibleDate("20060401");
            警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日);
            警告配列コード = new IchijiHanteiKeikokuHairetsuCode(create配列コード(警告種別.get警告数()), 判定年月日);
        }

        @Test
        public void リストが空のとき_trueが返る() {
            警告List = createList(0);
            sut = new IchijiHanteiKeikokuList(警告配列コード, 警告List);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void リストが空でないとき_falseが返る() {
            警告List = createList(3);
            sut = new IchijiHanteiKeikokuList(警告配列コード, 警告List);
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            判定年月日 = new FlexibleDate("20060401");
            警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日);
            警告List = createList(3);
            警告配列コード = new IchijiHanteiKeikokuHairetsuCode(create配列コード(警告種別.get警告数()), 判定年月日);
        }

        @Test
        public void リストが3件の要素を持っているとき_3が返る() {
            sut = new IchijiHanteiKeikokuList(警告配列コード, 警告List);
            assertThat(sut.size(), is(3));
        }
    }

    private static List<IchijiHanteiKeikoku> createList(int 警告数) {
        List<IchijiHanteiKeikoku> list = new ArrayList<>();
        for (int i = 0; i < 警告数; i++) {
            list.add(new IchijiHanteiKeikoku(new Code("code" + i), RString.EMPTY, RString.EMPTY));
        }
        return list;
    }

    private static RString create配列コード(int 警告数) {
        RStringBuilder 警告配列コードBuilder = new RStringBuilder();
        for (int i = 0; i < 警告数; i++) {
            警告配列コードBuilder.append("0");
        }
        return 警告配列コードBuilder.toRString();
    }
}
