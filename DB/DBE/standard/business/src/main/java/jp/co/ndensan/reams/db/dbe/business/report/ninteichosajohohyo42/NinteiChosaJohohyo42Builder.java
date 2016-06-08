/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo42ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査票情報Builderのクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo42Builder implements INinteiChosaJohohyo42Builder {

    private final INinteiChosaJohohyo42Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaJohohyo42Editor}
     */
    public NinteiChosaJohohyo42Builder(INinteiChosaJohohyo42Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaJohohyoReportSource}
     */
    @Override
    public NinteiChosaJohohyo42ReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaJohohyo42ReportSource()).join(editor).buildSource();
    }
}
