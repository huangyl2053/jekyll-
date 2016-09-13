/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehisofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200019_高額介護サービス費給付判定結果送付一覧表 のPropertyクラスです。
 *
 * @reamsid_L DBC-2610-040 qinzhen
 */
public class KogakuServicehiSofuIchiranProperty extends
        ReportPropertyBase<KogakuServicehiSofuIchiranSource> {

    /**
     * コンストラクタです。
     */
    public KogakuServicehiSofuIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200019.getReportId());
    }
}
