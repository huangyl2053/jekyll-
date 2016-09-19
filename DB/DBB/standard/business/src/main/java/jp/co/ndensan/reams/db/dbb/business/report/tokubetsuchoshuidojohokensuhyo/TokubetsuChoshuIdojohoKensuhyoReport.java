/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Report
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoReport extends Report<TokubetsuChoshuIdojohoKensuhyoSource> {

    private final TokubetsuChoshuIdojohoKensuhyoParameter parameter;

    /**
     * コンストラクタです。
     *
     *
     * @param parameter TokubetsuChoshuIdojohoKensuhyoParameter
     */
    public TokubetsuChoshuIdojohoKensuhyoReport(TokubetsuChoshuIdojohoKensuhyoParameter parameter) {

        this.parameter = parameter;
    }

    /**
     * createFormメソッド
     *
     * @param parameter TokubetsuChoshuIraiJohoKensuhyoParameter
     * @return TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport
     */
    public static TokubetsuChoshuIdojohoKensuhyoReport createForm(
            @NonNull TokubetsuChoshuIdojohoKensuhyoParameter parameter) {
        return new TokubetsuChoshuIdojohoKensuhyoReport(parameter);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIdojohoKensuhyoSource> writer) {

        ITokubetsuChoshuIdojohoKensuhyoEditor editor
                = new TokubetsuChoshuIdojohoKensuhyoEditor(parameter);
        ITokubetsuChoshuIdojohoKensuhyoBuilder builder
                = new TokubetsuChoshuIdojohoKensuhyoBuilder(editor);
        writer.writeLine(builder);

    }
}
