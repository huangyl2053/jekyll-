/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査特記事項Collectionのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoListTest extends TestBase {

    private static NinteichosaTokkijikoList sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaTokkijikoList(null);
        }
    }

    public static class get認定調査特記事項_引数が認定調査依頼履歴番号の場合のテスト extends TestBase {

        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号;

        @Override
        public void setUp() {
            sut = new NinteichosaTokkijikoList(create5件のリスト());
        }

        @Test
        public void 認定調査依頼履歴番号_1を指定したとき_3件の要素を持つ認定調査特記事項Listが取得できる() {
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
            assertThat(sut.get認定調査特記事項(認定調査依頼履歴番号).size(), is(3));
        }

        @Test
        public void 存在しない認定調査依頼履歴番号を指定したとき_空の認定調査特記事項Listが返る() {
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(999);
            assertThat(sut.get認定調査特記事項(認定調査依頼履歴番号).isEmpty(), is(true));
        }
    }

    public static class get認定調査特記事項_引数が認定調査特記事項番号の場合のテスト extends TestBase {

        private RString 認定調査特記事項番号;

        @Override
        public void setUp() {
            sut = new NinteichosaTokkijikoList(create5件のリスト());
        }

        @Test
        public void 認定調査特記事項番号に2を指定したとき_2件の要素を持つ認定調査特記事項Listが取得できる() {
            認定調査特記事項番号 = new RString("2");
            assertThat(sut.get認定調査特記事項(認定調査特記事項番号).size(), is(2));
        }

        @Test
        public void 存在しない認定調査特記事項番号を指定したとき_空の認定調査特記事項Listが返る() {
            認定調査特記事項番号 = new RString("4649");
            assertThat(sut.get認定調査特記事項(認定調査特記事項番号).isEmpty(), is(true));
        }
    }

    public static class get認定調査特記事項_引数に依頼履歴番号と特記事項番号を渡した場合のテスト extends TestBase {

        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
        private RString 認定調査特記事項番号;

        @Override
        public void setUp() {
            sut = new NinteichosaTokkijikoList(create5件のリスト());
        }

        @Test
        public void 依頼履歴番号に2_特記事項番号に1_を指定したとき_特記事項その2を持つ認定調査特記事項が取得できる() {
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(2);
            認定調査特記事項番号 = new RString("1");
            assertThat(sut.get認定調査特記事項(認定調査依頼履歴番号, 認定調査特記事項番号).get特記事項(), is(new RString("特記その2")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 存在しない項目を指定したとき_IllegalArgumentExceptionが発生する() {
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(4989);
            認定調査特記事項番号 = new RString("710810");
            assertThat(sut.get認定調査特記事項(認定調査依頼履歴番号, 認定調査特記事項番号).get特記事項(), is(new RString("特記事項その2")));
        }
    }

    public static class isEmptyのテスト extends TestBase {

        @Test
        public void Collectionが空のとき_trueを返す() {
            sut = new NinteichosaTokkijikoList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void Collectionが空でないとき_falseを返す() {
            sut = new NinteichosaTokkijikoList(create5件のリスト());
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト {

        @Test
        public void 要素を3件持つCollectionの場合_3を返す() {
            sut = new NinteichosaTokkijikoList(create5件のリスト());
            assertThat(sut.size(), is(5));
        }
    }

    private static NinteichosaTokkijiko create認定調査特記事項(int 認定調査依頼履歴番号, int 特記事項番号, String 特記事項) {
        return new NinteichosaTokkijiko(new ShinseishoKanriNo(new RString("A001")),
                new NinteichosaIraiRirekiNo(認定調査依頼履歴番号),
                new RString(Integer.toString(特記事項番号)),
                new RString(特記事項));
    }

    private static List<NinteichosaTokkijiko> create5件のリスト() {
        List<NinteichosaTokkijiko> list = new ArrayList<>();
        list.add(create認定調査特記事項(1, 1, "特記その1"));
        list.add(create認定調査特記事項(2, 1, "特記その2"));
        list.add(create認定調査特記事項(1, 2, "特記その3"));
        list.add(create認定調査特記事項(1, 3, "特記その4"));
        list.add(create認定調査特記事項(2, 2, "特記その5"));
        return list;
    }
}
