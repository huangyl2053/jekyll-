/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;

/**
 * 介護認定調査員のコレクションを扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoNinteichosainCollectionTest extends TestBase {

    private static KaigoNinteichosainCollection sut;

    public static class ConstructorTest extends TestBase {

        private List<KaigoNinteichosain> 介護認定調査員リスト;

        @Override
        protected void setUp() {
            介護認定調査員リスト = new ArrayList<>();
            介護認定調査員リスト.add(createKaigoNinteichosain("S001", "K00A"));
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定調査員リストがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            介護認定調査員リスト = null;
            sut = new KaigoNinteichosainCollection(介護認定調査員リスト);
        }
    }

    public static class get介護認定調査員 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_get介護認定調査員は_該当の認定調査員情報を返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoNinteichosainNo(new RString("K00A")))
                    .get介護事業者番号().value(), is(new RString("S001")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 市町村コードが該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteichosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("9999")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoNinteichosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護事業者番号が該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteichosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S999")),
                    new KaigoNinteichosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護調査員番号が該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteichosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoNinteichosainNo(new RString("K999")));
        }
    }

    public static class sub介護認定調査員Collectionで介護事業者番号を指定した場合 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_sub介護認定調査員Collectionは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new KaigoJigyoshaNo(new RString("S001"))).size(), is(1));
        }

        @Test
        public void 介護認定調査員が存在しない時_sub介護認定調査員Collectionは_空のListを返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new KaigoJigyoshaNo(new RString("S999"))).size(), is(0));
        }
    }

    public static class sub介護認定調査員Collectionで市町村コードを指定した場合 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_sub介護認定調査員Collectionは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new ShichosonCode(new RString("0001"))).size(), is(3));
        }

        @Test
        public void 介護認定調査員が存在しない時_sub介護認定調査員Collectionは_空のListを返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new ShichosonCode(new RString("9999"))).size(), is(0));
        }
    }

    public static class sub介護認定調査員Collectionで市町村コードと介護事業者番号を指定した場合 extends TestBase {

        @Test
        public void 該当する介護認定調査員が存在する時_sub介護認定調査員Collectionは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new ShichosonCode(new RString("0001")), new KaigoJigyoshaNo(new RString("S001"))).size(), is(1));
        }

        @Test
        public void 該当する介護認定調査員が存在しない時_sub介護認定調査員Collectionは_空のListを返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.sub介護認定調査員Collection(new ShichosonCode(new RString("9999")), new KaigoJigyoshaNo(new RString("S999"))).size(), is(0));
        }
    }

    public static class isEmpty {

        @Test
        public void 介護認定調査員が存在する時_isEmptyは_FALSEを返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void 介護認定調査員が存在しない時_isEmptyは_TRUEを返す() {
            sut = new KaigoNinteichosainCollection(new ArrayList<KaigoNinteichosain>());
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class size {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_sizeは3を返す() {
            sut = createKaigoNinteichosainList();
            assertThat(sut.size(), is(3));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KaigoNinteichosainCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static KaigoNinteichosainCollection createKaigoNinteichosainList() {
        List<KaigoNinteichosain> chosainlist = new ArrayList<>();
        chosainlist.add(createKaigoNinteichosain("S001", "K00A"));
        chosainlist.add(createKaigoNinteichosain("S002", "K00A"));
        chosainlist.add(createKaigoNinteichosain("S003", "K00B"));
        return new KaigoNinteichosainCollection(chosainlist);
    }

    private static KaigoNinteichosain createKaigoNinteichosain(String 介護事業者番号, String 介護調査員番号) {
        return new KaigoNinteichosain(
                new ShichosonCode(new RString("0001")),
                new KaigoJigyoshaNo(new RString(介護事業者番号)),
                new KaigoNinteichosainNo(new RString(介護調査員番号)),
                true,
                new AtenaMeisho(new RString("0001")),
                new AtenaKanaMeisho(new RString("0001")),
                Gender.MALE,
                new Code(new RString("0001")),
                new ChikuCode(new RString("0001")),
                new YubinNo(new RString("001")),
                new AtenaJusho(new RString("0001")),
                new TelNo(new RString("0001")),
                createNinteichosaItakusaki(介護事業者番号));
    }

    private static NinteichosaItakusaki createNinteichosaItakusaki(String 介護事業者番号) {
        return new NinteichosaItakusaki(
                new RString("0001"),
                new KaigoJigyoshaNo(new RString(介護事業者番号)),
                new JigyoshaNo(new RString("0001")),
                true,
                ChosaItakuKubun.その他,
                1,
                new RString("地区１"),
                new RString("介護保険施設"));
    }
}
