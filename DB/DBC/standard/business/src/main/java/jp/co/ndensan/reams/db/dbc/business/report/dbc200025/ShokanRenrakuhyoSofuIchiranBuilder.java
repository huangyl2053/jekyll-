/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表Builder
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
public class ShokanRenrakuhyoSofuIchiranBuilder
        implements IShokanRenrakuhyoSofuIchiranBuilder {

    private final IShokanRenrakuhyoSofuIchiranEditor headerEditor;
    private final IShokanRenrakuhyoSofuIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public ShokanRenrakuhyoSofuIchiranBuilder(
            IShokanRenrakuhyoSofuIchiranEditor headerEditor,
            IShokanRenrakuhyoSofuIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public ShokanRenrakuhyoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new ShokanRenrakuhyoSofuIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
