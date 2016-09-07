/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link YokaigoNinteiShinseishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoProperty extends ReportPropertyBase<YokaigoNinteiShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiShinseishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD501001.getReportId());
    }

}
