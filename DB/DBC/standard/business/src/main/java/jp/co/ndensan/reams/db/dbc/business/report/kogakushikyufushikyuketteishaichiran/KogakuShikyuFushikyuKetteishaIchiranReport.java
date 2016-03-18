/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票Report
 */
public class KogakuShikyuFushikyuKetteishaIchiranReport extends Report<KogakuShikyuFushikyuKetteishaIchiranSource> {

    private final List<KogakuShikyuFushikyuKetteishaIchiranItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<KogakuShikyuFushikyuKetteishaIchiranItem>
     */
    public KogakuShikyuFushikyuKetteishaIchiranReport(List<KogakuShikyuFushikyuKetteishaIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<KogakuKyufuTaishoshaIchiranItem> targets
     * @return KogakuKyufuTaishoshaIchiranReport
     */
    public static KogakuShikyuFushikyuKetteishaIchiranReport createForm(
            @NonNull List<KogakuShikyuFushikyuKetteishaIchiranItem> targets) {
        return new KogakuShikyuFushikyuKetteishaIchiranReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuFushikyuKetteishaIchiranSource> writer) {
        for (KogakuShikyuFushikyuKetteishaIchiranItem target : targets) {
            IKogakuShikyuFushikyuKetteishaIchiranEditor headerEditor = new HeaderEditor(target);
            IKogakuShikyuFushikyuKetteishaIchiranEditor bodyEditor = new BodyEditor(target);
            IKogakuShikyuFushikyuKetteishaIchiranBuilder builder = new KogakuShikyuFushikyuKetteishaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
