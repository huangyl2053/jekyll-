/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nushijuminjoho;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class NushiJuminJohoParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * コンストラクタです。
     *
     * @param key 宛名情報検索key
     */
    public NushiJuminJohoParameter(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }

}
