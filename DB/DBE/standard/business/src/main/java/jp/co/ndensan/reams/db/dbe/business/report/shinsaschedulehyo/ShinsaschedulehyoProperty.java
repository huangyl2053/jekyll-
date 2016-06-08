package jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査会スケジュール表（年間）のプロパティです。
 *
 * @reamsid_L DBE-0130-081 duanzhanli
 */
public class ShinsaschedulehyoProperty extends ReportPropertyBase<ShinsaschedulehyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsaschedulehyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE514003.getReportId());
    }
}
