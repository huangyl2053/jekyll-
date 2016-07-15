/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigohokenichilan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険所得情報一覧表ＣＳＶ用データEntity。
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShotokuJohoIchilanEucCsvEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 40, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 50, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 60, name = "氏名(カナ)")
    private RString 氏名_カナ;
    @CsvField(order = 70, name = "所得年度")
    private RString 所得年度;
    @CsvField(order = 80, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 90, name = "性別")
    private RString 性別;
    @CsvField(order = 100, name = "住民税課税区分(減免前)")
    private RString 住民税課税区分_減免前;
    @CsvField(order = 110, name = "住民税課税区分(減免後）")
    private RString 住民税課税区分_減免後;
    @CsvField(order = 120, name = "合計所得金額")
    private RString 合計所得金額;
    @CsvField(order = 130, name = "課税標準額")
    private RString 課税標準額;
    @CsvField(order = 140, name = "登録業務")
    private RString 登録業務;
    @CsvField(order = 150, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 160, name = "氏名")
    private RString 氏名;
    @CsvField(order = 170, name = "年齢")
    private RString 年齢;
    @CsvField(order = 180, name = "種別")
    private RString 種別;
    @CsvField(order = 180, name = "年金収入額")
    private RString 年金収入額;
}
