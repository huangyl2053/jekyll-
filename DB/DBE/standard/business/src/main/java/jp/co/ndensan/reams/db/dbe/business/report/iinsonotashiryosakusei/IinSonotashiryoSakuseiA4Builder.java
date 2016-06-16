/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員用その他資料のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA4Builder implements IIinSonotashiryoSakuseiA4Builder {

    private final IIinSonotashiryoSakuseiA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinSonotashiryoSakuseiA4Editor}
     */
    public IinSonotashiryoSakuseiA4Builder(IIinSonotashiryoSakuseiA4Editor editor) {
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
