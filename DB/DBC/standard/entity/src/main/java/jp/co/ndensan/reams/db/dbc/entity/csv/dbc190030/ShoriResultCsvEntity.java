/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc190030;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成_対象世帯員するCSVクラスです。
 *
 * @reamsid_L DBC-4640-080 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriResultCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 3, name = "処理日時")
    private RString 処理日時;
    @CsvField(order = 4, name = "キー項目１")
    private RString キー項目1;
    @CsvField(order = 5, name = "キー項目２")
    private RString キー項目2;
    @CsvField(order = 6, name = "キー項目３")
    private RString キー項目3;
    @CsvField(order = 7, name = "キー項目４")
    private RString キー項目4;
    @CsvField(order = 8, name = "キー項目５")
    private RString キー項目5;
    @CsvField(order = 9, name = "プログラム名（上）")
    private RString プログラム名_上;
    @CsvField(order = 10, name = "プログラム名（下）")
    private RString プログラム名_下;
    @CsvField(order = 11, name = "項目１")
    private RString 項目1;
    @CsvField(order = 12, name = "項目２")
    private RString 項目2;
    @CsvField(order = 13, name = "項目３")
    private RString 項目3;
    @CsvField(order = 14, name = "項目４")
    private RString 項目4;
    @CsvField(order = 15, name = "項目５")
    private RString 項目5;
    @CsvField(order = 16, name = "内容（上）")
    private RString 内容_上;
    @CsvField(order = 17, name = "内容（下）")
    private RString 内容_下;
}
