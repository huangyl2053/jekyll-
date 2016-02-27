/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険受領委任払い契約申請書帳票作成します。
 */
public final class JuryoIninharaiKeiyakuShinseishoReport extends Report<JuryoIninharaiKeiyakuShinseishoReportSource> {
    
    private final JuryoIninharaiKeiyakuShinseishoItem item;
    
    private JuryoIninharaiKeiyakuShinseishoReport(JuryoIninharaiKeiyakuShinseishoItem item) {
        this.item = item;
    }
    
    /**
     * インスタンスを生成します。
     * @param item 介護保険受領委任払い契約申請書Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static JuryoIninharaiKeiyakuShinseishoReport createReport(@NonNull JuryoIninharaiKeiyakuShinseishoItem item) {
        return new JuryoIninharaiKeiyakuShinseishoReport(item);
    }

    /**
     * 介護保険受領委任払い契約申請書writeByします。
     * @param writer 介護保険受領委任払い契約申請書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JuryoIninharaiKeiyakuShinseishoReportSource> writer) {
        IJuryoIninharaiKeiyakuShinseishoEditor joho = new JuryoIninharaiKeiyakuShinseishoEditor(item);
        IJuryoIninharaiKeiyakuShinseishoBuilder builder = new JuryoIninharaiKeiyakuShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
