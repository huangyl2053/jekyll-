/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員用その他資料のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA3Builder implements IIinSonotashiryoSakuseiA3Builder {

    private final IIinSonotashiryoSakuseiA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinSonotashiryoSakuseiA3Editor}
     */
    public IinSonotashiryoSakuseiA3Builder(IIinSonotashiryoSakuseiA3Editor editor) {
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
