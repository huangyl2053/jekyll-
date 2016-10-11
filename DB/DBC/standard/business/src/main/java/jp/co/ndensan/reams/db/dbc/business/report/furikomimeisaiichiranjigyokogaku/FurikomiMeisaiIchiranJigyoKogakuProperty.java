/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 振込明細一覧表（事業高額）Propertyクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiMeisaiIchiranJigyoKogakuProperty extends ReportPropertyBase<FurikomiMeisaiIchiranJigyoKogakuSource> {

    /**
     * コンストラクタです。
     *
     */
    public FurikomiMeisaiIchiranJigyoKogakuProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200102.getReportId());
    }

}
