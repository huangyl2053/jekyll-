/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohisaishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込共通処理（保険者分・ファイル読込）をProcessParameter
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaReadCsvFileProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;

}
