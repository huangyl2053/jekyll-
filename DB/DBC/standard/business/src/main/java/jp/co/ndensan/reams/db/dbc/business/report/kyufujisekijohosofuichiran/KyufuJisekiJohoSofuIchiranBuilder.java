/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200053_給付実績情報送付一覧表　Builderクラスです。
 *
 * @reamsid_L DBC-2460-030 lijian
 */
public class KyufuJisekiJohoSofuIchiranBuilder implements IKyufuJisekiJohoSofuIchiranBuilder {

    private final IKyufuJisekiJohoSofuIchiranEditor headerEditor;
    private final IKyufuJisekiJohoSofuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IKyufuJisekiJohoSofuIchiranEditor
     * @param bodyEditor IKyufuJisekiJohoSofuIchiranEditor
     */
    public KyufuJisekiJohoSofuIchiranBuilder(
            IKyufuJisekiJohoSofuIchiranEditor headerEditor,
            IKyufuJisekiJohoSofuIchiranEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuJisekiJohoSofuIchiranSource}
     */
    @Override
    public KyufuJisekiJohoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new KyufuJisekiJohoSofuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
