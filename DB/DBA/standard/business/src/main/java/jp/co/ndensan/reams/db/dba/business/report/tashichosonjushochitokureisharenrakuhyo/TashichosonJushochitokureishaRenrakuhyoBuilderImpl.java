/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険他市町村住所地特例者連絡票Builderクラスです。
 */
class TashichosonJushochitokureishaRenrakuhyoBuilderImpl implements ITashichosonJushochitokureishaRenrakuhyoBuilder {

    private final TashichosonJushochitokureishaRenrakuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor {@link TashichosonJushochitokureishaRenrakuhyoEditor}
     */
    public TashichosonJushochitokureishaRenrakuhyoBuilderImpl(TashichosonJushochitokureishaRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TashichosonJushochitokureishaRenrakuhyoReportSource}
     */
    @Override
    public TashichosonJushochitokureishaRenrakuhyoReportSource build() {
        return ReportEditorJoiner.from(new TashichosonJushochitokureishaRenrakuhyoReportSource()).join(editor).buildSource();
    }
}
