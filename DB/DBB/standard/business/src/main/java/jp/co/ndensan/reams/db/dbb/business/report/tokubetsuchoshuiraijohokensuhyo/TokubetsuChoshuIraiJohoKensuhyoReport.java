/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のPropertyクラスです。
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
public class TokubetsuChoshuIraiJohoKensuhyoReport extends Report<TokubetsuChoshuIraiJohoKensuhyoSource> {

    private final TokubetsuChoshuIraiJohoKensuhyoParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter TokubetsuChoshuIraiJohoKensuhyoParameter
     */
    public TokubetsuChoshuIraiJohoKensuhyoReport(TokubetsuChoshuIraiJohoKensuhyoParameter parameter) {
        this.parameter = parameter;
    }

    /**
     * createFormメソッド
     *
     * @param parameter TokubetsuChoshuIraiJohoKensuhyoParameter
     * @return TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport
     */
    public static TokubetsuChoshuIraiJohoKensuhyoReport createForm(
            @NonNull TokubetsuChoshuIraiJohoKensuhyoParameter parameter) {
        return new TokubetsuChoshuIraiJohoKensuhyoReport(parameter);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIraiJohoKensuhyoSource> writer) {

        ITokubetsuChoshuIraiJohoKensuhyoEditor editor = new TokubetsuChoshuIraiJohoKensuhyoEditor(parameter);
        ITokubetsuChoshuIraiJohoKensuhyoBuilder builder = new TokubetsuChoshuIraiJohoKensuhyoBuilder(editor);
        writer.writeLine(builder);
    }

}
