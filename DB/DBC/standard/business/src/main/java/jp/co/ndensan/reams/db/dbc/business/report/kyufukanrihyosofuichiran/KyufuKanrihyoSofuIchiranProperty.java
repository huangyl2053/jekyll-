/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表 Propertyクラスです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
public class KyufuKanrihyoSofuIchiranProperty extends ReportPropertyBase<KyufuKanrihyoSofuIchiranReportSource> {

    /**
     * コンストラクタです。
     *
     */
    public KyufuKanrihyoSofuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200009.getReportId());
    }

}
