/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 受給資格証明書Builderクラスです。
 */
public class JukyuShikakuShomeishoBuilderItem implements IJukyuShikakuShomeishoBuilder {
    
    private final IJukyuShikakuShomeishoEditor bodyEditor;
    
    /**
     * インスタンスを生成します。
     * @param headEditor {@link IJukyuShikakuShomeishoEditor}
     * @param bodyEditor {@link IJukyuShikakuShomeishoEditor}
     */
    JukyuShikakuShomeishoBuilderItem(IJukyuShikakuShomeishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyuShikakuShomeishoReportSource}
     */
    @Override
    public JukyuShikakuShomeishoReportSource build() {
        return ReportEditorJoiner.from(new JukyuShikakuShomeishoReportSource())
                .join(bodyEditor).buildSource();
    }
    
}
