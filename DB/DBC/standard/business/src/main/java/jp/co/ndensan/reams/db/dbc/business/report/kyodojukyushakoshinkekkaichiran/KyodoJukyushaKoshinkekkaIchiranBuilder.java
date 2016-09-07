/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 共同処理用受給者情報一覧表Builderのインターフェースクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
public class KyodoJukyushaKoshinkekkaIchiranBuilder implements IKyodoJukyushaKoshinkekkaIchiranBuilder {

    private final IKyodoJukyushaKoshinkekkaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor IKyodoJukyushaKoshinkekkaIchiranEditor
     */
    public KyodoJukyushaKoshinkekkaIchiranBuilder(
            IKyodoJukyushaKoshinkekkaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyodoJukyushaKoshinkekkaIchiranReportSource}
     */
    @Override
    public KyodoJukyushaKoshinkekkaIchiranReportSource build() {
        return ReportEditorJoiner.from(new KyodoJukyushaKoshinkekkaIchiranReportSource()).join(editor).buildSource();
    }
}
