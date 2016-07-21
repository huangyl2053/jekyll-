/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteierrorichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN41002_高額介護サービス費判定エラーリスト Property
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuServicehiHanteiErrorIchiranProperty
        extends ReportPropertyBase<KogakuServicehiHanteiErrorIchiranSource> {

    /**
     * インスタンスを生成します。
     */
    public KogakuServicehiHanteiErrorIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200018.getReportId());
    }
}
