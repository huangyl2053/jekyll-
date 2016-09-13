/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算補正済自己負担額情報作成のコントロールレコードです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanSoufuFairuSakuseiCsvEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "№")
    private RString no;
    @CsvField(order = 60, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "申請書整理番号")
    private RString 申請書整理番号;
    @CsvField(order = 90, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 100, name = "受取年月")
    private RString 受取年月;
    @CsvField(order = 110, name = "バッチ補正実施年月日")
    private RString バッチ補正実施年月日;
    @CsvField(order = 120, name = "リアル補正実施年月日")
    private RString リアル補正実施年月日;
    @CsvField(order = 130, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 140, name = "介護加入期間・開始年月日")
    private RString 介護加入期間_開始年月日;
    @CsvField(order = 150, name = "介護加入期間・終了年月日")
    private RString 介護加入期間_終了年月日;
    @CsvField(order = 160, name = "計算対象期間・開始年月日")
    private RString 計算対象期間_開始年月日;
    @CsvField(order = 170, name = "計算対象期間・終了年月日")
    private RString 計算対象期間_終了年月日;
    @CsvField(order = 180, name = "自己負担額合計")
    private RString 自己負担額合計;
    @CsvField(order = 190, name = "自己負担額合計（うち70～74歳）")
    private RString 自己負担額合計_うち70_74歳;
    @CsvField(order = 200, name = "高額介護サービス費")
    private RString 高額介護サービス費;
    @CsvField(order = 210, name = "再送")
    private RString 再送;
}
