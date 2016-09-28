/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費（経過措置）資格照合表Propertyクラスです。
 *
 * @reamsid_L DBC-2890-031 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShikakuShogohyoKeikaSochiProperty
        extends ReportPropertyBase<SogojigyohiShikakuShogohyoKeikaSochiSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiShikakuShogohyoKeikaSochiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100018.getReportId());
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(SogojigyohiShikakuShogohyoKeikaSochiSource.ReportSourceFields.hokenshaNo.name()));

    }
}
