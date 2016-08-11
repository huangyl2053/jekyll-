/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費（経過措置）請求額通知書情報取込一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC_2480_DBCMNF2002-151 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiProperty extends ReportPropertyBase<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200068.getReportId());

        pageBreakKeys = new ArrayList<>();

        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.shoKisaiHokenshaNo.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.kanName.name()));
        pageBreakKeys.add(
                new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.kouName.name()));
    }
}
