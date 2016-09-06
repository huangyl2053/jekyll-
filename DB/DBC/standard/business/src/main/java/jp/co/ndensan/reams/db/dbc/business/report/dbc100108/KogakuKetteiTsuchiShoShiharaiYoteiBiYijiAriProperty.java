/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100108;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource}のプロパティです。
 *
 * @reamsid_L DBC-5160-040 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty extends
        ReportPropertyBase<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource> {

    /**
     * コンストラクタです。
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100108.getReportId());
    }

}
