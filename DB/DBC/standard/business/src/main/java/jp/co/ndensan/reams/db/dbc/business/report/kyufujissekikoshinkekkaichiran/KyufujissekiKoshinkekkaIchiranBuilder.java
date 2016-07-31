/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Builder
 *
 * @reamsid_L DBC-2470-030 sunhui
 */
public class KyufujissekiKoshinkekkaIchiranBuilder implements IKyufujissekiKoshinkekkaIchiranBuilder {

    private final IKyufujissekiKoshinkekkaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufujissekiKoshinkekkaIchiranEditor}
     */
    KyufujissekiKoshinkekkaIchiranBuilder(IKyufujissekiKoshinkekkaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufujissekiKoshinkekkaIchiranSource}
     */
    @Override
    public KyufujissekiKoshinkekkaIchiranSource build() {
        return ReportEditorJoiner.from(new KyufujissekiKoshinkekkaIchiranSource()).join(editor).buildSource();
    }
}
