/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * （高額合算支給（不支給）決定通知書）支払予定日なし Property
 *
 * @reamsid_L DBC-4850-030 dongqianjing
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty extends
        ReportPropertyBase<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> {

    /**
     * コンストラクタです。
     */
    public GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200201.getReportId());
    }
}
