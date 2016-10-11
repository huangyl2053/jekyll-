/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200003_振込明細一覧表（高額合算） Propertyクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranProperty extends ReportPropertyBase<FurikomiMeisaiIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public FurikomiMeisaiIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200003.getReportId());
    }

}
