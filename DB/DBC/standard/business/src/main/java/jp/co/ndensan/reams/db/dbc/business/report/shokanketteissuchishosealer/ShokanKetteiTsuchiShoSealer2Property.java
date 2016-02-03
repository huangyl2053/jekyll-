/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のプロパティです。
 *
 */
public class ShokanKetteiTsuchiShoSealer2Property
        extends ReportPropertyBase<ShokanKetteiTsuchiShoSealer2ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShokanKetteiTsuchiShoSealer2Property() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100006.getReportId());
    }
}
