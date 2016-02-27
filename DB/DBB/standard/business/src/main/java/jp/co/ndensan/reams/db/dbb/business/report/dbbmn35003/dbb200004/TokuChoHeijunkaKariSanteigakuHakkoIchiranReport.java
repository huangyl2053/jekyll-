/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のReportです。
 */
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranReport
        extends Report<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> {

    private final List<TokuChoHeijunkaKariSanteigakuHakkoIchiranItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected TokuChoHeijunkaKariSanteigakuHakkoIchiranReport(List<TokuChoHeijunkaKariSanteigakuHakkoIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static TokuChoHeijunkaKariSanteigakuHakkoIchiranReport
            createFrom(@NonNull List<TokuChoHeijunkaKariSanteigakuHakkoIchiranItem> items) {
        return new TokuChoHeijunkaKariSanteigakuHakkoIchiranReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> reportSourceWriter) {
        for (TokuChoHeijunkaKariSanteigakuHakkoIchiranItem target : targets) {
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor headerEditor = new TokuChoHeijunkaKariSanteigakuHakkoIchiranHeaderEditor(target);
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor hyojiBodyEditor = new TokuChoHeijunkaKariSanteigakuHakkoIchiranBodyEditor(target);
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranBuilder builder
                    = new TokuChoHeijunkaKariSanteigakuHakkoIchiranBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);

        }
    }

}
