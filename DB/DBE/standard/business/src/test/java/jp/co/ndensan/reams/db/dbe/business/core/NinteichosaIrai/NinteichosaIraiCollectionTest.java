/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.NinteichosaIrai;

import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaIrai.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaIrai.NinteichosaIraiCollection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinteichosainBangoCode;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class NinteichosaIraiCollectionTest extends DbeTestBase {

    private static NinteichosaIraiCollection sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIraiCollection(null);
        }
    }

    public static class get認定申請情報のテスト extends DbeTestBase {

        public void setUp() {
        }

        @Test
        public void 申請書管理番号_001_認定調査依頼履歴番号_1を指定したとき_申請書管理番号に001を持つ認定申請情報を返す() {
            sut = new NinteichosaIraiCollection(create認定調査依頼情報List());
            assertThat(sut.get認定申請情報(create申請書管理番号("001"), create認定調査依頼履歴番号(1)).get申請書管理番号(), is(create申請書管理番号("001")));
        }

        @Test
        public void 申請書管理番号_001_認定調査依頼履歴番号_1を指定したとき_認定調査依頼履歴番号に1を持つ認定申請情報を返す() {
            sut = new NinteichosaIraiCollection(create認定調査依頼情報List());
            assertThat(sut.get認定申請情報(create申請書管理番号("001"), create認定調査依頼履歴番号(1)).get認定調査依頼履歴番号(), is(create認定調査依頼履歴番号(1)));
        }
    }

    public static class isEmptyのテスト {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new NinteichosaIraiCollection(create認定調査依頼情報List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new NinteichosaIraiCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_sizeは4を返す() {
            sut = new NinteichosaIraiCollection(create認定調査依頼情報List());
            assertThat(sut.size(), is(4));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new NinteichosaIraiCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<NinteichosaIrai> create認定調査依頼情報List() {
        List<NinteichosaIrai> list = new ArrayList<>();
        list.add(create認定調査依頼情報("001", create認定調査依頼履歴番号(1)));
        list.add(create認定調査依頼情報("002", create認定調査依頼履歴番号(1)));
        list.add(create認定調査依頼情報("003", create認定調査依頼履歴番号(1)));
        list.add(create認定調査依頼情報("001", create認定調査依頼履歴番号(2)));
        return list;
    }

    private static NinteichosaIrai create認定調査依頼情報(String 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        KaigoJigyoshaNo 認定調査委託先コード = new KaigoJigyoshaNo(new RString("0000000001"));
        NinteichosainBangoCode 調査員番号コード = new NinteichosainBangoCode(new RString("001"));
        NinteichosaIrai ninteichosaIraiJoho = new NinteichosaIrai(create申請書管理番号(申請書管理番号),
                認定調査依頼履歴番号, 認定調査委託先コード, 調査員番号コード, NinteichosaIraiKubun.初回, 0, new RDate(20140301), new RDate(20140331), new RDate(20140311), new RDate(20140311), MobileDataShutsuryoku.未出力, new RDate(20140331), NinteichosaTokusokuHoho.その他, 0, new RString("メモ"));
//        when(ninteichosaIraiJoho.get申請書管理番号()).thenReturn(create申請書管理番号(申請書管理番号));
//        when(ninteichosaIraiJoho.get認定調査依頼履歴番号()).thenReturn(認定調査依頼履歴番号);
        return ninteichosaIraiJoho;
    }

    private static ShinseishoKanriNo create申請書管理番号(String str) {
        return new ShinseishoKanriNo(new RString(str));
    }

    private static NinteichosaIraiRirekiNo create認定調査依頼履歴番号(int i) {
        return new NinteichosaIraiRirekiNo(i);
    }
}
