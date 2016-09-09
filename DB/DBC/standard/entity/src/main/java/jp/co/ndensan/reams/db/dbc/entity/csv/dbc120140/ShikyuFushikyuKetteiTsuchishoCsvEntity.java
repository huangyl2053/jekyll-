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
 * 支給不支給決定通知書情報ファイルの明細です。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuKetteiTsuchishoCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 50, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 60, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 70, name = "宛先郵便番号")
    private RString 宛先郵便番号;
    @CsvField(order = 80, name = "宛先住所")
    private RString 宛先住所;
    @CsvField(order = 90, name = "宛先氏名")
    private RString 宛先氏名;
    @CsvField(order = 100, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 110, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 120, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 130, name = "被保険者証番号")
    private RString 被保険者証番号;
    @CsvField(order = 140, name = "計算対象期間開始年月日")
    private RString 計算対象期間開始年月日;
    @CsvField(order = 150, name = "計算対象期間終了年月日")
    private RString 計算対象期間終了年月日;
    @CsvField(order = 160, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 170, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 180, name = "自己負担総額")
    private Decimal 自己負担総額;
    @CsvField(order = 190, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 200, name = "支給額")
    private Decimal 支給額;
    @CsvField(order = 210, name = "給付の種類")
    private RString 給付の種類;
    @CsvField(order = 220, name = "不支給の理由")
    private RString 不支給の理由;
    @CsvField(order = 230, name = "備考")
    private RString 備考;
    @CsvField(order = 240, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 250, name = "窓口払情報_支払場所")
    private RString 窓口払情報_支払場所;
    @CsvField(order = 260, name = "窓口払情報_支払期間開始年月日")
    private RString 窓口払情報_支払期間開始年月日;
    @CsvField(order = 270, name = "窓口払情報_支払期間終了年月日")
    private RString 窓口払情報_支払期間終了年月日;
    @CsvField(order = 280, name = "窓口払情報_支払期間開始年月日_曜日")
    private RString 窓口払情報_支払期間開始年月日_曜日;
    @CsvField(order = 290, name = "窓口払情報_支払期間終了年月日_曜日")
    private RString 窓口払情報_支払期間終了年月日_曜日;
    @CsvField(order = 300, name = "窓口払情報_支払期間開始年月日_開始時間")
    private RString 窓口払情報_支払期間開始年月日_開始時間;
    @CsvField(order = 310, name = "窓口払情報_支払期間終了年月日_終了時間")
    private RString 窓口払情報_支払期間終了年月日_終了時間;
    @CsvField(order = 320, name = "口座払情報_金融機関名")
    private RString 口座払情報_金融機関名;
    @CsvField(order = 330, name = "口座払情報_金融機関支店名")
    private RString 口座払情報_金融機関支店名;
    @CsvField(order = 340, name = "口座払情報_口座種目名")
    private RString 口座払情報_口座種目名;
    @CsvField(order = 350, name = "口座払情報_口座番号")
    private RString 口座払情報_口座番号;
    @CsvField(order = 360, name = "口座払情報_口座名義人_カナ")
    private RString 口座払情報_口座名義人_カナ;
    @CsvField(order = 370, name = "通知書発行者情報_通知書発行者名")
    private RString 通知書発行者情報_通知書発行者名;
    @CsvField(order = 380, name = "通知書発行者情報_通知書発行者郵便番号")
    private RString 通知書発行者情報_通知書発行者郵便番号;
    @CsvField(order = 390, name = "通知書発行者情報_通知書発行者住所_漢字")
    private RString 通知書発行者情報_通知書発行者住所_漢字;
    @CsvField(order = 400, name = "問い合わせ先情報_問い合わせ先郵便番号")
    private RString 問い合わせ先情報_問い合わせ先郵便番号;
    @CsvField(order = 410, name = "問い合わせ先情報_問い合わせ先住所")
    private RString 問い合わせ先情報_問い合わせ先住所;
    @CsvField(order = 420, name = "問い合わせ先情報_問い合わせ先名称1")
    private RString 問い合わせ先情報_問い合わせ先名称1;
    @CsvField(order = 430, name = "問い合わせ先情報_問い合わせ先名称2")
    private RString 問い合わせ先情報_問い合わせ先名称2;
    @CsvField(order = 440, name = "問い合わせ先情報_問い合わせ先電話番号")
    private RString 問い合わせ先情報_問い合わせ先電話番号;
    @CsvField(order = 450, name = "帳票関連付け番号")
    private RString 帳票関連付け番号;
    @CsvField(order = 460, name = "不服の申し立て先名称")
    private RString 不服の申し立て先名称;
    @CsvField(order = 470, name = "ブランク")
    private RString ブランク;

}
