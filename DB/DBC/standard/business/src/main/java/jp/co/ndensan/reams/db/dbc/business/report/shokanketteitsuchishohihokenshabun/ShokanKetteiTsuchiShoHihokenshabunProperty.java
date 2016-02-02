/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のプロパティです。
 */
public class ShokanKetteiTsuchiShoHihokenshabunProperty
        extends ReportPropertyBase<ShokanKetteiTsuchiShoHihokenshabunReportSource> {

    public ShokanKetteiTsuchiShoHihokenshabunProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100005.getReportId());
    }
}
