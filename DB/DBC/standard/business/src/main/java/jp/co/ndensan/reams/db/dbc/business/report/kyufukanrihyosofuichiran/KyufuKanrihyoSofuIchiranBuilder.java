/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表 Builderするクラスです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
public class KyufuKanrihyoSofuIchiranBuilder implements IKyufuKanrihyoSofuIchiranBuilder {

   private final KyufuKanrihyoSofuIchiranEditor editor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param editor {@link KyufuKanrihyoSofuIchiranEditor}
     */
    public KyufuKanrihyoSofuIchiranBuilder(KyufuKanrihyoSofuIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link KyufuKanrihyoSofuIchiranReportSource}
     */
    @Override
    public KyufuKanrihyoSofuIchiranReportSource build() {
        return ReportEditorJoiner.from(new KyufuKanrihyoSofuIchiranReportSource())
                .join(editor)
                .buildSource();
    }

}
