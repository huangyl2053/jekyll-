/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 追加資料鑑（A4版）Builderクラスです。
 *
 * @reamsid_L DBE-0150-420 wangrenze
 */
public class TsuikashiryokagamiA4Builder implements ITsuikashiryokagamiA4Builder {

    private final ITsuikashiryokagamiA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITsuikashiryokagamiA4Editor}
     */
    public TsuikashiryokagamiA4Builder(ITsuikashiryokagamiA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TsuikashiryokagamiA4ReportSource}
     */
    @Override
    public TsuikashiryokagamiA4ReportSource build() {
        return ReportEditorJoiner.from(new TsuikashiryokagamiA4ReportSource()).join(editor).buildSource();
    }
}
