/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100022;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100022.TokubChiiKasRiysFutGengKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別地域加算に係る訪問介護利用者負担減額確認証のReportです。
 *
 * @reamsid_L DBD-3540-120 wangchao
 */
public class TokubchiiKasHomKaigRiysFutGengKakuninshoReport extends Report<TokubChiiKasRiysFutGengKakuninshoReportSource> {

    private final TokubchiiKasHomKaigRiysFutGengKakuninshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 特別地域加算に係る訪問介護利用者負担減額確認証
     * @return 特別地域加算に係る訪問介護利用者負担減額確認証
     */
    public static TokubchiiKasHomKaigRiysFutGengKakuninshoReport createReport(@NonNull TokubchiiKasHomKaigRiysFutGengKakuninshoItem bodyItem) {
        return new TokubchiiKasHomKaigRiysFutGengKakuninshoReport(bodyItem);
    }

    private TokubchiiKasHomKaigRiysFutGengKakuninshoReport(TokubchiiKasHomKaigRiysFutGengKakuninshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubChiiKasRiysFutGengKakuninshoReportSource> writer) {
        ITokubchiiKasHomKaigRiysFutGengKakuninshoEditor bodyEditor = new TokubchiiKasHomKaigRiysFutGengKakuninshoBodyEditor(bodyItem);
        ITokubchiiKasHomKaigRiysFutGengKakuninshoBuider builder = new TokubchiiKasHomKaigRiysFutGengKakuninshoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
