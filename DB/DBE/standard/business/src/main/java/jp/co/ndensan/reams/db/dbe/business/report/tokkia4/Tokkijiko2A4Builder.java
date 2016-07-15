/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4.Tokkijiko2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用特記事項のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
class Tokkijiko2A4Builder implements ITokkijiko2A4Builder {

    private final ITokkijiko2A4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokkijiko2A4Editor}
     */
    public Tokkijiko2A4Builder(ITokkijiko2A4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokkiText1A4ReportSource}
     */
    @Override
    public Tokkijiko2A4ReportSource build() {
        return ReportEditorJoiner.from(new Tokkijiko2A4ReportSource()).join(editor).buildSource();
    }

}
