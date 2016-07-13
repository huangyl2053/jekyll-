/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリスト PrintService
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranProperty
        extends ReportPropertyBase<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> {

    /**
     * インスタンスを生成します。
     */
    public KogakuSogoJigyoServicehiHanteiErrorIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200076.getReportId());
    }
}
