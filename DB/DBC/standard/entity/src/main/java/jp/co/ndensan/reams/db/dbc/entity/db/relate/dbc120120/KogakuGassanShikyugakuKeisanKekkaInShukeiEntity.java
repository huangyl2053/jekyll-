/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * トレーラレコード項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyugakuKeisanKekkaInShukeiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "トレーラレコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "70歳以上負担額合計")
    private RString 七十歳以上負担額合計;
    @CsvField(order = 60, name = "70歳以上支給額合計")
    private RString 七十歳以上支給額合計;
    @CsvField(order = 70, name = "70歳未満負担額合計")
    private RString 七十歳未満負担額合計;
    @CsvField(order = 80, name = "負担額合計")
    private RString 負担額合計;
    @CsvField(order = 90, name = "70歳未満支給額合計")
    private RString 七十歳未満支給額合計;
    @CsvField(order = 100, name = "支給額合計")
    private RString 支給額合計;
    @CsvField(order = 110, name = "ブランク")
    private RString ブランク;
}
