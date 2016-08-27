/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KohifutanshaReadCsvFileProcessパラメータです。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenkyotsuCsvFileReadProcessParameter implements IBatchProcessParameter {

    private int レコード件数合算;
    private FlexibleYearMonth 処理年月;
    private RString 保存先パース;
    private boolean isFirst;
    private boolean isLast;
    private int 明細件数合算;
    private int 集計件数合算;

}
