/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202.JissekiDataIchijiSakuseiMybatisprmParamter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者同定_processのメタークラスですs
 *
 * @reamsid_L DBD-4910-040 x_tz_sunl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JissekiDataIchijiSakuseiProcessParamter implements IBatchProcessParameter {

    /**
     * 実績データ一時の引数を返します
     *
     * @param searchKey 検索キー
     * @return JissekiDataIchijiSakuseiMybatisprmParamter
     */
    public JissekiDataIchijiSakuseiMybatisprmParamter toJissekiDataIchijiSakuseiMybatisprmParamter(
            IShikibetsuTaishoPSMSearchKey searchKey) {
        return new JissekiDataIchijiSakuseiMybatisprmParamter(searchKey);
    }
}
