/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100107;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource}のプロパティです。
 *
 * @reamsid_L DBC-5160-050 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty extends
        ReportPropertyBase<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> {

    /**
     * コンストラクタです。
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100107.getReportId());
    }

}
