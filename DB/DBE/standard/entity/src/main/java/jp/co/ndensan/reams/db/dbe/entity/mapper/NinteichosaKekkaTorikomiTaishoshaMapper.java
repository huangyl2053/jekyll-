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
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteichosainEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaTorikomiTaishoshaEntity;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;

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
     * 認定調査結果取込対象者Entityと介護事業者と個人を、認定調査結果取込対象者にMappingします。
     *
     * @param 認定調査結果取込対象者Entity 認定調査結果取込対象者Entity
     * @param 介護事業者 介護事業者
     * @param 個人 個人
     * @return 認定調査結果取込対象者
     */
    public static NinteichosaKekkaTorikomiTaishosha toNinteichosaKekkaTorikomiTaishosha(
            NinteichosaKekkaTorikomiTaishoshaEntity 認定調査結果取込対象者Entity,
            IKaigoJigyosha 介護事業者,
            IKojin 個人) {

        NinteiShinseiJoho 認定申請情報 = NinteishinseiJohoMapper.to認定申請情報(認定調査結果取込対象者Entity.getNinteiShinseiJohoEntity());
        NinteichosaIrai 認定調査依頼情報 = NinteichosaIraiMapper.to認定調査依頼情報(認定調査結果取込対象者Entity.getNinteichosaIraiJohoEntity());
        KaigoNinteichosainCollection 介護認定調査員Collection = new KaigoNinteichosainCollection(
                create介護認定調査員Collection(認定調査結果取込対象者Entity.getNinteichosainEntityList()));

        return new NinteichosaKekkaTorikomiTaishosha(
                認定申請情報,
                認定調査依頼情報,
                介護認定調査員Collection,
                介護事業者,
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
