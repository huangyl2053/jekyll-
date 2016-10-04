/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.koseitaishojissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200097_更正対象給付実績一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-4960-040 qinzhen
 */
public class KoseiTaishoJissekiIchiranBuilder implements IKoseiTaishoJissekiIchiranBuilder {

    private final IKoseiTaishoJissekiIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKoseiTaishoJissekiIchiranEditor
     */
    public KoseiTaishoJissekiIchiranBuilder(IKoseiTaishoJissekiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KoseiTaishoJissekiIchiranSource build() {
        return ReportEditorJoiner.from(new KoseiTaishoJissekiIchiranSource())
                .join(editor).buildSource();
    }
}
