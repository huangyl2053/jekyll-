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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査特記事項Collectionのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoCollectionTest extends TestBase {

    private static NinteichosaTokkijikoCollection sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaTokkijikoCollection(null);
        }
    }

    public static class get認定調査特記事項のテスト extends TestBase {

        private ShinseishoKanriNo 申請書管理番号;
        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号;

        @Override
        public void setUp() {
            List<NinteichosaTokkijiko> list = new ArrayList<>();
            list.add(create認定調査特記事項("A001", 1, "特記その1"));
            list.add(create認定調査特記事項("A001", 2, "特記その2"));
            list.add(create認定調査特記事項("A002", 1, "特記その3"));
            list.add(create認定調査特記事項("A003", 1, "特記その4"));
            sut = new NinteichosaTokkijikoCollection(list);
        }

        @Test
        public void 申請書管理番号_A001_認定調査依頼履歴番号_1を指定したとき_対応した認定調査特記事項が取得できる() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
            assertThat(sut.get認定調査特記事項(申請書管理番号, 認定調査依頼履歴番号).get特記事項(), is(new RString("特記その1")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した引数に対応する認定調査特記事項が存在しないとき_IllegalArgumentExceptionが発生する() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("A099"));
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
            sut.get認定調査特記事項(申請書管理番号, 認定調査依頼履歴番号);
        }
    }

    public static class isEmptyのテスト extends TestBase {

        @Test
        public void Collectionが空のとき_trueを返す() {
            sut = new NinteichosaTokkijikoCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void Collectionが空でないとき_falseを返す() {
            sut = new NinteichosaTokkijikoCollection(create3件のリスト());
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト {

        @Test
        public void 要素を3件持つCollectionの場合_3を返す() {
            sut = new NinteichosaTokkijikoCollection(create3件のリスト());
            assertThat(sut.size(), is(3));
        }
    }

    private static NinteichosaTokkijiko create認定調査特記事項(String 申請書管理番号, int 認定調査依頼履歴番号, String 特記事項) {
        return new NinteichosaTokkijiko(new ShinseishoKanriNo(new RString(申請書管理番号)),
                new NinteichosaIraiRirekiNo(認定調査依頼履歴番号), new RString("B001"), new RString(特記事項));
    }

    private static List<NinteichosaTokkijiko> create3件のリスト() {
        List<NinteichosaTokkijiko> list = new ArrayList<>();
        list.add(create認定調査特記事項("A001", 1, "特記その1"));
        list.add(create認定調査特記事項("A001", 2, "特記その2"));
        list.add(create認定調査特記事項("A002", 1, "特記その3"));
        return list;
    }
}
