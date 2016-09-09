/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishikakushogohyokeikasochiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2890-011 wangxingpeng
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "No.")
    private RString 連番;
    @CsvField(order = 40, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 100, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 110, name = "警告種別")
    private RString 警告種別;
    @CsvField(order = 120, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 130, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 140, name = "要介護区分コード")
    private RString 要介護区分コード;
    @CsvField(order = 150, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 160, name = "認定有効期間（開始)")
    private RString 認定有効期間_開始;
    @CsvField(order = 170, name = "認定有効期間（終了）")
    private RString 認定有効期間_終了;
    @CsvField(order = 180, name = "サービス日数・回数")
    private RString サービス日数_回数;
    @CsvField(order = 190, name = "サービス単位数")
    private RString サービス単位数;
    @CsvField(order = 200, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 210, name = "証記載保険者番号")
    private RString 証記載保険者番号;

}
