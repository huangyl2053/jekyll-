/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護給付費等請求額通知書情一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoInProperty extends ReportPropertyBase<SeikyugakuTsuchishoSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SeikyugakuTsuchishoInProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC120230.getReportId());
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.hokenshaNo.name()));
        pageBreakKeys.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.kanName.name()));
        pageBreakKeys.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.kouName.name()));
    }

}
