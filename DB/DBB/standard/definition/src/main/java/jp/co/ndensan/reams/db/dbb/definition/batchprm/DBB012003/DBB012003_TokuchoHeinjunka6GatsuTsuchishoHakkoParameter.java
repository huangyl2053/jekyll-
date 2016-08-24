/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
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
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private List<OutputChohyoIchiran> 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力対象;
    private boolean 一括発行フラグ;
    private RString 帳票グループ;
    private RString 文書番号;

}
