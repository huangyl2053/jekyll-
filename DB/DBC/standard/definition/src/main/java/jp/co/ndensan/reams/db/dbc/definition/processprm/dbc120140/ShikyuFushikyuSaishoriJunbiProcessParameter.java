/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120140;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給（不支給）決定通知書情報取込のShikyuFushikyuSaishoriJunbiProcessパラメータ。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuSaishoriJunbiProcessParameter implements IBatchProcessParameter {

    private RString 処理区分;
    private FlexibleYearMonth 処理年月;
}
