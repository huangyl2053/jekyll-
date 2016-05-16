/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(高額介護サービス費状況)のCSVEntityです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyouRisutoSyuturyokuEucCsvEntity {

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
    private RString 住所と番地と方書;
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
    private RString 前住所と番地と方書;
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
    @CsvField(order = 450, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 460, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 470, name = "送付先住所コード")
    private RString 送付先住所コード;
    @CsvField(order = 480, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 490, name = "送付先住所＋番地＋方書")
    private RString 送付先住所と番地と方書;
    @CsvField(order = 500, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 510, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 520, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 530, name = "送付先行政区コード")
    private RString 送付先行政区コード;
    @CsvField(order = 540, name = "送付先行政区名")
    private RString 送付先行政区名;
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
    @CsvField(order = 650, name = "指定事業者コード")
    private RString 指定事業者コード;
    @CsvField(order = 660, name = "施設入所日")
    private RString 施設入所日;
    @CsvField(order = 670, name = "施設退所日")
    private RString 施設退所日;
    @CsvField(order = 680, name = "指定事業者名")
    private RString 指定事業者名;
    @CsvField(order = 690, name = "指定事業者名カナ")
    private RString 指定事業者名カナ;
    @CsvField(order = 700, name = "指定事業者郵便番号")
    private RString 指定事業者郵便番号;
    @CsvField(order = 710, name = "指定事業者住所")
    private RString 指定事業者住所;
    @CsvField(order = 720, name = "指定事業者代表者名")
    private RString 指定事業者代表者名;
    @CsvField(order = 730, name = "指定事業者代表者名カナ")
    private RString 指定事業者代表者名カナ;
    @CsvField(order = 740, name = "指定事業者代表者役職")
    private RString 指定事業者代表者役職;
    @CsvField(order = 750, name = "指定事業者電話番号")
    private RString 指定事業者電話番号;
    @CsvField(order = 760, name = "指定事業者ＦＡＸ番号")
    private RString 指定事業者ＦＡＸ番号;
    @CsvField(order = 770, name = "指定事業者ケアマネ数")
    private RString 指定事業者ケアマネ数;
    @CsvField(order = 780, name = "指定事業者利用者数")
    private RString 指定事業者利用者数;
    @CsvField(order = 790, name = "指定事業者認定日")
    private RString 指定事業者認定日;
    @CsvField(order = 800, name = "指定事業者取消日")
    private RString 指定事業者取消日;
    @CsvField(order = 810, name = "指定事業者実施地域")
    private RString 指定事業者実施地域;
    @CsvField(order = 820, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 830, name = "支払開始日")
    private RString 支払開始日;
    @CsvField(order = 840, name = "支払終了日")
    private RString 支払終了日;
    @CsvField(order = 850, name = "支払開始曜日")
    private RString 支払開始曜日;
    @CsvField(order = 860, name = "支払終了曜日")
    private RString 支払終了曜日;
    @CsvField(order = 870, name = "支払開始時間")
    private RString 支払開始時間;
    @CsvField(order = 880, name = "支払終了時間")
    private RString 支払終了時間;
    @CsvField(order = 890, name = "銀行郵便区分")
    private RString 銀行郵便区分;
    @CsvField(order = 900, name = "銀行コード")
    private RString 銀行コード;
    @CsvField(order = 910, name = "支店コード")
    private RString 支店コード;
    @CsvField(order = 920, name = "銀行名カナ")
    private RString 銀行名カナ;
    @CsvField(order = 930, name = "銀行名")
    private RString 銀行名;
    @CsvField(order = 940, name = "支店名カナ")
    private RString 支店名カナ;
    @CsvField(order = 950, name = "支店名")
    private RString 支店名;
    @CsvField(order = 960, name = "口座種目")
    private RString 口座種目;
    @CsvField(order = 970, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 980, name = "名義人カナ（短）")
    private RString 名義人カナ短;
    @CsvField(order = 990, name = "名義人（短）")
    private RString 名義人短;
    @CsvField(order = 1000, name = "名義人カナ")
    private RString 名義人カナ;
    @CsvField(order = 1010, name = "名義人")
    private RString 名義人;
    @CsvField(order = 1020, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 1030, name = "管理番号")
    private RString 管理番号;
    @CsvField(order = 1040, name = "（給付）証記載保険者番号")
    private RString 給付証記載保険者番号;
    @CsvField(order = 1050, name = "申請日")
    private RString 申請日;
    @CsvField(order = 1060, name = "申請理由")
    private RString 申請理由;
    @CsvField(order = 1070, name = "申請区分")
    private RString 申請区分;
    @CsvField(order = 1080, name = "申請氏名")
    private RString 申請氏名;
    @CsvField(order = 1090, name = "申請氏名カナ")
    private RString 申請氏名カナ;
    @CsvField(order = 1100, name = "申請電話番号")
    private RString 申請電話番号;
    @CsvField(order = 1110, name = "申請支払額")
    private RString 申請支払額;
    @CsvField(order = 1120, name = "判定費用額")
    private RString 判定費用額;
    @CsvField(order = 1130, name = "判定利用負担額")
    private RString 判定利用負担額;
    @CsvField(order = 1140, name = "判定算定基準額")
    private RString 判定算定基準額;
    @CsvField(order = 1150, name = "判定支払済金額")
    private RString 判定支払済金額;
    @CsvField(order = 1160, name = "判定高額支給額")
    private RString 判定高額支給額;
    @CsvField(order = 1170, name = "受付日")
    private RString 受付日;
    @CsvField(order = 1180, name = "決定日")
    private RString 決定日;
    @CsvField(order = 1190, name = "保決定利用負担額")
    private RString 保決定利用負担額;
    @CsvField(order = 1200, name = "保決定支給区分")
    private RString 保決定支給区分;
    @CsvField(order = 1210, name = "保決定高額支給額")
    private RString 保決定高額支給額;
    @CsvField(order = 1220, name = "保決定不支給理由")
    private RString 保決定不支給理由;
    @CsvField(order = 1230, name = "審査方法")
    private RString 審査方法;
    @CsvField(order = 1240, name = "国決定通知書ＮＯ")
    private RString 国決定通知書ＮＯ;
    @CsvField(order = 1250, name = "国決定利用負担額")
    private RString 国決定利用負担額;
    @CsvField(order = 1260, name = "国決定支給区分")
    private RString 国決定支給区分;
    @CsvField(order = 1270, name = "国決定年月")
    private RString 国決定年月;
    @CsvField(order = 1280, name = "国決定高額支給額")
    private RString 国決定高額支給額;
    @CsvField(order = 1290, name = "判定受取年月")
    private RString 判定受取年月;
    @CsvField(order = 1300, name = "保決定送付年月")
    private RString 保決定送付年月;
    @CsvField(order = 1310, name = "国決定受取年月")
    private RString 国決定受取年月;
    @CsvField(order = 1320, name = "高額対象判定年月")
    private RString 高額対象判定年月;
    @CsvField(order = 1330, name = "通知書作成日")
    private RString 通知書作成日;
    @CsvField(order = 1340, name = "振込書作成日")
    private RString 振込書作成日;
    @CsvField(order = 1350, name = "支払方法")
    private RString 支払方法;
    @CsvField(order = 1360, name = "備考（算定基準）")
    private RString 備考算定基準;
    @CsvField(order = 1370, name = "国保連委託なし")
    private RString 国保連委託なし;
    @CsvField(order = 1380, name = "高額自動償還")
    private RString 高額自動償還;
    @CsvField(order = 1390, name = "利用者負担段階")
    private RString 利用者負担段階;
    @CsvField(order = 1400, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 1410, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 1420, name = "受給要介護度")
    private RString 受給要介護度;
    @CsvField(order = 1430, name = "受給認定開始日")
    private RString 受給認定開始日;
    @CsvField(order = 1440, name = "受給認定終了日")
    private RString 受給認定終了日;
    @CsvField(order = 1450, name = "受給認定日")
    private RString 受給認定日;
    @CsvField(order = 1460, name = "受給旧措置")
    private RString 受給旧措置;
    @CsvField(order = 1470, name = "受給みなし更新認定")
    private RString 受給みなし更新認定;
    @CsvField(order = 1480, name = "受給直近事由")
    private RString 受給直近事由;
}
