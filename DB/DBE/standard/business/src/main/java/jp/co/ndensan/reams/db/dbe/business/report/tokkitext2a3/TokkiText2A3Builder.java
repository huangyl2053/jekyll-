/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a3;

import jp.co.ndensan.reams.db.dbe.entity.report.tokkitext2a3.TokkiText2A3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項（2枚目以降）A3版Builderクラスです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
public class TokkiText2A3Builder implements ITokkiText2A3Builder {

    private final ITokkiText2A3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkiText2A3Editor}
     */
    public TokkiText2A3Builder(ITokkiText2A3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiText2A3ReportSource}
     */
    @Override
    public TokkiText2A3ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText2A3ReportSource()).join(editor).buildSource();
    }
}
