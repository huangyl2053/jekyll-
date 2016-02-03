/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 住宅改修事前申請承認結果通知書のプロパティです。
 */
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty
        extends ReportPropertyBase<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100001.getReportId());
    }
}
