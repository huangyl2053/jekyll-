/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufugengakumenjyoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyufugengakumenjyoshinseisho.KyufugengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付額減額免除申請書のプロパティです。
 */
public class KyufugengakuMenjyoShinseishoProerty extends ReportPropertyBase<KyufugengakuMenjyoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufugengakuMenjyoShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800008.getReportId());
    }
}
