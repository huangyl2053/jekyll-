/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN63003_高額合算支給決定通知書（単） Property クラスです。
 *
 * @reamsid_L DBC-2310-035 chenyadong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty extends
        ReportPropertyBase<GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> {

    /**
     * コンストラクタです。
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100053.getReportId());
    }
}
