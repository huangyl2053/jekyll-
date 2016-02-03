/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko;

import jp.co.ndensan.reams.db.dba.entity.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険住所地特例適用・変更・終了届の帳票を作成します。
 */
public final class JyushochiTokureiTekiyoHenkoReport extends Report<JyushochiTokureiTekiyoHenkoReportSource> {
    
    private final JyushochiTokureiTekiyoHenkoItem item;
    
    private JyushochiTokureiTekiyoHenkoReport(JyushochiTokureiTekiyoHenkoItem item) {
        this.item = item;
    }
    
    /**
     * インスタンスを生成します。
     * @param item 介護保険住所地特例適用・変更・終了届のEntity
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static JyushochiTokureiTekiyoHenkoReport createReport(@NonNull JyushochiTokureiTekiyoHenkoItem item) {
        return new JyushochiTokureiTekiyoHenkoReport(item);
    }

    /**
     * 介護保険住所地特例適用・変更・終了届のwriteBy処理です。
     * @param writer 介護保険住所地特例適用・変更・終了届作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JyushochiTokureiTekiyoHenkoReportSource> writer) {
        IJyushochiTokureiTekiyoHenkoEditor joho = new JyushochiTokureiTekiyoHenkoEditor(item);
        IJyushochiTokureiTekiyoHenkoBuilder builder = new JyushochiTokureiTekiyoHenkoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
