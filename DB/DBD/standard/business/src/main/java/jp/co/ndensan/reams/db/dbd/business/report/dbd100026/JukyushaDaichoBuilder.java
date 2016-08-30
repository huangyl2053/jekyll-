/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100026;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者台帳Builderクラスです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public class JukyushaDaichoBuilder implements IJukyushaDaichoBuilder {

    private final IJukyushaDaichoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IJukyushaDaichoEditor}
     */
    JukyushaDaichoBuilder(IJukyushaDaichoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaDaichoReportSource}
     */
    @Override
    public JukyushaDaichoReportSource build() {
        return ReportEditorJoiner.from(new JukyushaDaichoReportSource()).join(bodyEditor).buildSource();
    }
}
