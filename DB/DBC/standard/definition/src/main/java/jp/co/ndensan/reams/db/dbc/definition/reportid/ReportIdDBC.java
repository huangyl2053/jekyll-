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
     * 住宅改修理由書作成手数料請求書兼申請書
     *
     */
    DBC100045(new ReportId("DBC100045_JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseisho"), new RString("住宅改修理由書作成手数料請求書兼申請書")),
    /**
     * DBC701019_HanyoListJigyoKogakuServiceHiJokyo
     *
     */
    DBC701019(new ReportId("DBC701019_HanyoListJigyoKogakuServiceHiJokyo"), new RString("")),
    /**
     * DBC701003_HanyoListKogakuKaigoServiceHiJokyo
     *
     */
    DBC701003(new ReportId("DBC701003_HanyoListKogakuKaigoServiceHiJokyo"), new RString("")),
    /**
     * 受給者給付実績台帳作成
     *
     */
    DBC100055(new ReportId("DBC100055_JukyushaKyufuJissekidaicho"), new RString("受給者給付実績台帳作成")),
    /**
     * 住宅改修理由書作成手数料請求書兼申請書作成
     */
    DBC200064(new ReportId("DBC200064_JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiran"), new RString("住宅改修理由書作成手数料請求書兼申請書作成")),
    /**
     * 利用状況統計表
     */
    DBC300005(new ReportId("DBC300005_RiyoJokyoTokeihyo"), new RString("利用状況統計表")),
    /**
     * 受給者給付実績一覧表
     */
    DBC200002(new ReportId("DBC200002_JukyushaKyufuJissekiIchiran"),
            new RString("受給者給付実績一覧表")),
    /**
     * サービスコード単位明細リスト
     */
    DBC200005(new ReportId("DBC200005_ServiceCodeTaniMeisaiIchiran"),
            new RString("サービスコード単位明細リスト")),
    /**
     * 高額合算支給額計算結果連絡票情報取込一覧表
     */
    DBC200037(new ReportId("DBC200037_GassanShikyugakuKeisankekkaRanrakuhyoTorikomiIchiran"),
            new RString("高額合算支給額計算結果連絡票情報取込一覧表")),
    /**
     * 高額合算支給額計算結果連絡票情報確認リスト
     */
    DBC200038(new ReportId("DBC200038_GassanShikyugakuKeisankekkaRanrakuhyoKakuninIchiran"),
            new RString("高額合算支給額計算結果連絡票情報確認リスト")),
    /**
     * 自己負担額補正一覧表
     */
    DBC200031(new ReportId("DBC200031_GassanJikofutangakuHoseiIchiran"), new RString("自己負担額補正一覧表")),
    /**
     * 高額合算自己負担額計算結果一覧表
     */
    DBC200029(new ReportId("DBC200029_GassanJikofutangakuKeisanKekkaIchiran"), new RString("高額合算自己負担額計算結果一覧表")),
    /**
     * 更正対象給付実績一覧表
     */
    DBC200096(new ReportId("DBC200096_KoseiTaishoKyufuJissekiIchiran"), new RString("更正対象給付実績一覧表")),
    /**
     * 給付実績取消一覧表
     */
    DBC200097(new ReportId("DBC200097_KyufuJissekiTorikeshiIchiran"), new RString("給付実績取消一覧表")),
    /**
     * 高額サービス給付のお知らせ通知書（提出期限あり）
     */
    DBC100011_Ari(new ReportId("DBC100011_KogakuOshiraseTsuchiTeshutsuKigenAri"),
            new RString("高額サービス給付のお知らせ通知書（提出期限あり）")),
    /**
     * 高額サービス給付のお知らせ通知書（提出期限なし）
     */
    DBC100012_Nashi(new ReportId("DBC100012_KogakuOshiraseTsuchiTeshutsuKigenNashi"),
            new RString("高額サービス給付のお知らせ通知書（提出期限なし）")),
    /**
     * 総合事業分自己負担額計算結果一覧表
     */
    DBC200203(new ReportId("DBC200203_GassanJigyobunJikofutangakuKeisanKekkaIchiran"), new RString("総合事業分自己負担額計算結果一覧表")),
    /**
     * 総合事業分支給額計算結果一覧表
     */
    DBC200204(new ReportId("DBC200204_GassanJigyobunShikyugakuKeisanKekkaIchiran"), new RString("総合事業分支給額計算結果一覧表")),
    /**
     * 総合事業費過再審査定通知書情報
     */
    DBC100057(new ReportId("DBC100057_ServiceRiyohyoBeppyo"), new RString("介護保険サービス利用票（兼居宅サービス計画）・別表 ")),
    /**
     * 高額サービス等支給（不支給）決定通知書（単）帳票ＩＤです。
     */
    DBC100107(new ReportId("DBC100107_KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashi"), new RString("高額サービス等支給（不支給）決定通知書（単）")),
    /**
     * 高額サービス等支給（不支給）決定通知書(支払予定日あり）（単）帳票ＩＤです。
     */
    DBC100108(new ReportId("DBC100108_KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAri"), new RString("高額サービス等支給（不支給）決定通知書(支払予定日あり）（単）")),
    /**
     * 総合事業費過再審査定通知書情報
     */
    DBC200080(new ReportId("DBC200080_SogojigyohiSaishinsaKetteiTsuchishoTorikomiIchiran"), new RString("総合事業費過再審査定通知書情報")),
    /**
     * 総合事業費（経過措置）過誤決定通知書情報取込一覧表
     */
    DBC200075(new ReportId("DBC200075_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran"), new RString("総合事業費（経過措置）過誤決定通知書情報取込一覧表")),
    /**
     * 総合事業費過誤申立書情報送付一覧表
     */
    DBC200079(new ReportId("DBC200079_SogojigyohiKagoMoshitateshojohoSofuIchiran"), new RString("総合事業費過誤申立書情報送付一覧表")),
    /**
     * 総合事業費審査決定請求明細表
     */
    DBC200084(new ReportId("DBC200084_SogojigyohiShinsaKetteiSeikyumeisaihyo"), new RString("総合事業費審査決定請求明細表")),
    /**
     * 総合事業費過誤決定通知書情報取込一覧表
     */
    DBC200085(new ReportId("DBC200085_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran"), new RString("総合事業費過誤決定通知書情報取込一覧表")),
    /**
     * 総合事業費等請求額通知書一覧表
     */
    DBC200087(new ReportId("DBC200087_SogojigyohiSeikyugakuTsuchisho"), new RString("総合事業費等請求額通知書一覧表")),
    /**
     * 給付実績更新結果情報一覧表
     */
    DBC200054(new ReportId("DBC200054_KyufujissekiKoshinkekkaIchiran"), new RString("給付実績更新結果情報一覧表")),
    /**
     * 受給者情報更新結果一覧表
     */
    DBC200055(new ReportId("DBC200055_JukyushaKoshinkekkaIchiran"), new RString("受給者情報更新結果一覧表")),
    /**
     * 共同処理用受給者情報更新結果一覧表
     */
    DBC200056(new ReportId("DBC200056_KyodoJukyushaKoshinkekkaIchiran"), new RString("共同処理用受給者情報更新結果一覧表")),
    /**
     * 共同処理用受給者情報一覧表
     */
    DBC200057(new ReportId("DBC200057_KyodoJukyushaIchiran"), new RString("共同処理用受給者情報一覧表")),
    /**
     * 受給者情報突合結果一覧表
     */
    DBC200058(new ReportId("DBC200058_JukyushaTotsugokekkaIchiran"), new RString("受給者情報突合結果一覧表")),
    /**
     * 負担割合判定一覧表帳票ＩＤです。
     */
    DBC200089(new ReportId("DBC200089_FutanWariaiHanteiIchiran"), new RString("負担割合判定一覧表")),
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
     * 総合事業費再審査決定通知書情報取込一覧表（公費）帳票ＩＤです。
     */
    DBC200081(new ReportId("DBC200081_SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohi"), new RString("総合事業費再審査決定通知書情報取込一覧表（公費）")),
    /**
     * 高額介護（予防）サービス費支給申請書
     */
    DBC100068(new ReportId("DBC100068_KogakuShikyuShinseisho"), new RString("高額介護（予防）サービス費支給申請書")),
    /**
     * 高額介護（予防）サービス費支給申請書（ゆうちょ銀行）
     */
    DBC100069(new ReportId("DBC100069_KogakuShikyuShinseishoYucho"), new RString("高額介護（予防）サービス費支給申請書（ゆうちょ銀行）")),
    /**
     * 介護保険高額総合事業サービス費支給申請書
     */
    DBC100070(new ReportId("DBC100070_KogakuJigyoShikyuShinseisho"), new RString("介護保険高額総合事業サービス費支給申請書")),
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
    DBC200017(new ReportId("DBC200017_KogakuShikyuShinseishoHakkoIchiran"), new RString("高額介護サービス費支給申請書発行一覧表 ")),
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
     * 高額サービス等支給（不支給）決定通知書(支払予定日あり）の帳票ＩＤです。
     */
    DBC100008(new ReportId("DBC100008_KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAri"), new RString("高額サービス等支給（不支給）決定通知書(支払予定日あり）")),
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
    DBC200024(
            new ReportId("DBC200024_ShokanbaraiSashitomeTaishoshaIchiran"), new RString("償還払支給（不支給）決定通知一覧表")),
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
    DBC100072(new ReportId("DBC100072_KogakuJigyoOshiraseTsuchishoKigenAri"), new RString("高額総合事業サービス費給付お知らせ通知書")),
    /**
     * 介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）
     */
    DBC100071(
            new ReportId("DBC100071_KogakuJigyoShikyuShinseishoYucho"), new RString("介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日なし帳票ＩＤです。
     */
    DBC200201(new ReportId("DBC200201_GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashi"), new RString("事業分高額合算支給決定通知書（単）")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日あり帳票ＩＤです。
     */
    DBC200202(new ReportId("DBC200202_GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAri"), new RString("事業分高額合算支給決定通知書（単）")),
    /**
     * 帳票設計_DBC200068_総合事業費（経過措置）請求額通知書帳票ＩＤです。
     */
    DBC200068(new ReportId("DBC200068_SogojigyohiSeikyugakuTsuchishoKeikaSochi"), new RString("総合事業費（経過措置）請求額通知書")),
    /**
     * 介護給付費等請求額通知書帳票ＩＤです。
     */
    DBC120230(new ReportId("DBC200066_SeikyugakuTsuchisho"), new RString("介護給付費等請求額通知書")),
    /**
     * 高額総合事業サービス費給付お知らせ通知書（提出期限`なし）帳票ＩＤです。
     */
    DBC100073(new ReportId("DBC100073_KogakuJigyoOshiraseTsuchishoKigenNashi"), new RString("高額総合事業サービス費給付お知らせ通知書")),
    /**
     * 事業高額決定通知書(支払予定日あり)帳票ＩＤです。
     */
    DBC100062(new ReportId("DBC100062_JigyoKogakuKetteiTsuchishoYoteiBiYijiAri"), new RString("事業高額決定通知書(支払予定日あり）")),
    /**
     * 事業高額決定通知書帳票ＩＤです。
     */
    DBC100061(new ReportId("DBC100061_JigyoKogakuKetteiTsuchishoYoteiBiYijiNashi"), new RString("事業高額決定通知書")),
    /**
     * 高額サービス給付のお知らせ通知書 の帳票ＩＤです
     *
     */
    DBC100011(new ReportId("DBC100011_KogakuOshiraseTsuchi"), new RString("高額サービス給付のお知らせ通知書")),
    /**
     * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）の帳票ＩＤです。
     */
    DBC100009(new ReportId("DBC100009_KogakuKetteiTsuchiShoSealer"), new RString("高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）")),
    /**
     * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）の帳票ＩＤです。
     */
    DBC100010(new ReportId("DBC100010_KogakuKetteiTsuchiShoSealer2"), new RString("高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）")),
    /**
     * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）の帳票ＩＤです。
     */
    DBC200067(new ReportId("DBC200067_SeikyugakuTsuchishoKohi"), new RString("介護給付費等請求額通知書（公費負担者分）")),
    /**
     * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）の帳票ＩＤです。
     */
    DBC100014(new ReportId("DBC100014_JukyushaTeiseiRenrakuhyo"), new RString("受給者訂正連絡票（紙媒体）")),
    /**
     * 帳票設計_DBC100063_基準収入額適用お知らせ通知書の帳票ＩＤです。
     */
    DBC100063(new ReportId("DBC100063_KijunShunyugakuTekiyoOshiraseTsuchisho"), new RString("基準収入額適用お知らせ通知書")),
    /**
     * 帳票設計_DBC100064_基準収入額適用申請書の帳票ＩＤです。
     */
    DBC100064(new ReportId("DBC100064_KijunShunyugakuTekiyoShinseisho"), new RString("基準収入額適用申請書")),
    /**
     * 帳票設計_DBC200088_基準収入額適用申請書一覧表の帳票ＩＤです。
     */
    DBC200088(new ReportId("DBC200088_KijunShunyugakuTekiyoShinseishoHakkoIchiran"), new RString("基準収入額適用申請書一覧表")),
    /**
     * （受給者台帳（一覧表）帳票ＩＤです。
     */
    DBC200006(new ReportId("DBC200006_KokuhorenJukyushaDaichoIchiran"), new RString("受給者台帳（一覧表）")),
    /**
     * 給付管理票取込結果一覧表帳票ＩＤです。
     */
    DBC200073(new ReportId("DBC200073_KyufuKanrihyoTorikomiKekkaIchiran"), new RString("給付管理票取込結果一覧表")),
    /**
     * 総合事業費等請求額通知書（公費負担者分）帳票ＩＤです。
     */
    DBC200082(new ReportId("DBC200082_SogojigyohiSeikyugakuTsuchishoKohi"), new RString("総合事業費等請求額通知書（公費負担者分）")),
    /**
     * 総合事業費公費受給者別一覧表
     */
    DBC200083(new ReportId("DBC200083_SogojigyohiKohiJukyushaBetsuIchiran"), new RString("総合事業費公費受給者別一覧表")),
    /**
     * 総合事業費過誤決定通知書情報取込一覧表（公費）帳票ＩＤです。
     */
    DBC200086(new ReportId("DBC200086_SogojigyohiKagoKetteitsuchishoTorikomiIchiranKohi"), new RString("総合事業費過誤決定通知書情報取込一覧表（公費）")),
    /**
     * 介護給付費資格照合表 帳票ＩＤです。
     */
    DBC100017(new ReportId("DBC100017_ShikakuShogohyo"), new RString("介護給付費資格照合表")),
    /**
     * 給付費通知減免補正一覧表 帳票ＩＤです。
     */
    DBC200043(new ReportId("DBC200043_KyufuhiTuchiGenmenhoseiIchiran"), new RString("給付費通知減免補正一覧表")),
    /**
     * 介護予防・日常生活支援総合事業費審査決定請求明細表帳票ＩＤです。
     */
    DBC200070(new ReportId("DBC200070_SogojigyohiShinsaKetteiSeikyumeisaihyo"), new RString("介護予防・日常生活支援総合事業費審査決定請求明細表")),
    /**
     * 介護給付費資格照合表 帳票ＩＤです。
     */
    DBC300003(new ReportId("DBC300003_NenreiKeikyuBetsuRiyoJyokyo"), new RString("年齢階級別利用状況作成")),
    /**
     * 介護給付費等審査決定請求明細表帳票ＩＤです。
     */
    DBC200069(new ReportId("DBC200069_KyufuhiShinsaKetteiSeikyuMeisaihyo"), new RString("介護給付費等審査決定請求明細表")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日なし帳票ＩＤです。
     */
    DBC100053(new ReportId("DBC100053_GassanKetteiTsuchishoShiharaiYoteiBiYijiNashi"), new RString("高額合算支給（不支給）決定通知書（単）")),
    /**
     * 振込明細一覧表帳票ＩＤです。
     */
    DBC200003(new ReportId("DBC200003_FurikomiMeisaiIchiranKogakuGassan"), new RString("振込明細一覧表")),
    /**
     * （高額合算支給（不支給）決定通知書）支払予定日あり帳票ＩＤです。
     */
    DBC100054(new ReportId("DBC100054_GassanKetteiTsuchishoShiharaiYoteiBiYijiAri"), new RString("高額合算支給（不支給）決定通知書（単）")),
    /**
     * 受領委任契約事業者一覧表帳票ＩＤです。
     */
    DBC200012(new ReportId("DBC200012_JuryoIninJigyoshaIchiran"), new RString("受領委任契約事業者一覧表")),
    /**
     * 高額合算自己負担額証明書情報一覧表
     */
    DBC200034(new ReportId("DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran"), new RString("高額合算自己負担額証明書情報一覧表")),
    /**
     * 総合事業費（経過措置）資格照合表帳票ＩＤです。
     */
    DBC100018(new ReportId("DBC100018_SogojigyohiShikakuShogohyoKeikaSochi"), new RString("総合事業費（経過措置）資格照合表")),
    /**
     * 総合事業費資格照合表帳票ＩＤです。
     */
    DBC100099(new ReportId("DBC100099_SogojigyohiShikakuShogohyo"), new RString("総合事業費資格照合表 ")),
    /**
     * 総合事業費（経過措置）資格照合表帳票ＩＤです。
     */
    DBC100204(new ReportId("DBC100204_GassanJigyobunKeisanKekkaRenrakuhyo"), new RString("事業分計算結果連絡票")),
    /**
     * DBC701008_HanyoList_KyufuKanriHyo
     */
    DBC701008(new ReportId("DBC701008_HanyoListKyufuKanriHyo"), new RString("汎用リスト出力(給付管理票)")),
    /**
     * DBC701008_HanyoList_KyufuKanriHyo
     */
    DBC701009(new ReportId("DBC701009_HanyoListKagoMoshitate"), new RString("汎用リスト出力(過誤申立情報)")),
    /**
     * DBC701010_HanyoList_KyufuKanriHyo
     */
    DBC701010(new ReportId("DBC701010_HanyoListKagoKekka"), new RString("汎用リスト出力(過誤結果情報)")),
    /**
     * DBC701016_HanyoListKogakuGassanKeisanKekkaRenrakuHyo
     */
    DBC701016(new ReportId("DBC701016_HanyoListKogakuGassanKeisanKekkaRenrakuHyo"), new RString("汎用リスト出力(高額合算計算結果連絡票情報)")),
    /**
     * 介護保険受領委任契約承認（不承認）確認書（利用者向け）帳票ＩＤです。
     */
    DBC100029(new ReportId("DBC100029_JyuryoItakuKeiyakuKakuninSho"), new RString("介護保険受領委任契約承認（不承認）確認書（利用者向け）")),
    /**
     * 事業分高額合算支給決定情報
     */
    DBC701021(new ReportId("DBC701021_HanyoListJigyoBunKogakuGassanShikyuKettei"), new RString("事業分高額合算支給決定情報")),
    /**
     * 汎用リスト　高額合算申請書情報帳票ＩＤです。
     */
    DBC701014(new ReportId("DBC701014_HanyoListKogakuGassanShinseishoJoho"), new RString("汎用リスト　高額合算申請書情報")),
    /**
     * 汎用リスト　高額合算自己負担額情報帳票ＩＤです。
     */
    DBC701015(new ReportId("DBC701015_HanyoListKogakuGassanJikoFutangaku"), new RString("汎用リスト　高額合算自己負担額情報")),
    /**
     * 汎用リスト　基準収入額適用情報帳票ＩＤです。
     */
    DBC701020(new ReportId("DBC701020_HanyoListKijunShunyugakuTekiyo"), new RString("汎用リスト　基準収入額適用情報")),
    /**
     * 汎用リスト_短期入所拡大該当者帳票ＩＤです。
     */
    DBC701013(new ReportId("DBC701013_HanyoListTankiNyushoKakudaiGaitosha"), new RString("汎用リスト_短期入所拡大該当者")),
    /**
     * 汎用リスト 再審査申立情報帳票ＩＤです。
     */
    DBC701011(new ReportId("DBC701011_HanyoListSaishinsaMoshitate"), new RString("汎用リスト 再審査申立情報")),
    /**
     * 高額合算補正済自己負担額情報送付一覧表
     */
    DBC200032(new ReportId("DBC200032_GassanHoseizumiJikofutangakuJohoSofuchiran"), new RString("高額合算補正済自己負担額情報送付一覧表")),
    /**
     * 高額合算補正済自己負担額情報未送付一覧表
     */
    DBC200033(new ReportId("DBC200033_GassanHoseizumiJikofutangakuJohoMisofuchiran"), new RString("高額合算補正済自己負担額情報未送付一覧表")),
    /**
     * 汎用リスト 再審査結果情報帳票ＩＤです。
     */
    DBC701012(new ReportId("DBC701012_HanyoListSaishinsaKekka"), new RString("汎用リスト 再審査結果情報")),
    /**
     * 給付管理票総括票帳票ＩＤです。
     */
    DBC300001(new ReportId("DBC300001_KyufuKanrihyoSokatsuhyo"), new RString("給付管理票総括票")),
    /**
     * 高額合算給付実績情報送付一覧表帳票ＩＤです。
     */
    DBC200042(new ReportId("DBC200042_GassanKyufujissekiSofuIchiran"), new RString("高額合算給付実績情報送付一覧表")),
    /**
     * 給付実績情報送付一覧表帳票ＩＤです。
     */
    DBC200053(new ReportId("DBC200053_KyufuJisekiJohoSofuIchiran"), new RString("給付実績情報送付一覧表")),
    /**
     * 給付再審査申立書情報送付一覧表帳票ＩＤです。
     */
    DBC200047(new ReportId("DBC200047_KyufuSaishinsaMoshitateshojohoSofuIchiran"), new RString("給付再審査申立書情報送付一覧表")),
    /**
     * 償還連絡票送付一覧表帳票ＩＤです。
     */
    DBC200025(new ReportId("DBC200025_ShokanRenrakuhyoSofuIchiran"), new RString("償還連絡票送付一覧表")),
    /**
     * 償還連絡票送付情報エラーリスト帳票ＩＤです。
     */
    DBC200026(new ReportId("DBC200026_ShokanRenrakuhyoSofuJohoErrorIchiran"), new RString("償還連絡票送付情報エラーリスト")),
    /**
     * 償高額合算自己負担額確認情報取込一覧表帳票ＩＤです。
     */
    DBC200028(new ReportId("DBC200028_GassanJikofutangakuKakuninTorikomiIchiran"), new RString("高額合算自己負担額確認情報取込一覧表")),
    /**
     * 高額介護サービス費給付判定結果送付一覧表帳票ＩＤです。
     */
    DBC200019(new ReportId("DBC200019_KogakuServicehiKyufuHanteiKekkaSofuIchiran"), new RString("高額介護サービス費給付判定結果送付一覧表")),
    /**
     * 高額合算支給額計算結果連絡票情報送付一覧表帳票ＩＤです。
     */
    DBC200036(new ReportId("DBC200036_GassanShikyugakuKeisankekkaRanrakuhyoSofuIchiran"), new RString("高額合算支給額計算結果連絡票情報送付一覧表")),
    /**
     * 給付管理票送付一覧表帳票ＩＤです。
     */
    DBC200009(new ReportId("DBC200009_KyufuKanrihyoSofuIchiran"), new RString("給付管理票送付一覧表")),
    /**
     * 給付過誤申立書情報送付一覧表帳票ＩＤです。
     */
    DBC200045(new ReportId("DBC200045_KyufuKagoMoshitateshojohoSofuIchiran"), new RString("給付過誤申立書情報送付一覧表")),
    /**
     * 総合事業費（経過措置）過誤申立書情報送付一覧表帳票ＩＤです。
     */
    DBC200046(new ReportId("DBC200046_SogojigyohiKagoMoshitateshojohoSofuIchiran"), new RString("総合事業費（経過措置）過誤申立書情報送付一覧表")),
    /**
     * 平均利用額統計表帳票ＩＤです。
     */
    DBC300004(new ReportId("DBC300004_HeikinRiyoGakuTokeihyo"), new RString("平均利用額統計表")),
    /**
     * 高額合算給付実績情報取込一覧表帳票ＩＤです。
     */
    DBC200041(new ReportId("DBC200041_GassanKyufujissekiTorikomiIchiran"), new RString("高額合算給付実績情報取込一覧表")),
    /**
     * 介護保険高額サービス費受領委任契約承認（不承認）確認書帳票ＩＤです。
     */
    DBC100031(new ReportId("DBC100031_KogakuServiceHiJyuryoItakuKeiyakuKakuninSho"), new RString("介護保険高額サービス費受領委任契約承認（不承認）確認書")),
    /**
     * 介護保険給付費通知書(２ページ目以降)帳票ＩＤです。
     */
    DBC100041_２ページ目以降(new ReportId("DBC100041_KyufuhiTsuchisho"), new RString("介護保険給付費通知書（２ページ目以降）")),
    /**
     * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）帳票ＩＤです。
     */
    DBC100043(new ReportId("DBC100043_KyufuhiTsuchishoFukushiYoguTaiyoHinmoku"), new RString("介護保険給付費通知書（福祉用具貸与品目）")),
    /**
     * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）帳票ＩＤです。
     */
    DBC100042(new ReportId("DBC100042_KyufuhiTsuchishoSealer"), new RString("介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)")),
    /**
     * 帳票設計_DBC200004_利用状況一覧表帳票ＩＤです。
     */
    DBC200004(new ReportId("DBC200004_RiyoJokyoIchiran"), new RString("利用状況一覧表")),
    /**
     * 帳票設計_DBC200044_給付費通知発行一覧表ＩＤです。
     */
    DBC200044(new ReportId("DBC200044_KyufuhiTuchiHakkoIchiran"), new RString("給付費通知発行一覧表")),
    /**
     * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表帳票ＩＤです。
     */
    DBC200013(new ReportId("DBC200013_JuryoIninShoninKakuninshoIchiran"), new RString("受領委任契約承認確認書発行一覧表")),
    /**
     * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（事業者用） 帳票ＩＤです。
     */
    DBC100030(new ReportId("DBC100030_JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayo"), new RString("介護保険受領委任契約承認（不承認）確認書（事業者用）")),
    /**
     * 事業合算・事業分振込明細書作成（一括）帳票ＩＤです。
     */
    DBC100059(new ReportId("DBC100059_FurikomiIraisho"), new RString("事業合算・事業分振込明細書作成（一括）")),
    /**
     * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表 ＩＤです。
     */
    DBC200039(new ReportId("DBC200039_GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiran"), new RString("高額合算支給不支給決定通知書情報取込一覧表 ")),
    /**
     * 帳票設計_DBC200035_高額合算自己負担額証明書発行一覧表 ＩＤです。
     */
    DBC200035(new ReportId("DBC200035_GassanJikofutangakushomeishoHakkoIchiran"), new RString("高額合算自己負担額証明書発行一覧表 ")),
    /**
     * 汎用リスト 共同処理用受給者情報（基本）帳票ＩＤです。
     */
    DBC701005(new ReportId("DBC701005_HanyoListKyodoJukyushaKihon"), new RString("汎用リスト 共同処理用受給者情報（基本）")),
    /**
     * 汎用リスト 共同処理用受給者情報（償還）帳票ＩＤです。
     */
    DBC701007(new ReportId("DBC701007_HanyoListKyodoJukyushaShokan"), new RString("汎用リスト 共同処理用受給者情報（償還）")),
    /**
     * 汎用リスト 共同処理用受給者情報（高額）帳票ＩＤです。
     */
    DBC701006(new ReportId("DBC701006_HanyoListKyodoJukyushaKogaku"), new RString("汎用リスト 共同処理用受給者情報（高額）")),
    /**
     * 汎用リスト 国保連受給者情報帳票ＩＤです。
     */
    DBC701004(new ReportId("DBC701004_HanyoListKokuhorenJukyusha"), new RString("汎用リスト 国保連受給者情報")),
    /**
     * 事業合算・事業分振込明細書作成（一括）帳票ＩＤです。
     */
    DBC100060(new ReportId("DBC100060_FurikomiTsuchisho"), new RString("事業合算・事業分振込明細書作成（一括）")),
    /**
     * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リスト帳票ＩＤです。
     */
    DBC200010(new ReportId("DBC200010_JukyushaIdorenrakuhyoSofuTaishoshachiran"), new RString("受給者異動連絡票情報送付対象者リスト")),
    /**
     * 帳票設計_DBCMNF1001_1_国保連送付データエラーリスト帳票ＩＤです。
     */
    DBC200095(new ReportId("DBC200095_KokuhorenSofuDataErrorIchiran"), new RString("国保連送付データエラーリスト")),
    /**
     * 帳票設計_DBCMNF1001_1_国保連受給者異動情報履歴訂正リスト帳票ＩＤです。
     */
    DBC200074(new ReportId("DBC200074_JukyushaIdoRirekiTeiseiIchiran"), new RString("国保連受給者異動情報履歴訂正リスト")),
    /**
     * 帳票設計_DBC100041_介護保険給付費通知書 ＩＤです。
     */
    DBC100041(new ReportId("DBC100041_KyufuhiTsuchisho"), new RString("介護保険給付費通知書")),
    /**
     * 請求明細・給付管理票返戻（保留）一覧表帳票ＩＤです。
     */
    DBC200001(new ReportId("DBC200001_SeikyumeisaiKyufukanrihyoHenreiHoryuIchiran"), new RString("請求明細・給付管理票返戻（保留）一覧表")),
    /**
     * 汎用リスト出力(総合事業費情報1)帳票ＩＤです。
     */
    DBC701018(new ReportId("DBC701018_HanyoListSogoJigyoHi"), new RString("汎用リスト出力( 総合事業費情報)")),
    /**
     * 汎用リスト出力(総合事業費情報2)帳票ＩＤです。
     */
    DBC701022(new ReportId("DBC701022_HanyoListSogoJigyoHiMeisai"), new RString("汎用リスト出力(総合事業費情報)")),
    /**
     * 汎用リスト出力(総合事業費情報3)帳票ＩＤです。
     */
    DBC701023(new ReportId("DBC701023_HanyoListSogoJigyoHiShukei"), new RString("汎用リスト出力(総合事業費情報)")),
    /**
     * 汎用リスト出力(総合事業費情報4)帳票ＩＤです。
     */
    DBC701024(new ReportId("DBC701024_HanyoListSogoJigyoHiCare"), new RString("汎用リスト出力(総合事業費情報)")),
    /**
     * 居宅サービス計画作成依頼届出状況一覧表帳票ＩＤです。
     */
    DBC200060(new ReportId("DBC200060_KyotakuServiceKeikakuSakuseiIraitodokedeJyokyoIchiran"), new RString("居宅サービス計画作成依頼届出状況一覧表")),
    /**
     * 介護給付費公費受給者別一覧表帳票ＩＤです。
     */
    DBC200008(new ReportId("DBC200008_KohijukyushaBetsuIchiran"), new RString("介護給付費公費受給者別一覧表")),
    /**
     * 高額サービス等支給（不支給）決定通知書帳票ＩＤです。
     */
    DBC100007(new ReportId("DBC100007_KogakuKetteiTsuchiSho"), new RString("高額サービス等支給（不支給）決定通知書")),
    /**
     * 高額サービス等支給（不支給）決定通知書帳票ＩＤです。
     */
    DBC100007_支給(new ReportId("DBC100007_KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashi"), new RString("高額サービス等支給（不支給）決定通知書")),
    /**
     * 給付実績情報取込結果一覧表ＩＤです。
     */
    DBC200007(new ReportId("DBC200007_KyufujissekiTorikomiIchiran"), new RString("給付実績情報取込結果一覧表")),
    /**
     * 高額合算支給申請書情報送付一覧表帳票ＩＤです。
     */
    DBC200027(new ReportId("DBC200027_GassanShikyuShinseishoJohoSofuIchiran"), new RString("高額合算支給申請書情報送付一覧表")),
    /**
     * サービスコード別利用状況ＩＤです。
     */
    DBC300002(new ReportId("DBC300002_ServiceCodeBetsuRiyoJokyo"), new RString("サービスコード別利用状況")),
    /**
     * サービスコード一覧表ＩＤです。
     */
    DBC200061(new ReportId("DBC200061_ServiceCodeIchiran"), new RString("サービスコード一覧表")),
    /**
     * 自己負担額証明書帳票ＩＤです。
     */
    DBC100050(new ReportId("DBC100050_JikoFutangakushomeishoTo2008"), new RString("自己負担額証明書（介護）(平成２０年度まで用）")),
    /**
     * 振込明細一覧表（明細）帳票ＩＤです。
     */
    DBC200101(new ReportId("DBC200101_FurikomiMeisaiIchiran"), new RString("振込明細一覧表")),
    /**
     * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表 ＩＤです。
     */
    DBC200040(new ReportId("DBC200040_GassanShikyuFushikyuKetteishaIchiran"), new RString("高額合算支給不支給決定通知書情報取込一覧表 ")),
    /**
     * 帳票設計_DBCMN43002_高額介護サービス費支給（不支給）決定通知一覧表 ＩＤです。
     */
    DBC200020(new ReportId("DBC200020_KogakuShikyuFushikyuKetteiTsuchiHakkoIchiran"), new RString("高額介護サービス費支給（不支給）決定通知一覧表")),
    /**
     * 帳票設計_DBCMN43002_事業高額支給不支給決定通知一覧表 ＩＤです。
     */
    DBC200078(new ReportId("DBC200078_JigyoKogakuShikyuFushikyuKetteTsuchiIchiran"), new RString("事業高額支給不支給決定通知一覧表")),
    /**
     * 自己負担証明書_2009年以降 帳票ＩＤです。
     */
    DBC100051(new ReportId("DBC100051_JikoFutangakushomeishoFrom2009"), new RString("自己負担額証明書（介護）(平成２１年度以降用）")),
    /**
     * 給付管理票（居宅・介護予防サービス・総合事業） 帳票ＩＤです。
     */
    DBC100035(new ReportId("DBC100035_KyufuKanrihyoKyotakuYoboSogoJigyoService"), new RString("給付管理票（居宅・介護予防サービス・総合事業）")),
    /**
     * 汎用リスト出力(高額合算支給額決定情報) 帳票ＩＤです。
     */
    DBC701017(new ReportId("DBC701017_HanyoListKogakuGassanShikyugakuKettei"), new RString("汎用リスト出力(高額合算支給額決定情報)")),
    /**
     * 高額介護サービス費対象者一覧表（遡及分） 帳票ＩＤです。
     */
    DBC200100(new ReportId("DBC200100_KogakuServicehiTaishoshaIchiranSokyubun"), new RString("高額介護サービス費対象者一覧表（遡及分）")),
    /**
     * 住宅改修理由書作成手数料支給（不支給）決定通知書 帳票ＩＤです。
     */
    DBC100044(new ReportId("DBC100044_JutakuKaishuRiyushoSakuseiTesuryoKetteiTsuchisho"), new RString("住宅改修理由書作成手数料支給（不支給）決定通知書")),
    /**
     * 振込明細一覧表（事業高額） 帳票ＩＤです。
     */
    DBC200102(new ReportId("DBC200102_FurikomiMeisaiIchiranJigyoKogaku"), new RString("振込明細一覧表（事業高額）")),
    /**
     * 振込明細一覧表（事業高額合算） 帳票ＩＤです。
     */
    DBC200103(new ReportId("DBC200103_FurikomiMeisaiIchiranJigyoKogakuGassan"), new RString("振込明細一覧表（事業高額合算）"));

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
