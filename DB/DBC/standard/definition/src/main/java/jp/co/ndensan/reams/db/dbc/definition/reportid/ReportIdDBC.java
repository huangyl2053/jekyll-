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
     * 高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）
     */
    DBC100011_申請分(new ReportId("DBC100011_KogakuOshiraseTsuchiTeshutsuKigenAriShoShokai"),
            new RString("高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）")),
    /**
     * 高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）
     */
    DBC100011_償還分(new ReportId("DBC100011_KogakuOshiraseTsuchiShoTeshutsuKigenAriJidoShokan"),
            new RString("高額サービス給付のお知らせ通知書（自動償還分）（提出期限あり）")),
    /**
     * 高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）
     */
    DBC100011_131011_申請分(new ReportId("DBC100011_KogakuOshiraseTsuchiShoTeshutsuKigenAriShokai_131011"),
            new RString("高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）")),
    /**
     * 高額サービス給付のお知らせ通知書（初回申請分）（提出期限あり）
     */
    DBC100011_131011_償還分(new ReportId("DBC100011_KogakuOshiraseTsuchiShoTeshutsuKigenAriJidoShokan_131011"),
            new RString("高額サービス給付のお知らせ通知書（自動償還分）（提出期限あり）")),
    /**
     * 総合事業分自己負担額計算結果一覧表
     */
    DBC200203(new ReportId("DBC200203_GassanJigyobunJikofutangakuKeisanKekkaIchiran"), new RString("総合事業分自己負担額計算結果一覧表")),
    /**
     * 総合事業費過再審査定通知書情報
     */
    DBC100057(new ReportId("DBC100057_ServiceRiyohyoBeppyo"), new RString("介護保険サービス利用票（兼居宅サービス計画）・別表 ")),
    /**
     * 総合事業費過再審査定通知書情報
     */
    DBC200080(new ReportId("DBC200080_KyufujissekiKoshinkekkaIchiran"), new RString("総合事業費過再審査定通知書情報")),
    /**
     * 総合事業費過誤決定通知書情報取込一覧表
     */
    DBC200085(new ReportId("DBC200085_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran"), new RString("総合事業費過誤決定通知書情報取込一覧表")),
    /**
     * 給付実績更新結果情報一覧表
     */
    DBC200054(new ReportId("DBC200054_KyufujissekiKoshinkekkaIchiran"), new RString("給付実績更新結果情報一覧表")),
    /**
     * 負担割合証（カット紙）
     */
    DBC100065(new ReportId("DBC100065_FutanWariaiSho"), new RString("負担割合証（カット紙）")),
    /**
     * 負担割合証（連帳　縦）
     */
    DBC100066(new ReportId("DBC100066_FutanWariaiShoRenchoTate"), new RString("負担割合証（連帳　縦）")),
    /**
     * 負担割合証（連帳　横）
     */
    DBC100067(new ReportId("DBC100067_FutanWariaiShoRenchoYoko"), new RString("負担割合証（連帳　横）")),
    /**
     * 基準収入額適用決定通知書
     */
    DBC100074(
            new ReportId("DBC100074_KijunShunyugakuTekiyoKetteiTsuchisho"), new RString("基準収入額適用決定通知書")),
    /**
     * 負担割合証発行一覧表
     */
    DBC200090(new ReportId("DBC200090_FutanWariaiShoHakkoIchiran"), new RString("負担割合証発行一覧表")),
    /**
     * 高額総合事業サービス費判定エラーリスト
     */
    DBC200076(new ReportId("DBC200076_KogakuSogoJigyoServicehiHanteiErrorIchiran"), new RString("高額総合事業サービス費判定エラーリスト ")),
    /**
     * 高額介護サービス費判定エラーリスト
     */
    DBC200018(new ReportId("DBC200018_KogakuServicehiHanteiErrorIchiran"), new RString("高額介護サービス費判定エラーリスト ")),
    /**
     * 介護保険受領委任払い取扱事業者登録通知書
     */
    DBC100032(new ReportId("DBC100032_JyuryoItakuAtukaiJigyoshaTorokuTsuchisho"), new RString("介護保険受領委任払い取扱事業者登録通知書 ")),
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
     * 受給者異動連絡票（紙媒体）の帳票ＩＤです。
     */
    DBC100013(
            new ReportId("DBC100013_JukyushaIdoRenrakuhyo"), new RString("受給者異動連絡票（紙媒体）")),
    /**
     * 共同処理用受給者異動連絡票（紙媒体）の帳票ＩＤです。
     */
    DBC100015(new ReportId("DBC100015_KyodoShoriJukyushaIdoRenrakuhyo"), new RString("共同処理用受給者異動連絡票（紙媒体）")),
    /**
     * 共同処理用受給者訂正連絡票（紙媒体）の帳票ＩＤです。
     */
    DBC100016(new ReportId("DBC100016_KyodoShoriJukyushaTeiseiRenrakuhyo"), new RString("共同処理用受給者訂正連絡票（紙媒体）")),
    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）の帳票ＩＤです。
     */
    DBC100006(
            new ReportId("DBC100006_ShokanKetteiTsuchiShoSealer2"), new RString("償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）")),
    /**
     * 高額介護サービス費対象者一覧表 の帳票ＩＤです。
     */
    DBC200016(
            new ReportId("DBC200016_KogakuServicehiTaishoshaIchiran"), new RString("高額介護サービス費対象者一覧表")),
    /**
     * 償還払不支給決定者一覧情報 の帳票ＩＤです。
     */
    DBC200021(
            new ReportId("DBC200021_ShokanbaraiShikyuKetteishaIchiran"), new RString("償還払支給決定者一覧表")),
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
     * 高額総合事業サービス費対象者一覧表 の帳票ＩＤです。
     */
    DBC200077(new ReportId("DBC200077_KogakuSogoJigyoServiceHiTaishoshaIchiran"), new RString("高額総合事業サービス費対象者一覧表")),
    /**
     * 高額総合事業サービス費申請書発行一覧表 の帳票ＩＤです。
     */
    DBC200091(new ReportId("DBC200091_KogakuJigyoShinseishoHakkoIchiran"), new RString("高額総合事業サービス費申請書発行一覧表")),
    /**
     * 基準収入額適用決定通知一覧表 の帳票ＩＤです。
     */
    DBC200092(new ReportId("DBC200092_KijunShunyugakuTekiyoKetteiTsuchiIchiran"), new RString("基準収入額適用決定通知一覧表")),
    /**
     * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書の帳票ＩＤです。
     */
    DBC800015(new ReportId("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo"),
            new RString("介護保険高額介護（予防）サービス費支給（受領委任払）申請書")),
    /**
     * 第三者行為による被害届（介護保険用）の帳票ＩＤです。
     */
    DBC800020(new ReportId("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo"), new RString("第三者行為による被害届（介護保険用）")),
    /**
     * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）帳票ＩＤです。
     */
    DBC100072(new ReportId("DBC100072_KogakuJigyoOshiraseTsuchisho"), new RString("帳票設計_DBC100072_高額総合事業サービス費給付お知らせ通知書（提出期限あり）")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日なし帳票ＩＤです。
     */
    DBC200201(new ReportId("DBC200201_GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashi"), new RString("事業分高額合算支給決定通知書（単）")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日あり帳票ＩＤです。
     */
    DBC200202(new ReportId("DBC200202_GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAri"), new RString("事業分高額合算支給決定通知書（単）"));

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
