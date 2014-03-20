/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7010NinteichosaItakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.mapper.KojinMapper;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;

/**
 * 認定調査結果取込対象者を変換するMapperクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTorikomiTaishoshaMapperTest extends DbeTestBase {

    private static NinteichosaKekkaTorikomiTaishosha sut;
    private static DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
    private static DbT5006NinteichosaIraiJohoEntity 認定調査依頼情報Entity;
    private static DbT7013ChosainJohoEntity 調査員情報Entity;
    private static DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity;
    private static IKojin 個人;

    public static class toNinteichosaKekkaTorikomiTaishosha extends DbeTestBase {

        @Before
        public void setUp() {
            要介護認定申請情報Entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            認定調査依頼情報Entity = NinteichosaIraiTestHelper.create認定調査依頼情報Entity();
            調査員情報Entity = KaigoNinteichosainTestHelper.create認定調査員Entity();
            認定調査委託先情報Entity = DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance();
            個人 = KojinMapper.toKojin(KojinEntityMock.getSpiedInstance());
        }

        @Test
        public void 要介護認定申請情報Entityの市町村コードと_Mapping後の認定調査結果取込対象者の_認定申請情報の市町村コードが_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    要介護認定申請情報Entity, 認定調査依頼情報Entity, 調査員情報Entity, 認定調査委託先情報Entity, 個人);
            assertThat(sut.get認定申請情報().get市町村コード().getValue(), is(DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance().getShichosonCode().getValue()));
        }

        @Test
        public void 認定調査依頼情報Entityの申請書管理番号と_Mapping後の認定調査結果取込対象者の_認定調査依頼情報の申請書管理番号が_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    要介護認定申請情報Entity, 認定調査依頼情報Entity, 調査員情報Entity, 認定調査委託先情報Entity, 個人);
            assertThat(sut.get認定調査依頼情報().get申請書管理番号().value(), is(NinteichosaIraiTestHelper.create認定調査依頼情報Entity().getShinseishoKanriNo().value()));
        }

        @Test
        public void 調査員情報Entityの介護調査員番号と_Mapping後の認定調査結果取込対象者の_介護認定調査員の介護調査員番号が_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    要介護認定申請情報Entity, 認定調査依頼情報Entity, 調査員情報Entity, 認定調査委託先情報Entity, 個人);
            assertThat(sut.get介護認定調査員().get介護調査員番号().value(), is(KaigoNinteichosainTestHelper.create認定調査員Entity().getKaigoChosainNo()));
        }

        @Test
        public void 認定調査委託先情報Entityの事業者番号と_Mapping後の認定調査結果取込対象者の_介護認定調査員が持つ認定調査委託先の_事業者番号が_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    要介護認定申請情報Entity, 認定調査依頼情報Entity, 調査員情報Entity, 認定調査委託先情報Entity, 個人);
            assertThat(sut.get介護認定調査員().get認定調査委託先().getJigyoshaNo().getColumnValue(), is(DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance().get事業者番号().getColumnValue()));
        }
    }
}
