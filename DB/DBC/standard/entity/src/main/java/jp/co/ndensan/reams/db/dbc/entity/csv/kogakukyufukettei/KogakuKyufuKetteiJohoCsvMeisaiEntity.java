/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費決定情報取込みのCsvMeisaiEntity
 *
 * @reamsid_L DBC-0980-390 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiJohoCsvMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "no")
    private RString no;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名_漢字")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 80, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 90, name = "利用者負担額")
    private Decimal 利用者負担額;
    @CsvField(order = 100, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 110, name = "決定年月")
    private FlexibleYearMonth 決定年月;
    @CsvField(order = 120, name = "高額支給額")
    private Decimal 高額支給額;
    @CsvField(order = 130, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 140, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 150, name = "開始年月日")
    private FlexibleDate 開始年月日;
    @CsvField(order = 160, name = "終了年月日")
    private FlexibleDate 終了年月日;
    @CsvField(order = 170, name = "開始曜日")
    private RString 開始曜日;
    @CsvField(order = 180, name = "終了曜日")
    private RString 終了曜日;
    @CsvField(order = 190, name = "開始時間")
    private RTime 開始時間;
    @CsvField(order = 200, name = "終了時間")
    private RTime 終了時間;
    @CsvField(order = 210, name = "金融機関コード")
    private RString 金融機関コード;
    @CsvField(order = 220, name = "金融機関名")
    private RString 金融機関名;
    @CsvField(order = 230, name = "金融機関支店コード")
    private RString 金融機関支店コード;
    @CsvField(order = 240, name = "金融機関支店名")
    private RString 金融機関支店名;
    @CsvField(order = 250, name = "口座種目")
    private RString 口座種目;
    @CsvField(order = 260, name = "口座種目名")
    private RString 口座種目名;
    @CsvField(order = 270, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 280, name = "口座名義人_カナ")
    private RString 口座名義人_カナ;
    @CsvField(order = 290, name = "ブランク")
    private RString ブランク;

}
