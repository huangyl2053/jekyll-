/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassanshikyugakukettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算支給額決定情報)CSVEntityクラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanShikyugakuKetteiCSVEntity {

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
    @CsvField(order = 140, name = "住所番地方書")
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
    @CsvField(order = 360, name = "前住所番地方書")
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
    @CsvField(order = 450, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 460, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 470, name = "送付先住所コード")
    private RString 送付先住所コード;
    @CsvField(order = 480, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 490, name = "送付先住所番地方書")
    private RString 送付先住所番地方書;
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
    @CsvField(order = 610, name = "資格喪失届出日")
    private RString 資格喪失届出日;
    @CsvField(order = 620, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 630, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 640, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 650, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 660, name = "受給要介護度")
    private RString 受給要介護度;
    @CsvField(order = 670, name = "受給認定開始日")
    private RString 受給認定開始日;
    @CsvField(order = 680, name = "受給認定終了日")
    private RString 受給認定終了日;
    @CsvField(order = 690, name = "受給認定日")
    private RString 受給認定日;
    @CsvField(order = 700, name = "受給旧措置")
    private RString 受給旧措置;
    @CsvField(order = 710, name = "受給みなし更新認定")
    private RString 受給みなし更新認定;
    @CsvField(order = 720, name = "受給直近事由")
    private RString 受給直近事由;
    @CsvField(order = 730, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 740, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 750, name = "連絡票整理番号")
    private RString 連絡票整理番号;
    @CsvField(order = 760, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 770, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 780, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 790, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 800, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 810, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 820, name = "自己負担総額")
    private RString 自己負担総額;
    @CsvField(order = 830, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 840, name = "支給額")
    private RString 支給額;
    @CsvField(order = 850, name = "給付の種類")
    private RString 給付の種類;
    @CsvField(order = 860, name = "不支給理由")
    private RString 不支給理由;
    @CsvField(order = 870, name = "支払方法区分")
    private RString 支払方法区分;
    @CsvField(order = 880, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 890, name = "支払期間開始年月日")
    private RString 支払期間開始年月日;
    @CsvField(order = 900, name = "支払期間終了年月日")
    private RString 支払期間終了年月日;
    @CsvField(order = 910, name = "支払期間開始年月日(曜日)")
    private RString 支払期間開始年月日_曜日;
    @CsvField(order = 920, name = "支払期間終了年月日(曜日)")
    private RString 支払期間終了年月日_曜日;
    @CsvField(order = 930, name = "支払期間開始年月日(時間)")
    private RString 支払期間開始年月日_時間;
    @CsvField(order = 940, name = "支払期間終了年月日(時間)")
    private RString 支払期間終了年月日_時間;
    @CsvField(order = 950, name = "金融機関コード")
    private RString 金融機関コード;
    @CsvField(order = 960, name = "金融機関名")
    private RString 金融機関名;
    @CsvField(order = 970, name = "金融機関支店コード")
    private RString 金融機関支店コード;
    @CsvField(order = 980, name = "金融機関支店名")
    private RString 金融機関支店名;
    @CsvField(order = 990, name = "口座種目名")
    private RString 口座種目名;
    @CsvField(order = 1000, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 1010, name = "口座名義人（カナ）")
    private RString 口座名義人_カナ;
    @CsvField(order = 1020, name = "決定通知書作成年月日")
    private RString 決定通知書作成年月日;
    @CsvField(order = 1030, name = "振込通知書作成年月日")
    private RString 振込通知書作成年月日;
    @CsvField(order = 1040, name = "受取年月")
    private RString 受取年月;
    @CsvField(order = 1050, name = "給付の種類(短)")
    private RString 給付の種類_短;
    @CsvField(order = 1060, name = "不支給理由(短)")
    private RString 不支給理由_短;
    @CsvField(order = 1070, name = "支払場所(短)")
    private RString 支払場所_短;

}
