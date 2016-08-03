/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiimagea4;

import jp.co.ndensan.reams.db.dbe.entity.report.gaikyotokkiimagea4.GaikyotokkiImageA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局概況特記のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-370 wangrenze
 */
public class GaikyotokkiImageA4Builder implements IGaikyotokkiImageA4Builder {

    private final IGaikyotokkiImageA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyotokkiImageA4Editor}
     */
    public GaikyotokkiImageA4Builder(IGaikyotokkiImageA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GaikyotokkiImageA4ReportSource}
     */
    @Override
    public GaikyotokkiImageA4ReportSource build() {
        return ReportEditorJoiner.from(new GaikyotokkiImageA4ReportSource()).join(editor).buildSource();
    }
}
