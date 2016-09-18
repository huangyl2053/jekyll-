/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuBuilder implements ISogojigyohiKagoMoshitateshojohoSofuBuilder {

    private final ISogojigyohiKagoMoshitateshojohoSofuEditor headEditor;
    private final ISogojigyohiKagoMoshitateshojohoSofuEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor ISogojigyohiKagoMoshitateshojohoSofuIchiranHeadEditor
     * @param bodyEditor ISogojigyohiKagoMoshitateshojohoSofuIchiranBodyEditor
     */
    public SogojigyohiKagoMoshitateshojohoSofuBuilder(
            ISogojigyohiKagoMoshitateshojohoSofuEditor headEditor,
            ISogojigyohiKagoMoshitateshojohoSofuEditor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiKagoMoshitateshojohoSofuSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKagoMoshitateshojohoSofuSource()).join(headEditor).join(bodyEditor).buildSource();
    }

}
