/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ処理「給付費単位数表標準マスタ取込」のパラメータです。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter extends BatchParameterBase {

    @BatchParameter(key = "条件指定", name = "条件指定")
    private RString 条件指定;
}
