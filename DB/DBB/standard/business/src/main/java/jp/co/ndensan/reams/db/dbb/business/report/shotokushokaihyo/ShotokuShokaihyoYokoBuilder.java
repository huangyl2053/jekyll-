/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoYokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR51002_所得照会票のクラスです。
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoYokoBuilder implements IShotokuShokaihyoYokoBuilder {

    private final IShotokuShokaihyoYokoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiFukaDaichoEditor}
     */
    public ShotokuShokaihyoYokoBuilder(IShotokuShokaihyoYokoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public ShotokuShokaihyoYokoSource build() {
        return ReportEditorJoiner.from(new ShotokuShokaihyoYokoSource()).join(editor).buildSource();
    }
}
