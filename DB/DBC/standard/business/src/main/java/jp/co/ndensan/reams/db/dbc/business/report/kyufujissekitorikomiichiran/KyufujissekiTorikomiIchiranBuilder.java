/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200007_給付実績情報取込結果一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2440-030 qinzhen
 */
public class KyufujissekiTorikomiIchiranBuilder implements IKyufujissekiTorikomiIchiranBuilder {

    private final IKyufujissekiTorikomiIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKyufujissekiTorikomiIchiranEditor
     */
    public KyufujissekiTorikomiIchiranBuilder(IKyufujissekiTorikomiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KyufujissekiTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new KyufujissekiTorikomiIchiranSource())
                .join(editor).buildSource();
    }
}
