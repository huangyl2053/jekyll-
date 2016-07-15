/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Property
 *
 * @reamsid_L DBC-2470-030 sunhui
 */
public class KyufujissekiKoshinkekkaIchiranProperty extends ReportPropertyBase<KyufujissekiKoshinkekkaIchiranSource> {

    /**
     * インスタンスを生成します。
     */
    public KyufujissekiKoshinkekkaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200054.getReportId());
    }
}
