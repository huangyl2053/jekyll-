/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.reportid;

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
    DBDPR12002_1_2(new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchishoKyusochi"), new RString("負担限度額認定更新のお知らせ通知書旧措置")),
    /**
     * 負担限度額認定更新のお知らせ通知書旧措置の帳票ID。
     */
    DBD800001(new ReportId("DBD800001_FutangendogakuNinteiShinseisho"), new RString("負担限度額認定更新のお知らせ通知書旧措置")),
    /**
     * 介護保険利用者負担額減額・免除申請書の帳票ＩＤです。
     */
    DBD800002(new ReportId("DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho"), new RString("介護保険利用者負担額減額・免除申請書")),
    /**
     * 汎用リスト 受給者台帳２の帳票ＩＤです。
     */
    DBD130001(new ReportId("DBD130001_HanyoList_JukyushaDaicho2"), new RString("汎用リスト 受給者台帳２")),
    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書の帳票ＩＤです。
     */
    DBD800007(new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho"), new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")),
    /**
     * 給付減額滞納者把握リストの帳票ＩＤです。
     */
    DBD800006(new ReportId("DBD800006_ShafukuRiyoshaFutangakuKeigentaishoShinseisho"), new RString("社会福祉法人等利用者負担軽減対象確認申請書")),
    /**
     * 給付減額滞納者把握リストの帳票ＩＤです。
     */
    DBD200009(new ReportId("DBD200009_KyufuGengakuKanriIchiran"), new RString("給付減額滞納者把握リスト"));
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
