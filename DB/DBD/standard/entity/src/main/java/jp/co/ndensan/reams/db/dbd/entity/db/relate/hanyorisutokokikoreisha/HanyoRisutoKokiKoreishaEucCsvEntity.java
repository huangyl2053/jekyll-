/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokikoreisha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 汎用リスト出力(後期高齢者)CSV用データEntity。
 *
 * @reamsid_L DBD-5520-030 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoKokiKoreishaEucCsvEntity {

    @CsvField(order = 10, name = "連番")
    private RString 連番;
    @CsvField(order = 20, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 30, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 40, name = "氏名")
    private RString 氏名;
    @CsvField(order = 50, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 60, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 70, name = "年齢")
    private RString 年齢;
    @CsvField(order = 80, name = "性別")
    private RString 性別;
    @CsvField(order = 90, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 100, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 110, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 120, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 130, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 140, name = "住所＋番地＋方書")
    private RString 住所番地方書;
    @CsvField(order = 150, name = "住所")
    private RString 住所;
    @CsvField(order = 160, name = "番地")
    private RString 番地;
    @CsvField(order = 170, name = "方書")
    private RString 方書;
    @CsvField(order = 180, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 190, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 200, name = "地区１")
    private RString 地区１;
    @CsvField(order = 210, name = "地区２")
    private RString 地区２;
    @CsvField(order = 220, name = "地区３")
    private RString 地区３;
    @CsvField(order = 230, name = "連絡先１")
    private RString 連絡先１;
    @CsvField(order = 240, name = "連絡先２")
    private RString 連絡先２;
    @CsvField(order = 250, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 260, name = "登録事由")
    private RString 登録事由;
    @CsvField(order = 270, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 280, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 290, name = "住定事由")
    private RString 住定事由;
    @CsvField(order = 300, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 310, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 320, name = "消除事由")
    private RString 消除事由;
    @CsvField(order = 330, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 340, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 350, name = "前住所郵便番号")
    private RString 前住所郵便番号;
    @CsvField(order = 360, name = "前住所＋番地＋方書")
    private RString 前住所番地方書;
    @CsvField(order = 370, name = "前住所")
    private RString 前住所;
    @CsvField(order = 380, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 390, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 400, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 410, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 420, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 430, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 440, name = "空白")
    private RString 空白;
    @CsvField(order = 550, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 560, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 570, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 580, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 590, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 600, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 610, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 620, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 630, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 640, name = "（資格）証記載保険者番号")
    private RString 資格証記載保険者番号;
    @CsvField(order = 650, name = "医療保険種別")
    private RString 医療保険種別;
    @CsvField(order = 660, name = "医療保険番号")
    private RString 医療保険番号;
    @CsvField(order = 670, name = "医療保険者名")
    private RString 医療保険者名;
    @CsvField(order = 680, name = "医療保険記号番号")
    private RString 医療保険記号番号;
    @CsvField(order = 690, name = "特定疾病")
    private RString 特定疾病;
    @CsvField(order = 700, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 710, name = "申請理由")
    private RString 申請理由;
    @CsvField(order = 720, name = "申請関係者")
    private RString 申請関係者;
    @CsvField(order = 730, name = "本人関係")
    private RString 本人関係;
    @CsvField(order = 740, name = "申請氏名")
    private RString 申請氏名;
    @CsvField(order = 750, name = "申請氏名カナ")
    private RString 申請氏名カナ;
    @CsvField(order = 760, name = "申請代行事業者名")
    private RString 申請代行事業者名;
    @CsvField(order = 770, name = "申請代行事業者名カナ")
    private RString 申請代行事業者名カナ;
    @CsvField(order = 780, name = "申請者郵便番号")
    private RString 申請者郵便番号;
    @CsvField(order = 790, name = "申請住所")
    private RString 申請住所;
    @CsvField(order = 800, name = "申請連絡先")
    private RString 申請連絡先;
    @CsvField(order = 810, name = "申請事業コード")
    private RString 申請事業コード;
    @CsvField(order = 820, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 830, name = "調査委託先コード")
    private RString 調査委託先コード;
    @CsvField(order = 840, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 850, name = "委託先名")
    private RString 委託先名;
    @CsvField(order = 860, name = "委託先名カナ")
    private RString 委託先名カナ;
    @CsvField(order = 870, name = "委託先代表者名")
    private RString 委託先代表者名;
    @CsvField(order = 880, name = "委託先代表者名カナ")
    private RString 委託先代表者名カナ;
    @CsvField(order = 890, name = "委託先郵便番号")
    private RString 委託先郵便番号;
    @CsvField(order = 900, name = "委託先住所")
    private RString 委託先住所;
    @CsvField(order = 910, name = "委託先連絡先")
    private RString 委託先連絡先;
    @CsvField(order = 920, name = "委託先状況")
    private RString 委託先状況;
    @CsvField(order = 930, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 940, name = "調査員氏名カナ")
    private RString 調査員氏名カナ;
    @CsvField(order = 950, name = "調査員性別")
    private RString 調査員性別;
    @CsvField(order = 960, name = "調査員郵便")
    private RString 調査員郵便;
    @CsvField(order = 970, name = "調査員住所")
    private RString 調査員住所;
    @CsvField(order = 980, name = "調査員連絡先")
    private RString 調査員連絡先;
    @CsvField(order = 990, name = "調査員資格")
    private RString 調査員資格;
    @CsvField(order = 1000, name = "調査員所属機関名")
    private RString 調査員所属機関名;
    @CsvField(order = 1010, name = "調査員状況")
    private RString 調査員状況;
    @CsvField(order = 1020, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 1030, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 1040, name = "医療機関名称")
    private RString 医療機関名称;
    @CsvField(order = 1050, name = "医療機関名称カナ")
    private RString 医療機関名称カナ;
    @CsvField(order = 1060, name = "医療機関代表者名")
    private RString 医療機関代表者名;
    @CsvField(order = 1070, name = "医療機関代表者名カナ")
    private RString 医療機関代表者名カナ;
    @CsvField(order = 1080, name = "医療機関郵便番号")
    private RString 医療機関郵便番号;
    @CsvField(order = 1090, name = "医療機関住所")
    private RString 医療機関住所;
    @CsvField(order = 1100, name = "医療機関連絡先")
    private RString 医療機関連絡先;
    @CsvField(order = 1110, name = "医療機関状況")
    private RString 医療機関状況;
    @CsvField(order = 1120, name = "主治医名")
    private RString 主治医名;
    @CsvField(order = 1130, name = "主治医名カナ")
    private RString 主治医名カナ;
    @CsvField(order = 1140, name = "主治医性別")
    private RString 主治医性別;
    @CsvField(order = 1150, name = "主治医所属")
    private RString 主治医所属;
    @CsvField(order = 1160, name = "主治医状況")
    private RString 主治医状況;
    @CsvField(order = 1170, name = "一次判定要介護度")
    private RString 一次判定要介護度;
    @CsvField(order = 1180, name = "調査委託日")
    private RString 調査委託日;
    @CsvField(order = 1190, name = "調査予定日")
    private RString 調査予定日;
    @CsvField(order = 1200, name = "調査終了日")
    private RString 調査終了日;
    @CsvField(order = 1210, name = "意見依頼日")
    private RString 意見依頼日;
    @CsvField(order = 1220, name = "意見予定日")
    private RString 意見予定日;
    @CsvField(order = 1230, name = "意見取寄日")
    private RString 意見取寄日;
    @CsvField(order = 1240, name = "資料作成日")
    private RString 資料作成日;
    @CsvField(order = 1250, name = "審査予定日")
    private RString 審査予定日;
    @CsvField(order = 1260, name = "審査回答日")
    private RString 審査回答日;
    @CsvField(order = 1270, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 1280, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 1290, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 1300, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 1310, name = "認定日")
    private RString 認定日;
    @CsvField(order = 1320, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 1330, name = "みなし更新認定")
    private RString みなし更新認定;
    @CsvField(order = 1340, name = "審査会意見")
    private RString 審査会意見;
    @CsvField(order = 1350, name = "指定サービス種類")
    private RString 指定サービス種類;
    @CsvField(order = 1360, name = "受給喪失日")
    private RString 受給喪失日;
    @CsvField(order = 1370, name = "直近事由")
    private RString 直近事由;
    @CsvField(order = 1380, name = "受給状況")
    private RString 受給状況;
    @CsvField(order = 1390, name = "異動事由コード")
    private RString 異動事由コード;
    @CsvField(order = 1400, name = "異動事由追加文")
    private RString 異動事由追加文;
    @CsvField(order = 1410, name = "削除理由コード")
    private RString 削除理由コード;
    @CsvField(order = 1420, name = "異動事由文言")
    private RString 異動事由文言;
    @CsvField(order = 1430, name = "削除理由文言")
    private RString 削除理由文言;
    @CsvField(order = 1440, name = "支援申請区分")
    private RString 支援申請区分;
    @CsvField(order = 1450, name = "初回申請日")
    private RString 初回申請日;
    @CsvField(order = 1460, name = "初回認定日")
    private RString 初回認定日;
    @CsvField(order = 1470, name = "初回要介護度")
    private RString 初回要介護度;
    @CsvField(order = 1480, name = "初回認定開始日")
    private RString 初回認定開始日;
    @CsvField(order = 1490, name = "初回認定終了日")
    private RString 初回認定終了日;
    @CsvField(order = 1500, name = "初回申請事由")
    private RString 初回申請事由;
    @CsvField(order = 1510, name = "初回みなし更新")
    private RString 初回みなし更新;
    @CsvField(order = 1520, name = "初回当初認定有効開始日")
    private RString 初回当初認定有効開始日;
    @CsvField(order = 1530, name = "初回当初認定有効終了日")
    private RString 初回当初認定有効終了日;
    @CsvField(order = 1540, name = "初回支援申請事由")
    private RString 初回支援申請事由;
    @CsvField(order = 1550, name = "前回申請日")
    private RString 前回申請日;
    @CsvField(order = 1560, name = "前回認定日")
    private RString 前回認定日;
    @CsvField(order = 1570, name = "前回要介護度")
    private RString 前回要介護度;
    @CsvField(order = 1580, name = "前回認定開始日")
    private RString 前回認定開始日;
    @CsvField(order = 1590, name = "前回認定終了日")
    private RString 前回認定終了日;
    @CsvField(order = 1600, name = "前回受給申請事由")
    private RString 前回受給申請事由;
    @CsvField(order = 1610, name = "前回みなし更新")
    private RString 前回みなし更新;
    @CsvField(order = 1620, name = "前回当初認定有効開始日")
    private RString 前回当初認定有効開始日;
    @CsvField(order = 1630, name = "前回当初認定有効終了日")
    private RString 前回当初認定有効終了日;
    @CsvField(order = 1640, name = "前回支援申請事由")
    private RString 前回支援申請事由;
    @CsvField(order = 1690, name = "前々回申請日")
    private RString 前々回申請日;
    @CsvField(order = 1700, name = "前々回認定日")
    private RString 前々回認定日;
    @CsvField(order = 1710, name = "前々回要介護度")
    private RString 前々回要介護度;
    @CsvField(order = 1720, name = "前々回認定開始日")
    private RString 前々回認定開始日;
    @CsvField(order = 1730, name = "前々回認定終了日")
    private RString 前々回認定終了日;
    @CsvField(order = 1740, name = "前々回受給申請事由")
    private RString 前々回受給申請事由;
    @CsvField(order = 1750, name = "前々回みなし更新")
    private RString 前々回みなし更新;
    @CsvField(order = 1760, name = "前々回当初認定有効開始日")
    private RString 前々回当初認定有効開始日;
    @CsvField(order = 1770, name = "前々回当初認定有効終了日")
    private RString 前々回当初認定有効終了日;
    @CsvField(order = 1780, name = "前々回支援申請事由")
    private RString 前々回支援申請事由;
    @CsvField(order = 1830, name = "障害高齢者自立度")
    private RString 障害高齢者自立度;
    @CsvField(order = 1840, name = "認知症高齢者自立度")
    private RString 認知症高齢者自立度;
    @CsvField(order = 1850, name = "訪問支給限度額単位数")
    private RString 訪問支給限度額単位数;
    @CsvField(order = 1860, name = "訪問支給限度有効開始年月日")
    private RString 訪問支給限度有効開始年月日;
    @CsvField(order = 1870, name = "訪問支給限度有効終了年月日")
    private RString 訪問支給限度有効終了年月日;
    @CsvField(order = 1880, name = "短期入所支給限度日数")
    private RString 短期入所支給限度日数;
    @CsvField(order = 1890, name = "短期入所支給限度有効開始年月日")
    private RString 短期入所支給限度有効開始年月日;
    @CsvField(order = 1900, name = "短期入所支給限度有効終了年月日")
    private RString 短期入所支給限度有効終了年月日;
    @CsvField(order = 1910, name = "当初認定有効開始年月日")
    private RString 当初認定有効開始年月日;
    @CsvField(order = 1920, name = "当初認定有効終了年月日")
    private RString 当初認定有効終了年月日;
    @CsvField(order = 1930, name = "認定延期通知書発行年月日")
    private RString 認定延期通知書発行年月日;
    @CsvField(order = 1940, name = "認定延期通知書発行回数")
    private RString 認定延期通知書発行回数;
    @CsvField(order = 1950, name = "延期処理見込み開始年月日")
    private RString 延期処理見込み開始年月日;
    @CsvField(order = 1960, name = "延期処理見込み終了年月日")
    private RString 延期処理見込み終了年月日;
    @CsvField(order = 1970, name = "受給資格証明書発行日１")
    private RString 受給資格証明書発行日１;
    @CsvField(order = 1980, name = "受給資格証明書発行日２")
    private RString 受給資格証明書発行日２;
    @CsvField(order = 1990, name = "資格取得前申請区分")
    private RString 資格取得前申請区分;
    @CsvField(order = 2000, name = "一次判定結果（重み）")
    private RString 一次判定結果重み;
    @CsvField(order = 2010, name = "指定医区分")
    private RString 指定医区分;
    @CsvField(order = 2020, name = "訪問調査先郵便番号")
    private RString 訪問調査先郵便番号;
    @CsvField(order = 2030, name = "訪問調査先住所")
    private RString 訪問調査先住所;
    @CsvField(order = 2040, name = "訪問調査先名称")
    private RString 訪問調査先名称;
    @CsvField(order = 2050, name = "訪問調査先電話番号")
    private RString 訪問調査先電話番号;
    @CsvField(order = 2270, name = "後期保険者番号")
    private RString 後期保険者番号;
    @CsvField(order = 2280, name = "後期被保険者番号")
    private RString 後期被保険者番号;
    @CsvField(order = 2290, name = "後期取得日")
    private RString 後期取得日;
    @CsvField(order = 2300, name = "後期喪失日")
    private RString 後期喪失日;
    @CsvField(order = 2310, name = "後期登録区分")
    private RString 後期登録区分;
    @CsvField(order = 2430, name = "届出区分")
    private RString 届出区分;
    @CsvField(order = 2440, name = "居宅計画作成区分")
    private RString 居宅計画作成区分;
    @CsvField(order = 2450, name = "計画事業者番号")
    private RString 計画事業者番号;
    @CsvField(order = 2460, name = "計画事業者名")
    private RString 計画事業者名;
    @CsvField(order = 2470, name = "計画事業者カナ")
    private RString 計画事業者カナ;
    @CsvField(order = 2480, name = "計画管理者名")
    private RString 計画管理者名;
    @CsvField(order = 2490, name = "計画管理者カナ")
    private RString 計画管理者カナ;
    @CsvField(order = 2500, name = "計画適用開始日")
    private RString 計画適用開始日;
    @CsvField(order = 2510, name = "計画適用終了日")
    private RString 計画適用終了日;
    @CsvField(order = 2520, name = "計画届出日")
    private RString 計画届出日;
    @CsvField(order = 2530, name = "計画作成日")
    private RString 計画作成日;
    @CsvField(order = 2540, name = "計画変更日")
    private RString 計画変更日;
    @CsvField(order = 2550, name = "変更理由")
    private RString 変更理由;
}
