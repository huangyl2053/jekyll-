/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kyufujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KounyukingakuParamter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KyufuJohoParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyufujoho.KyufuJohoEntity;

/**
 * 総合照会_給付情報のFinderです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
public interface IKyufuJohoMapper {

    /**
     * 居宅サービス計画情報の取得します。
     *
     * @param paramter KyufuJohoParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity get居宅サービス計画情報(KyufuJohoParamter paramter);

    /**
     * 購入金額の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity get購入金額(KounyukingakuParamter paramter);

    /**
     * 保険請求負担額の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity get保険請求負担額(KounyukingakuParamter paramter);

    /**
     * 住宅改修費用合計の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity get住宅改修費用合計(KounyukingakuParamter paramter);

    /**
     * 住宅改修請求負担額の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity get住宅改修請求負担額(KounyukingakuParamter paramter);

    /**
     * サービス利用状況情報の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    List<KyufuJohoEntity> getサービス利用状況情報(KyufuJohoParamter paramter);

    /**
     * ViewStateへ償還払い状況照会の取得します。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoEntity
     */
    KyufuJohoEntity getViewState償還払い状況照会(KounyukingakuParamter paramter);

}
