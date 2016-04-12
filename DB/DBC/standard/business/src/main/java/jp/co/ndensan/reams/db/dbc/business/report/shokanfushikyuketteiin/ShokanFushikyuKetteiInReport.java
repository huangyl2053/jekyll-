/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInReport
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInReport extends Report<ShokanbaraiFushikyuKetteishaIchiranSource> {

    private final List<ShokanFushikyuKetteiInItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<HakkogoIdoTaishoshaIchiranItem>
     */
    protected ShokanFushikyuKetteiInReport(List<ShokanFushikyuKetteiInItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param items List<HakkogoIdoTaishoshaIchiranItem>
     * @return HakkogoIdoTaishoshaIchiranReport
     */
    public static ShokanFushikyuKetteiInReport createForm(@NonNull List<ShokanFushikyuKetteiInItem> items) {
        return new ShokanFushikyuKetteiInReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiFushikyuKetteishaIchiranSource> writer) {
        for (ShokanFushikyuKetteiInItem target : targets) {
            IShokanFushikyuKetteiInEditor headerEditor = new ShokanFushikyuKetteiInHeaderEditor(target);
            IShokanFushikyuKetteiInEditor bodyEditor = new ShokanFushikyuKetteiInBodyEditor(target);
            IShokanFushikyuKetteiInBuilder builder = new ShokanFushikyuKetteiInBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
}
