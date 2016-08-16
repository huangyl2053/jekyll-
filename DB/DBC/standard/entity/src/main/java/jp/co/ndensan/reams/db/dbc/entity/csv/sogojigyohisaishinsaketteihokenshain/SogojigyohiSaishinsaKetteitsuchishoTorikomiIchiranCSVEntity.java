/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "審査委員会名")
    private RString 審査委員会名;
    @CsvField(order = 50, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 60, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 70, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 80, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 90, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 100, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 110, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 120, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 130, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 140, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 150, name = "申立事由コード")
    private RString 申立事由コード;
    @CsvField(order = 160, name = "申立事由")
    private RString 申立事由;
    @CsvField(order = 170, name = "当初請求単位数")
    private RString 当初請求単位数;
    @CsvField(order = 180, name = "原審単位数")
    private RString 原審単位数;
    @CsvField(order = 190, name = "決定単位数")
    private RString 決定単位数;
    @CsvField(order = 200, name = "調整単位数")
    private RString 調整単位数;
    @CsvField(order = 210, name = "負担額")
    private RString 負担額;
    @CsvField(order = 220, name = "総合事業費・決定・件数")
    private RString 総合事業費_決定_件数;
    @CsvField(order = 230, name = "総合事業費・決定・単位数")
    private RString 総合事業費_決定_単位数;
    @CsvField(order = 240, name = "総合事業費・決定・負担額")
    private RString 総合事業費_決定_負担額;
    @CsvField(order = 250, name = "総合事業費・調整・件数")
    private RString 総合事業費_調整_件数;
    @CsvField(order = 260, name = "総合事業費・調整・単位数")
    private RString 総合事業費_調整_単位数;
    @CsvField(order = 270, name = "総合事業費・調整・負担額")
    private RString 総合事業費_調整_負担額;

}
