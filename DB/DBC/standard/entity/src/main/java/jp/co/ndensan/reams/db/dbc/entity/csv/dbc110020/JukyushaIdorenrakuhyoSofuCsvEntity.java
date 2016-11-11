/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110020;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者異動連絡票情報送付対象者リストCSVする。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdorenrakuhyoSofuCsvEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "タイトル")
    private RString タイトル;
    @CsvField(order = 30, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 40, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "氏名")
    private RString 氏名;
    @CsvField(order = 70, name = "区分")
    private RString 区分;
    @CsvField(order = 80, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 90, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 100, name = "開始認定日")
    private RString 開始認定日;
    @CsvField(order = 110, name = "終了認定日")
    private RString 終了認定日;
    @CsvField(order = 120, name = "変更項目")
    private RString 変更項目;
    @CsvField(order = 130, name = "備考")
    private RString 備考;

}
