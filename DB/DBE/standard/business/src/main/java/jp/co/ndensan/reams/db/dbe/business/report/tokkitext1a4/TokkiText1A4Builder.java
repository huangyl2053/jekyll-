/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項Builderクラスです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
class TokkiText1A4Builder implements ITokkiText1A4Builder {

    private final ITokkiText1A4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkiText1A4Editor}
     */
    public TokkiText1A4Builder(ITokkiText1A4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiText1ReportSource}
     */
    @Override
    public TokkiText1ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText1ReportSource()).join(editor).buildSource();
    }

}
