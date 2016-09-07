/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistfukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22001_汎用リスト 賦課台帳BatchParameterのクラス
 *
 * @reamsid_L DBB-1900-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListFukaDaichoBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_1 = "帳票ID";
    private static final String KEY_2 = "宛名抽出条件";
    private static final String KEY_3 = "出力順ID";
    private static final String KEY_4 = "出力項目ID";
    private static final String KEY_5 = "項目名付加";
    private static final String KEY_6 = "連番付加";
    private static final String KEY_7 = "日付編集";
    private static final String KEY_8 = "調定年度";
    private static final String KEY_9 = "賦課年度";
    private static final String KEY_10 = "最新状態で抽出";
    private static final String KEY_11 = "基準日";
    private static final String KEY_12 = "基準日区分";
    private static final String KEY_13 = "資格区分";
    private static final String KEY_14 = "受給者判定";
    private static final String KEY_15 = "徴収方法";
    private static final String KEY_16 = "保険料段階s";

    @BatchParameter(key = KEY_1, name = "帳票ID")
    private ReportId 帳票ID;
    @BatchParameter(key = KEY_2, name = "宛名抽出条件")
    private AtenaSelectBatchParameter 宛名抽出条件;
    @BatchParameter(key = KEY_3, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = KEY_4, name = "出力項目ID")
    private RString 出力項目ID;
    @BatchParameter(key = KEY_5, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = KEY_6, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = KEY_7, name = "日付編集")
    private boolean 日付編集;
    @BatchParameter(key = KEY_8, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_9, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_10, name = "最新状態で抽出")
    private boolean 最新状態で抽出;
    @BatchParameter(key = KEY_11, name = "基準日")
    private RDate 基準日;
    @BatchParameter(key = KEY_12, name = "基準日区分")
    private RString 基準日区分;
    @BatchParameter(key = KEY_13, name = "資格区分")
    private RString 資格区分;
    @BatchParameter(key = KEY_14, name = "受給者判定")
    private RString 受給者判定;
    @BatchParameter(key = KEY_15, name = "徴収方法")
    private RString 徴収方法;
    @BatchParameter(key = KEY_16, name = "保険料段階s")
    private List<RString> 保険料段階s;

}
