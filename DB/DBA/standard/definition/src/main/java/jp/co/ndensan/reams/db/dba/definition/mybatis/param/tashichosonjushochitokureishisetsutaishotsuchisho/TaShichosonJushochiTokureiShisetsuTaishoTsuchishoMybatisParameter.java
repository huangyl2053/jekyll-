/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuTaishoTsuchisho;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 *
 * 住特施設退所通知書のMyBatis用パラメータクラスです。
 */
public class TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * 共通「宛名取得」情報paramter
     *
     * @param searchKey
     */
    public TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

}
