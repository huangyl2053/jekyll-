/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource.ReportSourceFields;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費再審査決定通知書情報取込一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInProperty
        extends ReportPropertyBase<SogojigyohiSaishinsaKetteiHokenshaInSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiSaishinsaKetteiHokenshaInProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200080.getReportId());
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.kohiFutanshaNo.name()));
    }

}
