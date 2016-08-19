/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakoshinkekka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * JukyushaKoshinKekkaReadCsvFileProcessパラメータです。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKoshinKekkaReadCsvFileProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString ファイルパース;
    private int 連番;

}
