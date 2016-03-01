/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.tashihenkotsuchisho;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 他住特施設変更通知書データ作成の宛名識別取得のMyBatis用パラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString psmShikibetsuTaisho;

    /**
     * 共通「宛名取得」情報paramter
     *
     * @param searchKey searchKey
     */
    public TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * psmShikibetsuTaishoの設定
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public void setPsmShikibetsuTaisho(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
