/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 適用除外者台帳Builderクラスです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
class TekiyojogaishaDaichoBuilderImpl implements ITekiyojogaishaDaichoBuilder {

    private final TekiyojogaishaDaichoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link TekiyojogaishaDaichoEditor}
     */
    public TekiyojogaishaDaichoBuilderImpl(
            TekiyojogaishaDaichoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TekiyojogaishaDaichoReportSource}
     */
    @Override
    public TekiyojogaishaDaichoReportSource build() {
        return ReportEditorJoiner.from(new TekiyojogaishaDaichoReportSource()).join(editor).buildSource();
    }
}
