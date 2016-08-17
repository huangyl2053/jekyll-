/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）Propertyクラスです。
 *
 * @reamsid_L DBC-2790-030 lijian
 */
public class SeikyugakuTsuchishoKohifutanshabunProperty extends
        ReportPropertyBase<SeikyugakuTsuchishoKohifutanshabunSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SeikyugakuTsuchishoKohifutanshabunProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200067.getReportId());

        pageBreakKeys = new ArrayList<>();

        pageBreakKeys.add(
                new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kohiFutanshaNo.name()));

        pageBreakKeys.add(
                new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kanCode.name()));

        pageBreakKeys.add(
                new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kouCode.name()));

    }

}
