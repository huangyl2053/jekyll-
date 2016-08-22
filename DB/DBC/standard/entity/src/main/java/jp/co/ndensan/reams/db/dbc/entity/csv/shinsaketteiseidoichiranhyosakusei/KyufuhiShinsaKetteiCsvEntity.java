/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shinsaketteiseidoichiranhyosakusei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費等審査決定請求明細表情報取込のCsvEntityクラスです
 *
 * @reamsid_L DBC-2500-010 jiangxiaolong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiShinsaKetteiCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 60, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 70, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 80, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 90, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 100, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 110, name = "件数")
    private RString 件数;
    @CsvField(order = 120, name = "日数・回数")
    private RString 日数_回数;
    @CsvField(order = 130, name = "単位")
    private RString 単位;
    @CsvField(order = 140, name = "金額")
    private RString 金額;
    @CsvField(order = 150, name = "介護給付費")
    private RString 介護給付費;
    @CsvField(order = 160, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 170, name = "公費負担額")
    private RString 公費負担額;
}
