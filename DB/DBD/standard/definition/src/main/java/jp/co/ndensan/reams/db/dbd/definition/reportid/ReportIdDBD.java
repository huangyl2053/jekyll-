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
     * 社会福祉法人等利用者負担軽減対象確認申請書の帳票ＩＤです。
     */
    DBD800006(new ReportId("DBD800006_ShafukuRiyoshaFutangakuKeigentaishoShinseisho"), new RString("社会福祉法人等利用者負担軽減対象確認申請書")),
    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書の帳票ＩＤです。
     */
    DBD800007(new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho"), new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")),
    /**
     * 給付減額滞納者把握リストの帳票ＩＤです。
     */
    DBD200009(new ReportId("DBD200009_KyufuGengakuKanriIchiran"), new RString("給付減額滞納者把握リスト")),
    /**
     * 支払方法変更管理リストの帳票ＩＤです。
     */
    DBD200007(new ReportId("DBD200007_ShiharaiHohoHenkoKanriIchiran"), new RString("支払方法変更管理リスト")),
    /**
     * 支払方法変更予告通知書の帳票ＩＤです。
     */
    DBD100001(new ReportId("DBD100001_ShiharaiHohoHenkoYokokuTsuchisho"), new RString("支払方法変更予告通知書")),
    /**
     * 支払方法変更通知書の帳票ＩＤです。
     */
    DBD100002(new ReportId("DBD100002_ShiharaiHohoHenkoTsuchisho"), new RString("支払方法変更通知書")),
    /**
     * 支払一時差止通知書の帳票ＩＤです。
     */
    DBD100003(new ReportId("DBD100003_ShiharaiIchijiSashitomeTsuchisho"), new RString("支払一時差止通知書")),
    /**
     * 滞納保険料控除通知書の帳票ＩＤです。
     */
    DBD100004(new ReportId("DBD100004_TainoHokenryoKojoTsuchisho"), new RString("滞納保険料控除通知書")),
    /**
     * 給付額減額通知書の帳票ＩＤです。
     */
    DBD100005(new ReportId("DBD100005_KyufugakuGengakuTsuchisho"), new RString("給付額減額通知書")),
    /**
     * 差止予告通知書_２号用の帳票ＩＤです。
     */
    DBD100006(new ReportId("DBD100006_SashitomeYokokuTsuchishoNigo"), new RString("差止予告通知書_２号用")),
    /**
     * 差止処分通知書_２号用の帳票ＩＤです。
     */
    DBD100007(new ReportId("DBD100007_SashitomeShobunTsuchishoNigo"), new RString("差止処分通知書_２号用")),
    /**
     * 利用者負担額減額_免除決定通知書の帳票ＩＤです。
     */
    DBD100009(new ReportId("DBD100009_RiyoshaFutangakuGengakuMenjoKetteiTsuchisho"), new RString("利用者負担額減額_免除決定通知書")),
    /**
     * 訪問介護等利用者負担額減額決定通知書の帳票ＩＤです。
     */
    DBD100011(new ReportId("DBD100011_HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchisho"), new RString("訪問介護等利用者負担額減額決定通知書")),
    /**
     * 社会福祉法人等利用者負担軽減決定通知書の帳票ＩＤです。
     */
    DBD100012(new ReportId("DBD100012_ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchisho"), new RString("社会福祉法人等利用者負担軽減決定通知書")),
    /**
     * 負担限度額決定通知書の帳票ＩＤです。
     */
    DBD100013(new ReportId("DBD100013_FutanGendogakuKetteiTsuchisho"), new RString("負担限度額決定通知書")),
    /**
     * 特別地域加算減免・訪問介護利用者負担減額決定通知書の帳票ＩＤです。
     */
    DBD100014(new ReportId("DBD100014_HomonKaigoRiyoshaFutanGeｍmenKetteiTsuchisho"), new RString("特別地域加算減免・訪問介護利用者負担減額決定通知書")),
    /**
     * 利用者負担額減額_免除等認定証の帳票ＩＤです。
     */
    DBD100015(new ReportId("DBD100015_RiyoshaFutangakuGengakuMenjoNinteisho"), new RString("利用者負担額減額_免除等認定証")),
    /**
     * 利用者負担額減額_免除等認定証（旧措置者用）の帳票ＩＤです。
     */
    DBD100016(new ReportId("DBD100015_RiyoshaFutangakuGengakuMenjoNinteisho"), new RString("利用者負担額減額_免除等認定証（旧措置者用）")),
    /**
     * 訪問介護利用者負担額減額認定証の帳票ＩＤです。
     */
    DBD100017(new ReportId("DBD100017_HomonKaigoRiyoshaFutangakuGengakuNinteisho"), new RString("訪問介護利用者負担額減額認定証")),
    /**
     * 社会福祉法人等利用者負担軽減対象確認証の帳票ＩＤです。
     */
    DBD100018(new ReportId("DBD100018_ShafukuRiyoshaFutanKeigenTaishoKakuninsho"), new RString("社会福祉法人等利用者負担軽減対象確認証")),
    /**
     * 社会福祉法人等利用者負担軽減対象確認証の帳票ＩＤです。
     */
    DBD100019(new ReportId("DBD100019_ShafukuRiyoshaFutanKeigenTaishoKakuninshoShoNoAri"), new RString("社会福祉法人等利用者負担軽減対象確認証")),
    /**
     * 負担限度額認定証の帳票ＩＤです。
     */
    DBD100020(new ReportId("DBD100020_FutanGendogakuNinteisho"), new RString("負担限度額認定証")),
    /**
     * 特別地域加算に係る訪問介護利用者負担減額確認証の帳票ＩＤです。
     */
    DBD100022(new ReportId("DBD100022_TokubetsuChiikiKasanRiyoshaFutanGengakuKakuninsho"), new RString("特別地域加算に係る訪問介護利用者負担減額確認証")),
    /**
     * 要介護認定結果通知書の帳票ＩＤです。
     */
    DBD532001(new ReportId("DBD532001_YokaigoNinteiKekkaTshuchisho"), new RString("要介護認定結果通知書")),
    /**
     * サービス変更通知書の帳票ＩＤです。
     */
    DBD550002(new ReportId("DBD550002_ServiceHenkoTshuchisho"), new RString("サービス変更通知書")),
    /**
     * 要介護認定実施状況表（統計表）の帳票ＩＤです。
     */
    DBD300003(new ReportId("DBD300003_YokaigoNinteiJisshiJokyohyo"), new RString("要介護認定実施状況表（統計表）")),
    /**
     * 要介護認定月別受給者数状況表（統計表）の帳票ＩＤです。
     */
    DBD300004(new ReportId("DBD300004_YokaigoNinteiTsukibetsuJukyushaSuJokyohyo"), new RString("要介護認定月別受給者数状況表（統計表）")),
    /**
     * 要介護度変更通知書の帳票ＩＤです。
     */
    DBD550003(new ReportId("DBD550003_YokaigodoHenkoTshuchisho"), new RString("要介護度変更通知書")),
    /**
     * 要介護認定却下通知書の帳票ＩＤです。
     */
    DBD550001(new ReportId("DBD550001_YokaigoNinteiKyakkaTshuchisho"), new RString("要介護認定却下通知書")),
    /**
     * 要介護認定申請書の帳票ＩＤです。
     */
    DBD501001(new ReportId("DBD501001_YokaigoNinteiShinseisho"), new RString("要介護認定申請書")),
    /**
     * 要介護認定区分変更申請書の帳票ＩＤです。
     */
    DBD501002(new ReportId("DBD501002_yokaigoNinteikbnHenkoShinseisho"), new RString("要介護認定区分変更申請書")),
    /**
     * 障がい者控除対象者認定書の帳票ＩＤです。
     */
    DBD100025(new ReportId("DBD100025_ShogaishaKojoNinteisho"), new RString("障害者控除認定書")),
    /**
     * 負担額認定証・決定通知書発行一覧表の帳票ＩＤです。
     */
    DBD200019(new ReportId("DBD200019_FutangakuNinteiHakkoIchiran"), new RString("負担額認定証・決定通知書発行一覧表")),
    /**
     * 社会福祉法人軽減確認証・決定通知書発行一覧表の帳票ＩＤです。
     */
    DBD200018(new ReportId("DBD200018_ShakaiFukushiHojinKeigenHakkoIchiran"), new RString("社会福祉法人軽減確認証・決定通知書発行一覧表")),
    /**
     * 要介護認定通知書一括発行の帳票ＩＤです。
     */
    DBD532999(new ReportId("DBD532999_YokaigoTshuchishoIkkatsu"), new RString("要介護認定通知書一括発行"));

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
