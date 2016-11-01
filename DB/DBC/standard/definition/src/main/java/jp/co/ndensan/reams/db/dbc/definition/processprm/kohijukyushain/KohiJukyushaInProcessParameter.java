/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kohijukyushain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費公費受給者別一覧表情報取込のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2800-010 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohiJukyushaInProcessParameter implements IBatchProcessParameter {

    private final RString 処理年月;
    private final RString 再処理区分;
    private final long 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 再処理区分 再処理区分
     * @param 出力順ID 出力順ID
     */
    public KohiJukyushaInProcessParameter(RString 処理年月,
            RString 再処理区分,
            long 出力順ID) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
    }
}
