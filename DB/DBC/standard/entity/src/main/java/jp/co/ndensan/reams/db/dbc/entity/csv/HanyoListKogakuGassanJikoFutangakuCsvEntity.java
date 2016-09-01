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
 * 汎用リスト出力(高額合算自己負担額情報)のCSVEntityです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanJikoFutangakuCsvEntity {

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
    @CsvField(order = 750, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 760, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 770, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 780, name = "70歳以上の者に係る所得区分")
    private RString 所得区分_70歳以上;
    @CsvField(order = 790, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 800, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 810, name = "補正済自己負担額送付区分")
    private RString 補正済自己負担額送付区分;
    @CsvField(order = 820, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 830, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 840, name = "被保険者期間（開始）")
    private RString 被保険者期間_開始;
    @CsvField(order = 850, name = "被保険者期間（終了）")
    private RString 被保険者期間_終了;
    @CsvField(order = 860, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 870, name = "当０４・自己負担額")
    private RString 当０４_自己負担額;
    @CsvField(order = 880, name = "当０４・７０－７４")
    private RString 当０４_７０_７４;
    @CsvField(order = 890, name = "当０４・高額支給額")
    private RString 当０４_高額支給額;
    @CsvField(order = 900, name = "当０５・自己負担額")
    private RString 当０５_自己負担額;
    @CsvField(order = 910, name = "当０５・７０－７４")
    private RString 当０５_７０_７４;
    @CsvField(order = 920, name = "当０５・高額支給額")
    private RString 当０５_高額支給額;
    @CsvField(order = 930, name = "当０６・自己負担額")
    private RString 当０６_自己負担額;
    @CsvField(order = 940, name = "当０６・７０－７４")
    private RString 当０６_７０_７４;
    @CsvField(order = 950, name = "当０６・高額支給額")
    private RString 当０６_高額支給額;
    @CsvField(order = 960, name = "当０７・自己負担額")
    private RString 当０７_自己負担額;
    @CsvField(order = 970, name = "当０７・７０－７４")
    private RString 当０７_７０_７４;
    @CsvField(order = 980, name = "当０７・高額支給額")
    private RString 当０７_高額支給額;
    @CsvField(order = 990, name = "当０８・自己負担額")
    private RString 当０８_自己負担額;
    @CsvField(order = 1000, name = "当０８・７０－７４")
    private RString 当０８_７０_７４;
    @CsvField(order = 1010, name = "当０８・高額支給額")
    private RString 当０８_高額支給額;
    @CsvField(order = 1020, name = "当０９・自己負担額")
    private RString 当０９_自己負担額;
    @CsvField(order = 1030, name = "当０９・７０－７４")
    private RString 当０９_７０_７４;
    @CsvField(order = 1040, name = "当０９・高額支給額")
    private RString 当０９_高額支給額;
    @CsvField(order = 1050, name = "当１０・自己負担額")
    private RString 当１０_自己負担額;
    @CsvField(order = 1060, name = "当１０・７０－７４")
    private RString 当１０_７０_７４;
    @CsvField(order = 1070, name = "当１０・高額支給額")
    private RString 当１０_高額支給額;
    @CsvField(order = 1080, name = "当１１・自己負担額")
    private RString 当１１_自己負担額;
    @CsvField(order = 1090, name = "当１１・７０－７４")
    private RString 当１１_７０_７４;
    @CsvField(order = 1100, name = "当１１・高額支給額")
    private RString 当１１_高額支給額;
    @CsvField(order = 1110, name = "当１２・自己負担額")
    private RString 当１２_自己負担額;
    @CsvField(order = 1120, name = "当１２・７０－７４")
    private RString 当１２_７０_７４;
    @CsvField(order = 1130, name = "当１２・高額支給額")
    private RString 当１２_高額支給額;
    @CsvField(order = 1140, name = "翌０１・自己負担額")
    private RString 翌０１_自己負担額;
    @CsvField(order = 1150, name = "翌０１・７０－７４")
    private RString 翌０１_７０_７４;
    @CsvField(order = 1160, name = "翌０１・高額支給額")
    private RString 翌０１_高額支給額;
    @CsvField(order = 1170, name = "翌０２・自己負担額")
    private RString 翌０２_自己負担額;
    @CsvField(order = 1180, name = "翌０２・７０－７４")
    private RString 翌０２_７０_７４;
    @CsvField(order = 1190, name = "翌０２・高額支給額")
    private RString 翌０２_高額支給額;
    @CsvField(order = 1200, name = "翌０３・自己負担額")
    private RString 翌０３_自己負担額;
    @CsvField(order = 1210, name = "翌０３・７０－７４")
    private RString 翌０３_７０_７４;
    @CsvField(order = 1220, name = "翌０３・高額支給額")
    private RString 翌０３_高額支給額;
    @CsvField(order = 1230, name = "翌０４・自己負担額")
    private RString 翌０４_自己負担額;
    @CsvField(order = 1240, name = "翌０４・７０－７４")
    private RString 翌０４_７０_７４;
    @CsvField(order = 1250, name = "翌０４・高額支給額")
    private RString 翌０４_高額支給額;
    @CsvField(order = 1260, name = "翌０５・自己負担額")
    private RString 翌０５_自己負担額;
    @CsvField(order = 1270, name = "翌０５・７０－７４")
    private RString 翌０５_７０_７４;
    @CsvField(order = 1280, name = "翌０５・高額支給額")
    private RString 翌０５_高額支給額;
    @CsvField(order = 1290, name = "翌０６・自己負担額")
    private RString 翌０６_自己負担額;
    @CsvField(order = 1300, name = "翌０６・７０－７４")
    private RString 翌０６_７０_７４;
    @CsvField(order = 1310, name = "翌０６・高額支給額")
    private RString 翌０６_高額支給額;
    @CsvField(order = 1320, name = "翌０７・自己負担額")
    private RString 翌０７_自己負担額;
    @CsvField(order = 1330, name = "翌０７・７０－７４")
    private RString 翌０７_７０_７４;
    @CsvField(order = 1340, name = "翌０７・高額支給額")
    private RString 翌０７_高額支給額;
    @CsvField(order = 1350, name = "合計・自己負担額")
    private RString 合計_自己負担額;
    @CsvField(order = 1360, name = "合計・７０－７４")
    private RString 合計_７０_７４;
    @CsvField(order = 1370, name = "合計・高額支給額")
    private RString 合計_高額支給額;
    @CsvField(order = 1380, name = "補当０４・自己負担額")
    private RString 補当０４_自己負担額;
    @CsvField(order = 1390, name = "補当０４・７０－７４")
    private RString 補当０４_７０_７４;
    @CsvField(order = 1400, name = "補当０４・高額支給額")
    private RString 補当０４_高額支給額;
    @CsvField(order = 1410, name = "補当０５・自己負担額")
    private RString 補当０５_自己負担額;
    @CsvField(order = 1420, name = "補当０５・７０－７４")
    private RString 補当０５_７０_７４;
    @CsvField(order = 1430, name = "補当０５・高額支給額")
    private RString 補当０５_高額支給額;
    @CsvField(order = 1440, name = "補当０６・自己負担額")
    private RString 補当０６_自己負担額;
    @CsvField(order = 1450, name = "補当０６・７０－７４")
    private RString 補当０６_７０_７４;
    @CsvField(order = 1460, name = "補当０６・高額支給額")
    private RString 補当０６_高額支給額;
    @CsvField(order = 1470, name = "補当０７・自己負担額")
    private RString 補当０７_自己負担額;
    @CsvField(order = 1480, name = "補当０７・７０－７４")
    private RString 補当０７_７０_７４;
    @CsvField(order = 1490, name = "補当０７・高額支給額")
    private RString 補当０７_高額支給額;
    @CsvField(order = 1500, name = "補当０８・自己負担額")
    private RString 補当０８_自己負担額;
    @CsvField(order = 1510, name = "補当０８・７０－７４")
    private RString 補当０８_７０_７４;
    @CsvField(order = 1520, name = "補当０８・高額支給額")
    private RString 補当０８_高額支給額;
    @CsvField(order = 1530, name = "補当０９・自己負担額")
    private RString 補当０９_自己負担額;
    @CsvField(order = 1540, name = "補当０９・７０－７４")
    private RString 補当０９_７０_７４;
    @CsvField(order = 1550, name = "補当０９・高額支給額")
    private RString 補当０９_高額支給額;
    @CsvField(order = 1560, name = "補当１０・自己負担額")
    private RString 補当１０_自己負担額;
    @CsvField(order = 1570, name = "補当１０・７０－７４")
    private RString 補当１０_７０_７４;
    @CsvField(order = 1580, name = "補当１０・高額支給額")
    private RString 補当１０_高額支給額;
    @CsvField(order = 1590, name = "補当１１・自己負担額")
    private RString 補当１１_自己負担額;
    @CsvField(order = 1600, name = "補当１１・７０－７４")
    private RString 補当１１_７０_７４;
    @CsvField(order = 1610, name = "補当１１・高額支給額")
    private RString 補当１１_高額支給額;
    @CsvField(order = 1620, name = "補当１２・自己負担額")
    private RString 補当１２_自己負担額;
    @CsvField(order = 1630, name = "補当１２・７０－７４")
    private RString 補当１２_７０_７４;
    @CsvField(order = 1640, name = "補当１２・高額支給額")
    private RString 補当１２_高額支給額;
    @CsvField(order = 1650, name = "補翌０１・自己負担額")
    private RString 補翌０１_自己負担額;
    @CsvField(order = 1660, name = "補翌０１・７０－７４")
    private RString 補翌０１_７０_７４;
    @CsvField(order = 1670, name = "補翌０１・高額支給額")
    private RString 補翌０１_高額支給額;
    @CsvField(order = 1680, name = "補翌０２・自己負担額")
    private RString 補翌０２_自己負担額;
    @CsvField(order = 1690, name = "補翌０２・７０－７４")
    private RString 補翌０２_７０_７４;
    @CsvField(order = 1700, name = "補翌０２・高額支給額")
    private RString 補翌０２_高額支給額;
    @CsvField(order = 1710, name = "補翌０３・自己負担額")
    private RString 補翌０３_自己負担額;
    @CsvField(order = 1720, name = "補翌０３・７０－７４")
    private RString 補翌０３_７０_７４;
    @CsvField(order = 1730, name = "補翌０３・高額支給額")
    private RString 補翌０３_高額支給額;
    @CsvField(order = 1740, name = "補翌０４・自己負担額")
    private RString 補翌０４_自己負担額;
    @CsvField(order = 1750, name = "補翌０４・７０－７４")
    private RString 補翌０４_７０_７４;
    @CsvField(order = 1760, name = "補翌０４・高額支給額")
    private RString 補翌０４_高額支給額;
    @CsvField(order = 1770, name = "補翌０５・自己負担額")
    private RString 補翌０５_自己負担額;
    @CsvField(order = 1780, name = "補翌０５・７０－７４")
    private RString 補翌０５_７０_７４;
    @CsvField(order = 1790, name = "補翌０５・高額支給額")
    private RString 補翌０５_高額支給額;
    @CsvField(order = 1800, name = "補翌０６・自己負担額")
    private RString 補翌０６_自己負担額;
    @CsvField(order = 1810, name = "補翌０６・７０－７４")
    private RString 補翌０６_７０_７４;
    @CsvField(order = 1820, name = "補翌０６・高額支給額")
    private RString 補翌０６_高額支給額;
    @CsvField(order = 1830, name = "補翌０７・自己負担額")
    private RString 補翌０７_自己負担額;
    @CsvField(order = 1840, name = "補翌０７・７０－７４")
    private RString 補翌０７_７０_７４;
    @CsvField(order = 1850, name = "補翌０７・高額支給額")
    private RString 補翌０７_高額支給額;
    @CsvField(order = 1860, name = "補合計・自己負担額")
    private RString 補合計_自己負担額;
    @CsvField(order = 1870, name = "補合計・７０－７４")
    private RString 補合計_７０_７４;
    @CsvField(order = 1880, name = "補合計・高額支給額")
    private RString 補合計_高額支給額;
    @CsvField(order = 1890, name = "データ作成区分")
    private RString データ作成区分;
    @CsvField(order = 1900, name = "自己負担額確認情報受取年月")
    private RString 自己負担額確認情報受取年月;
    @CsvField(order = 1910, name = "補正済自己負担額情報送付年月")
    private RString 補正済自己負担額情報送付年月;
    @CsvField(order = 1920, name = "自己負担額証明書情報受取年月")
    private RString 自己負担額証明書情報受取年月;
    @CsvField(order = 1930, name = "送付対象外フラグ")
    private RString 送付対象外フラグ;
    @CsvField(order = 1940, name = "自己負担額計算年月日")
    private RString 自己負担額計算年月日;
    @CsvField(order = 1950, name = "自己負担額証明書作成年月日")
    private RString 自己負担額証明書作成年月日;
    @CsvField(order = 1960, name = "バッチ補正実施年月日")
    private RString バッチ補正実施年月日;
    @CsvField(order = 1970, name = "リアル補正実施年月日")
    private RString リアル補正実施年月日;
}
