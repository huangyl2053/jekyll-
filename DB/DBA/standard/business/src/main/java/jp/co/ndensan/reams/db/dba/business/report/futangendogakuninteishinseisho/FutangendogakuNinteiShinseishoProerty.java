/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.futangendogakuninteishinseisho.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link FutangendogakuNinteiShinseishoReportSource}のプロパティです。
 */
public class FutangendogakuNinteiShinseishoProerty extends ReportPropertyBase<FutangendogakuNinteiShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public FutangendogakuNinteiShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800001.getReportId());
    }
}
