/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc020080;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN626_自己負担額計算（一括）の処理結果CSVのエンティティです。
 *
 * @reamsid_L DBC-26-3 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080ShoriKekkaCSVEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "処理名")
    private RString 処理名;
    @CsvField(order = 3, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 6, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 7, name = "キー1")
    private RString キー1;
    @CsvField(order = 8, name = "キー2")
    private RString キー2;
    @CsvField(order = 9, name = "キー3")
    private RString キー3;
    @CsvField(order = 1, name = "キー4")
    private RString キー4;
    @CsvField(order = 11, name = "キー5")
    private RString キー5;
    @CsvField(order = 12, name = "エラー内容")
    private RString エラー内容;
    @CsvField(order = 13, name = "備考")
    private RString 備考;

}
