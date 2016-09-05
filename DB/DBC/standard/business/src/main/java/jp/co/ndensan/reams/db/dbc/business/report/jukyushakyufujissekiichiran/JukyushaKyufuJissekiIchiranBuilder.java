/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者給付実績一覧表 Builderクラスです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
public class JukyushaKyufuJissekiIchiranBuilder implements IJukyushaKyufuJissekiIchiranBuilder {

    private final IJukyushaKyufuJissekiIchiranEditor editor;
    private final IJukyushaKyufuJissekiIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JukyushaKyufuJissekiIchiranEditor}
     * @param bodyEditor {@link JukyushaKyufuJissekiIchiranBodyEditor}
     */
    protected JukyushaKyufuJissekiIchiranBuilder(IJukyushaKyufuJissekiIchiranEditor editor,
            IJukyushaKyufuJissekiIchiranEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaKyufuJissekiIchiranReportSource}
     */
    @Override
    public JukyushaKyufuJissekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new JukyushaKyufuJissekiIchiranReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
