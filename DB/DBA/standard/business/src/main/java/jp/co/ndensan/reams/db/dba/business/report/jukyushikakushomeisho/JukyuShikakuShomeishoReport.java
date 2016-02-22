/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 受給資格証明書のReportです。
 */
public final class JukyuShikakuShomeishoReport extends Report<JukyuShikakuShomeishoReportSource> {
    
    private final JukyuShikakuShomeishoBodyItem bodyItem;
    
    /**
     * インスタンスを生成します。
     * @param bodyItem 受給資格証明書情報
     * @return 受給資格証明書
     */
    public static JukyuShikakuShomeishoReport createReport(@NonNull JukyuShikakuShomeishoBodyItem bodyItem) {
        return new JukyuShikakuShomeishoReport(bodyItem);
    }
    
    private JukyuShikakuShomeishoReport(JukyuShikakuShomeishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyuShikakuShomeishoReportSource> writer) {
            IJukyuShikakuShomeishoEditor bodyEditor = new JukyuShikakuShomeishoBodyEditor(bodyItem);
            IJukyuShikakuShomeishoBuilder builder = new JukyuShikakuShomeishoBuilderImpl(bodyEditor);
            writer.writeLine(builder);
    }
}
