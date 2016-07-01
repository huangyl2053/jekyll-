/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用概況特記のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA3Builder implements IGaikyotokkiTextA3Builder {

    private final IGaikyotokkiTextA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyotokkiTextA3Editor}
     */
    public GaikyotokkiTextA3Builder(IGaikyotokkiTextA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GaikyotokkiTextA3ReportSource}
     */
    @Override
    public GaikyotokkiTextA3ReportSource build() {
        return ReportEditorJoiner.from(new GaikyotokkiTextA3ReportSource()).join(editor).buildSource();
    }
}
