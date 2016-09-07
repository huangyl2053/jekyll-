/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項（A4版）Builderクラスです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
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
     * @return {@link TokkiText1A4ReportSource}
     */
    @Override
    public TokkiText1A4ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText1A4ReportSource()).join(editor).buildSource();
    }

}
