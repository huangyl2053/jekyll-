/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 賦課台帳（仮算定）帳票 KarisanteiFukaDaichoBuilder
 */
public class KarisanteiFukaDaichoBuilder implements IKarisanteiFukaDaichouilder {

    private final IKarisanteiFukaDaichoEditor headerEditor;
    private final IKarisanteiFukaDaichoEditor hyojiIchiranEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKarisanteiFukaDaichoEditor}
     * @param hyojiIchiranEditor {@link IKarisanteiFukaDaichoEditor}
     */
    public KarisanteiFukaDaichoBuilder(IKarisanteiFukaDaichoEditor headerEditor, IKarisanteiFukaDaichoEditor hyojiIchiranEditor) {
        this.headerEditor = headerEditor;
        this.hyojiIchiranEditor = hyojiIchiranEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public KarisanteiFukaDaichoSource build() {
        return ReportEditorJoiner.from(new KarisanteiFukaDaichoSource()).join(headerEditor).join(hyojiIchiranEditor).buildSource();
    }
}
