/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果連絡票情報送付一覧表ＣＳＶファイルのヘッダレコードです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanShikyugakuKeisankekkaIchiranCsvEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "№")
    private RString 連番;
    @CsvField(order = 60, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 90, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 100, name = "計算対象期間開始年月日")
    private RString 計算対象期間開始年月日;
    @CsvField(order = 110, name = "計算対象期間終了年月日")
    private RString 計算対象期間終了年月日;
    @CsvField(order = 120, name = "世帯負担総額")
    private RString 世帯負担総額;
    @CsvField(order = 130, name = "世帯合算額")
    private RString 世帯合算額;
    @CsvField(order = 140, name = "世帯合算額_70歳以上")
    private RString 世帯合算額_70歳以上;
    @CsvField(order = 150, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 160, name = "所得区分名")
    private RString 所得区分名;
    @CsvField(order = 170, name = "所得区分_70歳以上")
    private RString 所得区分_70歳以上;
    @CsvField(order = 180, name = "所得区分名_70歳以上")
    private RString 所得区分名_70歳以上;
    @CsvField(order = 190, name = "算定基準額")
    private RString 算定基準額;
    @CsvField(order = 200, name = "算定基準額_70歳以上")
    private RString 算定基準額_70歳以上;
    @CsvField(order = 210, name = "世帯総支給額")
    private RString 世帯総支給額;
    @CsvField(order = 220, name = "世帯総支給額_70歳以上")
    private RString 世帯総支給額_70歳以上;
    @CsvField(order = 230, name = "按分後の支給額")
    private RString 按分後の支給額;
    @CsvField(order = 240, name = "按分後の支給額_70歳以上")
    private RString 按分後の支給額_70歳以上;
    @CsvField(order = 250, name = "再計算の有無")
    private RString 再計算の有無;
}
