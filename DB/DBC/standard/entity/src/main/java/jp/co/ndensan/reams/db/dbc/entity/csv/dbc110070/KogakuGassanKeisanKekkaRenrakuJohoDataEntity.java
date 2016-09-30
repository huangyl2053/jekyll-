/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果情報作成のデータレコードです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKeisanKekkaRenrakuJohoDataEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別")
    private RString レコード種別２;
    @CsvField(order = 50, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 60, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 70, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 80, name = "被保険者（証）番号")
    private RString 被保険者_証_番号;
    @CsvField(order = 90, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 100, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 110, name = "対象者氏名（漢字）")
    private RString 対象者氏名_漢字;
    @CsvField(order = 120, name = "70歳以上負担額")
    private RString ななじゅう歳以上負担額;
    @CsvField(order = 130, name = "70歳以上按分率")
    private RString ななじゅう歳以上按分率;
    @CsvField(order = 140, name = "70歳以上支給額")
    private RString ななじゅう歳以上支給額;
    @CsvField(order = 150, name = "70歳未満負担額")
    private RString ななじゅう歳未満負担額;
    @CsvField(order = 160, name = "負担額")
    private RString 負担額;
    @CsvField(order = 170, name = "按分率")
    private RString 按分率;
    @CsvField(order = 180, name = "70歳未満支給額")
    private RString ななじゅう歳未満支給額;
    @CsvField(order = 190, name = "支給額")
    private RString 支給額;
    @CsvField(order = 200, name = "備考欄記載70歳以上負担額")
    private RString 備考欄記載70歳以上負担額;
    @CsvField(order = 210, name = "備考欄記載70歳未満負担額")
    private RString 備考欄記載70歳未満負担額;
}
