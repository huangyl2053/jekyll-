/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa3.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * その他資料（A3版）のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-250 wangrenze
 */
public class SonotashiryoA3Builder implements ISonotashiryoA3Builder {

    private final ISonotashiryoA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISonotashiryoA3Editor}
     */
    public SonotashiryoA3Builder(ISonotashiryoA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SonotashiryoA3ReportSource}
     */
    @Override
    public SonotashiryoA3ReportSource build() {
        return ReportEditorJoiner.from(new SonotashiryoA3ReportSource()).join(editor).buildSource();
    }
}
