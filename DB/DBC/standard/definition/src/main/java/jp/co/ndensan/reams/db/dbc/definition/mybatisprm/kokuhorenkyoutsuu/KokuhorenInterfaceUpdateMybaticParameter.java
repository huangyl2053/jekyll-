/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込処理共通のバッチ処理クラスのMapperパラメータクラスです<br>
 * 国保連インタフェース管理TBLを更新します。
 *
 * @reamsid_L DBC-0980-530 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenInterfaceUpdateMybaticParameter implements IMyBatisParameter {

    private final FlexibleYearMonth shoriYM;
    private final RString kokanShikibetsuNo;

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 交換情報識別番号 RString
     */
    public KokuhorenInterfaceUpdateMybaticParameter(FlexibleYearMonth 処理年月, RString 交換情報識別番号) {
        this.shoriYM = 処理年月;
        this.kokanShikibetsuNo = 交換情報識別番号;
    }

}
