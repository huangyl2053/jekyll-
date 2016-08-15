/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者同定_processのメタークラスですs
 *
 * @reamsid_L DBD-4910-040 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChofukuTorikomiDataDeleteShoriProcessParmeter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 対象月;

    /**
     * コンストラクタです。
     *
     * @param 年度 処理年度
     * @param 処理区分 処理区分
     * @param 対象月 対象月
     */
    public ChofukuTorikomiDataDeleteShoriProcessParmeter(FlexibleYear 年度,
            RString 処理区分, RString 対象月) {
        this.処理年度 = 年度;
        this.対象月 = 対象月;
        this.処理区分 = 処理区分;
    }
}
