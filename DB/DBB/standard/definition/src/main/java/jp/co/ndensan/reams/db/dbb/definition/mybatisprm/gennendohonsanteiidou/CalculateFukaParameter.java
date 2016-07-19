/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課計算用パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CalculateFukaParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final RString 算定月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 算定月 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     */
    private CalculateFukaParameter(FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 算定月,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        super(searchkey, list);
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.算定月 = 算定月;
    }

    /**
     * 賦課計算のパラメータを生成します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 算定月 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @return パラメータ
     */
    public static CalculateFukaParameter createParam(FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 算定月,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        return new CalculateFukaParameter(賦課年度, 調定日時, 算定月, searchkey, list);
    }

}
