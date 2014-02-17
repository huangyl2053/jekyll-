/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 認定調査依頼情報Collectionのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoCollectionTest extends TestBase {

    private static NinteichosaIraiJohoCollection sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIraiJohoCollection(null);
        }
    }

    public static class get認定申請情報のテスト extends TestBase {

        @Override
        public void setUp() {
        }

        @Test
        public void 申請書管理番号_001_認定調査依頼履歴番号_1を指定したとき_申請書管理番号に001を持つ認定申請情報を返す() {
            sut = new NinteichosaIraiJohoCollection(create認定調査依頼情報List());
            assertThat(sut.get認定申請情報(create申請書管理番号("001"), 1).get申請書管理番号(), is(create申請書管理番号("001")));
        }

        @Test
        public void 申請書管理番号_001_認定調査依頼履歴番号_1を指定したとき_認定調査依頼履歴番号に1を持つ認定申請情報を返す() {
            sut = new NinteichosaIraiJohoCollection(create認定調査依頼情報List());
            assertThat(sut.get認定申請情報(create申請書管理番号("001"), 1).get認定調査依頼履歴番号(), is(1));
        }
    }

    public static class isEmptyのテスト {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new NinteichosaIraiJohoCollection(create認定調査依頼情報List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new NinteichosaIraiJohoCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_sizeは4を返す() {
            sut = new NinteichosaIraiJohoCollection(create認定調査依頼情報List());
            assertThat(sut.size(), is(4));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new NinteichosaIraiJohoCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<NinteichosaIraiJoho> create認定調査依頼情報List() {
        List<NinteichosaIraiJoho> list = new ArrayList<>();
        list.add(create認定調査依頼情報("001", 1));
        list.add(create認定調査依頼情報("002", 1));
        list.add(create認定調査依頼情報("003", 1));
        list.add(create認定調査依頼情報("001", 2));
        return list;
    }

    private static NinteichosaIraiJoho create認定調査依頼情報(String 申請書管理番号, int 認定調査依頼履歴番号) {
        NinteichosaIraiJoho ninteichosaIraiJoho = mock(NinteichosaIraiJoho.class);
        when(ninteichosaIraiJoho.get申請書管理番号()).thenReturn(create申請書管理番号(申請書管理番号));
        when(ninteichosaIraiJoho.get認定調査依頼履歴番号()).thenReturn(認定調査依頼履歴番号);
        return ninteichosaIraiJoho;
    }

    private static ShinseishoKanriNo create申請書管理番号(String str) {
        return new ShinseishoKanriNo(new RString(str));
    }
}
