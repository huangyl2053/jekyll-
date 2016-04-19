/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算後情報の識別子です。
 *
 * @reamsid_L DBB-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KeisangoJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 6889245923699395712L;
    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final RString 更正前後区分;
    private final RString 作成処理名;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     */
    public KeisangoJohoIdentifier(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.更正前後区分 = 更正前後区分;
        this.作成処理名 = 作成処理名;
    }
}
