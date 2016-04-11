/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.atena;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 *
 * 他市町村住所地特例者台帳 宛名情報検索keyクラスです。
 *
 * @reamsid_L DBA-0402-020 wangjie2
 */
public class OtherAddressInformationRecipientNameMybatisParam extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * コンストラクタです。
     *
     * @param key 宛名情報検索key
     */
    public OtherAddressInformationRecipientNameMybatisParam(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }

}
