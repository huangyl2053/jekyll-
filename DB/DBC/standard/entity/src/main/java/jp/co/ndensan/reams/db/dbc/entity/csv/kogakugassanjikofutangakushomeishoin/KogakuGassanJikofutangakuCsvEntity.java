/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額証明書情報取込の帳票CSVEntity
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuCsvEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "明細項目")
    private RString 明細項目;
    @CsvField(order = 60, name = "No.")
    private RString no;
    @CsvField(order = 70, name = "証記載保険者番号")
    private ShoKisaiHokenshaNo 証記載保険者番号;
    @CsvField(order = 80, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 90, name = "対象年度")
    private FlexibleYear 対象年度;
    @CsvField(order = 100, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 110, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 120, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 130, name = "履歴番号")
    private int 履歴番号;
    @CsvField(order = 140, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 150, name = "異動区分コード")
    private RString 異動区分コード;
    @CsvField(order = 160, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 170, name = "介護加入期間_開始")
    private RString 介護加入期間_開始;
    @CsvField(order = 180, name = "介護加入期間_終了")
    private RString 介護加入期間_終了;
    @CsvField(order = 190, name = "対象計算期間_開始")
    private RString 対象計算期間_開始;
    @CsvField(order = 200, name = "対象計算期間_終了")
    private RString 対象計算期間_終了;
    @CsvField(order = 210, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 220, name = "自己負担額")
    private RString 自己負担額;
    @CsvField(order = 230, name = "自己負担額_うち70_74歳")
    private Decimal 自己負担額_うち70_74歳;
    @CsvField(order = 240, name = "自己負担額の差異")
    private RString 自己負担額の差異;
}
