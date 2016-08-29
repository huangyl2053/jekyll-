/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧表CSVファイル作成するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyugakuKeisanKekkaInCsvEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "№")
    private RString 番号;
    @CsvField(order = 60, name = "年度")
    private RString 年度;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 90, name = "連絡票整理番号(支給申請書整理番号)")
    private RString 支給申請書整理番号;
    @CsvField(order = 100, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 110, name = "計算対象期間（開始）")
    private RString 計算対象期間_開始;
    @CsvField(order = 120, name = "計算対象期間（終了）")
    private RString 計算対象期間_終了;
    @CsvField(order = 130, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 140, name = "(70歳以上分)")
    private RString 七十歳以上分;
    @CsvField(order = 150, name = "世帯負担総額")
    private RString 世帯負担総額;
    @CsvField(order = 160, name = "(介護分)")
    private RString 介護分;
    @CsvField(order = 170, name = "(70歳以上介護分)")
    private RString 七十歳以上介護分;
    @CsvField(order = 180, name = "介護等合算算定基準額")
    private RString 介護等合算算定基準額;
    @CsvField(order = 190, name = "介護等合算算定基準額(70歳以上介護分)")
    private RString 介護等合算算定基準額_70歳以上介護分;
    @CsvField(order = 200, name = "世帯支給総額")
    private RString 世帯支給総額;
    @CsvField(order = 210, name = "世帯支給総額(うち70歳以上分)")
    private RString 世帯支給総額_うち70歳以上分;
    @CsvField(order = 220, name = "按分後支給額")
    private RString 按分後支給額;
    @CsvField(order = 230, name = "按分後支給額(うち70歳以上分)")
    private RString 按分後支給額_うち70歳以上分;
    @CsvField(order = 240, name = "備考")
    private RString 備考;
}
