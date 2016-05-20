/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査票情報Builderのクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyoBuilder implements INinteiChosaJohohyoBuilder {

    private final INinteiChosaJohohyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaJohohyoEditor}
     */
    public NinteiChosaJohohyoBuilder(INinteiChosaJohohyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaJohohyoReportSource}
     */
    @Override
    public NinteiChosaJohohyoReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaJohohyoReportSource()).join(editor).buildSource();
    }
}
