/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ35004_1_特徴平準化確定（バッチ）
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuHeijunkaKakuteiCSVEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "タイトル")
    private RString タイトル;
    @CsvField(order = 40, name = "年度")
    private RString 年度;
    @CsvField(order = 50, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 80, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 90, name = "氏名")
    private RString 氏名;
    @CsvField(order = 100, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 110, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 120, name = "町域_管内_管外住所")
    private RString 町域_管内_管外住所;
    @CsvField(order = 130, name = "番地")
    private RString 番地;
    @CsvField(order = 140, name = "保険料段階_仮算定時")
    private RString 保険料段階_仮算定時;
    @CsvField(order = 150, name = "今年度保険料率")
    private RString 今年度保険料率;
    @CsvField(order = 160, name = "特別徴収業務者コード")
    private RString 特別徴収業務者コード;
    @CsvField(order = 170, name = "特別徴収業務者")
    private RString 特別徴収業務者;
    @CsvField(order = 180, name = "特別徴収対象年金コード")
    private RString 特別徴収対象年金コード;
    @CsvField(order = 190, name = "特別徴収対象年金")
    private RString 特別徴収対象年金;
    @CsvField(order = 200, name = "変更前特徴額_１期")
    private RString 変更前特徴額_１期;
    @CsvField(order = 210, name = "変更前特徴額_２期")
    private RString 変更前特徴額_２期;
    @CsvField(order = 220, name = "変更前特徴額_３期")
    private RString 変更前特徴額_３期;
    @CsvField(order = 230, name = "変更後特徴額_１期")
    private RString 変更後特徴額_１期;
    @CsvField(order = 240, name = "変更後特徴額_２期")
    private RString 変更後特徴額_２期;
    @CsvField(order = 250, name = "変更後特徴額_３期")
    private RString 変更後特徴額_３期;
    @CsvField(order = 260, name = "普徴額_1期")
    private RString 普徴額_1期;
    @CsvField(order = 270, name = "普徴額_2期")
    private RString 普徴額_2期;
    @CsvField(order = 280, name = "普徴額_3期")
    private RString 普徴額_3期;
    @CsvField(order = 290, name = "普徴額_4期")
    private RString 普徴額_4期;
    @CsvField(order = 300, name = "普徴額5期")
    private RString 普徴額_5期;
    @CsvField(order = 310, name = "普徴額6期")
    private RString 普徴額_6期;
    @CsvField(order = 320, name = "備考")
    private RString 備考;

}
