/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.homonkaigoriyoushafutangakugengakushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.homonkaigoriyoushafutangakugengakushinseisho.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * HomonkaigoRiyoushaFutangakuGengakuShinseishoProertyのプロパティです。
 *
 */
public class HomonkaigoRiyoushaFutangakuGengakuShinseishoProerty extends ReportPropertyBase<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HomonkaigoRiyoushaFutangakuGengakuShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800005.getReportId());
    }
}
