/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.entity.helper.ChosainJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinseiJohoTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.entity.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.ur.urf.entity.mapper.NinteiChosainMapper;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;

/**
 * 認定調査対象者のビジネスクラスとエンティティの変換を行うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaMapperTest extends DbeTestBase {

    private static YokaigoNinteiProgress 認定進捗情報;
    private static NinteiShinseiJoho 認定申請情報;
    private static IKojin 個人;
    private static NinteichosaItakusaki 認定調査委託先;
    private static IKaigoJigyosha 介護事業者;
    private static INinteiChosain 認定調査員情報;
    private static NinteichosaIraiTaishosha sut;

    public static class ConstructorTest extends DbeTestBase {

        @Before
        public void setUp() {
            認定進捗情報 = mock(YokaigoNinteiProgress.class);
            認定申請情報 = mock(NinteiShinseiJoho.class);
            個人 = mock(IKojin.class);
            認定調査委託先 = mock(NinteichosaItakusaki.class);
            介護事業者 = mock(IKaigoJigyosha.class);
            認定調査員情報 = mock(INinteiChosain.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_認定進捗情報に_nullを指定した場合_NullPointerExceptionが発生する() {
            認定進捗情報 = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 認定調査委託先, 介護事業者, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_認定申請情報に_nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請情報 = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 認定調査委託先, 介護事業者, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_個人に_nullを指定した場合_NullPointerExceptionが発生する() {
            個人 = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 認定調査委託先, 介護事業者, 認定調査員情報);
        }
    }

    public static class toNinteichosaIraiTaishoshaTest extends DbeTestBase {

        @Before
        public void setUp() {
            認定進捗情報 = NinteiShinchokuJohoMock.create認定進捗情報();
            認定申請情報 = NinteishinseiJohoMapper.to認定申請情報(NinteiShinseiJohoTestHelper.create認定申請情報Entity());
            個人 = KojinTestHelper.create個人();
            認定調査委託先 = NinteichosaItakusakiMapper.toNinteichosaItakusaki(NinteichosaItakusakiTestHelper.create認定調査委託先Entity());
            介護事業者 = KaigoJigyoshaMapper.toKaigoJigyosha(KaigoJigyoshaEntityMock.getSpiedInstance());
            認定調査員情報 = NinteiChosainMapper.toNinteiChosain(ChosainJohoEntityMock.getSpiedInstance(), 介護事業者);

            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 認定調査委託先, 介護事業者, 認定調査員情報);
        }

        @Test
        public void 引き渡した_認定申請情報の申請書管理番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get申請書管理番号(), is(認定申請情報.get申請書管理番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の証記載保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get証記載保険者番号(), is(認定申請情報.get証記載保険者番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の被保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get被保険者番号(), is(認定申請情報.get介護被保険者番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の認定申請年月日_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定申請年月日(), is(認定申請情報.get認定申請年月日()));
        }

        @Test
        public void 引き渡した_認定申請情報の認定申請区分_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定申請区分(), is(認定申請情報.get認定申請区分_申請時()));
        }

        @Test
        public void 引き渡した_IKojin_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get個人情報(), instanceOf(IKojin.class));
        }

        @Test
        public void 引き渡した_個人の氏名_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get氏名(), is(個人.get氏名().getName().value()));
        }

        @Test
        public void 引き渡した_個人の住所_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get住所(), is(個人.get住所().getValue()));
        }

        @Test
        public void 引き渡した_認定調査委託先の証記載保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定調査委託先().get証記載保険者番号(), is(認定調査委託先.get証記載保険者番号()));
        }

        @Test
        public void 引き渡した_事業者情報の法人種別_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get事業者情報().get法人種別(), is(介護事業者.get法人種別()));
        }

        @Test
        public void 引き渡した_認定調査員情報の介護調査員番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定調査員情報().get介護調査員番号(), is(認定調査員情報.get介護調査員番号()));
        }
    }

    private static IKojin createKojinWhoseNameIs(String shimei, String kanaShimei) {
        IKojin kojin = createKojinMock(toName(shimei, kanaShimei), toJusho(""));
        return kojin;
    }

    private static IKojin createKojinMock(IName name, IJusho jusho) {
        IKojin kojin = mock(IKojin.class);
        when(kojin.get氏名()).thenReturn(name);
        when(kojin.get住所()).thenReturn(jusho);
        return kojin;
    }

    private static IName toName(String shimei, String kanaShimei) {
        IName name = mock(IName.class);
        AtenaMeisho atenaMeisho = new AtenaMeisho(shimei);
        AtenaKanaMeisho atenaKanaMeisho = new AtenaKanaMeisho(kanaShimei);
        when(name.getName()).thenReturn(atenaMeisho);
        when(name.getKana()).thenReturn(atenaKanaMeisho);
        return name;
    }

    private static IJusho toJusho(String jusho) {
        IJusho adress = mock(IJusho.class);
        when(adress.getValue()).thenReturn(new RString(jusho));
        return adress;
    }
}
