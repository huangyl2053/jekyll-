/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa4.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * その他資料（A4版）のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-270 wangrenze
 */
public class SonotashiryoA4Builder implements ISonotashiryoA4Builder {

    private final ISonotashiryoA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISonotashiryoA4Editor}
     */
    public SonotashiryoA4Builder(ISonotashiryoA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SonotashiryoA4ReportSource}
     */
    @Override
    public SonotashiryoA4ReportSource build() {
        return ReportEditorJoiner.from(new SonotashiryoA4ReportSource()).join(editor).buildSource();
    }
}
