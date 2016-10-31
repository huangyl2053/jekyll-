/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算に設定のParameter
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CaluculateFukaParameter extends KozaSearchParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;

    /**
     * コンストラクタです。
     *
     * @param key IKozaSearchKey
     * @param 権限有科目リスト List<KamokuCode>
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     */
    public CaluculateFukaParameter(IKozaSearchKey key, List<KamokuCode> 権限有科目リスト, FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        super(key, 権限有科目リスト);
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;

    }

    /**
     * パラメータメソッドです。
     *
     * @param key IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @return CaluculateFukaParameter
     */
    public static CaluculateFukaParameter createSelectByKeyParam(
            IKozaSearchKey key, List<KamokuCode> list, FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        return new CaluculateFukaParameter(key, list, 調定年度, 賦課年度);
    }

}
