/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 実績データ一時作成SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-040 tz_sunl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JissekiDataIchijiSakuseiMybatisprmParamter implements IMyBatisParameter {

    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * 実績データ一時Mybatisパラメータ
     *
     * @param searchKey 検索キー
     */
    public JissekiDataIchijiSakuseiMybatisprmParamter(IShikibetsuTaishoPSMSearchKey searchKey) {
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(searchKey);
    }
}
