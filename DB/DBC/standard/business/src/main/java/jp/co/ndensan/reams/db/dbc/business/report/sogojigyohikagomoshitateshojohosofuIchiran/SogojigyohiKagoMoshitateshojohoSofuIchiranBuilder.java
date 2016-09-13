/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran;

import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表 Buillderクラスです。
 *
 * @reamsid_L DBC-2530-041 liuxiaoyu
 */
public class SogojigyohiKagoMoshitateshojohoSofuIchiranBuilder implements ISogojigyohiKagoMoshitateshojohoSofuIchiranBuilder {

    private final ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor headerEditor;
    private final ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor
     * @param bodyEditor ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor
     */
    public SogojigyohiKagoMoshitateshojohoSofuIchiranBuilder(
            ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor headerEditor,
            ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SogojigyohiKagoMoshitateshojohoSofuIchiranSource}
     */
    @Override
    public SogojigyohiKagoMoshitateshojohoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKagoMoshitateshojohoSofuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
