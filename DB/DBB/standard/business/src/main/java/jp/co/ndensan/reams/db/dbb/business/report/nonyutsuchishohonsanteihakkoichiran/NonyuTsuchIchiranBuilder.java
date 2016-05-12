/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranBuilder
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranBuilder implements INonyuTsuchIchiranBuilder {

    private final INonyuTsuchIchiranEditor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKarisanteiFukaDaichoEditor}
     */
    public NonyuTsuchIchiranBuilder(INonyuTsuchIchiranEditor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public NonyuTsuchIchiranSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchIchiranSource()).join(headerEditor).buildSource();
    }
}
