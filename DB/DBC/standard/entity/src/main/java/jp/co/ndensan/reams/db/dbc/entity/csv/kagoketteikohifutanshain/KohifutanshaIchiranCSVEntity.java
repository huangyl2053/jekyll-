/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohifutanshaIchiranCSVEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 40, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 50, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 60, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 70, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 80, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 90, name = "公費受給者名")
    private RString 公費受給者名;
    @CsvField(order = 100, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 110, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 120, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 130, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 140, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 150, name = "過誤申立事由コード")
    private RString 過誤申立事由コード;
    @CsvField(order = 160, name = "過誤申立事由")
    private RString 過誤申立事由;
    @CsvField(order = 170, name = "単位数")
    private RString 単位数;
    @CsvField(order = 180, name = "負担額")
    private RString 負担額;
    @CsvField(order = 190, name = "介護給付費・件数")
    private RString 介護給付費_件数;
    @CsvField(order = 200, name = "介護給付費・単位数")
    private RString 介護給付費_単位数;
    @CsvField(order = 210, name = "介護給付費・負担額")
    private RString 介護給付費_負担額;
    @CsvField(order = 220, name = "高額介護サービス費・件数")
    private RString 高額介護サービス費_件数;
    @CsvField(order = 230, name = "高額介護サービス費・単位数")
    private RString 高額介護サービス費_単位数;
    @CsvField(order = 240, name = "高額介護サービス費・負担額")
    private RString 高額介護サービス費_負担額;
    @CsvField(order = 250, name = "特定入所者介護サービス費等・件数")
    private RString 特定入所者介護サービス費等_件数;
    @CsvField(order = 260, name = "特定入所者介護サービス費等・単位数")
    private RString 特定入所者介護サービス費等_単位数;
    @CsvField(order = 270, name = "特定入所者介護サービス費等・負担額")
    private RString 特定入所者介護サービス費等_負担額;

}
