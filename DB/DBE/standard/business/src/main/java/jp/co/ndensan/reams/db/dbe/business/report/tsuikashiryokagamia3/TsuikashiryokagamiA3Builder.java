/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 追加資料鑑（A3版）Builderクラスです。
 *
 * @reamsid_L DBE-0150-410 wangrenze
 */
public class TsuikashiryokagamiA3Builder implements ITsuikashiryokagamiA3Builder {

    private final ITsuikashiryokagamiA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITsuikashiryokagamiA3Editor}
     */
    public TsuikashiryokagamiA3Builder(ITsuikashiryokagamiA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TsuikashiryokagamiA3ReportSource}
     */
    @Override
    public TsuikashiryokagamiA3ReportSource build() {
        return ReportEditorJoiner.from(new TsuikashiryokagamiA3ReportSource()).join(editor).buildSource();
    }
}
