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
 * @author wangjie2
 */
public class OtherAddressInformationRecipientNameMybatisParam extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    public OtherAddressInformationRecipientNameMybatisParam(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }

}
