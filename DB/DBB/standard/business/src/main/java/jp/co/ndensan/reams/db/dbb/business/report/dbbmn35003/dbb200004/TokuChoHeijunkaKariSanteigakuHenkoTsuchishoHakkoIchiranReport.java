/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のReportです。
 */
public class TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReport extends Report<TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    private final List<TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem> targets;

    protected TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReport(List<TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReport createFrom(@NonNull List<TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem> items) {
        return new TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReport(items);
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> reportSourceWriter) {
        for (TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem target : targets) {
            ITokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranEditor headerEditor = new TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor(target);
            ITokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranEditor hyojiBodyEditor = new TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor(target);
            ITokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranBuilder builder = new TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);

        }
    }

}
