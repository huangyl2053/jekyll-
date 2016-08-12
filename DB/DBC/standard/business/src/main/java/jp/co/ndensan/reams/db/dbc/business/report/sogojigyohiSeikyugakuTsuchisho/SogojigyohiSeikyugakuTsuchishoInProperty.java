/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120890.SogojigyohiSeikyugakuTsuchishoInSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費等請求額通知書帳票のプロパティです。
 *
 * @reamsid_L DBC-2480-032 sunqingzhu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSeikyugakuTsuchishoInProperty extends ReportPropertyBase<SogojigyohiSeikyugakuTsuchishoInSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiSeikyugakuTsuchishoInProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200087.getReportId());

        pageBreakKeys = new ArrayList<>();

        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoInSource.ReportSourceFields.shoKisaiHokenshaNo.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoInSource.ReportSourceFields.kanName.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoInSource.ReportSourceFields.kouName.name()));
    }

}
