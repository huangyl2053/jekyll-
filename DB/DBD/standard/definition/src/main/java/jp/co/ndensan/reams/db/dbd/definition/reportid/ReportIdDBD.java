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
     * 負担限度額認定更新のお知らせ通知書旧措置の帳票ID。
     */
    DBD200008(new ReportId("DBD200008_KyufuGengakuHaakuIchiran"), new RString("給付額減額滞納者把握情報取得")),
    /**
     * 負担限度額認定更新のお知らせ通知書の帳票ID。
     */
    DBD511001(new ReportId("DBD511001_KoshinShinseiOshiraseTshuchisho"), new RString("認定更新お知らせ通知書")),
    /**
     * 負担限度額認定更新のお知らせ通知書旧措置の帳票ID。
     */
    DBD511002(new ReportId("DBD511002_KoshinShinseiTsuchishoHakkoIchiranhyo"), new RString("更新申請のお知らせ通知書発行一覧表")),
    /**
     * 汎用リスト 受給者台帳２の帳票ＩＤです。
     */
    DBD130001(new ReportId("DBD701002_HanyoListJukyushaDaicho2"), new RString("汎用リスト 受給者台帳２")),
    /**
     * 社会福祉法人等利用者負担軽減対象確認申請書の帳票ＩＤです。
     */
    DBD800006(new ReportId("DBD800006_ShafukuRiyoshaFutangakuKeigentaishoShinseisho"), new RString("社会福祉法人等利用者負担軽減対象確認申請書")),
    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書の帳票ＩＤです。
     */
    DBD800007(new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho"), new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")),
    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）の帳票ＩＤです。
     */
    DBD800004(new ReportId("DBD800004_TokuteiFutangendogakuShinseisho"), new RString("介護保険特定負担限度額申請書")),
    /**
     * 訪問介護利用者負担額減額申請書の帳票ＩＤです。
     */
    DBD800005(new ReportId("DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho"), new RString("訪問介護利用者負担額減額申請書")),
    /**
     * 給付減額滞納者把握リストの帳票ＩＤです。
     */
    DBD200009(new ReportId("DBD200009_KyufuGengakuKanriIchiran"), new RString("給付減額滞納者把握リスト")),
    /**
     * 利用者負担額減免認定者リストの帳票ＩＤです。
     */
    DBD200002(new ReportId("DBD200002_RiyoshaFutangakuGemmenGaitoshaIchiran"), new RString("利用者負担額減免認定者リスト")),
    /**
     * 支払方法変更管理リストの帳票ＩＤです。
     */
    DBD200006(new ReportId("DBD200006_ShiharaiHohoHenkoHaakuIchiran"), new RString("支払方法変更把握リスト")),
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
     * 負担限度額認定更新のお知らせ通知書（旧措置者用）の帳票ＩＤです。
     */
    DBD100027(new ReportId("DBD100027_FutanGendogakuNinteiKoshinTsuchishoKyusochi"), new RString("負担限度額認定更新のお知らせ通知書（旧措置者用）")),
    /**
     * おむつ証明書の帳票ＩＤです。
     */
    DBD100029(new ReportId("DBD100029_OmutsuShoumeisho"), new RString("おむつ証明書")),
    /**
     * 主治医意見書確認書の帳票ＩＤです。
     */
    DBD100030(new ReportId("DBD100030_ShujiiIkenshoKakuninsho"), new RString(" 主治医意見書確認書")),
    /**
     * 要介護認定結果通知書の帳票ＩＤです。
     */
    DBD532001(new ReportId("DBD532001_YokaigoNinteiKekkaTshuchisho"), new RString("要介護認定結果通知書")),
    /**
     * サービス変更通知書の帳票ＩＤです。
     */
    DBD550002(new ReportId("DBD550002_ServiceHenkoTshuchisho"), new RString("サービス変更通知書")),
    /**
     * 受給者減免月別申請・認定状況表の帳票ＩＤです。
     */
    DBD300001(new ReportId("DBD300001_JukyushaGemmenTsukibetsuShinseiNinteiJokyohyo"), new RString("受給者減免月別申請・認定状況表")),
    /**
     * 受給者減免月別認定者数状況表の帳票ＩＤです。
     */
    DBD300002(new ReportId("DBD300002_JukyushaGemmenTsukibetsuNinteishaJokyohyo"), new RString("受給者減免月別認定者数状況表")),
    /**
     * 要介護認定実施状況表（統計表）の帳票ＩＤです。
     */
    DBD300003(new ReportId("DBD300003_YokaigoNinteiJisshiJokyohyo"), new RString("要介護認定実施状況表（統計表）")),
    /**
     * 要介護認定月別受給者数状況表（統計表）の帳票ＩＤです。
     */
    DBD300004(new ReportId("DBD300004_YokaigoNinteiTsukibetsuJukyushaSuJokyohyo"), new RString("要介護認定月別受給者数状況表（統計表）")),
    /**
     * 年齢階級別要介護度状況の帳票ＩＤです。
     */
    DBD300005(new ReportId("DBD300005_NenreiKaikyubetsuYokaigodoJokyo"), new RString("年齢階級別要介護度状況")),
    /**
     * 要介護度変更通知書の帳票ＩＤです。
     */
    DBD550003(new ReportId("DBD550003_YokaigodoHenkoTshuchisho"), new RString("要介護度変更通知書")),
    /**
     * 要介護認定取消通知書の帳票ＩＤです。
     */
    DBD550004(new ReportId("DBD550004_YokaigoNinteiTorikeshiTshuchisho"), new RString("要介護認定取消通知書")),
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
     * 社会福祉法人軽減認定者リストの帳票ＩＤです。
     */
    DBD200004(new ReportId("DBD200004_ShakaiFukushiHojinKeigenGaitoshaIchiran"), new RString("社会福祉法人軽減認定者リスト")),
    /**
     * 負担限度額認定（一括）確認リストの帳票ＩＤです。
     */
    DBD200005(new ReportId("DBD200005_FutanGendogakuNinteiKakuninIchiran"), new RString("負担限度額認定（一括）確認リスト")),
    /**
     * 社会福祉法人軽減確認証・決定通知書発行一覧表の帳票ＩＤです。
     */
    DBD200018(new ReportId("DBD200018_ShakaiFukushiHojinKeigenHakkoIchiran"), new RString("社会福祉法人軽減確認証・決定通知書発行一覧表")),
    /**
     * 介護認定審査判定依頼一覧表の帳票ＩＤです。
     */
    DBD503001(new ReportId("DBD503001_ShinsaHanteiIraiIchiranhyo"), new RString("介護認定審査判定依頼一覧表")),
    /**
     * 給付制限対象者一覧CSVの帳票ＩＤです。
     */
    DBD200010(new ReportId("DBD200010_KyufuSeigenTaishoIchiran"), new RString("給付制限対象者一覧CSV")),
    /**
     * 特別地域加算軽減実績管理リストの帳票ＩＤです。
     */
    DBD200012(new ReportId("DBD200012_TokubetsuChiikiKasanKeigenJissekiKanriIchiran"), new RString("特別地域加算軽減実績管理リスト")),
    /**
     * 利用者負担額減免認定者リストの帳票ＩＤです。
     */
    DBD200013(new ReportId("DBD200013_RiyoshaFutangakuGemmenNinteishaIchiran"), new RString("利用者負担額減免認定者リスト")),
    /**
     * 訪問介護利用者負担額減額認定者リストの帳票ＩＤです。
     */
    DBD200014(new ReportId("DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran"), new RString("訪問介護利用者負担額減額認定者リスト")),
    /**
     * 訪問介護利用者負担額減額該当者リストの帳票ＩＤです。
     */
    DBD200003(new ReportId("DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran"), new RString("訪問介護利用者負担額減額該当者リスト")),
    /**
     * 負担限度額認定者リストの帳票ＩＤです。
     */
    DBD200001(new ReportId("DBD200001_FutanGendogakuNinteiGaitoshaIchiran"), new RString("負担限度額認定者リスト")),
    /**
     * 負担限度額認定者リストの帳票ＩＤです。
     */
    DBD200016(new ReportId("DBD200016_FutanGendogakuNinteishaIchiran"), new RString("負担限度額認定者リスト")),
    /**
     * 事業所向け社会福祉法人軽減対象者一覧表の帳票ＩＤです。
     */
    DBD200017(new ReportId("DBD200017_JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiran"), new RString("事業所向け社会福祉法人軽減対象者一覧表")),
    /**
     * 要介護認定通知書一括発行の帳票ＩＤです。
     */
    DBD532999(new ReportId("DBD532999_YokaigoTshuchishoIkkatsu"), new RString("要介護認定通知書一括発行")),
    /**
     * 要介護認定延期通知書タイトルの帳票ＩＤです。
     */
    DBD522001(new ReportId("DBD522001_YokaigoNinteiEnkiTshuchisho"), new RString("要介護認定延期通知書タイトル")),
    /**
     * 負担限度額認定申請書発行一覧表の帳票ＩＤです。
     */
    DBD200022(new ReportId("DBD200022_FutanGendogakuNinteiShinseishoHakkoIchiran"), new RString("負担限度額認定申請書発行一覧表")),
    /**
     * 要介護認定延期通知書発行一覧表の帳票ＩＤです。
     */
    DBD200037(new ReportId("DBD200037_JukyushaIdoCheckList"), new RString("受給者異動チェックリスト")),
    /**
     * 受給者台帳の帳票ＩＤです。
     */
    DBD100026(new ReportId("DBD100026_JukyushaDaicho"), new RString("受給者台帳")),
    /**
     * 要介護認定延期通知書発行一覧表の帳票ＩＤです。
     */
    DBD522002(new ReportId("DBD522002_NinteiEnkiTsuchishoHakkoIchiranhyo"), new RString("要介護認定延期通知書発行一覧表")),
    /**
     * 非課税年金対象者情報一覧表の帳票ＩＤです。
     */
    DBD900001(new ReportId("DBD900001_HikazeiNenkinTaishoshaJohoIchiran"), new RString("非課税年金対象者情報一覧表")),
    /**
     * 非課税年金対象者情報該当一覧表の帳票ＩＤです。
     */
    DBD900002(new ReportId("DBD900002_HikazeiNenkinGaitoIchiran"), new RString("非課税年金対象者情報該当一覧表")),
    /**
     * 非課税年金対象者情報不一致チェックリストの帳票ＩＤです。
     */
    DBD900003(new ReportId("DBD900003_HikazeiNenkinFuicchiCheckList"), new RString("非課税年金対象者情報不一致チェックリスト")),
    /**
     * 非課税年金対象者情報生年月日・性別・カナ氏名チェックリストの帳票ＩＤです。
     */
    DBD900004(new ReportId("DBD900004_HikazeiNenkinUmareYMDSeibetsuNameCheckList"),
            new RString("非課税年金対象者情報生年月日・性別・カナ氏名チェックリスト")),
    /**
     * 非課税年金年金番号チェックリストの帳票ＩＤです。
     */
    DBD900005(new ReportId("DBD900005_HikazeiNenkinNenkinNoCheckList"), new RString("非課税年金年金番号チェックリスト")),
    /**
     * 非課税年金対象者情報遡及該当者一覧表の帳票ＩＤです。
     */
    DBD900006(new ReportId("DBD900006_HikazeiNenkinSokyuGaitoIchiran"), new RString("非課税年金対象者情報遡及該当者一覧表")),
    /**
     * 非課税年金対象者情報遡及不一致チェックリストの帳票ＩＤです。
     */
    DBD900007(new ReportId("DBD900007_HikazeiNenkinSokyuFuicchiCheckList"), new RString("非課税年金対象者情報遡及不一致チェックリスト")),
    /**
     * 汎用リスト出力(特別地域加算減免)の帳票ＩＤです。
     */
    DBD701007(new ReportId("DBD701007_HanyoListTokubetsuChiikiKasanGemmen"), new RString("汎用リスト　特別地域加算減免")),
    /**
     * 汎用リスト出力(非課税年金対象者)の帳票ＩＤです。
     */
    DBD701008(new ReportId("DBD701008_HanyoListHikazeiNenkinTaishosha"), new RString("汎用リスト　非課税年金対象者"));

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
