/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.dbbbt35003;

import jp.co.ndensan.reams.db.dbb.definition.core.valueobject.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TsuchishoIkkatsuHakkoTempData;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴6月分）通知書一括発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class Dbbbt35003FlowParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private Object 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力対象;
    private boolean 一括発行フラグ;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDbbt35003Parameter(TsuchishoIkkatsuHakkoTempData tempData) {
        this.調定年度 = tempData.get調定年度();
        this.賦課年度 = tempData.get賦課年度();
        this.出力帳票一覧List = tempData.get出力帳票一覧List();
        this.発行日 = tempData.get発行日();
        this.出力対象 = tempData.get出力対象();
        this.一括発行フラグ = tempData.is一括発行フラグ();
    }

}
