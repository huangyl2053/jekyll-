/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo02;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo02ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査票情報Builderのクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo02Builder implements INinteiChosaJohohyo02Builder {

    private final INinteiChosaJohohyo02Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaJohohyo02Editor}
     */
    public NinteiChosaJohohyo02Builder(INinteiChosaJohohyo02Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaJohohyoReportSource}
     */
    @Override
    public NinteiChosaJohohyo02ReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaJohohyo02ReportSource()).join(editor).buildSource();
    }
}
