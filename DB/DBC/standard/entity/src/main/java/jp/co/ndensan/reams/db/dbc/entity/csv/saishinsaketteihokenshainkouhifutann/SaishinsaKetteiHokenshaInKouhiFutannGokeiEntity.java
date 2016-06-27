/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshainkouhifutann;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定通知書情報取込共通処理（公費負担者分・ファイル読込）のGokeiEntity。
 *
 * @reamsid_L DBC-2820-011 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInKouhiFutannGokeiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "介護給付費・請求・件数")
    private RString 介護給付費請求件数;
    @CsvField(order = 60, name = "介護給付費・請求・単位数")
    private RString 介護給付費請求単位数;
    @CsvField(order = 70, name = "介護給付費・請求・公費負担額")
    private RString 介護給付費請求公費負担額;
    @CsvField(order = 80, name = "介護給付費／総合事業費・決定・件数")
    private RString 介護給付費総合事業費決定件数;
    @CsvField(order = 90, name = "介護給付費／総合事業費・決定・単位数")
    private RString 介護給付費総合事業費決定単位数;
    @CsvField(order = 100, name = "介護給付費／総合事業費・決定・公費負担額")
    private RString 介護給付費総合事業費決定公費負担額;
    @CsvField(order = 110, name = "介護給付費／総合事業費・調整・件数")
    private RString 介護給付費総合事業費調整件数;
    @CsvField(order = 120, name = "介護給付費／総合事業費・調整・単位数")
    private RString 介護給付費総合事業費調整単位数;
    @CsvField(order = 130, name = "介護給付費／総合事業費・調整・公費負担額")
    private RString 介護給付費総合事業費調整公費負担額;
    @CsvField(order = 140, name = "高額介護サービス費・請求・件数")
    private RString 高額介護サービス費請求件数;
    @CsvField(order = 150, name = "高額介護サービス費・請求・単位数")
    private RString 高額介護サービス費請求単位数;
    @CsvField(order = 160, name = "高額介護サービス費・請求・公費負担額")
    private RString 高額介護サービス費請求公費負担額;
    @CsvField(order = 170, name = "高額介護サービス費・決定・件数")
    private RString 高額介護サービス費決定件数;
    @CsvField(order = 180, name = "高額介護サービス費・決定・単位数")
    private RString 高額介護サービス費決定単位数;
    @CsvField(order = 190, name = "高額介護サービス費・決定・公費負担額")
    private RString 高額介護サービス費決定公費負担額;
    @CsvField(order = 200, name = "高額介護サービス費・調整・件数")
    private RString 高額介護サービス費調整件数;
    @CsvField(order = 210, name = "高額介護サービス費・調整・単位数")
    private RString 高額介護サービス費調整単位数;
    @CsvField(order = 220, name = "高額介護サービス費・調整・公費負担額")
    private RString 高額介護サービス費調整公費負担額;
    @CsvField(order = 230, name = "ブランク")
    private RString ブランク;
}
