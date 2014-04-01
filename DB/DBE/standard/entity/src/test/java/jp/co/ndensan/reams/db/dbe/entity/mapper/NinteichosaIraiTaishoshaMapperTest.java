/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ChosainJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7010NinteichosaItakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 * 認定調査対象者のビジネスクラスとエンティティの変換を行うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaMapperTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
        private IKojin 個人;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
            個人 = mock(IKojin.class);
            認定調査委託先Entity = mock(DbT7010NinteichosaItakusakiJohoEntity.class);
            介護事業者Entity = mock(KaigoJigyoshaEntity.class);
            調査員情報Entity = mock(ChosainJohoEntity.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_要介護認定申請情報Entityに_nullを指定した場合_NullPointerExceptionが発生する() {
            要介護認定申請情報Entity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_個人に_nullを指定した場合_NullPointerExceptionが発生する() {
            個人 = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    要介護認定申請情報Entity, 個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }
    }

    public static class toNinteichosaIraiTaishoshaTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
        private IKojin 個人;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            要介護認定申請情報Entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("0001")));
            要介護認定申請情報Entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("111111")));
            要介護認定申請情報Entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0002")));
            要介護認定申請情報Entity.setNinteiShinseiYMD(new FlexibleDate(new RString("20140101")));
            要介護認定申請情報Entity.setNinteiShinseiShinseijiKubunCode(NinteiShinseiKubunShinsei.新規申請);
            個人 = createKojinWhoseNameIs("個人", "こじん");
            認定調査委託先Entity = DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance();
            認定調査委託先Entity.set証記載保険者番号(new ShoKisaiHokenshaNo(new RString("123456")));
            認定調査委託先Entity.set介護事業者番号(new KaigoJigyoshaNo(new RString("0001介護事業者番号")));
            認定調査委託先Entity.set事業者番号(new JigyoshaNo(new RString("0002事業者番号")));
            認定調査委託先Entity.set介護事業者状況(true);
            認定調査委託先Entity.set調査委託区分(ChosaItakuKubun.指定なし);
            認定調査委託先Entity.set割付定員(3);
            認定調査委託先Entity.set割付地区(new RString("1114"));
            認定調査委託先Entity.set機関の区分(new RString("1115"));
            介護事業者Entity = KaigoJigyoshaEntityMock.getSpiedInstance();
            調査員情報Entity = ChosainJohoEntityMock.getSpiedInstance();

            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    要介護認定申請情報Entity, 個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }

        @Test
        public void 引き渡した_要介護認定申請情報の申請書管理番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get申請書管理番号(), is(要介護認定申請情報Entity.getShinseishoKanriNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の証記載保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get証記載保険者番号(), is(要介護認定申請情報Entity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の被保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get被保険者番号(), is(要介護認定申請情報Entity.getHihokenshaNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請年月日_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定申請年月日(), is(要介護認定申請情報Entity.getNinteiShinseiYMD()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請区分_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定申請区分(), is(要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()));
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
        public void 引き渡した_認定調査委託先_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定調査委託先().get証記載保険者番号(), is(認定調査委託先Entity.get証記載保険者番号()));
        }

        @Test
        public void 引き渡した_事業者情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get事業者情報().get法人種別(), is(介護事業者Entity.get法人種別()));
        }

        @Test
        public void 引き渡した_認定調査員情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            assertThat(sut.get認定調査員情報().get介護調査員番号(), is(調査員情報Entity.get介護調査員番号()));
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
