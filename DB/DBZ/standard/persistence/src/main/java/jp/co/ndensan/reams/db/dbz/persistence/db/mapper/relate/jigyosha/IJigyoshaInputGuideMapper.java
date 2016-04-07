/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jigyosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ServiceJigyoshaInputGuideRelateEntity;

/**
 *
 * 対象事業者取得のクラス。
 *
 * @reamsid_L DBA-0140-010 houtp
 */
public interface IJigyoshaInputGuideMapper {

    /**
     * サービス事業者を取得します。
     *
     * @param params 介護事業者施設オブジェクトパラメータクラス
     * @return List<ServiceJigyoshaInputGuideRelateEntity>
     */
    List<ServiceJigyoshaInputGuideRelateEntity> getServiceJigyoshaInputGuide(JigyoshaInputGuideParameter params);

    /**
     * 適用除外施設を取得します。
     *
     * @param params 介護事業者施設オブジェクトパラメータクラス
     * @return List<ServiceJigyoshaInputGuideRelateEntity>
     */
    List<ServiceJigyoshaInputGuideRelateEntity> getTekiyoJogaiInputGuide(JigyoshaInputGuideParameter params);

    /**
     * その他特例施設取得。
     *
     * @param params 介護事業者施設オブジェクトパラメータクラス
     * @return List<ServiceJigyoshaInputGuideRelateEntity>
     */
    List<ServiceJigyoshaInputGuideRelateEntity> getOtherTokureiInputGuide(JigyoshaInputGuideParameter params);
}
