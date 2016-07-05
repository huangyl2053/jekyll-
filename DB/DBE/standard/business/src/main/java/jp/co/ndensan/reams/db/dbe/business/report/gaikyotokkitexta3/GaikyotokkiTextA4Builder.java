/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用概況特記のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA4Builder implements IGaikyotokkiTextA4Builder {

    private final IGaikyotokkiTextA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyotokkiTextA4Editor}
     */
    public GaikyotokkiTextA4Builder(IGaikyotokkiTextA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GaikyotokkiTextA4ReportSource}
     */
    @Override
    public GaikyotokkiTextA4ReportSource build() {
        return ReportEditorJoiner.from(new GaikyotokkiTextA4ReportSource()).join(editor).buildSource();
    }
}
