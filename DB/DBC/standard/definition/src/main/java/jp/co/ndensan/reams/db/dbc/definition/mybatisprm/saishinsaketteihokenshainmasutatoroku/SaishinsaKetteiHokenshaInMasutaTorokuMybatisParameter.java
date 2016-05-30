/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshainmasutatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_再審査決定通知書情報取込共通処理（マスタ登録）MybatisParameter
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter
        implements IMyBatisParameter {

    private FlexibleYearMonth 処理年月;
    private FlexibleYearMonth 取込年月;
    private RString 再処理区分;
    private Long 出力順ID;
    private RString 保険者区分;

    /**
     * コンストラクタです
     *
     */
    public SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter() {
    }

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 取込年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 出力順ID Long
     * @param 保険者区分 RString
     */
    public SaishinsaKetteiHokenshaInMasutaTorokuMybatisParameter(
            FlexibleYearMonth 処理年月,
            FlexibleYearMonth 取込年月,
            RString 再処理区分,
            Long 出力順ID,
            RString 保険者区分) {
        this.処理年月 = 処理年月;
        this.取込年月 = 取込年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
        this.保険者区分 = 保険者区分;
    }
}
