/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格取得者不整合リストCSVデータEntityクラスです。
 *
 * @reamsid_L DBU-4020-030 linghuhang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushutokushaFuseigoIchiranCsvDataEntity {

    @CsvField(order = 10, name = "連番")
    private int renban;
    @CsvField(order = 20, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 30, name = "ﾌﾘｶﾞﾅ")
    private RString arigana;
    @CsvField(order = 40, name = "氏名")
    private RString meisho;
    @CsvField(order = 50, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 60, name = "生年月日")
    private RString seneYMD;
    @CsvField(order = 70, name = "前住所")
    private RString zjusho;
    @CsvField(order = 80, name = "現住所")
    private RString jusho;
    @CsvField(order = 90, name = "市町村コード")
    private RString shichosonCode;
    @CsvField(order = 100, name = "資格区分")
    private RString shikaKubun;
    @CsvField(order = 110, name = "住特")
    private RString juutoku;
    @CsvField(order = 120, name = "不整合情報")
    private RString fuseigoJyou;

}
