/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 再審査決定通知書情報取込一覧表（保険者分）のプロパティです。
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInProperty
        extends ReportPropertyBase<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiHokenshaInProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200048.getReportId());
    }
}
