/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用概況特記一覧表Builderクラスです。
 *
 * @reamsid_L DBE-0150-030 lishengli
 */
class GaikyoTokkiIchiranBuilderImpl implements IGaikyoTokkiIchiranBuilder {

    private final IGaikyoTokkiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyoTokkiIchiranEditor}
     */
    public GaikyoTokkiIchiranBuilderImpl(IGaikyoTokkiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GaikyoTokkiIchiranReportSource}
     */
    @Override
    public GaikyoTokkiIchiranReportSource build() {
        return ReportEditorJoiner.from(new GaikyoTokkiIchiranReportSource()).join(editor).buildSource();
    }
}
