/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.HikazeiNennkinDeleteMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者削除ProcessParameter
 *
 * @reamsid_L DBD-4910-030 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinDeleteProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 対象月;
    private RString 登録区分;
    private RString 処理状態;

    /**
     *
     * @param 処理年度 処理年度
     * @param 処理区分 処理区分
     * @param 対象月 対象月
     * @param 登録区分 登録区分
     * @return HikazeiNennkinDeleteMybatisParameter
     */
    public HikazeiNennkinDeleteMybatisParameter MybatisParameter(FlexibleYear 処理年度,
            RString 処理区分,
            RString 対象月,
            RString 登録区分) {
        this.処理年度 = 処理年度;
        this.処理区分 = 処理区分;
        this.対象月 = 対象月;
        this.登録区分 = 登録区分;
        return new HikazeiNennkinDeleteMybatisParameter(処理年度, 処理区分, 対象月, 登録区分);
    }

}
