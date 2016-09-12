/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自己負担証明書のEditorです。
 *
 * @reamsid_L DBC-4810-030 sunhaidi
 */
public class CompKaigoToiawasesakiEditor implements IJikoFutangakushomeishoEditor {

    private final ToiawasesakiSource toiawasesakiSource;
    private final RString 問合せ先タイトル = new RString("（問い合せ先）");
    private final RString 内線タイトル = new RString("内線");

    /**
     * インスタンスを生成します。
     *
     * @param toiawasesakiSource ToiawasesakiSource
     */
    protected CompKaigoToiawasesakiEditor(ToiawasesakiSource toiawasesakiSource) {
        this.toiawasesakiSource = toiawasesakiSource;
    }

    @Override
    public JikoFutangakushomeishoReportSource edit(JikoFutangakushomeishoReportSource source) {
        source.toiawasesakiTitle = 問合せ先タイトル;
        source.choshaBushoName = toiawasesakiSource.choshaBushoName;
        source.naisenLabel = 内線タイトル;
        source.naisenNo = toiawasesakiSource.naisenNo;
        source.shozaichi = toiawasesakiSource.shozaichi;
        source.tantoName = toiawasesakiSource.tantoName;
        source.telNo = toiawasesakiSource.telNo;
        source.yubinBango = toiawasesakiSource.yubinBango;
        return source;
    }
}
