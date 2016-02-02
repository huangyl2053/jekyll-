/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険受給資格証明書交付申請書の帳票作成します。
 */
public final class JukyuShikakuShomeishokoufuShinseishoReport extends Report<JukyuShikakuShomeishokoufuShinseishoReportSource> {
    
    private final JukyuShikakuShomeishokoufuShinseishoItem item;
    
    private JukyuShikakuShomeishokoufuShinseishoReport(JukyuShikakuShomeishokoufuShinseishoItem item) {
        this.item = item;
    }
    
    /**
     * インスタンスを生成します。
     * @param item 介護保険受給資格証明書交付申請書のEntity
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static JukyuShikakuShomeishokoufuShinseishoReport createReport(@NonNull JukyuShikakuShomeishokoufuShinseishoItem item) {
        return new JukyuShikakuShomeishokoufuShinseishoReport(item);
    }

    /**
     * 介護保険受給資格証明書交付申請書のwriteBy処理です。
     * @param writer 介護保険受給資格証明書交付申請書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JukyuShikakuShomeishokoufuShinseishoReportSource> writer) {
        IJukyuShikakuShomeishokoufuShinseishoEditor joho = new JukyuShikakuShomeishokoufuShinseishoEditor(item);
        IJukyuShikakuShomeishokoufuShinseishoBuilder builder = new JukyuShikakuShomeishokoufuShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
