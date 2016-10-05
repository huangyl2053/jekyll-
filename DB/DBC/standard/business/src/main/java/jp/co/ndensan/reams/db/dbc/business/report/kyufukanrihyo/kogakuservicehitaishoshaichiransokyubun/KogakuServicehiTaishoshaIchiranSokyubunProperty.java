/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.kogakuservicehitaishoshaichiransokyubun;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分） Propertyクラスです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
public class KogakuServicehiTaishoshaIchiranSokyubunProperty extends ReportPropertyBase<KogakuServicehiTaishoshaIchiranSokyubunReportSource> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuServicehiTaishoshaIchiranSokyubunProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200100.getReportId());
    }

}
