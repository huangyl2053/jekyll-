/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果リスト作成Entityクラスです
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaCSVEntity {

    @CsvField(order = 10, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 20, name = "処理名")
    private RString 処理名;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 50, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 60, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 70, name = "キー1")
    private RString キー1;
    @CsvField(order = 80, name = "キー2")
    private RString キー2;
    @CsvField(order = 90, name = "キー3")
    private RString キー3;
    @CsvField(order = 100, name = "キー4")
    private RString キー4;
    @CsvField(order = 110, name = "キー5")
    private RString キー5;
    @CsvField(order = 120, name = "エラー内容")
    private RString エラー内容;
    @CsvField(order = 130, name = "備考")
    private RString 備考;
}
