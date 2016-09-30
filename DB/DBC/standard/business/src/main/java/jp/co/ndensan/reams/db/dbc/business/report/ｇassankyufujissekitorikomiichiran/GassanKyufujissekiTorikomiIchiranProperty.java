/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 高額合算給付実績情報取込一覧表Propertyクラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
public class GassanKyufujissekiTorikomiIchiranProperty extends
        ReportPropertyBase<GassanKyufujissekiTorikomiIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanKyufujissekiTorikomiIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200041.getReportId());

    }

}
