/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.heikinriyogakutokeihyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 平均利用額統計表のPropertyです。
 *
 * @reamsid_L DBC-3490-040 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoProperty extends ReportPropertyBase<HeikinRiyoGakuTokeihyoReportSource> {

    /**
     * コンストラクタです。
     */
    public HeikinRiyoGakuTokeihyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC300004.getReportId());
    }
}
