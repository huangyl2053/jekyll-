/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のPropertyです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranProperty extends ReportPropertyBase<
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200064.getReportId());
    }

}
