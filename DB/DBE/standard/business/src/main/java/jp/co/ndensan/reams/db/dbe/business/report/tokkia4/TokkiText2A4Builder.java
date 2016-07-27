/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4.TokkiText2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項2枚目以降（A4版）のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
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
     * @return {@link TokkiText1A4ReportSource}
     */
    @Override
    public TokkiText2A4ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText2A4ReportSource()).join(editor).buildSource();
    }

}
