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
public class KogakuGassanKeisanKekkaRenrakuJohoToreraEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別")
    private RString レコード種別２;
    @CsvField(order = 50, name = "70歳以上負担額合計")
    private RString ななじゅう歳以上負担額合計;
    @CsvField(order = 60, name = "70歳以上支給額合計")
    private RString ななじゅう歳以上支給額合計;
    @CsvField(order = 70, name = "70歳未満負担額合計")
    private RString ななじゅう歳未満負担額合計;
    @CsvField(order = 80, name = "負担額の合計額")
    private RString 負担額の合計額;
    @CsvField(order = 90, name = "70歳未満支給額合計")
    private RString ななじゅう歳未満支給額合計;
    @CsvField(order = 100, name = "支給額合計額")
    private RString 支給額合計額;
}
