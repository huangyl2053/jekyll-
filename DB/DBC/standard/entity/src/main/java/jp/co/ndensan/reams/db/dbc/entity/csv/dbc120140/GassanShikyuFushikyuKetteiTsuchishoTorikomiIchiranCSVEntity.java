/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給（不支給）決定通知書情報取込一覧表CSVのentity。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiranCSVEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "№")
    private RString no;
    @CsvField(order = 40, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 60, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 90, name = "住所")
    private RString 住所;
    @CsvField(order = 100, name = "連絡票整理番号(支給申請書整理番号)")
    private RString 支給申請書整理番号;
    @CsvField(order = 110, name = "計算対象期間（開始）")
    private RString 計算対象期間_開始;
    @CsvField(order = 120, name = "計算対象期間（終了）")
    private RString 計算対象期間_終了;
    @CsvField(order = 130, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 140, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 150, name = "支給区分")
    private RString 支給区分;
    @CsvField(order = 160, name = "支給区分名称")
    private RString 支給区分名称;
    @CsvField(order = 170, name = "自己負担総額")
    private RString 自己負担総額;
    @CsvField(order = 180, name = "支給額")
    private RString 支給額;
    @CsvField(order = 190, name = "支払方法")
    private RString 支払方法;
    @CsvField(order = 200, name = "支払方法名称")
    private RString 支払方法名称;
    @CsvField(order = 210, name = "窓口払い：支払場所")
    private RString 窓口払い_支払場所;
    @CsvField(order = 220, name = "窓口払：支払期間")
    private RString 窓口払_支払期間;
    @CsvField(order = 230, name = "口座払：金融機関・支店名")
    private RString 口座払_金融機関_支店名;
    @CsvField(order = 240, name = "口座払：種目")
    private RString 口座払_種目;
    @CsvField(order = 250, name = "口座払：口座番号")
    private RString 口座払_口座番号;
    @CsvField(order = 260, name = "口座払：口座名義人")
    private RString 口座払_口座名義人;

}
