/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 普徴仮算定賦課のバッチパラメータクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB014001_FuchoKarisanteiFukaParameter extends BatchParameterBase {

    @BatchParameter(key = "調定年度", name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = "賦課年度", name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = "出力帳票一覧", name = "出力帳票一覧")
    private List<HonsanteifukaBatchTyouhyou> 出力帳票一覧;
}
