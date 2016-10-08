/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD104010;

import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者減免実施状況のバッチパラメタークラスです。//TODO このクラスを使用しないて下さい、これは一時のものです。
 *
 * @reamsid_L DBD-3770-030 x_liuwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD104010_JukyushaGemmenJisshiJokyoParameter extends BatchParameterBase {

    private static final String OUTPUTBILL = "outputBill";
    private static final String TARGETYEAR = "targetYear";
    private static final String BASEDAYDIFF = "baseDayDiff";
    private static final String BASEDAY = "baseDay";
    private static final String REPORTID = "reportId";
    private static final String ATENACHUSHUTSUJOUKENN = "atenaChushutsuJoukenn";

    @BatchParameter(key = OUTPUTBILL, name = "出力帳票")
    private RString 出力帳票;
    @BatchParameter(key = TARGETYEAR, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = BASEDAYDIFF, name = "基準日区分")
    private RString 基準日区分;
    @BatchParameter(key = BASEDAY, name = "基準日")
    private RString 基準日;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;
    @BatchParameter(key = ATENACHUSHUTSUJOUKENN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter 宛名抽出条件;
}
