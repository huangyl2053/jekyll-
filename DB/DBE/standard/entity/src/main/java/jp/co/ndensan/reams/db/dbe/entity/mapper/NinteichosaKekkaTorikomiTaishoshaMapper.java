/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
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
     * 認定調査結果取込対象者に関係するEntityと、介護認定調査員、個人を、認定調査結果取込対象者にMappingします。
     *
     * @param 要介護認定申請情報Entity 要介護認定申請情報Entity
     * @param 認定調査依頼情報Entity 認定調査依頼情報Entity
     * @param 介護認定調査員 介護認定調査員
     * @param 個人 個人
     * @return 認定調査結果取込対象者
     */
    public static NinteichosaKekkaTorikomiTaishosha toNinteichosaKekkaTorikomiTaishosha(
            DbT5005NinteiShinchokuJohoEntity 要介護認定進捗情報Entity,
            DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity,
            DbT5006NinteichosaIraiJohoEntity 認定調査依頼情報Entity,
            KaigoNinteichosain 介護認定調査員,
            IKojin 個人) {

        return new NinteichosaKekkaTorikomiTaishosha(
                NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(要介護認定進捗情報Entity),
                NinteishinseiJohoMapper.to認定申請情報(要介護認定申請情報Entity),
                NinteichosaIraiMapper.to認定調査依頼情報(認定調査依頼情報Entity),
                介護認定調査員,
                個人);
    }
}
