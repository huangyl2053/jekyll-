/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shotokujohotemp;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 所得情報CSVのEntity
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoControlCsvEntity {

    @CsvField(order = 10, name = "市町村コード")
    private LasdecCode 市町村コード;
    @CsvField(order = 20, name = "識別ＩＤ")
    private RString 識別ＩＤ;
    @CsvField(order = 30, name = "タイムスタンプ")
    private YMDHMS タイムスタンプ;
    @CsvField(order = 40, name = "最終レコード区分")
    private RString 最終レコード区分;
    @CsvField(order = 50, name = "連番")
    private RString 連番;
    @CsvField(order = 60, name = "ＦＩＬＬＥＲ")
    private RString ＦＩＬＬＥＲ;
    @CsvField(order = 70, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @CsvField(order = 80, name = "住民ｺｰﾄﾞ")
    private RString 住民ｺｰﾄﾞ;
    @CsvField(order = 90, name = "所得把握区分_申告区分")
    private RString 所得把握区分_申告区分;
    @CsvField(order = 100, name = "非課税区分")
    private RString 非課税区分;
    @CsvField(order = 110, name = "住民税所得割")
    private RString 住民税所得割;
    @CsvField(order = 120, name = "住民税均等割")
    private RString 住民税均等割;
    @CsvField(order = 130, name = "合計所得金額")
    private Decimal 合計所得金額;
    @CsvField(order = 140, name = "給与収入額")
    private Decimal 給与収入額;
    @CsvField(order = 150, name = "公的年金等収入額")
    private Decimal 公的年金等収入額;
    @CsvField(order = 160, name = "公的年金等所得額")
    private Decimal 公的年金等所得額;
    @CsvField(order = 170, name = "その他所得１")
    private RString その他所得１;
    @CsvField(order = 180, name = "その他所得２")
    private RString その他所得２;
    @CsvField(order = 190, name = "予備")
    private RString 予備;
    @CsvField(order = 200, name = "激変緩和区分")
    private RString 激変緩和区分;
    @CsvField(order = 210, name = "データ種類")
    private RString データ種類;
    @CsvField(order = 220, name = "所得税")
    private Decimal 所得税;
    @CsvField(order = 230, name = "更新日時")
    private YMDHMS 更新日時;
}
