/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource.ReportSourceFields;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 総合事業費資格照合表のプロパティです。
 *
 * @reamsid_L DBC-2890-032 wangxue
 */
public class SogojigyohiShikakuShogohyoProperty
        extends ReportPropertyBase<SogojigyohiShikakuShogohyoInSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     */
    public SogojigyohiShikakuShogohyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100099.getReportId());
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.hokenshaNo.name()));
    }

}
