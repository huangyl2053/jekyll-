/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定結果通知一覧表のプロパティです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
public class KekkatsuchiIchiranhyoProperty extends ReportPropertyBase<KekkatsuchiIchiranhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KekkatsuchiIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE525004.getReportId());
    }

}
