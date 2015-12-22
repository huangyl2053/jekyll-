/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.rorenfukushinenkinjohokanri;

import jp.co.ndensan.reams.db.dbu.definition.core.rorenfukushinenkinjohokanri.RorenFukushiNenkinJohoKanriParameter;

/**
 * 老齢福祉年金受給者台帳管理です。
 *
 */
public interface IRorenFukushiNenkinJohoKanriMapper {

    /**
     * 老齢福祉年金受給者台帳管理受給期間重複チェック。
     *
     * @param param 老齢福祉年金受給者台帳管理パラメータ
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity 受給期間重複チェック結果
     */
    int jukyuKikanJufukuCheck(RorenFukushiNenkinJohoKanriParameter param);

}
