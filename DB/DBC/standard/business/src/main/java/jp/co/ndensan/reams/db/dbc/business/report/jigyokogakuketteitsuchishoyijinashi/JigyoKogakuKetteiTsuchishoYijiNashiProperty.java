/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijinashi;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN43002_事業高額決定通知書 Propertyするクラスです。
 *
 * @reamsid_L DBC-2000-100 lijian
 */
public class JigyoKogakuKetteiTsuchishoYijiNashiProperty extends ReportPropertyBase<JigyoKogakuKetteiTsuchishoYijiNashiSource> {

    /**
     * コンストラクタです。
     *
     */
    public JigyoKogakuKetteiTsuchishoYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100061.getReportId());
    }

}
