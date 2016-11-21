/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext.TokkiTextA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項A4版Builderクラスです。
 *
 * @reamsid_L DBE-0150-340 lishengli
 */
public class TokkiTextA4Builder implements ITokkiTextA4Builder {

    private final ITokkiTextA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkiTextA4Editor}
     */
    public TokkiTextA4Builder(ITokkiTextA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiTextA4ReportSource}
     */
    @Override
    public TokkiTextA4ReportSource build() {
        return ReportEditorJoiner.from(new TokkiTextA4ReportSource()).join(editor).buildSource();
    }
}
