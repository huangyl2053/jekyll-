/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 仮算定額変更通知書発行一覧表のReportです。
 */
public class KariSanteigakuHenkoTsuchishoHakkoIchiranReport extends Report<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    private final List<KariSanteigakuHenkoTsuchishoHakkoIchiranItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected KariSanteigakuHenkoTsuchishoHakkoIchiranReport(List<KariSanteigakuHenkoTsuchishoHakkoIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static KariSanteigakuHenkoTsuchishoHakkoIchiranReport createFrom(@NonNull List<KariSanteigakuHenkoTsuchishoHakkoIchiranItem> items) {
        return new KariSanteigakuHenkoTsuchishoHakkoIchiranReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> reportSourceWriter) {
        for (KariSanteigakuHenkoTsuchishoHakkoIchiranItem target : targets) {
            IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor headerEditor = new KariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor(target);
            IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor hyojiBodyEditor = new KariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor(target);
            IKariSanteigakuHenkoTsuchishoHakkoIchiranBuilder builder
                    = new KariSanteigakuHenkoTsuchishoHakkoIchiranBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);

        }
    }
}
