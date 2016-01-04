/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定結果通知書対象者一覧表Builderクラスです。
 */
class KaigoKekkaTaishouIchiranBuilderImpl implements KaigoKekkaTaishouIchiranBuilder {

    private final KaigoKekkaTaishouIchiranEditor headerEditor;
    private final KaigoKekkaTaishouIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link KaigoKekkaTaishouIchiranEditor}
     * @param hyojiIchiranEditor {@link KaigoKekkaTaishouIchiranEditor}
     */
    public KaigoKekkaTaishouIchiranBuilderImpl(KaigoKekkaTaishouIchiranEditor headerEditor, KaigoKekkaTaishouIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KekkatsuchiTaishoshaIchiranReportSource}
     */
    @Override
    public KekkatsuchiTaishoshaIchiranReportSource build() {
        return ReportEditorJoiner.from(new KekkatsuchiTaishoshaIchiranReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
