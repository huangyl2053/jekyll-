/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票（概況特記）Builderのクラスです。
 *
 * @reamsid_L DBE-0080-190 xuyannan
 */
public class GaikyotokkiA4BuilderImpl implements IGaikyotokkiA4Builder {

    private final IGaikyotokkiA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IGaikyotokkiA4Editor}
     */
    public GaikyotokkiA4BuilderImpl(IGaikyotokkiA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GaikyotokkiA4ReportSource}
     */
    @Override
    public GaikyotokkiA4ReportSource build() {
        return ReportEditorJoiner.from(new GaikyotokkiA4ReportSource()).join(editor).buildSource();
    }

}
