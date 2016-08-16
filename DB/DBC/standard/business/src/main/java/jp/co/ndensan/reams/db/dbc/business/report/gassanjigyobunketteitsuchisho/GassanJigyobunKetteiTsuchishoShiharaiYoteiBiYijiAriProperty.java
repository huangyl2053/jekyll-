/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * （高額合算支給（不支給）決定通知書）支払予定日あり Property
 *
 * @reamsid_L DBC-4850-030 chenyadong
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriProperty extends
        ReportPropertyBase<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource> {

    /**
     * コンストラクタです。
     */
    public GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200202.getReportId());
    }
}
