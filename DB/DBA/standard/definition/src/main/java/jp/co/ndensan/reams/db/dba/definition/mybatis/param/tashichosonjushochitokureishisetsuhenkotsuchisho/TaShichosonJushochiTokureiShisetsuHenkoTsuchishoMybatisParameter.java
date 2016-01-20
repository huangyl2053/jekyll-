/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuHenkoTsuchisho;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 他住特施設変更通知書データ作成の宛名識別取得のMyBatis用パラメータクラスです。
 *
 */
public class TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * 共通「宛名取得」情報paramter
     *
     * @param searchKey
     */
    public TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

}
