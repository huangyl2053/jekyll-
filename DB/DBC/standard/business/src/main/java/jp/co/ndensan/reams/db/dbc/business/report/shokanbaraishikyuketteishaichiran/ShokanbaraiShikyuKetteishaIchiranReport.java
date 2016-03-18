/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyuketteishaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 償還払支給決定者一覧表帳票Report
 */
public class ShokanbaraiShikyuKetteishaIchiranReport extends Report<ShokanbaraiShikyuKetteishaIchiranSource> {

    private final List<ShokanbaraiShikyuKetteishaIchiranItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<ShokanbaraiShikyuKetteishaIchiranItem>
     */
    protected ShokanbaraiShikyuKetteishaIchiranReport(List<ShokanbaraiShikyuKetteishaIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<ShokanbaraiShikyuKetteishaIchiranItem> targets
     * @return KogakuKyufuTaishoshaIchiranReport
     */
    public static ShokanbaraiShikyuKetteishaIchiranReport createForm(
            @NonNull List<ShokanbaraiShikyuKetteishaIchiranItem> targets) {
        return new ShokanbaraiShikyuKetteishaIchiranReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiShikyuKetteishaIchiranSource> writer) {
        for (ShokanbaraiShikyuKetteishaIchiranItem target : targets) {
            IShokanbaraiShikyuKetteishaIchiranEditor headerEditor = new HeaderEditor(target);
            IShokanbaraiShikyuKetteishaIchiranEditor bodyEditor = new BodyEditor(target);
            IShokanbaraiShikyuKetteishaIchiranBuilder builder = new ShokanbaraiShikyuKetteishaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
