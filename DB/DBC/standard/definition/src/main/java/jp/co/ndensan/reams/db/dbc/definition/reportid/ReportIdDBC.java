/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBC-9999-021 zhangzhiming
 */
public enum ReportIdDBC {

    /**
     * 再審査決定通知書情報取込一覧表【保険者分】
     */
    DBC200048(new ReportId("DBC200048_SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBun"), new RString("再審査決定通知書情報取込一覧表【保険者分】")),
    /**
     * 高額介護サービス費給付対象者取込み
     */
    DBC200014(new ReportId("DBC200014_KogakuKyufuTaishoshaIchiran"), new RString("高額介護サービス費給付対象者取込み")),
    /**
     * 高額サービス費決定情報取込みの帳票ＩＤです。
     */
    DBC200015(new ReportId("DBC200015_KogakuShikyuFushikyuKetteishaIchiran"), new RString("高額サービス費決定情報取込み")),
    /**
     * 過誤決定通知書情報取込一覧表【公費負担者分】の帳票ＩＤです。
     */
    DBC200051(new ReportId("DBC200051_KagoKetteitsuchishoTorikomiIchiranKohifutanshaBun"), new RString("過誤決定通知書情報取込一覧表【公費負担者分】")),
    /**
     * 住宅改修事前申請承認結果通知書の帳票ＩＤです。
     */
    DBC100001(new ReportId("DBC100001_JutakukaishuJizenShinseiShoninKekkaTsuchisho"), new RString("住宅改修事前申請承認結果通知書")),
    /**
     * 償還払い支給（不支給）決定通知書の帳票ＩＤです。
     */
    DBC100002(new ReportId("DBC100002_ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashi"), new RString("償還払い支給（不支給）決定通知書")),
    /**
     * 償還払い支給（不支給）決定通知書の帳票ＩＤです。
     */
    DBC100002_2(new ReportId("DBC100002_ShokanKetteiTsuchiSho"), new RString("償還払い支給（不支給）決定通知書")),
    /**
     * 償還払い支給（不支給）決定通知書(支払予定日あり）の帳票ＩＤです。
     */
    DBC100003(new ReportId("DBC100003_ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAri"), new RString("償還払い支給（不支給）決定通知書(支払予定日あり）")),
    /**
     * 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）の帳票ＩＤです。
     */
    DBC100005(new ReportId("DBC100005_ShokanKetteiTsuchiShoHihokenshabun"), new RString("償還払支給（不支給）決定通知書（受領委任払い・被保険者用）")),
    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）の帳票ＩＤです。
     */
    DBC100004(
            new ReportId("DBC100004_ShokanKetteiTsuchiShoSealer"), new RString("償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）")),
    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）の帳票ＩＤです。
     */
    DBC100006(
            new ReportId("DBC100006_ShokanKetteiTsuchiShoSealer2"), new RString("償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）")),
    /**
     * 償還払不支給決定者一覧情報 の帳票ＩＤです。
     */
    DBC200022(
            new ReportId("DBC200022_ShokanbaraiFushikyuKetteishaIchiran"), new RString("償還払不支給決定者一覧情報")),
    /**
     * 償還払支給（不支給）決定通知一覧表の帳票ＩＤです。
     */
    DBC200023(
            new ReportId("DBC200023_ShokanbaraiShikyuFushikyuKetteiTsuchiIchiran"), new RString("償還払支給（不支給）決定通知一覧表")),
    /**
     * 償還払支給（不支給）決定通知一覧表の帳票ＩＤです。
     */
    DBC200049(
            new ReportId("DBC200049_SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBun"), new RString("再審査決定通知書情報取込一覧表（公費負担者分）")),
    /**
     * 過誤決定通知書情報取込一覧表（保険者分）の帳票ＩＤです。
     */
    DBC200050(new ReportId("DBC200050_KagoKetteitsuchishoTorikomiIchiranHokenshaBun"), new RString("過誤決定通知書情報取込一覧表（保険者分）")),
    /**
     * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書の帳票ＩＤです。
     */
    DBC800015(new ReportId("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo"),
            new RString("介護保険高額介護（予防）サービス費支給（受領委任払）申請書"));
    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBC(ReportId reportId, RString reportName) {
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
