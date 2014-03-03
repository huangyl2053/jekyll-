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
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoChosainNo;
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
public class KaigoNinteiChosainCollectionTest extends TestBase {

    private static KaigoNinteiChosainCollection sut;

    public static class ConstructorTest extends TestBase {

        private List<KaigoNinteiChosain> 介護認定調査員リスト = new ArrayList<>();
        private List<NinteichosaItakusaki> 認定調査委託先リスト = new ArrayList<>();

        @Override
        protected void setUp() {
            介護認定調査員リスト = new ArrayList<>();
            認定調査委託先リスト = new ArrayList<>();
            介護認定調査員リスト.add(createKaigoNinteiChosain("S001", "K00A"));
            認定調査委託先リスト.add(createNinteichosaItakusaki("S001"));
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定調査員リストがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            介護認定調査員リスト = null;
            sut = new KaigoNinteiChosainCollection(介護認定調査員リスト, 認定調査委託先リスト);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先リストがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            認定調査委託先リスト = null;
            sut = new KaigoNinteiChosainCollection(介護認定調査員リスト, 認定調査委託先リスト);
        }
    }

    public static class get介護認定調査員 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_get介護認定調査員は_該当の認定調査員情報を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoChosainNo(new RString("K00A")))
                    .get介護事業者番号().value(), is(new RString("S001")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 市町村コードが該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("9999")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoChosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護事業者番号が該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S999")),
                    new KaigoChosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護調査員番号が該当しない時_get介護認定調査員は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get介護認定調査員(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoChosainNo(new RString("K999")));
        }
    }

    public static class get認定調査委託先 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_get認定調査委託先は_該当の認定調査委託先を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.get認定調査委託先(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S002")),
                    new KaigoChosainNo(new RString("K00A")))
                    .getKaigoJigyoshaNo().value(), is(new RString("S002")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 市町村コードが該当しない時_get認定調査委託先は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get認定調査委託先(
                    new ShichosonCode(new RString("9999")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoChosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護事業者番号が該当しない時_get認定調査委託先は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get認定調査委託先(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S999")),
                    new KaigoChosainNo(new RString("K00A")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護調査員番号が該当しない時_get認定調査委託先は_IllegalArgumentExceptionを投げる() {
            sut = createKaigoNinteiChosainList();
            sut.get認定調査委託先(
                    new ShichosonCode(new RString("0001")),
                    new KaigoJigyoshaNo(new RString("S001")),
                    new KaigoChosainNo(new RString("K999")));
        }
    }

    public static class sub介護認定調査員Listで介護事業者番号を指定した場合 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_sub介護認定調査員Listは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new KaigoJigyoshaNo(new RString("S001"))).size(), is(1));
        }

        @Test
        public void 介護認定調査員が存在しない時_sub介護認定調査員Listは_空のListを返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new KaigoJigyoshaNo(new RString("S999"))).size(), is(0));
        }
    }

    public static class sub介護認定調査員Listで市町村コードを指定した場合 extends TestBase {

        @Test
        public void 介護認定調査員が存在する時_sub介護認定調査員Listは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new ShichosonCode(new RString("0001"))).size(), is(3));
        }

        @Test
        public void 介護認定調査員が存在しない時_sub介護認定調査員Listは_空のListを返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new ShichosonCode(new RString("9999"))).size(), is(0));
        }
    }

    public static class sub介護認定調査員Listで市町村コードと介護事業者番号を指定した場合 extends TestBase {

        @Test
        public void 該当する介護認定調査員が存在する時_sub介護認定調査員Listは_該当の介護認定調査員を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new ShichosonCode(new RString("0001")), new KaigoJigyoshaNo(new RString("S001"))).size(), is(1));
        }

        @Test
        public void 該当する介護認定調査員が存在しない時_sub介護認定調査員Listは_空のListを返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.sub介護認定調査員List(new ShichosonCode(new RString("9999")), new KaigoJigyoshaNo(new RString("S999"))).size(), is(0));
        }
    }

    public static class isEmpty {

        @Test
        public void 介護認定調査員が存在する時_isEmptyは_FALSEを返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void 介護認定調査員が存在しない時_isEmptyは_TRUEを返す() {
            sut = new KaigoNinteiChosainCollection(new ArrayList<KaigoNinteiChosain>(), new ArrayList<NinteichosaItakusaki>());
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class size {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_sizeは3を返す() {
            sut = createKaigoNinteiChosainList();
            assertThat(sut.size(), is(3));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KaigoNinteiChosainCollection(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static KaigoNinteiChosainCollection createKaigoNinteiChosainList() {
        List<KaigoNinteiChosain> chosainlist = new ArrayList<>();
        List<NinteichosaItakusaki> itakusakiList = new ArrayList<>();
        chosainlist.add(createKaigoNinteiChosain("S001", "K00A"));
        chosainlist.add(createKaigoNinteiChosain("S002", "K00A"));
        chosainlist.add(createKaigoNinteiChosain("S003", "K00B"));
        itakusakiList.add(createNinteichosaItakusaki("S001"));
        itakusakiList.add(createNinteichosaItakusaki("S002"));
        itakusakiList.add(createNinteichosaItakusaki("S003"));
        return new KaigoNinteiChosainCollection(chosainlist, itakusakiList);
    }

    private static KaigoNinteiChosain createKaigoNinteiChosain(String 介護事業者番号, String 介護調査員番号) {
        return new KaigoNinteiChosain(
                new ShichosonCode(new RString("0001")),
                new KaigoJigyoshaNo(new RString(介護事業者番号)),
                new KaigoChosainNo(new RString(介護調査員番号)),
                new JigyoshaNo(new RString("0001")),
                true,
                new AtenaMeisho(new RString("0001")),
                new AtenaKanaMeisho(new RString("0001")),
                Gender.MALE,
                new Code(new RString("0001")),
                new ChikuCode(new RString("0001")),
                new YubinNo(new RString("001")),
                new AtenaJusho(new RString("0001")),
                new TelNo(new RString("0001")));
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
