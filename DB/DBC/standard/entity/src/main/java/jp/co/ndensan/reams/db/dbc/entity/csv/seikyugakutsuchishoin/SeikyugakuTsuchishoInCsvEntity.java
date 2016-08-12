/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishoin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @@reamsid_L DBC-2480-010 jiangwenkai
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoInCsvEntity {

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
    @CsvField(order = 70, name = "款コード")
    private RString 款コード;
    @CsvField(order = 80, name = "款名")
    private RString 款名;
    @CsvField(order = 90, name = "項コード")
    private RString 項コード;
    @CsvField(order = 100, name = "項名")
    private RString 項名;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 130, name = "通常分・件数")
    private RString 通常_分件数;
    @CsvField(order = 140, name = "通常分・実日数")
    private RString 通常分_実日数;
    @CsvField(order = 150, name = "通常分・単位数")
    private RString 通常分_単位数;
    @CsvField(order = 160, name = "通常分・金額")
    private RString 通常分_金額;
    @CsvField(order = 170, name = "再審査・過誤・件数")
    private RString 再審査_過誤_件数;
    @CsvField(order = 180, name = "再審査・過誤・単位数")
    private RString 再審査_過誤_単位数;
    @CsvField(order = 190, name = "再審査・過誤・調整額")
    private RString 再審査_過誤_調整額;
    @CsvField(order = 200, name = "介護給付費")
    private RString 介護給付費;
    @CsvField(order = 210, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 220, name = "公費負担額")
    private RString 公費負担額;
    @CsvField(order = 230, name = "合計・通常分・件数")
    private RString 合計_通常分_件数;
    @CsvField(order = 240, name = "合計・通常分・単位数")
    private RString 合計_通常分_単位数;
    @CsvField(order = 250, name = "合計・通常分・金額")
    private RString 合計_通常分_金額;
    @CsvField(order = 260, name = "合計・再審査・過誤・件数")
    private RString 合計_再審査_過誤_件数;
    @CsvField(order = 270, name = "合計・再審査・過誤・単位数")
    private RString 合計_再審査_過誤_単位数;
    @CsvField(order = 280, name = "合計・再審査・過誤・調整額")
    private RString 合計_再審査_過誤_調整額;
    @CsvField(order = 290, name = "合計・介護給付費")
    private RString 合計_介護給付費;
    @CsvField(order = 300, name = "合計・利用者負担額")
    private RString 合計_利用者負担額;
    @CsvField(order = 310, name = "合計・公費負担額")
    private RString 合計_公費負担額;
    @CsvField(order = 320, name = "累計・通常分・件数")
    private RString 累計_通常分_件数;
    @CsvField(order = 330, name = "累計・通常分・単位数")
    private RString 累計_通常分_単位数;
    @CsvField(order = 340, name = "累計・通常分・金額")
    private RString 累計_通常分_金額;
    @CsvField(order = 350, name = "累計・再審査・過誤・件数")
    private RString 累計_再審査_過誤_件数;
    @CsvField(order = 360, name = "累計・再審査・過誤・単位数")
    private RString 累計_再審査_過誤_単位数;
    @CsvField(order = 370, name = "累計・再審査・過誤・調整額")
    private RString 累計_再審査_過誤_調整額;
    @CsvField(order = 380, name = "累計・介護給付費")
    private RString 累計_介護給付費;
    @CsvField(order = 390, name = "累計・利用者負担額")
    private RString 累計_利用者負担額;
    @CsvField(order = 400, name = "累計・公費負担額")
    private RString 累計_公費負担額;
    @CsvField(order = 410, name = "手数料・請求額")
    private RString 手数料_請求額;
    @CsvField(order = 420, name = "手数料・累計請求額")
    private RString 手数料_累計請求額;

}
