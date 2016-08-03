/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定延期通知書発行一覧表のBuilderクラスです。
 *
 * @reamsid_L DBD-1410-040 chenxin
 */
class NinteiEnkiTsuchishoHakkoIchiranhyoJyohoBuilderImpl implements INinteiEnkiTsuchishoHakkoIchiranhyoBuilder {

    private INinteiEnkiTsuchishoHakkoIchiranhyoEditor headerEditor;
    private INinteiEnkiTsuchishoHakkoIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor　headerEditor
     * @param hyojiIchiranEditor　bodyEditor
     */
    public NinteiEnkiTsuchishoHakkoIchiranhyoJyohoBuilderImpl(INinteiEnkiTsuchishoHakkoIchiranhyoEditor headerEditor,
            INinteiEnkiTsuchishoHakkoIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link }　NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     */
    @Override
    public NinteiEnkiTsuchishoHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new NinteiEnkiTsuchishoHakkoIchiranhyoReportSource())
                .join(headerEditor)
                .join(bodyEditor)
                .buildSource();
    }
}
