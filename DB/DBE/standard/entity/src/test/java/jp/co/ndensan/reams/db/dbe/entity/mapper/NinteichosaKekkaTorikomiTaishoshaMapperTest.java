/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7010NinteichosaItakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteichosainEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaTorikomiTaishoshaEntity;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.entity.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.mapper.KojinMapper;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 認定調査結果取込対象者を変換するMapperクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTorikomiTaishoshaMapperTest extends TestBase {

    private static NinteichosaKekkaTorikomiTaishosha sut;
    private static NinteichosaKekkaTorikomiTaishoshaEntity 認定調査結果取込対象者Entity;
    private static IKaigoJigyosha 介護事業者;
    private static IKojin 個人;

    public static class toNinteichosaKekkaTorikomiTaishosha extends TestBase {

        @Override
        protected void setUp() {
            認定調査結果取込対象者Entity = new NinteichosaKekkaTorikomiTaishoshaEntity();
            認定調査結果取込対象者Entity.setNinteiShinseiJohoEntity(DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance());
            認定調査結果取込対象者Entity.setNinteichosaIraiJohoEntity(NinteichosaIraiTestHelper.create認定調査依頼情報Entity());
            認定調査結果取込対象者Entity.setNinteichosainEntityList(create認定調査員EntityList(3));
            介護事業者 = KaigoJigyoshaMapper.toKaigoJigyosha(KaigoJigyoshaEntityMock.getSpiedInstance());
            個人 = KojinMapper.toKojin(KojinEntityMock.getSpiedInstance());
        }

        @Test
        public void 渡された介護事業者entityの事業者番号と_Mapping後の介護事業者の事業者番号が_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(認定調査結果取込対象者Entity, 介護事業者, 個人);
            assertThat(sut.get介護事業者情報().get事業者番号(), is(KaigoJigyoshaEntityMock.getSpiedInstance().get事業者番号()));
        }

        @Test
        public void 渡された介護事業者entityの識別番号と_Mapping後の介護事業者の識別番号が_同一になる() {
            sut = NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(認定調査結果取込対象者Entity, 介護事業者, 個人);
            assertThat(sut.get介護事業者情報().get識別コード().getValue(), is(KaigoJigyoshaEntityMock.getSpiedInstance().get識別コード()));
        }
    }

    private static List<KaigoNinteichosainEntity> create認定調査員EntityList(int num) {
        List<KaigoNinteichosainEntity> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            KaigoNinteichosainEntity entity = new KaigoNinteichosainEntity();
            entity.setDbT7010NinteichosaItakusakiJohoEntity(DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance());
            entity.setDbT7013ChosainJohoEntity(KaigoNinteichosainTestHelper.create認定調査員Entity());
            list.add(entity);
        }

        return list;
    }
}
