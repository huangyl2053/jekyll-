/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040031;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）_サブ処理のパラメータです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter extends BatchParameterBase {

    private static final String KEY_処理区分 = "処理区分";

    @BatchParameter(key = KEY_処理区分, name = "処理区分")
    private RString 処理区分;

}
