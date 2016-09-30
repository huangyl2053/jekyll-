/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受領委任契約事業者一覧表帳票Builder
 *
 * @reamsid_L DBC-2110-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranBuilder implements IJuryoIninJigyoshaIchiranBuilder {

    private final IJuryoIninJigyoshaIchiranEditor headEditor;
    private final IJuryoIninJigyoshaIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IJuryoIninJigyoshaIchiranEditor}
     * @param bodyEditor {@link IJuryoIninJigyoshaIchiranEditor}
     */
    public JuryoIninJigyoshaIchiranBuilder(IJuryoIninJigyoshaIchiranEditor headEditor,
            IJuryoIninJigyoshaIchiranEditor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuryoIninJigyoshaIchiranSource}
     */
    @Override
    public JuryoIninJigyoshaIchiranSource build() {
        return ReportEditorJoiner.from(new JuryoIninJigyoshaIchiranSource())
                .join(headEditor).join(bodyEditor).buildSource();
    }
}
