/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課徴収猶予の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChoshuYuyoIdentifier implements Serializable {

    private static final long serialVersionUID = -5952365166792946190L;

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuYuyoIdentifier(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
    }
}
