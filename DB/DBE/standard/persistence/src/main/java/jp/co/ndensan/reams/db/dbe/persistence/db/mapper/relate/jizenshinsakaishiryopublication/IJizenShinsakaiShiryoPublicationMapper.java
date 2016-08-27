/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaSelectEntity;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public interface IJizenShinsakaiShiryoPublicationMapper {

    /**
     * 介護認定審査会委員事前審査のリストを取得します。
     *
     * @param paramt IJizenShinsakaiShiryoPublicationMybitisParamter
     * @return List<JizenShinsakaiShiryoRelateEntity>
     */
    JizenShinsaKekkaSelectEntity select介護認定審査会開催番号(JizenShinsakaiShiryoPublicationMybitisParamter paramt);
}
