/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private RString 委託者コード;

    /**
     * コンストラクタ
     *
     * @param 振込指定年月日 振込指定年月日
     * @param 振込業務内区分 振込業務内区分
     * @param 委託者コード 委託者コード
     */
    public FurikomiDataProcessParameter(RDate 振込指定年月日, FurikomiGyomunaiKubun 振込業務内区分, RString 委託者コード) {
        this.振込指定年月日 = 振込指定年月日;
        this.振込業務内区分 = 振込業務内区分;
        this.委託者コード = 委託者コード;
    }

}
