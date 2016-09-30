/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 Builderクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranBuilder implements IKyufuSaishinsaMoshitateshojohoSofuIchiranBuilder {

    private final IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor headerEditor;
    private final IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor
     * @param bodyEditor IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor
     */
    public KyufuSaishinsaMoshitateshojohoSofuIchiranBuilder(
            IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor headerEditor,
            IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuSaishinsaMoshitateshojohoSofuIchiranSource}
     */
    @Override
    public KyufuSaishinsaMoshitateshojohoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new KyufuSaishinsaMoshitateshojohoSofuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
