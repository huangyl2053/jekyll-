/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 償還払い支給（不支給）決定通知書(支払予定日あり）のプロパティです。
 */
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty
        extends ReportPropertyBase<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource> {

    /**
     * コンストラクタです。
     */
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100003.getReportId());
    }
}
