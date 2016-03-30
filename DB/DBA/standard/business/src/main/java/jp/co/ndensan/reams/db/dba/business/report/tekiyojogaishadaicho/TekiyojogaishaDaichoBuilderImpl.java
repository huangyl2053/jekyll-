/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 適用除外者台帳Builderクラスです。
 */
class TekiyojogaishaDaichoBuilderImpl implements ITekiyojogaishaDaichoBuilder {

    private final ITekiyojogaishaDaichoEditor headerEditor;
    private final ITekiyojogaishaDaichoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ITekiyojogaishaDaichoEditor}
     * @param bodyEditor {@link ITekiyojogaishaDaichoEditor}
     */
    public TekiyojogaishaDaichoBuilderImpl(
            ITekiyojogaishaDaichoEditor headerEditor,
            ITekiyojogaishaDaichoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TekiyojogaishaDaichoReportSource}
     */
    @Override
    public TekiyojogaishaDaichoReportSource build() {
        return ReportEditorJoiner.from(new TekiyojogaishaDaichoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
