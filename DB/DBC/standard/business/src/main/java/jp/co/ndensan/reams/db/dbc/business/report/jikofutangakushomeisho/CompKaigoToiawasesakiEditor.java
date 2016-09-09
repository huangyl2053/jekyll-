/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;

/**
 * 自己負担証明書のEditorです。
 *
 * @reamsid_L DBC-4810-030 sunhaidi
 */
public class CompKaigoToiawasesakiEditor implements IJikoFutangakushomeishoEditor {

    private final CompKaigoToiawasesakiSource toiawasesakiSource;

    /**
     * インスタンスを生成します。
     *
     * @param toiawasesakiSource CompKaigoToiawasesakiSource
     */
    protected CompKaigoToiawasesakiEditor(CompKaigoToiawasesakiSource toiawasesakiSource) {
        this.toiawasesakiSource = toiawasesakiSource;
    }

    @Override
    public JikoFutangakushomeishoReportSource edit(JikoFutangakushomeishoReportSource source) {
        source.choshaBushoName = toiawasesakiSource.choshaBushoName;
        source.naisenLabel = toiawasesakiSource.naisenLabel;
        source.naisenNo = toiawasesakiSource.naisenNo;
        source.shozaichi = toiawasesakiSource.shozaichi;
        source.tantoName = toiawasesakiSource.tantoName;
        source.telNo = toiawasesakiSource.telNo;
        source.yubinBango = toiawasesakiSource.yubinBango;
        return source;
    }
}
