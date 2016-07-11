/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia3.TokkiText1A3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用特記事項のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
class Tokkijiko1A3Builder implements ITokkijiko1A3Builder {

    private final ITokkijiko1A3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkijiko1A3Editor}
     */
    public Tokkijiko1A3Builder(ITokkijiko1A3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiText1A3ReportSource}
     */
    @Override
    public TokkiText1A3ReportSource build() {
        return ReportEditorJoiner.from(new TokkiText1A3ReportSource()).join(editor).buildSource();
    }

}
