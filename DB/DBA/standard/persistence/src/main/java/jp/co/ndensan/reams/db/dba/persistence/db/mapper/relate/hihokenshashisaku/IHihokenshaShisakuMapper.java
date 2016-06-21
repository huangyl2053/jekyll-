/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshashisaku;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashisaku.HihokenshaShisakuRelateEntity;

/**
 * 被保険者資格詳細異動用、宛名情報を取得です。
 *
 * @reamsid_L DBA-0521-020 lijia
 */
public interface IHihokenshaShisakuMapper {

    /**
     * 識別コードによる、宛名情報を取得します。
     *
     * @param parameter ShikakuShutokuJogaishaKanriParameter
     * @return ShikakuShutokuJogaishaKanriEntity
     */
    HihokenshaShisakuRelateEntity get宛名情報(ShikakuShutokuJogaishaKanriParameter parameter);
}
