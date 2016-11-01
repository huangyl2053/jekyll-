/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshainkouhifutann;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（公費負担者分・ファイル読込）のgokeiEntity
 *
 * @reamsid_L DBC-0980-421 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInKouhiFutannCsvGokeiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "介護給付費／総合事業費・件数")
    private RString 介護給付費総合事業費件数;
    @CsvField(order = 60, name = "介護給付費／総合事業費・単位数")
    private RString 介護給付費総合事業費単位数;
    @CsvField(order = 70, name = "介護給付費／総合事業費・公費負担額")
    private RString 介護給付費総合事業費公費負担額;
    @CsvField(order = 80, name = "高額介護サービス費・件数")
    private RString 高額介護サービス費件数;
    @CsvField(order = 90, name = "高額介護サービス費・単位数")
    private RString 高額介護サービス費単位数;
    @CsvField(order = 100, name = "高額介護サービス費・公費負担額")
    private RString 高額介護サービス費公費負担額;
    @CsvField(order = 110, name = "特定入所者介護サービス費等・件数")
    private RString 特定入所者介護サービス費等件数;
    @CsvField(order = 120, name = "特定入所者介護サービス費等・単位数")
    private RString 特定入所者介護サービス費等単位数;
    @CsvField(order = 130, name = "特定入所者介護サービス費等・公費負担額")
    private RString 特定入所者介護サービス費等公費負担額;
    @CsvField(order = 140, name = "ブランク")
    private RString ブランク;
}
