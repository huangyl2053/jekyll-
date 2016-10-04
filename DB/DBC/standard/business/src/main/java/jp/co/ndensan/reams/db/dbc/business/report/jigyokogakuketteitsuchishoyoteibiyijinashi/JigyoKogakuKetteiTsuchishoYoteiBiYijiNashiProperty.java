/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 新総合事業・事業高額決定通知書（単）帳票Source
 *
 * @reamsid_L DBC-4760-030 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiProperty
        extends ReportPropertyBase<JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource> {

    /**
     * コンストラクタです。
     */
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100061.getReportId());
    }
}
