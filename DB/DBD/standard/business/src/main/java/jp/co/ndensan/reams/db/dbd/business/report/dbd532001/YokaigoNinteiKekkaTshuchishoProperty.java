/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link YokaigoNinteiKekkaTshuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public class YokaigoNinteiKekkaTshuchishoProperty extends ReportPropertyBase<YokaigoNinteiKekkaTshuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiKekkaTshuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD532001.getReportId());
    }

}
