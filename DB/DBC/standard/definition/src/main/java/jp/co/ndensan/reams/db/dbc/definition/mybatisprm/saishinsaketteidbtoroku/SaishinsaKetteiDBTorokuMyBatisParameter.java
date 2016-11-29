/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteidbtoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *  * 再審査決定通知書情報取込共通処理（マスタ登録）MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SaishinsaKetteiDBTorokuMyBatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth 処理年月;
    private final RString 保険者区分;

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 保険者区分 RString
     */
    public SaishinsaKetteiDBTorokuMyBatisParameter(
            FlexibleYearMonth 処理年月,
            RString 保険者区分) {
        this.処理年月 = 処理年月;
        this.保険者区分 = 保険者区分;
    }
}
