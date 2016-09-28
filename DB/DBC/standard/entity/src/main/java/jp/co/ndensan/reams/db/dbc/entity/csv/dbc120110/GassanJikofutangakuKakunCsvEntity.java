/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakuKakunCsvEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "連番")
    private RString 連番;
    @CsvField(order = 60, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 70, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 100, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 110, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 120, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 130, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 140, name = "異動区分コード")
    private RString 異動区分コード;
    @CsvField(order = 150, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 160, name = "介護加入期間_開始")
    private RString 介護加入期間_開始;
    @CsvField(order = 170, name = "介護加入期間_終了")
    private RString 介護加入期間_終了;
    @CsvField(order = 180, name = "対象計算期間_開始")
    private RString 対象計算期間_開始;
    @CsvField(order = 190, name = "対象計算期間_終了")
    private RString 対象計算期間_終了;
    @CsvField(order = 200, name = "自己負担額合計")
    private RString 自己負担額合計;
    @CsvField(order = 210, name = "自己負担額合計_うち70_74歳")
    private RString 自己負担額合計_うち70_74歳;
    @CsvField(order = 220, name = "高額介護サービス費")
    private RString 高額介護サービス費;

}
