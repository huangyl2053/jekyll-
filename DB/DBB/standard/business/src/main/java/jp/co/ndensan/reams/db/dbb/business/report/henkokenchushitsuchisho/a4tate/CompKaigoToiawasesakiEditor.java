/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のA4縦タイプのEditorです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class CompKaigoToiawasesakiEditor implements IKaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor {

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
    public KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource edit(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource source) {
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
