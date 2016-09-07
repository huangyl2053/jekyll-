/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistshotokujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistshotokujoho.HanyoListShotokuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報BatchParameterのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShotokuJohoBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_1 = "帳票ID";
    private static final String KEY_2 = "宛名抽出条件";
    private static final String KEY_3 = "出力順ID";
    private static final String KEY_4 = "出力項目ID";
    private static final String KEY_5 = "項目名付加";
    private static final String KEY_6 = "連番付加";
    private static final String KEY_7 = "日付編集";
    private static final String KEY_8 = "賦課年度";
    private static final String KEY_9 = "抽出期間From";
    private static final String KEY_10 = "抽出期間To";
    private static final String KEY_11 = "住民税減免前後表示区分";
    private static final String KEY_12 = "課税区分減免前s";
    private static final String KEY_13 = "課税区分減免後s";
    private static final String KEY_14 = "宛名検索条件";

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
    @BatchParameter(key = KEY_8, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_9, name = "抽出期間From")
    private YMDHMS 抽出期間From;
    @BatchParameter(key = KEY_10, name = "抽出期間To")
    private YMDHMS 抽出期間To;
    @BatchParameter(key = KEY_11, name = "住民税減免前後表示区分")
    private RString 住民税減免前後表示区分;
    @BatchParameter(key = KEY_12, name = "課税区分減免前s")
    private List<RString> 課税区分減免前s;
    @BatchParameter(key = KEY_13, name = "課税区分減免後s")
    private List<RString> 課税区分減免後s;

    /**
     * toProcessParameter
     *
     * @return HanyoListShotokuJohoProcessParameter
     */
    public HanyoListShotokuJohoProcessParameter toProcessParameter() {
        return new HanyoListShotokuJohoProcessParameter(帳票ID, 宛名抽出条件, 出力順ID, 出力項目ID, 項目名付加, 連番付加, 日付編集,
                賦課年度, 抽出期間From, 抽出期間To, 住民税減免前後表示区分, 課税区分減免前s, 課税区分減免後s);
    }

}
