/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ChosainJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7010NinteichosaItakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
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
        private KojinEntity 個人Entity;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
            個人Entity = mock(KojinEntity.class);
            認定調査委託先Entity = mock(DbT7010NinteichosaItakusakiJohoEntity.class);
            介護事業者Entity = mock(KaigoJigyoshaEntity.class);
            調査員情報Entity = mock(ChosainJohoEntity.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの要介護認定申請情報Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            要介護認定申請情報Entity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            個人Entity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }
    }

    public static class toNinteichosaIraiTaishoshaTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
        private KojinEntity 個人Entity;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            要介護認定申請情報Entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("0001")));
            要介護認定申請情報Entity.setShichosonCode(new ShichosonCode(new RString("1111")));
            要介護認定申請情報Entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0002")));
            要介護認定申請情報Entity.setNinteiShinseiYMD(new NinteiShinseiDate(new FlexibleDate(new RString("20140101"))));
            要介護認定申請情報Entity.setNinteiShinseiShinseijiKubunCode(new RString("0003"));
            個人Entity = KojinEntityMock.getSpiedInstance();
            認定調査委託先Entity = DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance();
            認定調査委託先Entity.set市町村コード(new RString("1111市町村コード"));
            認定調査委託先Entity.set介護事業者番号(new KaigoJigyoshaNo(new RString("0001介護事業者番号")));
            認定調査委託先Entity.set事業者番号(new JigyoshaNo(new RString("0002事業者番号")));
            認定調査委託先Entity.set介護事業者状況(true);
            認定調査委託先Entity.set調査委託区分(ChosaItakuKubun.指定なし);
            認定調査委託先Entity.set割付定員(3);
            認定調査委託先Entity.set割付地区(new RString("1114"));
            認定調査委託先Entity.set機関の区分(new RString("1115"));
            介護事業者Entity = KaigoJigyoshaEntityMock.getSpiedInstance();
            調査員情報Entity = ChosainJohoEntityMock.getSpiedInstance();
        }

        @Test
        public void 引き渡した_要介護認定申請情報の申請書管理番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get申請書管理番号(), is(要介護認定申請情報Entity.getShinseishoKanriNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の市町村コード_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get市町村コード(), is(要介護認定申請情報Entity.getShichosonCode()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の被保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get被保険者番号(), is(要介護認定申請情報Entity.getHihokenshaNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請年月日_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請年月日(), is(要介護認定申請情報Entity.getNinteiShinseiYMD()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請区分_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請区分(), is(要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()));
        }

        @Test
        public void 引き渡した_個人Entityから作成したIKojin_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get個人情報(), instanceOf(IKojin.class));
        }

        @Test
        public void 引き渡した_個人Entityの氏名_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get氏名(), is(個人Entity.get識別対象_名称()));
        }

        @Test
        public void 引き渡した_個人Entityの住所_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get住所(), instanceOf(RString.class));
        }

        @Test
        public void 引き渡した_認定調査委託先_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査委託先().get市町村コード(), is(認定調査委託先Entity.get市町村コード()));
        }

        @Test
        public void 引き渡した_事業者情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get事業者情報().get法人種別(), is(介護事業者Entity.get法人種別()));
        }

        @Test
        public void 引き渡した_認定調査員情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査員情報().get介護調査員番号(), is(調査員情報Entity.get介護調査員番号()));
        }
    }
}
