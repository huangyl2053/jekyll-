/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenjukyushain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KokuhorenJukyushaInReadCsvFileProcessパラメータです。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaReadCsvFileProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString 保存先フォルダ;
    private RString エントリ情報;
    private int 連番;
    private boolean isLast;

}
