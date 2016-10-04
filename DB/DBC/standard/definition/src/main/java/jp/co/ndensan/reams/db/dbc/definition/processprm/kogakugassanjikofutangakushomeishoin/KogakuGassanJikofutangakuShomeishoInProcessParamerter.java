/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KogakuGassanJikofutangakuShomeishoInProcessParamerterパラメータです
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuShomeishoInProcessParamerter implements IBatchProcessParameter {

    private RString path;
    private RString fileName;
    private FlexibleYearMonth 処理年月;
    private int レコード件数合算;
    private int 連番;
    private boolean さいごファイルフラグ;
}
