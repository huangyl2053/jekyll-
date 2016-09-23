/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranBuilder implements IGassanShikyuShinseishoJohoSofuIchiranBuilder {

    private final IGassanShikyuShinseishoJohoSofuIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IGassanShikyuShinseishoJohoSofuIchiranEditor
     */
    public GassanShikyuShinseishoJohoSofuIchiranBuilder(IGassanShikyuShinseishoJohoSofuIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanShikyuShinseishoJohoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new GassanShikyuShinseishoJohoSofuIchiranSource())
                .join(editor).buildSource();
    }

}
