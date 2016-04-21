/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ReportIdDBD {

    /**
     * 負担限度額認定更新のお知らせ通知書の帳票ID。
     */
    DBDPR12002_1_1(new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchisho"), new RString("負担限度額認定更新のお知らせ通知書")),
    /**
     * 負担限度額認定更新のお知らせ通知書旧措置の帳票ID。
     */
    DBDPR12002_1_2(new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchishoKyusochi"), new RString("負担限度額認定更新のお知らせ通知書旧措置"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBD(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    /**
     * 帳票ＩＤの取得します。
     *
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     *
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }

}
