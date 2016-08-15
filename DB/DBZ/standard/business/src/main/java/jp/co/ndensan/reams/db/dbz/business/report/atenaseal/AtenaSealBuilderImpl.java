/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.atenaseal;

import jp.co.ndensan.reams.db.dbz.entity.report.atenaseal.AtenaSealCreateReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 宛名シール Builderのクラスです。
 *
 * @reamsid_L DBA-1210-050 zhengsongling
 */
public class AtenaSealBuilderImpl implements IAtenaSealBuilder {

    private final IAtenaSealEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyotokkiA4Editor}
     */
    public AtenaSealBuilderImpl(IAtenaSealEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link AtenaSealCreateReportSource}
     */
    @Override
    public AtenaSealCreateReportSource build() {
        return ReportEditorJoiner.from(new AtenaSealCreateReportSource()).join(editor).buildSource();
    }
}
