/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者更新SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-030 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinDeleteMybatisParameter implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 対象月;

    /**
     * DB出力(処理日付管理マスタ)
     *
     * @param 処理年度 処理年度
     * @param 処理区分 処理区分
     * @param 対象月 対象月
     */
    public HikazeiNennkinDeleteMybatisParameter(FlexibleYear 処理年度,
            RString 処理区分,
            RString 対象月) {
        this.処理年度 = 処理年度;
        this.処理区分 = 処理区分;
        this.対象月 = 対象月;
    }
}
