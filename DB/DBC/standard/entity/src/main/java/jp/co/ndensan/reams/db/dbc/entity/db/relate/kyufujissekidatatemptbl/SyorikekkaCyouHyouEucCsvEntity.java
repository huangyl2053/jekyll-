/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認リストCsvEntity
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyorikekkaCyouHyouEucCsvEntity {

    @CsvField(order = 10, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 20, name = "処理名")
    private RString 処理名;
    @CsvField(order = 30, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 40, name = "キー１")
    private RString キー１;
    @CsvField(order = 50, name = "キー２")
    private RString キー２;
    @CsvField(order = 60, name = "エラー内容")
    private RString エラー内容;
    @CsvField(order = 70, name = "備考")
    private RString 備考;
}
