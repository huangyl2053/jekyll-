/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費等請求額通知書（公費負担者分）Property
 *
 * @reamsid_L DBC-4700-040 zhangyaru
 */
public class SogojigyohiSeikyugakuTsuchishoKohiProperty
        extends ReportPropertyBase<SogojigyohiSeikyugakuTsuchishoKohiSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     */
    public SogojigyohiSeikyugakuTsuchishoKohiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200082.getReportId());

        pageBreakKeys = new ArrayList<>();

        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKohiSource.ReportSourceFields.kohiFutanshaNo.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKohiSource.ReportSourceFields.kanName.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKohiSource.ReportSourceFields.kouName.name()));

    }
}
