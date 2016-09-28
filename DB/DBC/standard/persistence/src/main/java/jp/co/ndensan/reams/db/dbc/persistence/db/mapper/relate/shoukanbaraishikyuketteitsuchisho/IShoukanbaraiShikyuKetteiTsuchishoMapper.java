/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.HihokenshaJyohoTaishoPSMFuka;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuEntity;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のビジネス。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
public interface IShoukanbaraiShikyuKetteiTsuchishoMapper {

    /**
     * 償還払支給情報取得です。
     *
     * @param param param
     * @return {@link ShoukanbaraiShikyuEntity}
     */
    ShoukanbaraiShikyuEntity select償還払支給(ShoukanbaraiShikyuKetteiTsuchishoParameter param);

    /**
     * 被保険者宛名情報取得です。
     *
     * @param param param
     * @return {@link HihokenshaTaishoPSMFuka}
     */
    HihokenshaJyohoTaishoPSMFuka select被保険者宛名情報(ShoukanbaraiShikyuKetteiTsuchishoParameter param);
}
