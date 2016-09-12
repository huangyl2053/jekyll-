/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のgokeiEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInGokeiCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 50, name = "介護給付費／総合事業費・件数")
    private RString kaigoKyufuhiKensu;
    @CsvField(order = 60, name = "介護給付費／総合事業費・単位数")
    private RString kaigoKyufuhiTanisu;
    @CsvField(order = 70, name = "介護給付費／総合事業費・保険者負担額")
    private RString kaigoKyufuhiFutangaku;
    @CsvField(order = 80, name = "高額介護サービス費・件数")
    private RString kogakuServicehiKensu;
    @CsvField(order = 90, name = "高額介護サービス費・単位数")
    private RString kogakuServicehiTanisu;
    @CsvField(order = 100, name = "高額介護サービス費・保険者負担額")
    private RString kogakuServicehiFutangaku;
    @CsvField(order = 110, name = "特定入所者介護サービス費等・件数")
    private RString tokuteiNyushoshaServicehiKensu;
    @CsvField(order = 120, name = "特定入所者介護サービス費等・単位数")
    private RString tokuteiNyushoshaServicehiTanisu;
    @CsvField(order = 130, name = "特定入所者介護サービス費等・保険者負担額")
    private RString tokuteiNyushoshaServicehiFutangaku;
    @CsvField(order = 140, name = "ブランク")
    private RString flag;
}
