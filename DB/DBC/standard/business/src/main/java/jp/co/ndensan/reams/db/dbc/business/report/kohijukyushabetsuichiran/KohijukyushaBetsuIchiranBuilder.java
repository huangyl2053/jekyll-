/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護給付費公費受給者別一覧表Builderクラスです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
public class KohijukyushaBetsuIchiranBuilder implements IKohijukyushaBetsuIchiranBuilder {

    private final IKohijukyushaBetsuIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKohijukyushaBetsuIchiranEditor}
     */
    public KohijukyushaBetsuIchiranBuilder(IKohijukyushaBetsuIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KohijukyushaBetsuIchiranReportSource}
     */
    @Override
    public KohijukyushaBetsuIchiranReportSource build() {
        return ReportEditorJoiner.from(new KohijukyushaBetsuIchiranReportSource()).join(editor).buildSource();
    }

}
