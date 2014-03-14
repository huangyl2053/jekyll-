/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosainCollection;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteichosainEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaTorikomiTaishoshaEntity;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urf.entity.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.ur.urz.entity.mapper.helper.KojinFactory;

/**
 * 認定調査結果取込対象者を変換するMapperクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class NinteichosaKekkaTorikomiTaishoshaMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaTorikomiTaishoshaMapper() {
    }

    /**
     * 認定調査結果取込対象者Entityと個人Entityを、認定調査結果取込対象者にMappingします。
     *
     * @param 認定調査結果取込対象者Entity 認定調査結果取込対象者Entity
     * @param 介護事業者Entity 介護事業者Entity
     * @param 個人Entity 個人Entity
     * @return 認定調査結果取込対象者
     */
    public static NinteichosaKekkaTorikomiTaishosha toNinteichosaKekkaTorikomiTaishosha(
            NinteichosaKekkaTorikomiTaishoshaEntity 認定調査結果取込対象者Entity,
            KaigoJigyoshaEntity 介護事業者Entity,
            KojinEntity 個人Entity) {

        YokaigoninteiProgress 要介護認定進捗情報 = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(認定調査結果取込対象者Entity.getNinteiShinchokuJohoEntity());
        NinteiShinseiJoho 認定申請情報 = NinteishinseiJohoMapper.to認定申請情報(認定調査結果取込対象者Entity.getNinteiShinseiJohoEntity());
        NinteichosaIrai 認定調査依頼情報 = NinteichosaIraiMapper.to認定調査依頼情報(認定調査結果取込対象者Entity.getNinteichosaIraiJohoEntity());
        KaigoNinteichosainCollection 介護認定調査員Collection = new KaigoNinteichosainCollection(
                create介護認定調査員Collection(認定調査結果取込対象者Entity.getNinteichosainEntityList()));
        IKaigoJigyosha 事業者情報 = KaigoJigyoshaMapper.toKaigoJigyosha(介護事業者Entity);
        IKojin 個人 = KojinFactory.create(個人Entity);

        return new NinteichosaKekkaTorikomiTaishosha(
                要介護認定進捗情報,
                認定申請情報,
                認定調査依頼情報,
                介護認定調査員Collection,
                事業者情報,
                個人);
    }

    private static List<KaigoNinteichosain> create介護認定調査員Collection(List<KaigoNinteichosainEntity> entityList) {
        List<KaigoNinteichosain> list = new ArrayList<>();
        for (KaigoNinteichosainEntity entity : entityList) {
            list.add(KaigoNinteichosainMapper.toKaigoNinteichosain(
                    entity.getDbT7013ChosainJohoEntity(),
                    entity.getDbT7010NinteichosaItakusakiJohoEntity()));
        }
        return list;
    }
}
