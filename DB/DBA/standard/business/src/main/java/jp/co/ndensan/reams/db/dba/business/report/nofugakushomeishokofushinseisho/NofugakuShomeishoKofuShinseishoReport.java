/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険料納付額証明書交付申請書帳票作成します。
 */
public final class NofugakuShomeishoKofuShinseishoReport extends Report<NofugakuShomeishoKofuShinseishoReportSource> {

    private final NofugakuShomeishoKofuShinseishoItem item;

    private NofugakuShomeishoKofuShinseishoReport(NofugakuShomeishoKofuShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険料納付額証明書交付申請書Entityリスト
     * @return NofugakuShomeishoKofuShinseishoReport
     */
    public static NofugakuShomeishoKofuShinseishoReport createReport(@NonNull NofugakuShomeishoKofuShinseishoItem item) {
        return new NofugakuShomeishoKofuShinseishoReport(item);
    }

    /**
     * 介護保険料納付額証明書交付申請書writeByします。
     *
     * @param writer 介護保険料納付額証明書交付申請書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<NofugakuShomeishoKofuShinseishoReportSource> writer) {
        INofugakuShomeishoKofuShinseishoEditor joho = new NofugakuShomeishoKofuShinseishoEditor(item);
        INofugakuShomeishoKofuShinseishoBuilder builder = new NofugakuShomeishoKofuShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
