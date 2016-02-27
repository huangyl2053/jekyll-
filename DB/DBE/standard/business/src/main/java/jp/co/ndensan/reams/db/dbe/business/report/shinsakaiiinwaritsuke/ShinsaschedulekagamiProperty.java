/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.ItakusakiChosainIchiranReportId;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査会スケジュール表かがみのプロパティです。
 */
public class ShinsaschedulekagamiProperty extends ReportPropertyBase<ShinsaschedulekagamiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsaschedulekagamiProperty() {
        super(SubGyomuCode.DBE認定支援, new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE514002.getCode()));
    }
}
