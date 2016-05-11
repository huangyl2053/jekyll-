/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 他市町村住所地特例者台帳Builderクラスです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
public class TashichosonJushochitokureishaDaichoBuilderImpl implements ITashichosonJushochitokureishaDaichoBuilder {

    private final TashichosonJushochitokureishaDaichoHeaderEditor headerEditor;
    private final TashichosonJushochitokureishaDaichoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link TashichosonJushochitokureishaDaichoHeaderEditor}
     * @param bodyEditor {@link TashichosonJushochitokureishaDaichoBodyEditor}
     */
    TashichosonJushochitokureishaDaichoBuilderImpl(
            TashichosonJushochitokureishaDaichoHeaderEditor headerEditor,
            TashichosonJushochitokureishaDaichoBodyEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TashichosonJushochitokureishaDaichoReportSource}
     */
    @Override
    public TashichosonJushochitokureishaDaichoReportSource build() {
        return ReportEditorJoiner.from(new TashichosonJushochitokureishaDaichoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
