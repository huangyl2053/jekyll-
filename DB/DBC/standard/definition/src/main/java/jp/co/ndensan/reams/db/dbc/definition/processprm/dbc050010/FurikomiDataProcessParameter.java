/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込データ作成パラメタークラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FurikomiDataProcessParameter implements IBatchProcessParameter {

    private RDate 振込指定年月日;
    private FurikomiGyomunaiKubun 振込業務内区分;

    /**
     * コンストラクタ
     *
     * @param 振込指定年月日 振込指定年月日
     * @param 振込業務内区分 振込業務内区分
     */
    public FurikomiDataProcessParameter(RDate 振込指定年月日, FurikomiGyomunaiKubun 振込業務内区分) {
        this.振込指定年月日 = 振込指定年月日;
        this.振込業務内区分 = 振込業務内区分;
    }

}
