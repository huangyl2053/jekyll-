/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.jigyobunshikyugakukeisankkarenrakuhyopanel;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 事業高額合算支給額計算結果情報のパラメータ。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "syoridate", name = "処理日時")
    private RString syoridate;
    @BatchParameter(key = "hihokenshaNo", name = "被保険者番号")
    private HihokenshaNo hihokenshaNo;
    @BatchParameter(key = "taisyonenndo", name = "対象年度")
    private KeyValueDataSource taisyonenndo;
    @BatchParameter(key = "ShikyuShinseishoSeiriNo", name = "連絡票整理番号")
    private KeyValueDataSource shikyuShinseishoSeiriNo;
    @BatchParameter(key = "ShoKisaiHokenshaNo", name = "証記載保険者番号")
    private KeyValueDataSource shoKisaiHokenshaNo;
}
