/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBE-9999-021 zhangzhiming
 */
public enum ReportIdDBE {

    /**
     * 主治医意見書（オルカ）の帳票ID。
     */
    DBE231102(new ReportId("DBE231102_ikenshokinyuyoshi"), new RString("主治医意見書（オルカ）")),
    /**
     * 主治医意見書（オルカ）の帳票ID。
     */
    DBE231101(new ReportId("DBE231101_ikenshokinyuyoshi"), new RString("主治医意見書（オルカ）")),
    /**
     * 認定調査報酬照会の帳票ID。
     */
    DBE601006(new ReportId("DBE601006_chosahoshuichiran"), new RString("認定調査報酬照会")),
    /**
     * 事務局用概況特記一覧表の帳票ID。
     */
    DBE517007(new ReportId("DBE517007_GaikyoTokkiIchiran"), new RString("事務局用概況特記一覧表")),
    /**
     * 事務局用一次判定結果票A3の帳票ID。
     */
    DBE517081(new ReportId("DBE517081_IchijihanteikekkahyoA3"), new RString("事務局用一次判定結果票A3")),
    /**
     * 委員用一次判定結果票A3の帳票ID。
     */
    DBE517085(new ReportId("DBE517085_IchijihanteikekkahyoA3"), new RString("委員用一次判定結果票A3")),
    /**
     * 委員用一次判定結果票A4の帳票ID。
     */
    DBE517038(new ReportId("DBE517038_ichijihanteikekkahyo"), new RString("委員用一次判定結果票A4")),
    /**
     * 委員用主治医意見書A3の帳票ID。
     */
    DBE517005(new ReportId("DBE517005_ShujiiikenshoA3"), new RString("委員用主治医意見書A3")),
    /**
     * 委員用主治医意見書A4の帳票ID。
     */
    DBE517152(new ReportId("DBE517151_Shujiiikensho1A4"), new RString("委員用主治医意見書A4")),
    /**
     * 事務局用予備判定記入表の帳票ID。
     */
    DBE517002(new ReportId("DBE517002_JimukyokuyoYobihanteiKinyuhyo"), new RString("事務局用予備判定記入表")),
    /**
     * 介護認定審査会開催のお知らせの帳票ID。
     */
    DBE515001(new ReportId("DBE515001_ShinsakaiKaisaiOshiraseTsuchi"), new RString("介護認定審査会開催のお知らせ")),
    /**
     * 事務局用介護認定審査対象者一覧表A3の帳票ID。
     */
    DBE517001(new ReportId("DBE517001_ShinsakaishiryoA3"), new RString("事務局用介護認定審査対象者一覧表A3")),
    /**
     * 事務局用介護認定審査対象者一覧表A4の帳票ID。
     */
    DBE517011(new ReportId("DBE517011_ShinsakaishiryoA4"), new RString("事務局用介護認定審査対象者一覧表A4")),
    /**
     * 医療機関・主治医一覧表の帳票ID。
     */
    DBE591001(new ReportId("DBE591001_ShujiiIryokikanShujiiIchiranhyo"), new RString("医療機関・主治医一覧表")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE230001(new ReportId("DBE230001_ShujiiIkenshoSakuseiIraisho"), new RString("主治医意見書作成依頼書")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE223002(
            new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo"), new RString("主治医意見書督促対象者一覧表")),
    /**
     * 要介護認定調査票（基本調査）（枠有 カラー印刷片面用）の帳票ＩＤです。
     */
    DBE221002(new ReportId("DBE221002_ChosahyoKihonchosaKatamen"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 要介護認定調査票（基本調査）（枠有 カラー印刷両面用）の帳票ＩＤです。
     */
    DBE221003(new ReportId("DBE221003_ChosahyoKihonchosaRyomen"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 認定調査依頼発行一覧表の帳票ＩＤです。
     */
    DBE220003(new ReportId("DBE220003_ChosaIraiHakkoIchiranhyo"), new RString("認定調査依頼発行一覧表")),
    /**
     * 認定調査依頼発行一覧表の帳票ＩＤです。
     */
    DBE233001(new ReportId("DBE233001_ShujiiIkenshoSakuseiTokusokujo"), new RString("主治医意見書提出督促状")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230002(
            new ReportId("DBE230002_IkenshoSakuseiIraiIchiranhyo"), new RString("主治医意見書作成依頼一覧")),
    /**
     * その他資料A3の帳票ID。
     */
    DBE517006(new ReportId("DBE517006_SonotashiryoA3"), new RString("その他資料")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230003(
            new ReportId("DBE230003_IkenshoSakuseiIraiHakkoIchiranhyo"), new RString("主治医意見書作成依頼発行一覧表")),
    /**
     * 要介護認定業務進捗状況一覧表の帳票ＩＤです。
     */
    DBE521002(new ReportId("DBE521002_NiteiGyomuShinchokuJokyoIchiranhyo"), new RString("要介護認定業務進捗状況一覧表")),
    /**
     * 認定調査スケジュール表(事務所)の帳票ＩＤです。
     */
    DBE202002(new ReportId("DBE202002_ChosaSchedulehyo"), new RString("認定調査スケジュール表(事務所)")),
    /**
     * 認定調査スケジュール表(時間管理)の帳票ＩＤです。
     */
    DBE202011(new ReportId("DBE202011_ChosaSchedulehyo"), new RString("認定調査スケジュール表(時間管理)")),
    /**
     * 認定調査スケジュール表(調査員)の帳票ＩＤです。
     */
    DBE202001(new ReportId("DBE202001_ChosaSchedulehyo"), new RString("認定調査スケジュール表(調査員)")),
    /**
     * 事務局用概況特記A3の帳票ＩＤです。
     */
    DBE517041(new ReportId("DBE517041_GaikyotokkiTextA3"), new RString("事務局用概況特記")),
    /**
     * 事務局用概況特記A4の帳票ＩＤです。
     */
    DBE517141(new ReportId("DBE517141_GaikyotokkiTextA4"), new RString("事務局用概況特記")),
    /**
     * 追加資料鑑の帳票ＩＤです。
     */
    DBE517009(new ReportId("DBE517009_TsuikashiryokagamiA3"), new RString("追加資料鑑")),
    /**
     * 追加資料鑑の帳票ＩＤです。
     */
    DBE517019(new ReportId("DBE517019_TsuikashiryokagamiA4"), new RString("追加資料鑑")),
    /**
     * 介護保険診断命令書の帳票ＩＤです。
     */
    DBE235001(new ReportId("DBE235001_kaigohokenShindanMeireisho"), new RString("介護保険診断命令書")),
    /**
     * 認定調査依頼一覧表の帳票ＩＤです。
     */
    DBE220002(
            new ReportId("DBE220002_ChosaIraiIchiranhyo"), new RString("認定調査依頼一覧表")),
    /**
     * 要介護認定調査依頼書の帳票ＩＤです。
     */
    DBE220001(
            new ReportId("DBE220001_ChosaIraisho"), new RString("要介護認定調査依頼書")),
    /**
     * 介護認定審査会スケジュール表です。
     */
    DBE514001(
            new ReportId("DBE514001_Shinsakaisukejuruhyo"), new RString("介護認定審査会スケジュール表")),
    /**
     * 要介護認定結果通知対象者一覧表です。
     */
    DBE525005(
            new ReportId("DBE525005_KekkatsuchiTaishoshaIchiran"), new RString("要介護認定結果通知対象者一覧表")),
    /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書です。
     */
    DBE236001(
            new ReportId("DBE236001_ShujiiIkenshoTeishutsuIraisho"), new RString("介護保険指定医依頼兼主治医意見書提出依頼書")),
    /**
     * 要介護認定調査督促状です。
     */
    DBE223001_NinteiChosaTokusokujo(
            new ReportId("DBE223001_NinteiChosaTokusokujo"), new RString("要介護認定調査督促状")),
    /**
     * 要介護認定・要支援認定等申請者一覧です。
     */
    DBE011001(
            new ReportId("DBE011001_yokaigoyoshienshinseiichiran"), new RString("要介護認定・要支援認定等申請者一覧")),
    /**
     * 認定調査督促対象者一覧表です。
     */
    DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo(
            new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo"), new RString("認定調査督促対象者一覧表")),
    /**
     * 主治医意見書作成料請求書です。
     */
    DBE234001(new ReportId("DBE234001_ShujiiIkenshoSakuseiRyoSeikyusho"), new RString("主治医意見書作成料請求書")),
    /**
     * 介護認定審査会スケジュール表かがみの帳票ID。
     */
    DBE514002(new ReportId("DBE514002_Shinsaschedulekagami"), new RString("介護認定審査会スケジュール表かがみ")),
    /**
     * 要介護認定調査票（概況調査）の帳票ＩＤです。
     */
    DBE221011(new ReportId("DBE221011_chosahyoGaikyochosa"), new RString("要介護認定調査票（概況調査）")),
    /**
     * 要介護認定調査票（概況調査）の帳票ＩＤです。
     */
    DBE221001(new ReportId("DBE221001_ChosahyoGaikyochosa"), new RString("要介護認定調査票（概況調査）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221022_1(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221021(new ReportId("DBE221021_chosahyoTokkijiko"), new RString("DBE221021_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221023(new ReportId("DBE221023_chosahyoTokkijiko"), new RString("DBE221023_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221024(new ReportId("DBE221024_chosahyoTokkijiko"), new RString("DBE221024_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221041(new ReportId("DBE221041_tokkijikoOCR"), new RString("DBE221041_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221042(new ReportId("DBE221042_tokkijikoOCR"), new RString("DBE221042_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221043(new ReportId("DBE221043_tokkijikoOCR"), new RString("DBE221043_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）フリー様式の帳票ＩＤです。
     */
    DBE221022_2(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）フリー様式")),
    /**
     * 要介護認定調査票（基本調査）の帳票ＩＤです。
     */
    DBE221012(new ReportId("DBE221012_chosahyoKihonchosa"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 前回認定調査結果との比較表の帳票ＩＤです。
     */
    DBE293001(new ReportId("DBE293001_ChosahyoSaiCheckhyo"), new RString("前回認定調査結果との比較表")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE292001(new ReportId("DBE292001_SaiChekkuhyo"), new RString("要介護認定調査票差異チェック票")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE701001(new ReportId("DBE701001_ShinsaHanteiJokyo"), new RString("介護認定審査会判定状況表")),
    /**
     * 要介護認定調査票差異チェック票(両面左)の帳票ＩＤです。
     */
    DBE292003(new ReportId("DBE292003_SaiChekkuhyoHidari"), new RString("要介護認定調査票差異チェック票(両面左)")),
    /**
     * 要介護認定調査票差異チェック票(両面右)の帳票ＩＤです。
     */
    DBE292002(new ReportId("DBE292002_SaiChekkuhyoMigi"), new RString("要介護認定調査票差異チェック票(両面右)")),
    /**
     * 介護認定審査会集計表（現在の状況別）の帳票ＩＤです。
     */
    DBE701009(new ReportId("DBE701009_ShinsakaiShukeiGenzainojokyo"), new RString("介護認定審査会集計表（現在の状況別）")),
    /**
     * 要介護認定実施状況統計の帳票ＩＤです。
     */
    DBE701003(new ReportId("DBE701003_JisshiJokyoTokei"), new RString("要介護認定実施状況統計")),
    /**
     * 要介護認定実施状況統計の帳票ＩＤです。
     */
    DBE702001(new ReportId("DBE702001_JigyoJokyoHokoku"), new RString("要介護認定事業状況報告")),
    /**
     * 要介護認定判定結果一覧表の帳票ＩＤです。
     */
    DBE525001(new ReportId("DBE525001_hanteikekkaichiranA4"), new RString("要介護認定判定結果一覧表")),
    /**
     * 要介護認定判定結果一覧表Ａ３版の帳票ＩＤです。
     */
    DBE525002(new ReportId("DBE525002_HanteiKekkaIchiranA3"), new RString("要介護認定判定結果一覧表Ａ３版")),
    /**
     * 介護認定審査判定結果（鑑）の帳票ＩＤです。
     */
    DBE525006(new ReportId("DBE525006_HanteikekkaKagami"), new RString("介護認定審査判定結果（鑑）")),
    /**
     * 介護認定審査会議事録の帳票ＩＤです。
     */
    DBE525003(new ReportId("DBE525003_ShinsakaiGijiroku"), new RString("介護認定審査会議事録")),
    /**
     * 要介護認定結果通知一覧表の帳票ＩＤです。
     */
    DBE525004(new ReportId("DBE525004_kekkatsuchiIchiranhyo"), new RString("要介護認定結果通知一覧表")),
    /**
     * 認定調査委託先・認定調査員一覧表の帳票ＩＤです。
     */
    DBE592001(new ReportId("DBE592001_ChosaItakusakiNinteiChosainIchiranhyo"), new RString("認定調査委託先・認定調査員一覧表")),
    /**
     * 介護認定審査会スケジュール表（年間）の帳票ＩＤです。
     */
    DBE514003(new ReportId("DBE514003_shinsakainenkansukejuruhyo"), new RString("介護認定審査会スケジュール表（年間）")),
    /**
     * 要介護状態区分別判定件数の帳票ＩＤです。
     */
    DBE701005(new ReportId("DBE701005_Jotaikubumbetsuhantei"), new RString("要介護状態区分別判定件数")),
    /**
     * 審査判定の変更状況の帳票ＩＤです。
     */
    DBE701006(new ReportId("DBE701006_ShinsahanteinoHenkojokyo"), new RString("審査判定の変更状況")),
    /**
     * 介護認定審査会集計表（判定別）の帳票ＩＤです。
     */
    DBE701007(new ReportId("DBE701007_shinsakaishukeihyoHanteibetsu"), new RString("介護認定審査会集計表（判定別）")),
    /**
     * 介護認定審査会集計表（判定別）の帳票ＩＤです。
     */
    DBE701008(new ReportId("DBE701008_ShinsakaiShukeihyo"), new RString("介護認定審査会集計表（申請区分別）")),
    /**
     * その他資料A4の帳票ＩＤです。
     */
    DBE517016(new ReportId("DBE517016_SonotashiryoA4"), new RString("その他資料")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001(new ReportId("DBE231001_ikenshokinyuyoshi"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 主治医意見書の帳票ＩＤです。
     */
    DBE517151(new ReportId("DBE517151_Shujiiikensho1A4"), new RString("主治医意見書")),
    /**
     * 一次判定結果の帳票ＩＤです。
     */
    DBE517181(new ReportId("DBE517181_IchijihanteikekkahyoA4"), new RString("一次判定結果")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091002(new ReportId("DBE091002_NinteiChosaJohohyo"), new RString("認定調査票情報_09B総合事業")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091012(new ReportId("DBE091012_NinteiChosaJohohyo"), new RString("認定調査票情報_09B")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091022(new ReportId("DBE091022_NinteiChosaJohohyo"), new RString("認定調査票情報_09A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091032(new ReportId("DBE091032_06ANinteiChosaJohohyo"), new RString("認定調査票情報_06A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091042(new ReportId("DBE091042_02ANinteiChosaJohohyo"), new RString("認定調査票情報_02A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091052(new ReportId("DBE091052_99ANinteiChosaJohohyo"), new RString("認定調査票情報_99A")),
    /**
     * 申請に関する帳票発行の帳票ＩＤです。
     */
    DBE012002(new ReportId("DBE012002_NinteichosaIraiHenko"), new RString("認定調査依頼先変更者一覧表")),
    /**
     * 申請に関する帳票発行の帳票ＩＤです。
     */
    DBE012001(new ReportId("DBE012001_NinteichosaYoteiMitei"), new RString("認定調査予定未定者一覧表")),
    /**
     * 委員用予備判定記入表の帳票ＩＤです。
     */
    DBE517022(new ReportId("DBE517022_IinYobihanteiKinyuhyo"), new RString("委員用予備判定記入表")),
    /**
     * 委員用予備判定記入表の帳票ＩＤです。
     */
    DBE517003(new ReportId("DBE517003_IinYobihanteiKinyuhyo"), new RString("委員用予備判定記入表")),
    /**
     * 申請に関する帳票発行の帳票ＩＤです。
     */
    DBE012003(new ReportId("DBE012003_ChosahyoIkenshoCheckList"), new RString("認定調査結果と主治医意見書のチェックリスト")),
    /**
     * 主治医意見書未提出者一覧表の帳票ＩＤです。
     */
    DBE013003(new ReportId("DBE013003_ShujiiIkenshoMiteishutsu"), new RString("主治医意見書未提出者一覧表")),
    /**
     * 主治医意見書未処理者一覧表の帳票ＩＤです。
     */
    DBE013001(new ReportId("DBE013001_ShujiiIkenshoMiIrai"), new RString("主治医意見書依頼未処理者一覧表")),
    /**
     * 主治医意見書未処理者一覧表の帳票ＩＤです。
     */
    DBE013004(new ReportId("DBE013004_ShujiiIkenshoIraiSumi"), new RString("主治医意見書依頼済み一覧表")),
    /**
     * 主治医意見書5項目確認一覧表の帳票ＩＤです。
     */
    DBE013005(new ReportId("DBE013005_ShujiiIkensho5komoku"), new RString("主治医意見書5項目確認一覧表")),
    /**
     * 主治医意見書作成依頼変更者一覧表の帳票ＩＤです。
     */
    DBE013002(new ReportId("DBE013002_ShijiiIkenshoIraiHenko"), new RString("主治医意見書作成依頼変更者一覧表")),
    /**
     * 主治医意見書作成依頼変更者一覧表の帳票ＩＤです。
     */
    DBE013006(new ReportId("DBE013006_ShujiiIkenshoSeikyuIchiran"), new RString("主治医意見書作成料請求一覧表")),
    /**
     * 要介護認定申請モニタリストの帳票ＩＤです。
     */
    DBE011002(new ReportId("DBE011002_ShinseiMonitor"), new RString("要介護認定申請モニタリスト")),
    /**
     * 特記事項の帳票ＩＤです。
     */
    DBE091003(new ReportId("DBE091003_NinteiChosaTokkiImage"), new RString("特記事項")),
    /**
     * 特記事項の帳票ＩＤです。
     */
    DBE517131(new ReportId("DBE517131_TokkiText1A4"), new RString("特記事項")),
    /**
     * 特記事項の帳票ＩＤです。
     */
    DBE517031(new ReportId("DBE517031_TokkiText1A3"), new RString("特記事項")),
    /**
     * 特記事項の帳票ＩＤです。
     */
    DBE517134(new ReportId("DBE517134_TokkiText2A4"), new RString("特記事項")),
    /**
     * 主治医意見書作成報酬支払通知書の帳票ＩＤです。
     */
    DBE621002(new ReportId("DBE621002_shujiihoshushiharai"), new RString("主治医意見書作成報酬支払通知書")),
    /**
     * 認定調査報酬支払通知書の帳票ＩＤです。
     */
    DBE621003(new ReportId("DBE621003_chosahoshushiharai"), new RString("認定調査報酬支払通知書")),
    /**
     * 主治医意見書作成報酬請求書の帳票ＩＤです。
     */
    DBE621004(new ReportId("DBE621004_ikenshohoshuseikyu"), new RString("主治医意見書作成報酬請求書")),
    /**
     * 主治医意見書作成報酬支払明細書の帳票ＩＤです。
     */
    DBE622001(new ReportId("DBE622001_ShujiiHoshumeisai"), new RString("主治医意見書作成報酬支払明細書")),
    /**
     * 主治医意見書作成料支払内訳確認書の帳票ＩＤです。
     */
    DBE622004(new ReportId("DBE622004_IkenChosaShiharaiuchiwakeMeisai"), new RString("主治医意見書作成料支払内訳確認書")),
    /**
     * 要介護認定結果情報提供票（主治医）の帳票ID。
     */
    DBE090001(new ReportId("DBE090001_JohoTeikyoShiryo"), new RString("要介護認定結果情報提供票（主治医）")),
    /**
     * 主治医意見書作成実績集計表の帳票ID。
     */
    DBE601001(new ReportId("DBE601001_IkenshoJissekiIchiran"), new RString("主治医意見書作成実績集計表")),
    /**
     * 認定調査報酬請求書の帳票ID。
     */
    DBE621005(new ReportId("DBE621005_chosahoshuseikyu"), new RString("認定調査報酬請求書")),
    /**
     * 認定調査報酬支払明細書の帳票ID。
     */
    DBE622002(new ReportId("DBE622002_ChosaHoshumeisai"), new RString("認定調査報酬支払明細書")),
    /**
     * 介護認定審査会委員報酬支払明細書の帳票ID。
     */
    DBE622003(new ReportId("DBE622003_ShinsainShiharaimeisaisho"), new RString("介護認定審査会委員報酬支払明細書")),
    /**
     * 主治医意見書作成依頼履歴一覧表の帳票ID。
     */
    DBE230004(new ReportId("DBE230004_IkenshoirairirekiIchiran"), new RString("主治医意見書作成依頼履歴一覧表")),
    /**
     * 介護認定審査委員報酬・費用弁償等支払明細書の帳票ID。
     */
    DBE622006(new ReportId("DBE622006_HiyobenshotoShiharaimeisaisho"), new RString("介護認定審査委員報酬・費用弁償等支払明細書")),
    /**
     * 介護認定審査会委員報酬支払通知書の帳票ID。
     */
    DBE621001(new ReportId("DBE621001_iinhoshushiharai"), new RString("介護認定審査会委員報酬支払通知書")),
    /**
     * 要介護認定調査票（概況特記）の帳票ID。
     */
    DBE221051(new ReportId("DBE221051_GaikyotokkiA4"), new RString("要介護認定調査票（概況特記）")),
    /**
     * 帳票出力用認定調査実績集計表の帳票ID。
     */
    DBE601002(new ReportId("DBE601002_ChosahyoJissekiIchiran"), new RString("帳票出力用認定調査実績集計表")),
    /**
     * 介護認定審査会委員実績集計表の帳票ID。
     */
    DBE601003(new ReportId("DBE601003_ShinsaiinJissekiIchiran"), new RString("介護認定審査会委員実績集計表")),
    /**
     * 意見書作成報酬照会の帳票ID。
     */
    DBE601004(new ReportId("DBE601004_ikenhoshuichiran"), new RString("主治医意見書作成報酬一覧表")),
    /**
     * 介護認定審査会委員報酬一覧表の帳票ID。
     */
    DBE601005(new ReportId("DBE601005_shinsahoshuichiran"), new RString("介護認定審査会委員報酬一覧表"));

    private final ReportId reportId;

    private final RString reportName;

    private ReportIdDBE(ReportId reportId, RString reportName) {
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
