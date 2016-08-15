/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    private RString psmShikibetsuTaisho;

    public JissekiDataIchijiSakuseiMybatisprmParamter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
