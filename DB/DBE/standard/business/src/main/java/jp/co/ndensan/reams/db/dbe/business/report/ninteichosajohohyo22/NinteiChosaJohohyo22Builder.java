/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo22;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo22ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査票情報Builderのクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo22Builder implements INinteiChosaJohohyo22Builder {

    private final INinteiChosaJohohyo22Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaJohohyo22Editor}
     */
    public NinteiChosaJohohyo22Builder(INinteiChosaJohohyo22Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaJohohyoReportSource}
     */
    @Override
    public NinteiChosaJohohyo22ReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaJohohyo22ReportSource()).join(editor).buildSource();
    }
}
