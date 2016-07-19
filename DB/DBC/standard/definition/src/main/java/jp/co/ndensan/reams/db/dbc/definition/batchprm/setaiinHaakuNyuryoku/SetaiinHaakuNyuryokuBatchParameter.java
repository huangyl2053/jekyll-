/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.setaiinHaakuNyuryoku;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;

/**
 * 世帯員把握（バッチ）のパラメータです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SetaiinHaakuNyuryokuBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_管理識別区分 = "管理識別区分";

    @BatchParameter(key = KEY_管理識別区分, name = "管理識別区分")
    private SetaiinHaakuKanriShikibetsuKubun 管理識別区分;
}
