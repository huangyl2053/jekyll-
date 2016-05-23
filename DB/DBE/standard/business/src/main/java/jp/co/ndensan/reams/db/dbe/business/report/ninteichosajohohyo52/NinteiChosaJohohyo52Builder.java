/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo52ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査票情報Builderのクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo52Builder implements INinteiChosaJohohyo52Builder {

    private final INinteiChosaJohohyo52Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaJohohyo52Editor}
     */
    public NinteiChosaJohohyo52Builder(INinteiChosaJohohyo52Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaJohohyoReportSource}
     */
    @Override
    public NinteiChosaJohohyo52ReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaJohohyo52ReportSource()).join(editor).buildSource();
    }
}
