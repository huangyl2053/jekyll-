/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付管理票のPropertyクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceProperty extends ReportPropertyBase<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100035.getReportId());
    }
}
