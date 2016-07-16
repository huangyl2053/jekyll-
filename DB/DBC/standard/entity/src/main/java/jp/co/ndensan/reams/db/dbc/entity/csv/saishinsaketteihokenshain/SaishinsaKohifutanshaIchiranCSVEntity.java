/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKohifutanshaIchiranCSVEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "審査委員会名")
    private RString 審査委員会名;
    @CsvField(order = 50, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 60, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 70, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 80, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 90, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 100, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 110, name = "公費受給者名")
    private RString 公費受給者名;
    @CsvField(order = 120, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 130, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 140, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 150, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 160, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 170, name = "申立事由コード")
    private RString 申立事由コード;
    @CsvField(order = 180, name = "申立事由")
    private RString 申立事由;
    @CsvField(order = 190, name = "再審査結果コード")
    private RString 再審査結果コード;
    @CsvField(order = 200, name = "再審査結果")
    private RString 再審査結果;
    @CsvField(order = 210, name = "当初請求単位数")
    private RString 当初請求単位数;
    @CsvField(order = 220, name = "原審単位数")
    private RString 原審単位数;
    @CsvField(order = 230, name = "申立単位数")
    private RString 申立単位数;
    @CsvField(order = 240, name = "決定単位数")
    private RString 決定単位数;
    @CsvField(order = 250, name = "調整単位数")
    private RString 調整単位数;
    @CsvField(order = 260, name = "公費負担額")
    private RString 負担額;
    @CsvField(order = 270, name = "介護給付費・申立・件数")
    private RString 介護給付費_申立_件数;
    @CsvField(order = 280, name = "介護給付費・申立・単位数")
    private RString 介護給付費_申立_単位数;
    @CsvField(order = 290, name = "介護給付費・申立・公費負担額")
    private RString 介護給付費_申立_負担額;
    @CsvField(order = 300, name = "介護給付費・決定・件数")
    private RString 介護給付費_決定_件数;
    @CsvField(order = 310, name = "介護給付費・決定・単位数")
    private RString 介護給付費_決定_単位数;
    @CsvField(order = 320, name = "介護給付費・決定・公費負担額")
    private RString 介護給付費_決定_負担額;
    @CsvField(order = 330, name = "介護給付費・調整・件数")
    private RString 介護給付費_調整_件数;
    @CsvField(order = 340, name = "介護給付費・調整・単位数")
    private RString 介護給付費_調整_単位数;
    @CsvField(order = 350, name = "介護給付費・調整・公費負担額")
    private RString 介護給付費_調整_負担額;
    @CsvField(order = 360, name = "高額介護サービス費・申立・件数")
    private RString 高額介護サービス費_申立_件数;
    @CsvField(order = 370, name = "高額介護サービス費・申立・単位数")
    private RString 高額介護サービス費_申立_単位数;
    @CsvField(order = 380, name = "高額介護サービス費・申立・公費負担額")
    private RString 高額介護サービス費_申立_負担額;
    @CsvField(order = 390, name = "高額介護サービス費・決定・件数")
    private RString 高額介護サービス費_決定_件数;
    @CsvField(order = 400, name = "高額介護サービス費・決定・単位数")
    private RString 高額介護サービス費_決定_単位数;
    @CsvField(order = 410, name = "高額介護サービス費・決定・公費負担額")
    private RString 高額介護サービス費_決定_負担額;
    @CsvField(order = 420, name = "高額介護サービス費・調整・件数")
    private RString 高額介護サービス費_調整_件数;
    @CsvField(order = 430, name = "高額介護サービス費・調整・単位数")
    private RString 高額介護サービス費_調整_単位数;
    @CsvField(order = 440, name = "高額介護サービス費・調整・公費負担額")
    private RString 高額介護サービス費_調整_負担額;
}
