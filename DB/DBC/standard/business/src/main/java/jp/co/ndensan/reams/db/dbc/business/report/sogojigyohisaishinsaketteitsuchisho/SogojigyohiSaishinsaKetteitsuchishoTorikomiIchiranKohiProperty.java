/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranSource.ReportSourceFields;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（公費）帳票のプロパティです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiProperty
        extends ReportPropertyBase<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200081.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.hokenshaNo.name()));
    }

}
