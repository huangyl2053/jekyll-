/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext2a4.TokkiText2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項Builderクラスです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
class TokkiText2A4Builder implements ITokkiText2A4Builder {

    private final ITokkiText2A4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkiText2A4Editor}
     */
    public TokkiText2A4Builder(ITokkiText2A4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiText2ReportSource}
     */
    @Override
    public TokkiText2ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText2ReportSource()).join(editor).buildSource();
    }

}
