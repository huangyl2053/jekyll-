/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2710-040 qinzhen
 */
public class GassanKyufujissekiSofuIchiranBuilder implements IGassanKyufujissekiSofuIchiranBuilder {

    private final IGassanKyufujissekiSofuIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanKyufujissekiSofuIchiranEditor
     */
    public GassanKyufujissekiSofuIchiranBuilder(IGassanKyufujissekiSofuIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanKyufujissekiSofuIchiranSource build() {
        return ReportEditorJoiner.from(new GassanKyufujissekiSofuIchiranSource())
                .join(editor).buildSource();
    }
}
