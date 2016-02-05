/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hokenryogenmenchoshuyoyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hokenryogenmenchoshuyoyushinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険料減免申請書のReportです。
 */
public final class HokenryoGenmenChoshuYoyuShinseishoReport extends Report<HokenryoGenmenChoshuYoyuShinseishoReportSource> {

    private final HokenryoGenmenChoshuYoyuShinseishoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 介護保険料減免申請書情報
     * @return 介護保険料減免申請書
     */
    public static HokenryoGenmenChoshuYoyuShinseishoReport createReport(@NonNull HokenryoGenmenChoshuYoyuShinseishoBodyItem bodyItem) {
        return new HokenryoGenmenChoshuYoyuShinseishoReport(bodyItem);
    }

    private HokenryoGenmenChoshuYoyuShinseishoReport(HokenryoGenmenChoshuYoyuShinseishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoGenmenChoshuYoyuShinseishoReportSource> writer) {
        IHokenryoGenmenChoshuYoyuShinseishoEditor bodyEditor = new HokenryoGenmenChoshuYoyuShinseishoBodyEditor(bodyItem);
        IHokenryoGenmenChoshuYoyuShinseishoBuilder builder = new HokenryoGenmenChoshuYoyuShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
