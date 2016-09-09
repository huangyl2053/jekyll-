/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 支給不支給決定者一覧情報ファイルの明細です。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別_HDT")
    private RString レコード種別_HDT;
    @CsvField(order = 50, name = "no")
    private RString no;
    @CsvField(order = 60, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 70, name = "被保険者証番号")
    private RString 被保険者証番号;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 90, name = "計算対象期間開始年月日")
    private RString 計算対象期間開始年月日;
    @CsvField(order = 100, name = "計算対象期間終了年月日")
    private RString 計算対象期間終了年月日;
    @CsvField(order = 110, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 120, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 130, name = "自己負担額")
    private Decimal 自己負担額;
    @CsvField(order = 140, name = "支給額")
    private Decimal 支給額;
    @CsvField(order = 150, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 160, name = "窓口払情報_支払場所")
    private RString 窓口払情報_支払場所;
    @CsvField(order = 170, name = "窓口払情報_支払期間開始年月日")
    private RString 窓口払情報_支払期間開始年月日;
    @CsvField(order = 180, name = "窓口払情報_支払期間終了年月日")
    private RString 窓口払情報_支払期間終了年月日;
    @CsvField(order = 190, name = "窓口払情報_支払期間開始年月日_曜日")
    private RString 窓口払情報_支払期間開始年月日_曜日;
    @CsvField(order = 200, name = "窓口払情報_支払期間終了年月日_曜日")
    private RString 窓口払情報_支払期間終了年月日_曜日;
    @CsvField(order = 210, name = "窓口払情報_支払期間開始年月日_開始時間")
    private RString 窓口払情報_支払期間開始年月日_開始時間;
    @CsvField(order = 220, name = "窓口払情報_支払期間終了年月日_終了時間")
    private RString 窓口払情報_支払期間終了年月日_終了時間;
    @CsvField(order = 230, name = "口座払情報_金融機関コード")
    private RString 口座払情報_金融機関コード;
    @CsvField(order = 240, name = "口座払情報_金融機関名")
    private RString 口座払情報_金融機関名;
    @CsvField(order = 250, name = "口座払情報_金融機関支店コード")
    private RString 口座払情報_金融機関支店コード;
    @CsvField(order = 260, name = "口座払情報_金融機関支店名")
    private RString 口座払情報_金融機関支店名;
    @CsvField(order = 270, name = "口座払情報_口座種目")
    private RString 口座払情報_口座種目;
    @CsvField(order = 280, name = "口座払情報_口座種目名")
    private RString 口座払情報_口座種目名;
    @CsvField(order = 290, name = "口座払情報_口座番号")
    private RString 口座払情報_口座番号;
    @CsvField(order = 300, name = "口座払情報_口座名義人_カナ")
    private RString 口座払情報_口座名義人_カナ;
    @CsvField(order = 310, name = "ブランク")
    private RString ブランク;

}
